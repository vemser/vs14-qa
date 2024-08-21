package automationexercise.factory.data;


import automationexercise.dto.LoginDto;
import automationexercise.util.DataFakerGeneretor;

public class LoginData {

    // instanciar a ferramenta Faker
    DataFakerGeneretor dataFakerGeneretor = new DataFakerGeneretor();


    // Gerar dados fakes e guardar no DTO correspondente
    public LoginDto loginDadosValidos(){
        // Instanciar = conexão com LoginDto
        LoginDto loginDto = new LoginDto();
        loginDto.setEmail("vs@gmail.com");
        loginDto.setSenha("123456");

        return loginDto;
    }


    // Gerar dados fakes e guardar no DTO correspondente
    public LoginDto LoginDadoDinamicos(){
        // Instanciar = conexão com LoginDto
        LoginDto loginDto = new LoginDto();
            loginDto.setEmail(dataFakerGeneretor.emailFaker());
            loginDto.setSenha(dataFakerGeneretor.senhaFaker());

        return loginDto;
    }





}
