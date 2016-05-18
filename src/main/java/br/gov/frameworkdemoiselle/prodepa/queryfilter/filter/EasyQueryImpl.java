package br.gov.frameworkdemoiselle.prodepa.queryfilter.filter;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import br.gov.frameworkdemoiselle.prodepa.queryfilter.exception.EasyQueryFilterException;

import com.uaihebert.factory.EasyCriteriaFactory;
import com.uaihebert.model.EasyCriteria;

public class EasyQueryImpl<T> implements EasyQuery<T> {

  private Class<T> beanClass;
  
  private EntityManager em;
  
  private EasyCriteria<T> criteria;
  
  private Map<Class, Object> cache;
  
  private String[] resultColumns;
  
  public EasyQueryImpl(Class<T> beanClass, EntityManager em) {
    super();
    
    this.beanClass = beanClass;
    this.em = em;
    
    this.criteria = EasyCriteriaFactory.createQueryCriteria(em, beanClass);
  }
  
  /**
   * Infelizmente o EasyCriteria
   * 
   * @return
   */
  public EasyQuery<T> clean() {
    
    this.criteria = EasyCriteriaFactory.createQueryCriteria(this.em, this.beanClass);
    
    return this;
  }
  

  /*
   * Configure Query Result
   */
  
  public void setResultColumns(String[] columns) {
    this.resultColumns = columns;
  }
  
  /*
   * get Result methods   
   */
  
  
  /**
   * Will use the EntityManager.getResultList() method to return the data.
   *
   * @return a list of objects
   */
  public List<T> getResultList() {
    
    if(resultColumns != null) {
      return criteria.getResultList();
    }
    
    return criteria.getResultList();
  }

  /**
   * Will use the EntityManager.getSingleResult() method to return the data. <br/> <br/>
   * <p/>
   * <b> The JPA might raise the NonUniqueResultException or the NoResultException</b>
   *
   * @return just one object
   */
  public T getSingleResult() {
    if(resultColumns != null) {
      return criteria.getSingleResult();
    }

    return criteria.getSingleResult();
  }
  
  public Long count() {
    return criteria.count();
  }
  
  /*
   * Add Predicates Methods   
   */
  
  public EasyQuery<T> addAnnotatedFilter(Object filter) throws EasyQueryFilterException {
    
    new EasyQueryParameterBuild(criteria, beanClass).addFilters(filter);
      
    return this;
  }
  
  public EasyQuery<T> andEquals(String attributeName, Object value) {
    this.criteria.andEquals(attributeName, value);
    return this;
  }

  public EasyQuery<T> andEquals(boolean toLowerCase, String attributeName, Object value) {
    this.criteria.andEquals(toLowerCase, attributeName, value);
    return this;
  }

  public EasyQuery<T> orEquals(String attributeName, Object... values) {
    this.criteria.orEquals(attributeName, values);
    return this;
  }

  public EasyQuery<T> orEquals(boolean toLowerCase, String attributeName, Object... values) {
    this.criteria.orEquals(toLowerCase, attributeName, values);
    return this;
  }

  public EasyQuery<T> orEquals(int index, String attributeName, Object... values) {
    this.criteria.orEquals(index, attributeName, values);
    return this;
  }

  public EasyQuery<T> orEquals(boolean toLowerCase, int index, String attributeName, Object... values) {
    this.criteria.orEquals(toLowerCase, index, attributeName, values);
    return this;
  }

  public EasyQuery<T> andNotEquals(String attributeName, Object value) {
    this.criteria.andNotEquals(attributeName, value);
    return this;
  }

  public EasyQuery<T> andNotEquals(boolean toLowerCase, String attributeName, Object value) {
    this.criteria.andNotEquals(toLowerCase, attributeName, value);
    return this;
  }

  public EasyQuery<T> orNotEquals(String attributeName, Object... values) {
    this.criteria.orNotEquals(attributeName, values);
    return this;
  }

