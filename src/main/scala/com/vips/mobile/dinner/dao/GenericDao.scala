package com.vips.mobile.dinner.dao

import org.hibernate.criterion.DetachedCriteria

/**
  * Created by cielleech on 16/9/14.
  */
trait GenericDao[T >: Null, PK <: java.io.Serializable] {
  /**
    * Generic method used to get all objects of a particular type. This
    * is the same as lookup up all rows in a table.
    *
    * @return List of populated objects
    */
  def getAll(): List[T]

  /**
    * Gets all records without duplicates.
    * <p>Note that if you use this method, it is imperative that your model
    * classes correctly implement the hashcode/equals methods</p>
    *
    * @return List of populated objects
    */
  def getAllDistinct: List[T]

  def search[E](searchQuery: String, clz: Class[E], values: Object*): List[E]

  def getByDetachedCriteria(detachedCriteria: DetachedCriteria): T

  def findByDetachedCriteria(detachedCriteria: DetachedCriteria): List[T]

  def createDetachedCriteria: DetachedCriteria

  /**
    * generic method to get an object based on class and identifier. an
    * objectretrievalfailureexception runtime exception is thrown if
    * nothing is found.
    *
    * @param id the identifier (primary key) of the object to get
    * @return a populated object
    * @see org.springframework.orm.objectretrievalfailureexception
    */
  def get(id: PK): T

  /**
    * Checks for existence of an object of type T using the id arg.
    *
    * @param id the id of the entity
    * @return - true if it exists, false if it doesn't
    */
  def exists(id: PK): Boolean

  /**
    *
    * @param obj
    * @return
    */
  def save(obj: T): PK

  /**
    *
    * @param obj
    */
  def saveOrUpdate(obj: T): Unit

  /**
    *
    * @param objList
    * @return
    */
  def saveAll(objList: List[T]): List[PK]

  /**
    *
    * @param obj
    */
  def update(obj: T): Unit

  /**
    *
    * @param obj
    */
  def remove(obj: T): Unit

  /**
    *
    * @param id
    */
  def remove(id: PK): Unit

  /**
    *
    * @param queryName
    * @param queryParams
    * @return
    */
  def findByNamedQuery(queryName: String, queryParams: Map[String, Object]): List[T]

  /**
    *
    * @param hql
    * @param offset
    * @param pageSize
    * @return
    */
  def findByPage(hql: String, offset: Int, pageSize: Int): List[T]

  /**
    *
    * @param hql
    * @param params
    * @return
    */
  def find(hql: String, params: Map[String, Object]): List[T]

  /**
    *
    * @param obj
    */
  def evict(obj: T): Unit

  /**
    *
    * @param oldList
    * @param newList
    * @tparam E
    * @return
    */
  def updateList[E](oldList: List[E], newList: List[E]): List[E]

  /**
    *
    * @param sql
    * @param values
    * @return
    */
  def sqlQuery(sql: String, values: Object*): List[T]

  /**
    *
    * @param sql
    * @param values
    * @return
    */
  def sqlExec(sql: String, values: Object*): List[_]

  /**
    *
    * @param clz
    * @param sql
    * @param values
    * @tparam E
    * @return
    */
  def sqlQuery[E](clz: Class[E], sql: String, values: Object*): List[E]

  /**
    *
    * @param sql
    * @param values
    * @return
    */
  def executeSqlUpdate(sql: String, values: Object*): Int

  /**
    *
    * @param hql
    * @param params
    * @return
    */
  def executeUpdate(hql: String, params: Map[String, Object]): Int
}