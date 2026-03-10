package org.example.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.example.questions.HomeSauceDemoScreenData;
import org.example.tasks.LoginTask;
import org.example.tasks.OpenPage;
import org.openqa.selenium.WebDriver;

public class LoginSD {
    private Actor usuario;

    @Before
    public void setTheStage(){
        OnStage.setTheStage(new OnlineCast());
        usuario = OnStage.theActorCalled("Usuario");
        WebDriver driver = ThucydidesWebDriverSupport.getDriver();
        usuario.can(BrowseTheWeb.with(driver));
    }

    @Given("el usuario se encuentra en la pagina web de saucedemo")
    public void openSauceDemoPage(){
        String base_url = System.getProperty("base_url", "https://www.saucedemo.com/");
        usuario.attemptsTo(OpenPage.atUrl(base_url));
    }

    @When("inicia session con user {string} y password {string}")
    public void iniciaSessionConUserYPassword(String user_name, String password) {
        usuario.attemptsTo(LoginTask.perform(user_name,password));
    }

    @Then("se encuentra en el home de ventas de saucedemo")
    public void seEncuentraEnElHomeDeVentasDeSaucedemo() {
        usuario.attemptsTo(
                Ensure.that(HomeSauceDemoScreenData.isTitleVisible()).isTrue()
        );
    }
}
