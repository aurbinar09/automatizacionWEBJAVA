package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.example.ui.SauceDemoScreen;

public class LoginTask implements Task {
    private final String username;
    private final String password;

    public LoginTask(String username, String password){
        this.username = username;
        this.password = password;
    }

    public static LoginTask perform(String username, String password){
        return Tasks.instrumented(LoginTask.class, username, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(username).into(SauceDemoScreen.USERNAME_FIELD),
                Enter.theValue(password).into(SauceDemoScreen.PASSWORD_FIELD),
                Click.on(SauceDemoScreen.LOGIN_BUTTON)
        );
    }
}
