package org.example.ui;

import net.serenitybdd.screenplay.targets.Target;

public class SauceDemoScreen {
    public static final Target USERNAME_FIELD = Target.the("Campo nombre de usuario")
            .locatedBy("#user-name");
    public static final Target PASSWORD_FIELD = Target.the("Campo contrasena")
            .locatedBy("#password");
    public static final Target LOGIN_BUTTON = Target.the("Boton iniciar session")
            .locatedBy("#login-button");
}
