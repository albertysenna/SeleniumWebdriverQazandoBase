package steps;

import driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import pages.LoginPage;
import support.ScreenshotUtils;

public class LoginSteps  {

    LoginPage loginPage = new LoginPage();

    @Dado("que estou na tela de login")
    public void que_estou_na_tela_de_login() {

        loginPage.acessarAplicacao();
        loginPage.acessarTelaLogin();
    }

    @Quando("preencho login {string} e senha {string}")
    public void preencho_login_e_senha(String email, String senha) {
        loginPage.preencherEmail(email);
        loginPage.preencherSenha(senha);
    }

    @Quando("clico em Login")
    public void clico_em_Login() {
        loginPage.clicarLogin();
    }

    @Então("vejo mensagem de login com sucesso")
    public void vejo_mensagem_login_sucesso() {

        loginPage.verificaLoginSucesso();
    }

    @Então("vejo mensagem {string} de campo não preenchido")
    public void vejo_mensagem_de_campo_nao_preenchido(String message)  {

        loginPage.verificaCampoVazio(message);
    }

    @Quando("acesso a tela de cadastro de usuário")
    public void acesso_a_tela_de_cadastro_de_usuario() {
        loginPage.acessarTelaCadastro();
    }

    @Dado("que estou logado na aplicação com user {string} e senha {string}")
    public void que_estou_logado_na_aplicacao_com_user_e_senha(String email, String senha)  {
        loginPage.acessarAplicacao();
        loginPage.acessarTelaLogin();
        loginPage.preencherEmail(email);
        loginPage.preencherSenha(senha);
        loginPage.clicarLogin();
        loginPage.verificaLoginSucesso();
    }

//    @After
//    public void tirarPrint(Scenario scenario){
//
//        System.out.println(" ====================================== ");
//        System.out.println("Cenário: " + scenario.getName());
//        System.out.println("Status: " + scenario.getStatus());
//        System.out.println("Tag: " + scenario.getSourceTagNames());
//        System.out.println("========================================");
//
//
//        if(scenario.isFailed()){
//
//            //tirar print da tela
//            ScreenshotUtils.adicionarPrintNoCenario(scenario);
//
//        }
//        DriverFactory.quitDriver();
//
//    }
}
