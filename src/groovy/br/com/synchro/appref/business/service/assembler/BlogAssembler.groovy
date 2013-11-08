package br.com.synchro.appref.business.service.assembler

import br.com.synchro.appref.business.model.Blog
import br.com.synchro.appref.business.model.Post
import br.com.synchro.appref.business.repository.BlogRepository
import br.com.synchro.appref.business.service.to.BlogTO
import com.google.gson.Gson

/**
 * <pre>
 * User: rfh
 * Date: 11/8/13
 *
 * </pre>
 */
class BlogAssembler {

    private final PersonAssembler personAssembler
    private final BlogRepository blogRepository
    private final Gson gsonInstance

    BlogAssembler(final PersonAssembler pPersonAssembler, final BlogRepository pBlogRepository){
        personAssembler = pPersonAssembler
        blogRepository = pBlogRepository
        gsonInstance = new Gson()
    }

    BlogTO assemble(final Blog pBlog){
        final json = gsonInstance.toJson(AssemblerUtils.mapifyDomain(pBlog))
        gsonInstance.fromJson(json, BlogTO)
    }

    Blog dismantle(final BlogTO pBlog){
        final blog = blogRepository.findByKey(pBlog.key) ?: new Blog()

        blog.properties << [
                key: pBlog.key,
                name: pBlog.name,
                author: personAssembler.dismantle(pBlog.author),
                readers: pBlog.collect { personAssembler.dismantle(it) },
                posts: pBlog.collect { new Post(it.properties) }
        ]
        blog
    }
}
