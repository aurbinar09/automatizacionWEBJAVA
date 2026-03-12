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
import org.example.tasks.LoginTaskBlaze;
import org.example.tasks.LogoutTaskBlaze;
import org.example.tasks.OpenPage;
import org.example.ui.HomePageBlaze;
import org.example.ui.LoginPageBlaze;
import org.openqa.selenium.WebDriver;

public class LogoutBlazeSD {
    private Actor usuario;

    @Before
    public void setTheStage(){
        OnStage.setTheStage(new OnlineCast());
        usuario = OnStage.theActorCalled("Usuario");
        WebDriver driver = ThucydidesWebDriverSupport.getDriver();
        usuario.can(BrowseTheWeb.with(driver));
    }

    @Given("el usuario está autenticado")
    public void elUsuarioEstáAutenticado() {
        String base_url = System.getProperty("base_url", "https://www.demoblaze.com/");
        usuario.attemptsTo(OpenPage.atUrl(base_url));
        usuario.attemptsTo(Click.on(LoginPageBlaze.BTN_LOGIN));
        usuario.attemptsTo(LogoutTaskBlaze.perform("ADEL","123456"));
    }

    @When("selecciona Cerrar sesión")
    public void seleccionaCerrarSesión() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        usuario.attemptsTo(Click.on(HomePageBlaze.BTN_LOGOUT));
    }

    @Then("la sesión se cierra")
    public void laSesiónSeCierra() {
        usuario.attemptsTo(
                Ensure.that(BlazeDemoScreenData.isTitleVisible()).isTrue()
        );
    }
}
