package com.vemser.rest.tests.usuarios;

import com.vemser.rest.model.usuarios.Usuarios;
import com.vemser.rest.model.usuarios.UsuariosResponse;
import io.restassured.http.ContentType;

import net.datafaker.Faker;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.Random;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class UsuariosTest {

    Faker faker = new Faker(new Locale("PT-BR"));
    Random geradorBoolean = new Random();

    @BeforeEach
    public void setUp() {
        baseURI = "http://localhost:3000";
    }

    @Test
    public void testListarTodosUsuariosComSucesso() {

        given()
        .when()
                .get("/usuarios")
        .then()
                .statusCode(200)
        ;
    }

    @Test
    public void testListarUsuariosPorNomeComSucesso() {

        String nome = "Luiz Henrique Peres";

        given()
                .log().all()
                .queryParam("nome", nome)
        .when()
                .get("/usuarios")
        .then()
                .log().all()
                .statusCode(200)
        ;
    }

    @Test
    public void testBuscarUsuarioPorIDComHamcrest() {

        String id = "SSfUpYxyOTgdjYCL";

        given()
                .log().all()
                .pathParam("id", id)
        .when()
                .get("/usuarios/{id}")
        .then()
                .log().all()
                .header("Content-Type", "application/json; charset=utf-8")
                .statusCode(200)
                .time(lessThan(3000L))
                .body("_id", notNullValue())
                .body("nome", equalTo("Pietra da Aldeia"))
                .body("email", containsStringIgnoringCase("nathan"))
        ;
    }

    @Test
    public void testBuscarUsuarioPorIDComAssertions() {

        String id = "SSfUpYxyOTgdjYCL";

        UsuariosResponse response =
        given()
                .log().all()
                .pathParam("id", id)
        .when()
                .get("/usuarios/{id}")
        .then()
                .log().all()
                .statusCode(200)
                .extract()
                    .as(UsuariosResponse.class)
        ;

        Assertions.assertEquals("Pietra da Aldeia", response.getNome());
        Assertions.assertEquals("nathan.barbosa@bol.com.br", response.getEmail());
    }

    @Test
    public void testBuscarUsuarioPorIDComAssertAll() {

        String id = "SSfUpYxyOTgdjYCL";

        UsuariosResponse response =
                given()
                        .log().all()
                        .pathParam("id", id)
                .when()
                        .get("/usuarios/{id}")
                .then()
                        .log().all()
                        .statusCode(200)
                        .extract()
                            .as(UsuariosResponse.class)
                ;

        Assertions.assertAll("response",
                () -> Assertions.assertEquals("Pietra da Aldeia", response.getNome()),
                () -> Assertions.assertEquals("nathan.barbosa@bol.com.br", response.getEmail()),
                () -> Assertions.assertTrue(response.getEmail().contains("nathan")),
                () -> Assertions.assertNotNull(response.getPassword())
        );
    }

    @Test
    public void testDeveValidarContratoUsuariosPorIDComSucesso() {

        String id = "SSfUpYxyOTgdjYCL";

        given()
                .pathParam("_id", id)
        .when()
                .get("/usuarios/{_id}")
        .then()
                .statusCode(HttpStatus.SC_OK)
                .body(matchesJsonSchemaInClasspath("schemas/usuarios_por_id.json"))
        ;
    }

    @Test
    public void testCadastrarUsuarioComSucesso() {

        // massa de teste - body - payload
        Usuarios usuario = new Usuarios();
        usuario.setNome(faker.name().firstName() + " " + faker.name().lastName());
        usuario.setEmail(faker.internet().emailAddress());
        usuario.setPassword(faker.internet().password());
        usuario.setAdministrador(String.valueOf(geradorBoolean.nextBoolean()));

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(usuario)
        .when()
                .post("/usuarios")
        .then()
                .log().all()
                .statusCode(201)
        ;
    }

    @Test
    public void testAtualizarUsuariosComSucesso() {

        String id = "dEV1fk1klY3pl28P";

        // massa de teste - body - payload
        Usuarios usuario = new Usuarios();
        usuario.setNome(faker.name().firstName() + " " + faker.name().lastName());
        usuario.setEmail(faker.internet().emailAddress());
        usuario.setPassword(faker.internet().password());
        usuario.setAdministrador(String.valueOf(geradorBoolean.nextBoolean()));

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(usuario)
                .pathParam("id", id)
        .when()
                .put("/usuarios/{id}")
        .then()
                .log().all()
                .statusCode(200)
        ;
    }

    @Test
    public void testExcluirUsuarioComSucesso() {

        String id = "dEV1fk1klY3pl28P";

        given()
                .log().all()
                .pathParam("id", id)
        .when()
                .delete("/usuarios/{id}")
        .then()
                .log().all()
                .statusCode(200)
        ;
    }

}
