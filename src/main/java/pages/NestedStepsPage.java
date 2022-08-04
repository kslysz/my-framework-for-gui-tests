package pages;

import io.qameta.allure.Step;
import utils.CustomSteps;

public class NestedStepsPage extends CustomSteps {

    @Step("Step A")
    public void stepA() {
        Step("Lambda nested step", () -> {

        });
    }

    @Step("Step B")
    public void stepB() {

    }

    @Step("Step C")
    public void stepC() {

    }

}
