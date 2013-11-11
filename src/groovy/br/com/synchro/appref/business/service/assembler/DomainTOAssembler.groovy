package br.com.synchro.appref.business.service.assembler

import br.com.synchro.appref.business.model.Domain
import com.google.gson.Gson

/**
 * <pre>
 * User: rfh
 * Date: 11/11/13
 * 
 * </pre>
 */
class DomainTOAssembler {

    private final Gson gsonInstance

    DomainTOAssembler(){
        gsonInstance = new Gson()
    }

    DomainToTO from(final Domain pDomain){
        new DomainToTO(pDomain)
    }

    private class DomainToTO {

        private final Domain domain
        private Set<DomainTOMapper> mappers = [].toSet()

        DomainToTO(final Domain pDomain){
            domain = pDomain
        }

        DomainToTO with(final Class<? extends DomainTOMapper> pMapperClazz){
            mappers << pMapperClazz.newInstance()
            this
        }

        public <T> T to(final Class<T> pClazz){
            final properties = resolvePropertiesFor(this.domain)
            final json = gsonInstance.toJson(mapify(properties))
            gsonInstance.fromJson(json, pClazz)
        }

        private resolvePropertiesFor(final Domain pDomain){
            final mapper = mappers.find{ it.maps(pDomain.class) }
            mapper? mapper.mapProperties(pDomain) : [:] << pDomain.properties
        }

        private Map<String, Object> mapify(final Map<String, Object> pProperties){
            pProperties.collectEntries{k,v->[(k):mapValue(v)]} as Map<String, Object>
        }

        private Object mapValue(final Object pValue){
            if(pValue instanceof Domain){
                final properties = resolvePropertiesFor(pValue)
                return mapify(properties)
            }else if(pValue instanceof Map){
                return mapify(pValue)
            }else if(pValue instanceof Collection){
                return pValue.collect { mapValue(it)}
            }

            pValue
        }
    }
}
