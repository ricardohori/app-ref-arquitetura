package br.com.synchro.appref.gateway.data

import br.com.synchro.appref.business.repository.BaseAppRefRepository
import br.com.synchro.data.infra.persistence.AbstractGormCrudRepository
import org.apache.commons.lang.Validate
import org.bson.types.ObjectId

/**
 * Created with IntelliJ IDEA.
 * User: rfh
 * Date: 11/7/13
 * Time: 6:52 PM
 * To change this template use File | Settings | File Templates.
 */
abstract class BaseRepositoryMongo<T> extends AbstractGormCrudRepository<Serializable, T> implements BaseAppRefRepository<T>{

    BaseRepositoryMongo(final Class<T> clazz){
        super(clazz)
    }

    @Override
    T findOne(final Serializable id){
        Validate.notNull(id, "[Id] cannot be null")
        final objectId = id instanceof ObjectId? id: new ObjectId(id)

        clazz.get(objectId)
    }

    @Override
    Boolean exists(final Serializable id){
        Validate.notNull(id, "[Id] cannot be null")
        final objectId = id instanceof ObjectId? id: new ObjectId(id)

        clazz.exists(objectId)
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
