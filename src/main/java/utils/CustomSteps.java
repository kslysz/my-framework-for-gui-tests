package utils;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.apache.commons.lang3.StringUtils;

public class CustomSteps {

    @Step("{title}")
    protected void Step(String title, Runnable code) {
        step(title, code);
    }

    private void step(String title, Runnable code) {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.getParameters().clear());

        int prefixSize = 45;
        int maxChars = 140;

        String beginTitle = String.format(StringUtils.leftPad(" ", prefixSize, '=') + "Begin: %s ", title);
        System.out.println("\n" + StringUtils.rightPad(beginTitle, maxChars, '='));

        code.run();

        String endTitle = String.format(StringUtils.leftPad(" ", prefixSize, '=') + "End: %s ", title);
        System.out.println(StringUtils.rightPad(endTitle, maxChars, '='));
    }

}
