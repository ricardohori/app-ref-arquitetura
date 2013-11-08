package br.com.synchro.appref.gateway.data

import br.com.synchro.appref.business.model.Blog
import br.com.synchro.appref.business.model.Person
import br.com.synchro.appref.business.repository.BlogRepository

/**
 * Created with IntelliJ IDEA.
 * User: rfh
 * Date: 11/7/13
 * Time: 6:51 PM
 * To change this template use File | Settings | File Templates.
 */
class BlogRepositoryMongo extends BaseRepositoryMongo<Blog> implements BlogRepository{

    BlogRepositoryMongo(final Class<Blog> clazz){
        super(clazz)
    }

    @Override
    Set<Blog> withAuthor(Person pAuthor) {
        Blog.findAllByAuthor(pAuthor)
    }
}
