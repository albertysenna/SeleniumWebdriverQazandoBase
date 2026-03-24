package pages;

import driver.DriverFactory;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static support.Commands.*;

public class LoginPage {

    private String url = "http://automationpratice.com.br/";
    private By botaoAcessarLogin = By.cssSelector(".right_list_fix > li > a > .fa-user");

    private By campoEmail = By.id("user");
    private By campoSenha = By.id("password");
    private By botaoLogin = By.id("btnLogin");
    private By botaoAcessarCadastro = By.cssSelector(".right_list_fix > li > a > .fa-lock");

    public void acessarAplicacao(){
        DriverFactory.getDriver().get(url);
    }

    public void acessarTelaLogin() {

        clickElement(botaoAcessarLogin);

//        WebDriverWait wait = new WebDriverWait( DriverFactory.getDriver(), Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(botaoAcessarLogin)).click();

    }

    public void preencherEmail(String email){

//        WebDriverWait wait = new WebDriverWait( DriverFactory.getDriver(), Duration.ofSeconds(10));
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(campoEmail))
//                .sendKeys(email);

        fillField(campoEmail, email);
    }



    public void preencherSenha(String senha){

       // DriverFactory.getDriver().findElement(campoSenha).sendKeys(senha);

        fillField(campoSenha,senha);
    }

    public void clicarLogin(){

        clickElement(botaoLogin);
       // DriverFactory.getDriver().findElement(botaoLogin).click();
    }

    public void verificaLoginSucesso(){

        checkMessage(By.id("swal2-title"),"Login realizadoxx");

//        String textoLoginSucesso = DriverFactory.getDriver().findElement(By.id("swal2-title")).getText();
//        Assertions.assertEquals( "Login realizado", textoLoginSucesso, "Os textos não são iguais!");
    }


    public void verificaCampoVazio(String message){

        checkMessage(By.className("invalid_input"), message);

//        String textError = DriverFactory.getDriver().findElement(By.className("invalid_input")).getText();
//        Assertions.assertEquals(message, textError);
    }

    public void acessarTelaCadastro(){

        clickElement(botaoAcessarCadastro);
        //        DriverFactory.getDriver().findElement(botaoAcessarCadastro).click();
    }

}