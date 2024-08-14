package com.vemser.rest.client;

import com.vemser.rest.model.UsuariosModel;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class UsuariosClient extends BaseClient {

    private final String USUARIOS = "/usuarios";

    public Response cadastrarUsuarios(UsuariosModel usuario) {

        return
                given()
                        .spec(super.set())
                        .contentType(ContentType.JSON)
                        .body(usuario)
                .when()
                        .post(USUARIOS)
                ;
    }
}
