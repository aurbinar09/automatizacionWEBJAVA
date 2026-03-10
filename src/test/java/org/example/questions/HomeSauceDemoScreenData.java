package org.example.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import org.example.ui.HomeSauceDemoScreen;

public class HomeSauceDemoScreenData {
    public static Question<Boolean> isTitleVisible(){
        return actor -> Visibility.of(HomeSauceDemoScreen.TITLE_SAUCE_DEMO).answeredBy(actor);
    }
}
