// nomedo pacote

package apiTest;


// Bibliotecas

import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


// Classe
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestUser{         // iniciou da classe
    // Atributos

    static String ct = "applicattion/json"; // content type
    static String uriUser = "https://petstore.swagger.io/v2/user/";

    // Funcoes e metodos
    // funcoes de apoio
    public static String lerArquivoJson(String arquivoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(arquivoJson)));

    }
    // Funcoes de teste
    @Test
    @Order(1)
    public void testarIncluirUser() throws IOException {
        String jsonBody = lerArquivoJson("src/test/resources/json/user1.json");

        String userId = "1372955451";

        // realiza o teste

        given()                                                             // Dado que
                .contentType (ct)
                .log().all()                                              // o tipo do conteudo
                .body(jsonBody)                                          //  o corpo da requisicao
        .when()                                                         // quando
                .post(uriUser)                                         // End point // Onde
        .then()                                                       // Entao
                .log().all()                                         // Mostre tudo na volta
                .statusCode(200)                                    // comunicacao ida e volta ok
                .body("code", is(200))                    // tag code e 200
                .body("type", is("unknown"))             // tag e o type unknown
                .body("message", is(userId));                  // message e o userId
            }// final do Post

    @Test
    @Order(2)
    public void testarConsultarUser(){
        String username = "jota";

        //Resultado Esperado
        int userId = 1372955451;
        String email = "chico@test.com";
        String senha = "123456";
        String telefone = "18999998888";


        given()
                .contentType (ct)
                .log().all()
        .when()
                .get(uriUser + username)
        .then()
                .log().all()
                .statusCode(200)
                .body("id", is(userId))
                .body("email", is(email))
                .body("password", is(senha))
                .body("phone", is(telefone));
    }

    @Test
    @Order(3)
    public void testarAlterarUser() throws IOException { // iniciou do Put
        String jsonBody = lerArquivoJson("src/test/resources/json/user2.json");

        String userId = "1372955451";
        String username = "jota";

        given()
                .header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON) // mostre tudo
                .log().all()
                .body(jsonBody)
        .when()
                .put(uriUser + username)
        .then()
                .log().all()
                .statusCode(200)
                .body("code", is(200))                      // tag code e 200
                .body("type", is("unknown"))              // tag e o type unknown
                .body("message", is(userId))
        ;
    } // final do Put
    @Test
    @Order(4)
    public void testarExcluirUser () {        // iniciou do delete User
        String username = "jota";

        given()
                .header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON) // mostre tudo
                .log().all()
        .when()
                .delete(uriUser + username)
        .then()
                .statusCode(200)
                .body("code", is(200))
                .body("type", is("unknown"))
                .body("message", is(username));
    }// fim do delete User


    @Test
    @Order(5)
    public void testarLogin() throws InterruptedException {

        String username = "jota";
        String password = "123";

       Response response = (Response) given()
                .header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON) // mostre tudo
                .log().all()
        .when()
                .get(uriUser + "login?username=" + username + "&password=" + password)
        .then()
                .statusCode(200)
                .body("code", is(200))
                .body("type", is("unknown"))
                .body("message", containsString("logged in user session:"))
                .body("message", hasLength(36))
        .extract()
        ;
        // extracao do token.
        String token = response.jsonPath().getString("message").substring(23);
        System.out.println("Conteudo do Token: " + token);

    }
    @Order(6)
    @ParameterizedTest
    @CsvFileSource(resources = "csv/massaUUser.csv", numLinesToSkip = 1, delimiter = 1)
    public void testarIncluirCSV(
           String id,
           String username,
           String firstName,
           String lastName,
           String email,
           String password,
           String phone,
           String userStatus){
        
//        StringBuilder jsonBody = new StringBuilder("{");
//        jsonBody.append("'id':" + id + ",");
//                jsonBody.append("'username':" + username + ",");
//                jsonBody.append("'firstName':" + firstName + ",");
//                jsonBody.append("'lastName':" + lastName +",");
//                jsonBody.append("'email':" + email + ",");
//                jsonBody.append("'password':" + password +  ",");
//                jsonBody.append("'phone':" + phone + ",");
//                jsonBody.append("'userStatus':" + userStatus);
//                jsonBody.append("}");

        String userId = "1372955451";
        User user = new User(); // instancia a classe User

        user.id = id;
        user.username = username;
        user.firstName = firstName;
        user.lastName = lastName;
        user.email = email;
        user.password = password;
        user.phone = phone;
        user.userStatus = userStatus;

        Gson gson = new Gson(); // instancia a classe Gson

        String jsonBody = gson.toJson(user);

        // realiza o teste
        given()                                                             // Dado que
                .header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON) // mostre tudo
                .log().all()                                              // o tipo do conteudo
                .body(jsonBody)                                          //  o corpo da requisicao
        .when()                                                         // quando
                .post(uriUser)                                         // End point // Onde
        .then()                                                       // Entao
                .log().all()                                         // Mostre tudo na volta
                .statusCode(200)                                  // comunicacao ida e volta ok
                .body("code", is(200))                      // tag code e 200
                .body("type", is ("unknown"))              // tag e o type unknown
                .body("message", is(userId));                  // message e o userId
    } //fim do CSV
}// final da classe



