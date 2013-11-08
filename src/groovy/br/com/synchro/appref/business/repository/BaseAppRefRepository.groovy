package br.com.synchro.appref.business.repository

import br.com.synchro.data.infra.persistence.GormCrudRepository

/**
 * Created with IntelliJ IDEA.
 * User: rfh
 * Date: 11/8/13
 * Time: 11:57 AM
 * To change this template use File | Settings | File Templates.
 */
interface BaseAppRefRepository<T> extends GormCrudRepository<Serializable, T>{
    T findByKey(String key)
}
