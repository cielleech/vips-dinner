package com.vips.mobile.dinner.dao.impl

import com.vips.mobile.dinner.dao.GenericDao
import org.hibernate.criterion.DetachedCriteria
import org.hibernate.{Session, SessionFactory}
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.{Autowired, Required}
import org.springframework.orm.hibernate4.HibernateCallback
import org.springframework.orm.hibernate4.support.HibernateDaoSupport
import org.springframework.stereotype.Repository

import scala.collection.JavaConverters._

/**
  * This class serves as the Base class for all other DAOs - namely to hold
  * common CRUD methods that they might all use. You should only need to extend
  * this class when your require custom CRUD logic.
  */
@Repository("dao")
class GenericDaoImpl[T >: Null, PK <: java.io.Serializable] extends HibernateDaoSupport with GenericDao[T, PK] {
  var persistentClass: Class[T] = _

  /**
    * Constructor that takes in a class to see which type of entity to persist.
    * Use this constructor when subclassing.
    *
    * @param persistentClass
    * the class type you'd like to persist
    */
  def this(persistentClass: Class[T]) = {
    this
    this.persistentClass = persistentClass
  }

  /**
    * Constructor that takes in a class and sessionFactory for easy creation of
    * DAO.
    *
    * @param persistentClass
    * the class type you'd like to persist
    * @param sessionFactory
    * the pre-configured Hibernate SessionFactory
    */
  def GenericDaoImpl(persistentClass: Class[T], sessionFactory: SessionFactory) = {
    this.persistentClass = persistentClass
    super.setSessionFactory(sessionFactory)
  }

  @Autowired
  @Required
  def setSessionFactory0(sessionFactory: SessionFactory) = {
    if (null == super.getSessionFactory) {
      super.setSessionFactory(sessionFactory)
    }
  }

  private def closeSession(session: Session): Unit = {
    if (session != null) session.close()
  }

  /**
    * Generic method used to get all objects of a particular type. This
    * is the same as lookup up all rows in a table.
    *
    * @return List of populated objects
    */
  override def getAll(): List[T] = getHibernateTemplate.findByCriteria(DetachedCriteria.forClass(persistentClass)).asScala.toList.map(x => x.asInstanceOf[T])

  /**
    * Gets all records without duplicates.
    * <p>Note that if you use this method, it is imperative that your model
    * classes correctly implement the hashcode/equals methods</p>
    *
    * @return List of populated objects
    */
  override def getAllDistinct: List[T] = {
    null
  }

  override def search[E](searchQuery: String, clz: Class[E], values: Object*): List[E] = {
    getHibernateTemplate.executeWithNativeSession(new HibernateCallback[List[E]]() {
      override def doInHibernate(session: Session): List[E] = {
        val query = session.createQuery(searchQuery)

        if (null != values) {
          values.zipWithIndex.foreach(t => {
            query.setParameter(t._2, t._1)
          })
        }

        query.list().asInstanceOf[List[E]]
      }
    })
  }

  override def getByDetachedCriteria(detachedCriteria: DetachedCriteria): T = {
    val result = findByDetachedCriteria(detachedCriteria)

    if (null != result || result.nonEmpty) result.head else null
  }

  override def findByDetachedCriteria(detachedCriteria: DetachedCriteria): List[T] = {
    getHibernateTemplate.findByCriteria(detachedCriteria).asInstanceOf[List[T]]
  }

  override def createDetachedCriteria: DetachedCriteria = DetachedCriteria.forClass(persistentClass)

  /**
    * generic method to get an object based on class and identifier. an
    * objectretrievalfailureexception runtime exception is thrown if
    * nothing is found.
    *
    * @param id the identifier (primary key) of the object to get
    * @return a populated object
    */
  override def get(id: PK): T = getHibernateTemplate.get(persistentClass, id)

  /**
    * Checks for existence of an object of type T using the id arg.
    *
    * @param id the id of the entity
    * @return - true if it exists, false if it doesn't
    */
  override def exists(id: PK): Boolean = getHibernateTemplate.get(persistentClass, id) != null

  /**
    *
    * @param obj the entity
    * @return
    */
  override def save(obj: T): PK = getHibernateTemplate.save(obj).asInstanceOf[PK]

  /**
    *
    * @param obj the entity
    */
  override def saveOrUpdate(obj: T): Unit = getHibernateTemplate.saveOrUpdate(obj)

