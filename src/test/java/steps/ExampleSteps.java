package steps;

import io.cucumber.java8.En;
import utils.Context;
import utils.Delay;

public class ExampleSteps implements En {

    public ExampleSteps(Context context) {

        When("do something", () -> {
            Delay.sec(1, 10);
        });

    }

}
