package br.com.synchro.appref.business.service.assembler

import br.com.synchro.appref.business.service.to.PersonTO
import br.com.synchro.appref.business.model.Person
import br.com.synchro.appref.business.repository.PersonRepository

/**
 * <pre>
 * User: rfh
 * Date: 11/8/13
 *
 * </pre>
 */
class PersonAssembler {

    private final PersonRepository personRepository

    PersonAssembler(final PersonRepository pPersonRepository){
        personRepository = pPersonRepository
    }

    PersonTO assemble(final Person pPerson){
        new PersonTO(pPerson.properties)
    }

    Person dismantle(final PersonTO pPerson){
        final person = personRepository.findByKey(pPerson.key) ?: new Person()

        person.properties << pPerson.properties
        person
    }
}
