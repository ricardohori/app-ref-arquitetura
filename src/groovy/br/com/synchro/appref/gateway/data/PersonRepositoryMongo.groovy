package br.com.synchro.appref.gateway.data

import br.com.synchro.appref.business.repository.PersonRepository
import br.com.synchro.appref.business.model.Person

/**
 * <pre>
 * User: rfh
 * Date: 11/8/13
 *
 * </pre>
 */
class PersonRepositoryMongo extends BaseRepositoryMongo<Person> implements PersonRepository{

    PersonRepositoryMongo(){
        super(Person.class)
    }

    @Override
    Person whosNameIs(final String pName) {
        Person.findByName(pName)
    }
}
