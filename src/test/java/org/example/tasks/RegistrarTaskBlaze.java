package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.example.ui.HomePageBlaze;

public class RegistrarTaskBlaze implements Task {

    private final String username;
    private final String password;

    public RegistrarTaskBlaze(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(HomePageBlaze.BTN_SIGN_UP),
                Enter.theValue(username).into(HomePageBlaze.INP_USERNAME),
                Enter.theValue(password).into(HomePageBlaze.INP_PASSWORD),
                Click.on(HomePageBlaze.BTN_REGISTRAR)
        );
    }

}
