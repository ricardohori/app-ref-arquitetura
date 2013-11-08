package br.com.synchro.appref.business.model

import org.bson.types.ObjectId

/**
 * Created with IntelliJ IDEA.
 * User: rfh
 * Date: 11/7/13
 * Time: 6:36 PM
 * To change this template use File | Settings | File Templates.
 */
class Person implements Domain {

    static mapWith = "mongo"

    ObjectId id

    String key
    String name
    String email

}
