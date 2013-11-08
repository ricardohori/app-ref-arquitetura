package br.com.synchro.appref.business.repository

import br.com.synchro.appref.business.model.Blog
import br.com.synchro.appref.business.model.Person

/**
 * Created with IntelliJ IDEA.
 * User: rfh
 * Date: 11/7/13
 * Time: 6:41 PM
 * To change this template use File | Settings | File Templates.
 */
interface BlogRepository extends BaseAppRefRepository<Blog>{

    Set<Blog> withAuthor(final Person pAuthor)

}
