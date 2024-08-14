package com.vemser.rest.data.factory;

import com.vemser.rest.model.UsuariosModel;
import net.datafaker.Faker;
import org.apache.commons.lang3.StringUtils;

import java.util.Locale;
import java.util.Random;

public class UsuariosDataFactory {

    private static Faker faker = new Faker(new Locale("PT-BR"));
    private static Random geradorBoolean = new Random();

    public static UsuariosModel usuarioValido() {
        return novoUsuario();
    }

    public static UsuariosModel usuarioComNomeEmBranco() {
        UsuariosModel usuario = novoUsuario();
        usuario.setNome(StringUtils.EMPTY);

        return usuario;
    }

    public static UsuariosModel usuarioComEmailEmBranco() {
        UsuariosModel usuario = novoUsuario();
        usuario.setEmail(StringUtils.EMPTY);

        return usuario;
    }

    public static UsuariosModel usuarioComPasswordEmBranco() {
        UsuariosModel usuario = novoUsuario();
        usuario.setPassword(StringUtils.EMPTY);

        return usuario;
    }

    public static UsuariosModel usuarioComIsAdminEmBranco() {
        UsuariosModel usuario = novoUsuario();
        usuario.setAdministrador(StringUtils.EMPTY);

        return usuario;
    }

    public static UsuariosModel usuarioComDadosEmBranco() {

        UsuariosModel usuario = novoUsuario();
        usuario.setNome(StringUtils.EMPTY);
        usuario.setEmail(StringUtils.EMPTY);
        usuario.setPassword(StringUtils.EMPTY);
        usuario.setAdministrador(StringUtils.EMPTY);

        return usuario;
    }

    private static UsuariosModel novoUsuario() {

        UsuariosModel usuario = new UsuariosModel();
        usuario.setNome(faker.name().firstName() + " " + faker.name().lastName());
        usuario.setEmail(faker.internet().emailAddress());
        usuario.setPassword(faker.internet().password());
        usuario.setAdministrador(String.valueOf(geradorBoolean.nextBoolean()));

        return usuario;
    }


}
