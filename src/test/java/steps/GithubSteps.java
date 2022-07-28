package steps;

import io.cucumber.java8.En;
import pages.MainPage;
import utils.Context;
import utils.Delay;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class GithubSteps implements En {

    public GithubSteps(Context context) {

        MainPage mainPage = new MainPage();

        Given("the user is on Github page", () -> {
            open(context.getAppUrl());
            mainPage.searchTextBox().shouldBe(visible, Duration.ofSeconds(5));
        });

    }

}
