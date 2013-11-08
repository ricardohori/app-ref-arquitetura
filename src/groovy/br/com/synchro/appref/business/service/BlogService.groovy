package br.com.synchro.appref.business.service

import br.com.synchro.appref.business.model.Person
import br.com.synchro.appref.business.repository.BlogRepository
import br.com.synchro.appref.business.service.assembler.BlogAssembler
import br.com.synchro.appref.business.service.to.BlogTO
import com.google.common.collect.ImmutableSet

/**
 * Created with IntelliJ IDEA.
 * User: rfh
 * Date: 11/7/13
 * Time: 6:45 PM
 * To change this template use File | Settings | File Templates.
 */
class BlogService {

    private final BlogRepository blogRepository
    private final BlogAssembler blogAssembler

    BlogService(final BlogAssembler pBlogAssembler, final BlogRepository pBlogRepository){
        blogRepository = pBlogRepository
        blogAssembler = pBlogAssembler
    }

    void createNewBlog(final BlogTO pBlog){
        final blog = blogAssembler.dismantle(pBlog)
        blogRepository.save(pBlog)
    }

    ImmutableSet<BlogTO> lookupBlogsWithAuthor(final Person pAuthor){
        ImmutableSet.copyOf(
                blogRepository.withAuthor(pAuthor).collect { blogAssembler.assemble(it) }
        )
    }
}
