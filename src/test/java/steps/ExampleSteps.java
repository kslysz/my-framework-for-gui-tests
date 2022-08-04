package steps;

import io.cucumber.java8.En;
import pages.NestedStepsPage;
import utils.Context;
import utils.Delay;

public class ExampleSteps implements En {

    public ExampleSteps(Context context) {

        When("do something", () -> {
            Delay.sec(1, 10);
        });

        When("do something with multiple steps", () -> {
            NestedStepsPage nestedStepsPage = new NestedStepsPage();
            nestedStepsPage.stepA();
            nestedStepsPage.stepB();
            nestedStepsPage.stepC();
        });

    }

}
