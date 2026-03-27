package steps;


import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Então;
import pages.CadastroUsuarioPage;
import pages.LoginPage;

import java.io.IOException;

import static support.Commands.clickElement;
import static support.Commands.waitElementBeClickable;
import static support.Utils.getRandomEmail;


public class CadastroUsuarioSteps {

    LoginPage loginPage = new LoginPage();
    CadastroUsuarioPage cadastroPage = new CadastroUsuarioPage();

    @Dado("^que estou na tela de cadastro de usuário$")
    public void que_estou_na_tela_de_login() {
        loginPage.acessarAplicacao();
        loginPage.acessarTelaCadastro();
    }

    @Dado("^preencho todos os campos obrigatórios$")
    public void preencho_campos_obrigatorios() throws IOException {

        cadastroPage.preencheNome("Eduardo");
        cadastroPage.preencheEmail(getRandomEmail());
        cadastroPage.preencherSenha("1234567");
    }

    @Quando("^clico em cadastrar$")
    public void clico_cadastrar() throws IOException {

        cadastroPage.cadastrarUsuario();
    }

    @Então("^vejo mensagem de usuário cadastrado com sucesso$")
    public void vejo_mensagem_cadastro_sucesso() {
        cadastroPage.verificaCadastroSucesso();
    }

}
