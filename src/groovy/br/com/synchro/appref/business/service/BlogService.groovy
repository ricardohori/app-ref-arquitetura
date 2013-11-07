package br.com.synchro.appref.business.service

import br.com.synchro.appref.business.repository.BlogRepository
import br.com.synchro.appref.business.model.Blog

/**
 * Created with IntelliJ IDEA.
 * User: rfh
 * Date: 11/7/13
 * Time: 6:45 PM
 * To change this template use File | Settings | File Templates.
 */
class BlogService {

    private final BlogRepository blogRepository

    BlogService(final BlogRepository pBlogRepository){
        blogRepository = pBlogRepository
    }

    Blog createNewBlog(final Blog pBlog){
        blogRepository.save(pBlog)
    }
}
