package com.vemser.rest.data.provider;

import com.vemser.rest.data.factory.UsuariosDataFactory;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class UsuariosDataProvider {

    private static final String KEY_NOME = "nome";
    private static final String VALUE_NOME_EM_BRANCO = "nome não pode ficar em branco";
    private static final String KEY_EMAIL = "email";
    private static final String VALUE_EMAIL_EM_BRANCO = "email não pode ficar em branco";
    private static final String KEY_PASSWORD = "password";
    private static final String VALUE_PASSWORD_EM_BRANCO = "password não pode ficar em branco";
    private static final String KEY_ISADMIN = "administrador";
    private static final String VALUE_ISADMIN_EM_BRANCO = "administrador deve ser 'true' ou 'false'";

    public static Stream<Arguments> usuarioDataProvider() {
        return Stream.of(
                Arguments.of(UsuariosDataFactory.usuarioComNomeEmBranco(), KEY_NOME, VALUE_NOME_EM_BRANCO),
                Arguments.of(UsuariosDataFactory.usuarioComEmailEmBranco(), KEY_EMAIL, VALUE_EMAIL_EM_BRANCO),
                Arguments.of(UsuariosDataFactory.usuarioComPasswordEmBranco(), KEY_PASSWORD, VALUE_PASSWORD_EM_BRANCO),
                Arguments.of(UsuariosDataFactory.usuarioComIsAdminEmBranco(), KEY_ISADMIN, VALUE_ISADMIN_EM_BRANCO)
        );
    }
}
