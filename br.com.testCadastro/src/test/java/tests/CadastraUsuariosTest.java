package tests;

import org.easetech.easytest.annotation.*;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "informacoesUsuarioTest.csv")

public class CadastraUsuariosTest {
    private WebDriver navegador;
    private CadastroUsuarioPage usuario;
    private FormularioUsuarioCadastradoTest usuarioCadastrado;

    @Before
    public void testConfiguracoes(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\drivers\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().window().maximize();
        navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        navegador.get("http://prova.stefanini-jgr.com.br/teste/qa/");
        usuario = new CadastroUsuarioPage(navegador);
        usuarioCadastrado = new FormularioUsuarioCadastradoTest(navegador);
    }

    @Test
    public void testNomeAbaNavegador(){
       usuario
               .pegarTituloNavegador()
               .validarTituloNavegador();
    }

    @Test
    public void testCadastrarUsuarioComSucesso(@Param(name = "name") String nome,
                                               @Param(name = "email") String email,
                                               @Param( name = "password") String senha){
        usuario
                .informarCampoNome(nome)
                .informarCampoEmail(email)
                .informarSenha(senha)
                .clicarBotaoCadastrar();

        usuarioCadastrado
                .validarUsuarioCadastrado();
    }

    @Test
    public void testValidarMensagensCamposObrigatorios(@Param(name = "name") String nome,
                                                   @Param(name = "email") String email,
                                                   @Param( name = "password") String senha,
                                                   @Param(name = "mensagem") String mensagem){

     usuario
             .informarCampoNome(nome)
             .informarCampoEmail(email)
             .informarSenha(senha)
             .clicarBotaoCadastrar()
             .validarMensagemCamposObrigatoria(mensagem);
    }


    @Test
    public void testCadastrarEExcluirUsuario(@Param(name = "name") String nome,
                                             @Param(name = "email") String email,
                                             @Param( name = "password") String senha){
        usuario
                .informarCampoNome(nome)
                .informarCampoEmail(email)
                .informarSenha(senha)
                .clicarBotaoCadastrar();

        usuarioCadastrado
                .excluirUsuario();
    }

    @Test
    public void excluirUsuario(){
        usuario
                .informarCampoNome("Teste Um")
                .informarCampoEmail("teste@teste.com")
                .informarSenha("123456789")
                .clicarBotaoCadastrar();

        usuario
                .informarCampoNome("Teste Dois")
                .informarCampoEmail("teste@teste.com")
                .informarSenha("123456789")
                .clicarBotaoCadastrar();

        usuario
                .informarCampoNome("Teste Três")
                .informarCampoEmail("teste@teste.com")
                .informarSenha("123456789")
                .clicarBotaoCadastrar();

        usuarioCadastrado
                .excluirUsuario();
    }

    @Test
    public void testNaoCadastrarComDadosEmBranco(){
        usuario.clicarBotaoCadastrar()
                .deixarDadosEmBranco();
    }
}
