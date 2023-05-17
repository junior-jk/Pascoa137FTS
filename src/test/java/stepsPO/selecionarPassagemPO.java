package stepsPO;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObject.HomePage;
import pageObject.ReservePage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class selecionarPassagemPO {

    private WebDriver driver;
    private HomePage homePage;// mapeamento da home
    private ReservePage reservePage;


    @Before
    public void setup() {

        WebDriverManager.chromedriver ().setup ();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\henrr\\IdeaProjects\\Pascoa137\\drivers\\chrome\\chromedriver.exe");
        driver = new ChromeDriver (options);
        driver.manage ().window ().maximize ();
        driver.manage ().timeouts ().implicitlyWait (Duration.ofMillis (6000));

        // instancia as classes de mapeamento

        homePage = new HomePage (driver);
        reservePage = new ReservePage (driver);

    }

    @After
    public void tearDown() {
        //driver.quit();
    }

    @Given("que acesso a pagina inicial PO")
    public void que_acesso_a_pagina_inicial_po(){
        driver.get("https://blazedemo.com");

    }

    @When("seleciono origem {string} e destino {string} PO")
    public void seleciono_origem_e_destino_po(String origem, String destino){
        homePage.selecionarOrigemDestino(origem,destino);

    }
    @When ("clico no botao Find Flights PO")
    public void clico_no_botao_find_flights_po(){
        homePage.clicarBtnProcurarVoo();
    }

    @Then("exibe pagina de voos entre origem e destino disponiveis PO")
    public void exibe_pagina_de_voos_entre_origem_e_destino_disponiveis_po(String origem, String destino){
        assertEquals("Flights from " + origem + " to " + destino +":",reservePage.lerCabecalhoListaVoos());
    }
}


        /*synchronized (driver) {
            try {
                driver.wait(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }*/

