package org.example.ui;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

@DefaultUrl("https://www.demoblaze.com/")
public class LoginPageBlaze {
    public static final Target BTN_LOGIN = Target.the("Boton para iniciar sesion")
            .located(By.id("login2"));

    public static final Target BTN_LOGIN_ING = Target.the("Boton para modal de sesion")
            .located(By.xpath("//button[text()='Log in']"));

    public static final Target INP_USERNAMEL = Target.the("Nombre de usuario")
            .located(By.id("loginusername"));

    public static final Target INP_PASSWORDL = Target.the("Contraseña")
            .located(By.id("loginpassword"));
}
