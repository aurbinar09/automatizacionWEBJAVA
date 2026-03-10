package org.example.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.example.tasks.OpenPage;
import org.example.ui.HomePageBlaze;
import org.example.ui.LoginPageBlaze;
import org.openqa.selenium.WebDriver;

public class RegistrarBlazeSD {
    private Actor usuario;

    @Before
    public void setTheStage(){
        OnStage.setTheStage(new OnlineCast());
        usuario = OnStage.theActorCalled("Usuario");
        WebDriver driver = ThucydidesWebDriverSupport.getDriver();
        usuario.can(BrowseTheWeb.with(driver));
    }

    @Given("el usuario esta en la pagina de inicio")
    public void elUsuarioEstaEnLaPaginaDeInicio() {
        String base_url = System.getProperty("base_url", "https://www.demoblaze.com/");
        usuario.attemptsTo(OpenPage.atUrl(base_url));
        
    }

    @And("selecciona el boton de registro")
    public void seleccionaElBotonDeRegistro() {
        usuario.attemptsTo(Click.on(HomePageBlaze.BTN_SIGN_UP));
        
    }

    @And("ingresa un nombre de usuario {string} y contraseña {string} blaz")
    public void ingresaUnNombreDeUsuarioYContraseñaBlaz(String username, String password) {
        usuario.attemptsTo(Enter.theValue(username).into(HomePageBlaze.INP_USERNAME));
        usuario.attemptsTo(Enter.theValue(password).into(HomePageBlaze.INP_PASSWORD));
    }

    @When("selecciona el boton registrar")
    public void seleccionaElBotonRegistrar() {
        usuario.attemptsTo(Click.on(HomePageBlaze.BTN_REGISTRAR));
        
    }

    @Then("se realiza el registro de manera exitosa")
    public void seRealizaElRegistroDeManeraExitosa() {
        System.out.println("exitoso");
    }
}
