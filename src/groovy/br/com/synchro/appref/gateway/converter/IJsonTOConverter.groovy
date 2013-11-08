package br.com.synchro.appref.gateway.converter

/**
 * <pre>
 * User: rfh
 * Date: 11/8/13
 *
 * </pre>
 */
interface IJsonTOConverter {

    public <T> T fromJson(final String pJson, final Class<T> clazz)

    public <T> String toJson(final T pTO)

}
