package tests;

import org.junit.Assert;
import org.openqa.selenium.*;

public class CadastroUsuarioPage {
    private WebDriver navegador;
    private String tituloAbaNavegador;

    CadastroUsuarioPage(WebDriver navegador) {
        this.navegador = navegador;
    }

    public CadastroUsuarioPage pegarTituloNavegador() {
        this.tituloAbaNavegador = navegador.getTitle();
        return this;
    }

    public void validarTituloNavegador() {
        Assert.assertEquals(tituloAbaNavegador, "Cadastro de usuários");
    }

    public CadastroUsuarioPage informarCampoNome(String nome) {
        navegador.findElement(By.id("name")).sendKeys(nome);
        return this;
    }

    public CadastroUsuarioPage informarCampoEmail(String email) {
        navegador.findElement(By.id("email")).sendKeys(email);
        return this;
    }

    public CadastroUsuarioPage clicarBotaoCadastrar() {
        navegador.findElement(By.id("register")).click();
        return this;
    }

    public CadastroUsuarioPage informarSenha(String senha) {
        navegador.findElement(By.id("password")).sendKeys(senha);
        return this;
    }

    public void deixarDadosEmBranco(){
        String cabecalho = "Formulário";
        WebElement msg = navegador.findElement(By.cssSelector("div[class='register-form '] > h2"));
        String conferirCampo = msg.getText();
        Assert.assertEquals(conferirCampo, cabecalho);
    }

    public void validarMensagemCamposObrigatoria(String mensagem) {
        WebElement msgErro = navegador.findElement(By.cssSelector("p[class='error']"));
        String nomeObrigatorio = msgErro.getText();
        Assert.assertEquals(nomeObrigatorio, mensagem);
    }
}
