package com.vips.mobile.dinner.dao

import org.hibernate.criterion.DetachedCriteria

/**
  * Created by cielleech on 16/9/14.
  */
trait GenericDao[T, PK >: Serializable] {
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

  def search[E](searchQuery: String): List[E]

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
  def exists (id: PK): Boolean
}

//
///**
//* Checks for existence of an object of type T using the id arg.
//* @param id the id of the entity
//* @return - true if it exists, false if it doesn't
//*/
//boolean exists(PK id);
//
///**
//* Generic method to save an object - handles both update and insert.
//* @param object the object to save
//* @return the persisted object
//*/
//PK save(T object);
//
//void saveOrUpdate(T object);
//
//List<PK> saveAll(List<T> objectList);
//
//void update(T object);
//
///**
//* Generic method to delete an object
//* @param object the object to remove
//*/
//void remove(T object);
//
///**
//* Generic method to delete an object
//* @param id the identifier (primary key) of the object to remove
//*/
//void remove(PK id);
//
///**
//* Find a list of records by using a named query
//* @param queryName query name of the named query
//* @param queryParams a map of the query names and the values
//* @return a list of the records found
//*/
//List<T> findByNamedQuery(String queryName, Map<String, Object> queryParams);
//
//List<T> findByPage(final String hql, final int offset, final int pageSize);
///**
//* find a list with condition params
//* @param hql
//* @param params
//* @return
//*/
//List<T> find(String hql, Map<String, Object> params);
//
//void evict(T object);
//
//<E extends BaseEntity> List<E> updateList(List<E> oldList, List<E> newList);
//
///**
//* Generic method to regenerate full text index of the persistent class T
//*/
////    void reindex();
//
///**
//* Generic method to regenerate full text index of all indexed classes
//* @param async true to perform the reindexing asynchronously
//*/
////    void reindexAll(boolean async);
//
//public List<T> sqlQuery(final String sql, final Object... values);
//
//public List<?> sqlExec(final String sql, final Object... values);
//
//public <E> List<E> sqlQuery(final Class<E> clz, final String sql, final Object... values);
//
//public int executeSqlUpdate(final String sql, final Object... values);
//
//public int executeUpdate(final String hql, final Map<String, Object> params);
//
//}
