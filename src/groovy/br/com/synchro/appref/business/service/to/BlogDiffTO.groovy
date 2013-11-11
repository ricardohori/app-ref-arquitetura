package br.com.synchro.appref.business.service.to

import br.com.synchro.appref.business.model.Post

/**
 * <pre>
 * User: rfh
 * Date: 11/11/13
 * 
 * </pre>
 */
class BlogDiffTO {

    String key
    String name
    PersonTO author

    Set<PersonFavoritePostsTO> readers
    Set<PostTO> posts

}
