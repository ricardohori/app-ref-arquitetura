package br.com.synchro.appref.gateway.converter

import com.google.gson.Gson

/**
 * <pre>
 * User: rfh
 * Date: 11/8/13
 *
 * </pre>
 */
class JsonTOConverter implements IJsonTOConverter{

    private final Gson gsonInstance

    public JsonTOConverter(){
        gsonInstance = new Gson()
    }

    @Override
    public <T> T fromJson(String pJson, Class<T> clazz) {
        gsonInstance.fromJson(pJson, clazz)
    }

    @Override
    public <T> String toJson(T pTO) {
        gsonInstance.toJson(pTO)
    }
}
