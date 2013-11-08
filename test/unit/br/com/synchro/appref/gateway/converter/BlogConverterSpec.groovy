package br.com.synchro.appref.gateway.converter

import br.com.synchro.appref.gateway.test.AppRefUnitSpec
import com.google.gson.Gson
import br.com.synchro.appref.business.service.to.BlogTO

/**
 * <pre>
 * User: rfh
 * Date: 11/8/13
 *
 * </pre>
 */
class BlogConverterSpec extends AppRefUnitSpec{

    private final gsonInstance = new Gson()
    private final converter = new JsonTOConverter()

    def "Must be able to convert from json to TO and back"(){
        given:
        final blogJson = gsonInstance.toJson([
                key: "blog_20131107142115109",
                name: "Ninja blog!",
                author:[
                        key: "person_20131107142115110",
                        name: "Jiraya",
                        email: "jiraya@synchro.com.br"
                ],
                readers: [
                        [
                                key: "person_20131107142115110",
                                name: "Jiraya",
                                email: "jiraya@synchro.com.br"
                        ]
                ],
                posts: [
                        [
                                key: "post_20131107142115110",
                                title: "The way of the ninja!",
                                content: "Be zen"
                        ]
                ]
        ])

        when:
        final blogTO = converter.fromJson(blogJson, BlogTO)

        then:
        converter.toJson(blogTO)
    }
}
