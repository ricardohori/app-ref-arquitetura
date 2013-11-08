package br.com.synchro.appref.business.service.assembler

import br.com.synchro.appref.business.model.Domain

/**
 * <pre>
 * User: rfh
 * Date: 11/8/13
 *
 * </pre>
 */
class AssemblerUtils {

    static <T extends Domain> Map<String, Object> mapifyDomain(final T pDomain){
        final returnMap = [:] as Map<String, Object>
        final rootMap = pDomain.properties

        rootMap.each{property, value->
            if(value instanceof Domain){
                returnMap[property] = mapifyDomain(value)
            }else if(value instanceof Collection && value.first() instanceof Domain){
                returnMap[property] = value.collect { mapifyDomain(it as Domain)}
            }else{
                returnMap[property] = value
            }
        }
        returnMap
    }
}
