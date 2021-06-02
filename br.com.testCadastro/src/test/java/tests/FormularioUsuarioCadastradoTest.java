package tests;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class FormularioUsuarioCadastradoTest {
    private WebDriver navegador;

    public FormularioUsuarioCadastradoTest(WebDriver navegador){
        this.navegador = navegador;
    }

    public void validarUsuarioCadastrado(){
        WebElement formulario = navegador.findElement(By.cssSelector("div[class='register-form expanded'] > form + h2"));
        String tituloFormulario = formulario.getText();
        Assert.assertEquals(tituloFormulario, "Usuários cadastrados");
    }

    public void excluirUsuario(){
        WebDriverWait aguardar = new WebDriverWait(navegador, 10);
        aguardar.until(ExpectedConditions.elementToBeClickable
                (By.cssSelector("div[class='register-form expanded'] > table > tr > td > a"))).click();
    }
}
