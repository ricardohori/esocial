package br.com.synchro.esocial.conector.gateway.repository

import br.com.synchro.esocial.conector.business.repository.DefaultRepository
import br.com.synchro.data.infra.persistence.AbstractGormCrudRepository
import org.apache.commons.lang.Validate

/**
 * Created with IntelliJ IDEA.
 * User: rfh
 * Date: 11/7/13
 * Time: 6:52 PM
 * To change this template use File | Settings | File Templates.
 */
abstract class DefaultRepositoryImpl<T> extends AbstractGormCrudRepository<Serializable, T> implements DefaultRepository<T>{

    DefaultRepositoryImpl(final Class<T> clazz){
        super(clazz)
    }

    @Override
    T findOne(final Serializable id){
        Validate.notNull(id, "[Id] cannot be null")
        clazz.get(id)
    }

    @Override
    Boolean exists(final Serializable id){
        Validate.notNull(id, "[Id] cannot be null")
        clazz.exists(id)
    }

    @Override
    void deleteAll(){
        clazz.collection.drop()
    }

    @Override
    T findByKey(final String pChave) {
        clazz.findByChave(pChave)
    }

}
