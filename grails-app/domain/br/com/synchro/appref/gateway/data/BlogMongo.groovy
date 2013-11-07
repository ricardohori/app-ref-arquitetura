package br.com.synchro.appref.gateway.data

import br.com.synchro.appref.business.model.Blog

/**
 * Created with IntelliJ IDEA.
 * User: rfh
 * Date: 11/7/13
 * Time: 7:00 PM
 * To change this template use File | Settings | File Templates.
 */
class BlogMongo extends Blog{

    static hasMany = [readers:PersonMongo, posts:PostMongo]

}
