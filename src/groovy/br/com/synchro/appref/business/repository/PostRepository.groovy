package br.com.synchro.appref.business.repository

import br.com.synchro.appref.business.model.Post

/**
 * Created with IntelliJ IDEA.
 * User: rfh
 * Date: 11/7/13
 * Time: 6:43 PM
 * To change this template use File | Settings | File Templates.
 */
interface PostRepository {

    Set<Post> withTitleMetioning(final String pTerm)

}
