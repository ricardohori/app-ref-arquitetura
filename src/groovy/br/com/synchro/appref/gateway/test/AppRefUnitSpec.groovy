package br.com.synchro.appref.gateway.test

import grails.plugin.spock.UnitSpec

/**
 * <pre>
 * User: rfh
 * Date: 11/8/13
 *
 * </pre>
 */
class AppRefUnitSpec extends UnitSpec{

    def <T> T getUnitBean(Class<T> pBean){
        UnitBeans.findBean(pBean)
    }

}
