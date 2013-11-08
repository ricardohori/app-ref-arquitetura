package br.com.synchro.appref.business.assembler

import br.com.synchro.appref.gateway.test.AppRefUnitSpec
import br.com.synchro.appref.business.model.Blog
import br.com.synchro.appref.business.model.Person
import br.com.synchro.appref.business.model.Post
import br.com.synchro.appref.business.service.assembler.BlogAssembler

/**
 * <pre>
 * User: rfh
 * Date: 11/8/13
 *
 * </pre>
 */
class BlogAssemblerSpec extends AppRefUnitSpec{

    final blogAssembler = getUnitBean(BlogAssembler)

    def "Must be able to assemble a blog TO from a blog domain"(){
        setup:
            final author = new Person(key: "person_20131107142115110", name: "Jiraya", email: "jiraya@synchro.com.br")
            final blog = new Blog(
                    key: "blog_20131107142115109",
                    name: "Ninja journal",
                    author: author,
                    readers: [author],
                    posts: [new Post(
                            key: "post_20131107142115110",
                            title: "The way of the ninja!",
                            content: "Be zen"
                    )]
            )

        when:
        final to = blogAssembler.assemble(blog)

        then:
        true

    }
}
