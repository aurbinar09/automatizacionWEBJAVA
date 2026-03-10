package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.example.ui.HomePageBlaze;
import org.example.ui.LoginPageBlaze;
import org.example.ui.SauceDemoScreen;

public class LoginTaskBlaze implements Task {
    private final String username;
    private final String password;

    public LoginTaskBlaze(String username, String password){
        this.username = username;
        this.password = password;
    }

    public static LoginTask perform(String username, String password){
        return Tasks.instrumented(LoginTask.class, username, password);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(LoginPageBlaze.BTN_LOGIN),
                Enter.theValue(username).into(LoginPageBlaze.INP_USERNAMEL),
                Enter.theValue(password).into(LoginPageBlaze.INP_PASSWORDL),
                Click.on(LoginPageBlaze.BTN_LOGIN_ING)
        );
    }
}
