package automationexercise.util;

import com.github.javafaker.Faker;

public class DataFakerGeneretor {

    // instanciar a ferramenta Faker
    private static final Faker faker = new Faker();

    public String emailFaker(){
        return faker.internet().emailAddress();
    }

    public String senhaFaker(){
        return faker.internet().password();
    }





}
