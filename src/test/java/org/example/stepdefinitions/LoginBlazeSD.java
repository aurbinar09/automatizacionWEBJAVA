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
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.example.questions.BlazeDemoScreenData;
import org.example.questions.HomeSauceDemoScreenData;
import org.example.tasks.LoginTask;
import org.example.tasks.LoginTaskBlaze;
import org.example.tasks.OpenPage;
import org.example.ui.HomePageBlaze;
import org.example.ui.LoginPageBlaze;
import org.openqa.selenium.WebDriver;

public class LoginBlazeSD {
    private Actor usuario;

    @Before
    public void setTheStage(){
        OnStage.setTheStage(new OnlineCast());
        usuario = OnStage.theActorCalled("Usuario");
        WebDriver driver = ThucydidesWebDriverSupport.getDriver();
        usuario.can(BrowseTheWeb.with(driver));
    }

    @Given("el usuario está en la página de inicio")
    public void elUsuarioEstáEnLaPáginaDeInicio() {
        String base_url = System.getProperty("base_url", "https://www.demoblaze.com/");
        usuario.attemptsTo(OpenPage.atUrl(base_url));
    }

    @And("el usuario selecciona el boton de login")
    public void elUsuarioSeleccionaElBotonDeLogin() {
        usuario.attemptsTo(Click.on(LoginPageBlaze.BTN_LOGIN));
    }

    @And("ingresa un nombre de usuario {string} y contraseña {string}")
    public void ingresaUnNombreDeUsuarioYContraseña(String username, String password) {
        usuario.attemptsTo(LoginTaskBlaze.perform(username,password));
    }

    @When("el usuario selecciona el boton de logearse")
    public void elUsuarioSeleccionaElBotonDeLogearse() {

        usuario.attemptsTo(Click.on(LoginPageBlaze.BTN_LOGIN_ING));
    }

    @Then("se realiza el logeo de manera correcta")
    public void seRealizaElLogeoDeManeraCorrecta() {
        usuario.attemptsTo(
                Ensure.that(BlazeDemoScreenData.isTitleVisible()).isTrue()
        );
    }


}