  public EasyQuery<T> orNotEquals(boolean toLowerCase, String attributeName, Object... values) {
    this.criteria.orNotEquals(toLowerCase, attributeName, values);
    return this;
  }

  public EasyQuery<T> andGreaterThan(String attributeName, Object value) {
    this.criteria.andGreaterThan(attributeName, value);
    return this;
  }

  public EasyQuery<T> andGreaterThan(boolean toLowerCase, String attributeName, Object value) {
    this.criteria.andGreaterThan(toLowerCase, attributeName, value);
    return this;
  }

  public EasyQuery<T> andGreaterOrEqualTo(String attributeName, Object value) {
    this.criteria.andGreaterOrEqualTo(attributeName, value);
    return this;
  }

  public EasyQuery<T> andGreaterOrEqualTo(boolean toLowerCase, String attributeName, Object value) {
    this.criteria.andGreaterOrEqualTo(toLowerCase, attributeName, value);
    return this;
  }

  public EasyQuery<T> andLessThan(String attributeName, Object value) {
    this.criteria.andLessThan(attributeName, value);
    return this;
  }

  public EasyQuery<T> andLessThan(boolean toLowerCase, String attributeName, Object value) {
    this.criteria.andLessThan(toLowerCase, attributeName, value);
    return this;
  }

  public EasyQuery<T> andLessOrEqualTo(String attributeName, Object value) {
    this.criteria.andLessOrEqualTo(attributeName, value);
    return this;
  }

  public EasyQuery<T> andLessOrEqualTo(boolean toLowerCase, String attributeName, Object value) {
    this.criteria.andLessOrEqualTo(toLowerCase, attributeName, value);
    return this;
  }

  public EasyQuery<T> innerJoin(String joinName) {
    this.criteria.innerJoin(joinName);
    return this;
  }

  public EasyQuery<T> leftJoin(String joinName) {
    this.criteria.leftJoin(joinName);
    return this;
  }

  public EasyQuery<T> innerJoinFetch(String joinName) {
    this.criteria.innerJoinFetch(joinName);
    return this;
  }

  public EasyQuery<T> leftJoinFetch(String joinName) {
    this.criteria.leftJoinFetch(joinName);
    return this;
  }

  public EasyQuery<T> setDistinctTrue() {
    this.criteria.setDistinctTrue();
    return this;
  }

  public EasyQuery<T> andBetween(String attributeName, Object valueA, Object valueB) {
    this.criteria.andBetween(attributeName, valueA, valueB);
    return this;
  }

  public EasyQuery<T> andBetween(boolean toLowerCase, String attributeName, Object valueA, Object valueB) {
    this.criteria.andBetween(toLowerCase, attributeName, valueA, valueB);
    return this;
  }

  public EasyQuery<T> andIsNull(String attributeName) {
    this.criteria.andIsNull(attributeName);
    return this;
  }

  public EasyQuery<T> andIsNotNull(String attributeName) {
    this.criteria.andIsNotNull(attributeName);
    return this;
  }

  public EasyQuery<T> andCollectionIsEmpty(String collectionName) {
    this.criteria.andCollectionIsEmpty(collectionName);
    return this;
  }

  public EasyQuery<T> andCollectionIsNotEmpty(String collectionName) {
    this.criteria.andCollectionIsNotEmpty(collectionName);
    return this;
  }

  public EasyQuery<T> andStringLike(String attributeName, String value) {
    this.criteria.andStringLike(attributeName, value);
    return this;
  }

  public EasyQuery<T> andStringLike(boolean toLowerCase, String attributeName, String value) {
    this.criteria.andStringLike(toLowerCase, attributeName, value);
    return this;
  }

  public EasyQuery<T> andStringNotLike(String attributeName, String value) {
    this.criteria.andStringNotLike(attributeName, value);
    return this;
  }

  public EasyQuery<T> andStringNotLike(boolean toLowerCase, String attributeName, String value) {
    this.criteria.andStringNotLike(toLowerCase, attributeName, value);
    return this;
  }

