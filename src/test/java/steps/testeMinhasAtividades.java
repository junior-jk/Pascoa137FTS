package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class testeMinhasAtividades {

    public WebDriver driver;
    public WebDriverWait wait;

    @Before
    public void setup() {

        WebDriverManager.chromedriver ().setup ();
        ChromeOptions options = new ChromeOptions ();

        options.addArguments ("--remote-allow-origins=*");
        driver = new ChromeDriver (options);
        driver.manage ().window ().maximize ();
        driver.manage ().timeouts ().implicitlyWait (60000, TimeUnit.MILLISECONDS);
        wait = new WebDriverWait (driver, Duration.ofMillis (5000));
    }

    @After
    public void tearDown() {
//        driver.quit ();
    }

    @Given("que acesso a pagina Admin Conteudo")
    public void que_acesso_a_pagina_admin_conteudo() {

        driver.get ("https://testando.eveclass.com/pt/admin/conteudo");
//        driver.manage().window().setSize(new Dimension (1024, 728));
        driver.findElement (By.cssSelector (".dropdown:nth-child(2)")).click ();
        driver.findElement (By.cssSelector (".dropdown-item:nth-child(3) .infos-text")).click ();
        driver.findElement (By.cssSelector (".button > .fas")).click ();

    }

    @When("clico em minha Conta Perfil")
    public void clico_em_minha_conta_perfil() {
        driver.findElement (By.cssSelector (".dropdown-icon")).click ();
    }

    @When("clico no menu Minhas Atividades")
    public void clico_no_menu_minhas_atividades() {
        driver.findElement (By.cssSelector (".no-link-style:nth-child(3)")).click ();

    }

    @Then("e exibido a mensagem procurar atividades")
    public void e_exibido_a_mensagem_procurar_atividades() {
        driver.findElement (By.xpath ("//*[@id=\"my-activities\"]/div/a")).click ();

    }
}