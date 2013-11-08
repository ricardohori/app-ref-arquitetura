package br.com.synchro.appref.business.repository

import br.com.synchro.appref.business.model.Person

/**
 * Created with IntelliJ IDEA.
 * User: rfh
 * Date: 11/7/13
 * Time: 6:42 PM
 * To change this template use File | Settings | File Templates.
 */
interface PersonRepository extends BaseAppRefRepository<Person>{

    Person whosNameIs(final String pName)

}