  public EasyQuery<T> andStringIn(String attributeName, List<String> values) {
    this.criteria.andStringIn(attributeName, values);
    return this;
  }

  public EasyQuery<T> andStringIn(boolean toLowerCase, String attributeName, List<String> values) {
    this.criteria.andStringIn(toLowerCase, attributeName, values);
    return this;
  }

  public EasyQuery<T> andStringNotIn(String attributeName, List<String> values) {
    this.criteria.andStringNotIn(attributeName, values);
    return this;
  }

  public EasyQuery<T> andStringNotIn(boolean toLowerCase, String attributeName, List<String> values) {
    this.criteria.andStringNotIn(toLowerCase, attributeName, values);
    return this;
  }

  public EasyQuery<T> orderByAsc(String attributeName) {
    this.criteria.orderByAsc(attributeName);
    return this;
  }

  public EasyQuery<T> orderByDesc(String attributeName) {
    this.criteria.orderByDesc(attributeName);
    return this;
  }

  public EasyQuery<T> setFirstResult(int firstResult) {
    this.criteria.setFirstResult(firstResult);
    return this;
  }

  public EasyQuery<T> setMaxResults(int maxResults) {
    this.criteria.setMaxResults(maxResults);
    return this;
  }

  public EasyQuery<T> andJoinEquals(String joinName, String attributeName, Object value) {
    this.criteria.andJoinEquals(joinName, attributeName, value);
    return this;
  }

  public EasyQuery<T> andJoinEquals(boolean toLowerCase, String joinName, String attributeName, Object value) {
    this.criteria.andJoinEquals(toLowerCase, joinName, attributeName, value);
    return this;
  }

  public EasyQuery<T> andJoinNotEquals(String joinName, String attributeName, Object value) {
    this.criteria.andJoinNotEquals(joinName, attributeName, value);
    return this;
  }

  public EasyQuery<T> andJoinNotEquals(boolean toLowerCase, String joinName, String attributeName, Object value) {
    this.criteria.andJoinNotEquals(toLowerCase, joinName, attributeName, value);
    return this;
  }

  public EasyQuery<T> andJoinGreaterThan(String joinName, String attributeName, Object value) {
    this.criteria.andJoinGreaterThan(joinName, attributeName, value);
    return this;
  }

  public EasyQuery<T> andJoinGreaterThan(boolean toLowerCase, String joinName, String attributeName, Object value) {
    this.criteria.andJoinGreaterThan(toLowerCase, joinName, attributeName, value);
    return this;
  }

  public EasyQuery<T> andJoinGreaterOrEqualTo(String joinName, String attributeName, Object value) {
    this.criteria.andJoinGreaterOrEqualTo(joinName, attributeName, value);
    return this;
  }

  public EasyQuery<T> andJoinGreaterOrEqualTo(boolean toLowerCase, String joinName, String attributeName, Object value) {
    this.criteria.andJoinGreaterOrEqualTo(toLowerCase, joinName, attributeName, value);
    return this;
  }

  public EasyQuery<T> andJoinLessThan(String joinName, String attributeName, Object value) {
    this.criteria.andJoinLessThan(joinName, attributeName, value);
    return this;
  }

  public EasyQuery<T> andJoinLessThan(boolean toLowerCase, String joinName, String attributeName, Object value) {
    this.criteria.andJoinLessThan(toLowerCase, joinName, attributeName, value);
    return this;
  }

  public EasyQuery<T> andJoinLessOrEqualTo(String joinName, String attributeName, Object value) {
    this.criteria.andJoinLessOrEqualTo(joinName, attributeName, value);
    return this;
  }

  public EasyQuery<T> andJoinLessOrEqualTo(boolean toLowerCase, String joinName, String attributeName, Object value) {
    this.criteria.andJoinLessOrEqualTo(toLowerCase, joinName, attributeName, value);
    return this;
  }

  public EasyQuery<T> andJoinBetween(String joinName, String attributeName, Object valueA, Object valueB) {
    this.criteria.andJoinBetween(joinName, attributeName, valueA, valueB);
    return this;
  }

