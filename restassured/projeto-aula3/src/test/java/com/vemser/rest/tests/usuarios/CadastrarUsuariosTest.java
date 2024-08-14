package com.vemser.rest.tests.usuarios;

import com.vemser.rest.client.UsuariosClient;
import com.vemser.rest.data.factory.UsuariosDataFactory;
import com.vemser.rest.model.UsuariosModel;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class CadastrarUsuariosTest {

    private final UsuariosClient usuariosClient = new UsuariosClient();
    private final String NOME_EM_BRANCO = "nome não pode ficar em branco";
    private final String EMAIL_EM_BRANCO = "email não pode ficar em branco";

    @Test
    public void testCadastrarUsuarioComSucesso() {

        UsuariosModel usuario = UsuariosDataFactory.usuarioValido();

        usuariosClient.cadastrarUsuarios(usuario)
        .then()
                .statusCode(200)
        ;
    }

    @Test
    public void testDeveCadastrarUsuarioSemNome() {

        UsuariosModel usuario = UsuariosDataFactory.usuarioComNomeEmBranco();

        usuariosClient.cadastrarUsuarios(usuario)
        .then()
                .statusCode(400)
        ;
    }

    @Test
    public void testDeveCadastrarUsuarioComTodosDadosEmBranco() {

        UsuariosModel usuario = UsuariosDataFactory.usuarioComDadosEmBranco();

        UsuariosModel response = usuariosClient.cadastrarUsuarios(usuario)
                .then()
                    .extract()
                        .as(UsuariosModel.class)
                ;

        Assertions.assertAll("response",
                () -> Assertions.assertEquals(NOME_EM_BRANCO, response.getNome()),
                () -> Assertions.assertEquals(EMAIL_EM_BRANCO, response.getEmail())
        );
    }

    @ParameterizedTest
    @MethodSource("com.vemser.rest.data.provider.UsuariosDataProvider#usuarioDataProvider")
    public void testDeveCadastrarUsuariosComDataProvider(UsuariosModel usuario, String key, String value){

        usuariosClient.cadastrarUsuarios(usuario)
                .then()
                    .statusCode(400)
                    .body(key, Matchers.equalTo(value))
                ;
    }
}
