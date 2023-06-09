//0 - Pacote

package webTest;
// 1 - Bibliotecas


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 2 - Classes
public class comprarPassagemWD {
    // 2.1 - Atributos
    private WebDriver driver;  // declaramos o obejtos selenium

    // 2.2 - Funções e Métodos

@BeforeEach
    public void setUp(){ // iniciou da BeforeEach
    // declarar o gerenciador para baixar o chrome driver
    WebDriverManager.chromedriver().setup();
    // configuracao especifica a partir do Selenium webdriver
    ChromeOptions options = new ChromeOptions(); // intancia o chrome options liga ele
    // adiciona ao Chorme options  a opcao  de permitir qualquer origem de
    // acesso remoto
    options.addArguments("--remote-allow-origins=*");
    driver = new ChromeDriver(options); // instancia o Chrome Driver com options
    driver.manage().window().maximize();

} // fim do BeforeEach

    // Antes do teste



    // Depois do teste
    @AfterEach
    public void tearDown(){ // inicio do AfterEach
    //driver.quit(); // destroi a instancia do seleniumn web driver

    }// final do AfterAll

    // O teste
    @Test
    public void comprarPassagemWd(){ // inicou do teste

        driver.get("https://blazedemo.com/");  // // abre o endereço alvo
        // selecionar a lista/combo de cidades de origem
        driver.findElement(By.name("fromPort")).click();
        // selecionar a cidade na lista
        { //inicio da seleção dentro da lista
            WebElement lista = driver.findElement(By.name("fromPort"));
            lista.findElement(By.xpath("//option[.= 'São Paolo']")).click();
        } //fim da seleção dentro da lista

        driver.findElement(By.name("toPort")).click();
        // selecionar a cidade na lista
        { //inicio da seleção dentro da lista
            WebElement lista = driver.findElement(By.name("toPort"));
            lista.findElement(By.xpath("//option[.= 'Berlin']")).click();
        }  //fim da seleção dentro da lista

        // apertar o botão Find Flights
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();

        // validar a frase que indica que o vôo é de São Paolo para Berlin
        assertEquals("Flights from São Paolo to Berlin:",driver.findElement(By.cssSelector("h3")).getText());
         }
} // final da classe
