package br.com.synchro.appref.gateway.test

import br.com.synchro.appref.business.repository.BlogRepository
import br.com.synchro.appref.business.repository.PersonRepository
import br.com.synchro.appref.business.service.assembler.BlogAssembler
import br.com.synchro.appref.business.service.assembler.PersonAssembler
import br.com.synchro.appref.gateway.data.BlogRepositoryMongo
import br.com.synchro.appref.gateway.data.PersonRepositoryMongo

/**
 * <pre>
 * User: rfh
 * Date: 11/8/13
 *
 * </pre>
 */
class UnitBeans {

    private static final beans = [:]

    static {
        beans << [(BlogRepository): new BlogRepositoryMongo()]

        beans << [(PersonRepository): new PersonRepositoryMongo()]

        beans << [(PersonAssembler): new PersonAssembler(
                findBean(PersonRepository)
        )]

        beans << [(BlogAssembler): new BlogAssembler(
                findBean(PersonAssembler),
                findBean(BlogRepository)
        )]

    }

    static <T> T findBean(final Class<T> pBean){
        final bean = pBean.cast beans[pBean]
        if(!bean) throw new IllegalArgumentException("No bean named [${pBean.simpleName}] is registered for unit tests!")
        bean
    }
}
