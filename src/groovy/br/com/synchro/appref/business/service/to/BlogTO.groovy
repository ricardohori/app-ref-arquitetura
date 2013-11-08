package br.com.synchro.appref.business.service.to

/**
 * <pre>
 * User: rfh
 * Date: 11/8/13
 *
 * </pre>
 */
class BlogTO {
    String key
    String name
    PersonTO author

    Set<PersonTO> readers
    Set<PostTO> posts
}
