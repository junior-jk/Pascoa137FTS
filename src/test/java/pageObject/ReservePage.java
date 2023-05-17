package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReservePage extends Base {

    public ReservePage(WebDriver driver)
    {
        super (driver);

    }

    // apenas a frase que diz a origem e destino
    public By byCabecalhoListaVoos = By.cssSelector ("div.container h3");

    public String lerCabecalhoListaVoos() {
        return driver.findElement (byCabecalhoListaVoos).getText ();
    }

    // Acao
    // Titulo da guia reserve
    public String lerTituloGuia() {
        return driver.getTitle ();
    }
}