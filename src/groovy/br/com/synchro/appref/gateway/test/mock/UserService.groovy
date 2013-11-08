package br.com.synchro.appref.gateway.test.mock

import br.com.synchro.appref.business.service.integration.IUserService
import com.google.common.collect.ImmutableMap

/**
 * <pre>
 * User: rfh
 * Date: 11/8/13
 *
 * </pre>
 */
class UserService implements IUserService{

    private final userMap = ImmutableMap.copyOf([
            "ricardo.hori@synchro.com.br": false,
            "guilherme.roveri@synchro.com.br": true,
            "paulo.freitas@synchro.com.br": true
    ])

    @Override
    Boolean authorIsAUser(final String pEmail) {
        return userMap[pEmail]
    }
}
