package br.com.synchro.appref.business.service.assembler

import br.com.synchro.appref.business.model.Domain

/**
 * <pre>
 * User: rfh
 * Date: 11/11/13
 * 
 * </pre>
 */
interface DomainTOMapper <T extends Domain> {

    Boolean maps(final Class pDomainClazz)

    Map<String, Object> mapProperties(final T pDomain)
}
