package pages;

import driver.DriverFactory;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static support.Commands.clickElement;
import static support.Commands.fillField;

public class CadastroUsuarioPage {

    // elementos
    private By campoNome = By.id("user");
    private By campoEmail = By.id("email");
    private By campoSenha = By.id("password");
    private By botaoFazerCadastro = By.id("btnRegister");

    // ações / funções / métodos

    public void preencheNome(String nome) {

//         waitElementBeClickable(campoNome, 2000);
//         DriverFactory.getDriver().findElement(campoNome).sendKeys(nome);

        fillField(campoNome, nome);
    }

    public void preencheEmail(String email) {

        //  DriverFactory.getDriver().findElement(campoEmail).sendKeys(email);

        fillField(campoEmail, email);
    }

    public void preencherSenha(String senha) {

        // DriverFactory.getDriver().findElement(campoSenha).sendKeys(senha);

        fillField(campoSenha, senha);
    }

    public void cadastrarUsuario() {

        clickElement(botaoFazerCadastro);
        //DriverFactory.getDriver().findElement(botaoFazerCadastro).click();
    }

    public void verificaCadastroSucesso() {
        String textoLoginSucesso = DriverFactory.getDriver().findElement(By.id("swal2-title")).getText();
        Assertions.assertEquals("Cadastro realizado!", textoLoginSucesso, "Validar mensagem exibida");
    }
}