  public EasyQuery<T> andJoinBetween(boolean toLowerCase, String joinName, String attributeName, Object valueA, Object valueB) {
    this.criteria.andJoinBetween(toLowerCase, joinName, attributeName, valueA, valueB);
    return this;
  }

  public EasyQuery<T> andJoinAttributeIsNull(String joinName, String attributeName) {
    this.criteria.andJoinAttributeIsNull(joinName, attributeName);
    return this;
  }

  public EasyQuery<T> andJoinAttributeIsNotNull(String joinName, String attributeName) {
    this.criteria.andJoinAttributeIsNotNull(joinName, attributeName);
    return this;
  }

  public EasyQuery<T> andJoinListIsEmpty(String joinName, String listName) {
    this.criteria.andJoinListIsEmpty(joinName, listName);
    return this;
  }

  public EasyQuery<T> andJoinCollectionIsEmpty(String joinName, String collectionName) {
    this.criteria.andJoinCollectionIsEmpty(joinName, collectionName);
    return this;
  }

  public EasyQuery<T> andJoinSetIsEmpty(String joinName, String setName) {
    this.criteria.andJoinSetIsEmpty(joinName, setName);
    return this;
  }

  public EasyQuery<T> andJoinListIsNotEmpty(String joinName, String listName) {
    this.criteria.andJoinListIsNotEmpty(joinName, listName);
    return this;
  }

  public EasyQuery<T> andJoinCollectionIsNotEmpty(String joinName, String collectionName) {
    this.criteria.andJoinCollectionIsNotEmpty(joinName, collectionName);
    return this;
  }

  public EasyQuery<T> andJoinSetIsNotEmpty(String joinName, String setName) {
    this.criteria.andJoinSetIsNotEmpty(joinName, setName);
    return this;
  }

  public EasyQuery<T> andJoinStringLike(String joinName, String attributeName, String value) {
    this.criteria.andJoinStringLike(joinName, attributeName, value);
    return this;
  }

  public EasyQuery<T> andJoinStringLike(boolean toLowerCase, String joinName, String attributeName, String value) {
    this.criteria.andJoinStringLike(joinName, attributeName, value);
    return this;
  }

  public EasyQuery<T> andJoinStringNotLike(String joinName, String attributeName, String value) {
    this.criteria.andJoinStringNotLike(joinName, attributeName, value);
    return this;
  }

  public EasyQuery<T> andJoinStringNotLike(boolean toLowerCase, String joinName, String attributeName, String value) {
    this.criteria.andJoinStringNotLike(joinName, attributeName, value);
    return this;
  }

  public EasyQuery<T> andJoinStringIn(String joinName, String attributeName, List<String> values) {
    this.criteria.andJoinStringIn(joinName, attributeName, values);
    return this;
  }

  public EasyQuery<T> andJoinStringIn(boolean toLowerCase, String joinName, String attributeName, List<String> values) {
    this.criteria.andJoinStringIn(joinName, attributeName, values);
    return this;
  }

  public EasyQuery<T> andJoinStringNotIn(String joinName, String attributeName, List<String> values) {
    this.criteria.andJoinStringNotIn(joinName, attributeName, values);
    return this;
  }

  public EasyQuery<T> andJoinStringNotIn(boolean toLowerCase, String joinName, String attributeName, List<String> values) {
    this.criteria.andJoinStringNotIn(joinName, attributeName, values);
    return this;
  }

  public EasyQuery<T> addAndSeparatedByOr(int index, String attributeName, Object value) {
    this.criteria.addAndSeparatedByOr(index, attributeName, value);
    return this;
  }

  public EasyQuery<T> addAndSeparatedByOr(boolean toLowerCase, int index, String attributeName, Object value) {
    this.criteria.addAndSeparatedByOr(index, attributeName, value);
    return this;
  }


  /*
   * Internal Utilities
   * 
   */
  private List<T> fillCustomResult() {
    
    ///PAM!!!!! this.criteria.;
    
    return null;
  }
  
  
}
