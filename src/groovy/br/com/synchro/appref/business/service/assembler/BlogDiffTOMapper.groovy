package br.com.synchro.appref.business.service.assembler

import br.com.synchro.appref.business.model.Blog

/**
 * <pre>
 * User: rfh
 * Date: 11/11/13
 * 
 * </pre>
 */
class BlogDiffTOMapper implements DomainTOMapper<Blog>{

    @Override
    Boolean maps(Class pDomainClazz) {
        pDomainClazz == Blog.class
    }

    @Override
    Map<String, Object> mapProperties(final Blog pBlog){
        final properties = [:] << pBlog.properties
        properties << [
                readers: pBlog.readers.collect {[
                        fan: it,
                        favoritePosts:pBlog.posts
                ]}
        ]

        properties
    }



}
