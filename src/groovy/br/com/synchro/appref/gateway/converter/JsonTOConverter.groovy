package br.com.synchro.appref.gateway.converter

import com.google.gson.Gson

/**
 * <pre>
 * User: rfh
 * Date: 11/8/13
 *
 * </pre>
 */
class JsonTOConverter{

    private final Gson gsonInstance

    public JsonTOConverter(){
        gsonInstance = new Gson()
    }

    JsonToTO from(final String pJson){
        new JsonToTO(pJson)
    }

    String from(final Object pObject){
        gsonInstance.toJson(pObject)
    }

    private class JsonToTO {

        private final String json

        JsonToTO(final String pJson){
            json = pJson
        }

        public <T> T to(Class<T> pClazz){
           gsonInstance.fromJson(json, pClazz)
        }
    }
}
