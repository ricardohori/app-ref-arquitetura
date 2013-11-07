package br.com.synchro.appref.business.model

/**
 * Created with IntelliJ IDEA.
 * User: rfh
 * Date: 11/7/13
 * Time: 6:39 PM
 * To change this template use File | Settings | File Templates.
 */
class Blog {

    String key
    String name
    Person author

    Set<Person> readers
    Set<Post> posts

}
