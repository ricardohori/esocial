package br.com.synchro.esocial.conector.business.repository

import br.com.synchro.data.infra.persistence.GormCrudRepository


/**
 * 
 * @author carlos.garbiatti
 *
 * @param <T>
 */
interface DefaultRepository<T> extends GormCrudRepository<Serializable, T>{
    T findByKey(String key)
}
