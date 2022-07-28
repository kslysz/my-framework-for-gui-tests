package pages;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class MainPage {

    private final String SEARCH_TEXT_BOX = "//*[contains(text(),\"fakeText\")]//ancestor::button";

    public SelenideElement searchTextBox() {
        return $(By.xpath(SEARCH_TEXT_BOX));
    }

}
