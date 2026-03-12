package org.example.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.targets.Target;
import org.example.ui.HomePageBlaze;
import org.example.ui.HomeSauceDemoScreen;

public class BlazeDemoScreenData {
    public static Question<Boolean> isTitleVisible() {
        return actor -> Visibility.of(HomePageBlaze.TITLE_BLAZE_DEMO).answeredBy(actor);
    }
}