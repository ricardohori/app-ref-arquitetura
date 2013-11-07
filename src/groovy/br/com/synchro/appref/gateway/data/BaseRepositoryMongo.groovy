package br.com.synchro.appref.gateway.data

import br.com.synchro.data.infra.persistence.AbstractGormCrudRepository
import org.bson.types.ObjectId

/**
 * Created with IntelliJ IDEA.
 * User: rfh
 * Date: 11/7/13
 * Time: 6:52 PM
 * To change this template use File | Settings | File Templates.
 */
abstract class BaseRepositoryMongo<T> extends AbstractGormCrudRepository<ObjectId, T>{

    BaseRepositoryMongo(final Class<T> clazz){
        super(clazz)
    }
}