  /**
    *
    * @param objList : the entity list
    * @return
    */
  override def saveAll(objList: List[T]): List[PK] = {
    val result = List[PK]()

    if (result != null) {
      objList.foreach(_ => result :+ (save(_)))
    }

    result
  }

  /**
    *
    * @param obj : the entity
    */
  override def update(obj: T): Unit = getHibernateTemplate.merge(obj)

  /**
    *
    * @param obj : the entity
    */
  override def remove(obj: T): Unit = getHibernateTemplate.delete(obj)

  /**
    *
    * @param id : the entity id
    */
  override def remove(id: PK): Unit = {
    val obj = get(id)
    remove(obj)
  }

  /**
    *
    * @param queryName   : the named sql
    * @param queryParams : the query parameters
    * @return
    */
  override def findByNamedQuery(queryName: String, queryParams: Map[String, Object]): List[T] = getHibernateTemplate.findByNamedQuery(queryName, queryParams).asInstanceOf[List[T]]

  /**
    *
    * @param hql
    * @param offset
    * @param pageSize
    * @return
    */
  override def findByPage(hql: String, offset: Int, pageSize: Int): List[T] = {
    getHibernateTemplate.executeWithNativeSession(new HibernateCallback[List[T]]() {
      override def doInHibernate(session: Session): List[T] = session.createQuery(hql)
        .setFirstResult(offset).setMaxResults(pageSize).list().asInstanceOf[List[T]]
    })
  }

  /**
    *
    * @param hql
    * @param params
    * @return
    */
  override def find(hql: String, params: Map[String, Object]): List[T] = {
    val names = Option(params).getOrElse(Map()).keys.toArray
    val values = Option(params).getOrElse(Map()).values.toArray
    getHibernateTemplate.findByNamedParam(hql, names, values).asInstanceOf[List[T]]
  }

  /**
    *
    * @param obj
    */
  override def evict(obj: T): Unit = getHibernateTemplate.evict(obj)

  /**
    *
    * @param oldList
    * @param newList
    * @tparam E
    * @return
    */
  override def updateList[E](oldList: List[E], newList: List[E]): List[E] = ???

  /**
    *
    * @param sql
    * @param values
    * @return
    */
  override def sqlQuery(sql: String, values: Object*): List[T] = sqlQuery(this.persistentClass, sql, values)

  /**
    *
    * @param sql
    * @param values
    * @return
    */
  override def sqlExec(sql: String, values: Object*): List[_] = {
    getHibernateTemplate.executeWithNativeSession(new HibernateCallback[List[_]] {
      override def doInHibernate(session: Session): List[_] = {
        val query = session.createSQLQuery(sql)
        Option(values).getOrElse(List()).zipWithIndex.foreach(t => query.setParameter(t._2, t._1))
        query.list().asInstanceOf[List[_]]
      }
    })
  }

  /**
    *
    * @param clz
    * @param sql
    * @param values
    * @tparam E
    * @return
    */
  override def sqlQuery[E](clz: Class[E], sql: String, values: Object*): List[E] = {
    getHibernateTemplate.executeWithNativeSession(new HibernateCallback[List[E]] {
      override def doInHibernate(session: Session): List[E] = {
        val query = session.createSQLQuery(sql)
        values.zipWithIndex.foreach(t => query.setParameter(t._2, t._1))
        query.addEntity(clz).list().asInstanceOf[List[E]]
      }
    })
  }

  /**
    *
    * @param sql
    * @param values
    * @return
    */
  override def executeSqlUpdate(sql: String, values: Object*): Int = {
    getHibernateTemplate.executeWithNativeSession(new HibernateCallback[Integer] {
      override def doInHibernate(session: Session): Integer = {
        val query = session.createSQLQuery(sql)
        values.zipWithIndex.foreach(t => query.setParameter(t._2, t._1))
        query.executeUpdate()
      }
    })
  }

  /**
    *
    * @param hql
    * @param params
    * @return
    */
  override def executeUpdate(hql: String, params: Map[String, Object]): Int = {
    getHibernateTemplate.executeWithNativeSession(new HibernateCallback[Integer] {
      override def doInHibernate(session: Session): Integer = {
        val query = session.createQuery(hql)

        Option(params).getOrElse(Map()).foreach(t => query.setParameter(t._1, t._2))

        query.executeUpdate()
      }
    })
  }
}

object GenericDaoImpl {
  val logger = LoggerFactory.getLogger(GenericDaoImpl.getClass)
}
