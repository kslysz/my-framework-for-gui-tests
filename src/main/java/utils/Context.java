package utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import io.qameta.allure.selenide.LogType;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Level;

public class Context {

    public Context() {
        initialization();
    }

    private final Map<String, Object> properties = new HashMap<>();

    public Map<String, Object> getAllProperties() {
        return properties;
    }

    public String getEnv() {
        return get("env");
    }

    public String getBrowser() {
        return get("browser");
    }

    public String getAppUrl() {
        return get("appUrl");
    }

    public String getResource(String path) {
        return getAppUrl() + path;
    }

    public String browserSize() {
        return get("browser.size", String.class);
    }

    public boolean headless() {
        String maximized = get("browser.headless", String.class);
        return Objects.equals(maximized, "true");
    }

    public String get(String key) {
        return get(key, String.class);
    }

    public int getInt(String key) {
        return get(key, Integer.class);
    }

    public <T> T get(String key, Class<T> objectClass) {
        Object object = properties.get(key);
        if (object == null)
            throw new RuntimeException(String.format("Object with key [%s] not found.", key));

        return objectClass.cast(object);
    }

    public <T> T get(String key, Class<T> objectClass, Object defaultValue) {
        Object object = properties.get(key);
        if (object == null)
            return objectClass.cast(defaultValue);

        return objectClass.cast(object);
    }

    public <T> void put(String key, T object) {
        properties.put(key, object);
    }

    private void initialization() {
        loadEnvironmentProperties();
        setupSelenideConfiguration();
    }

    @SuppressWarnings("unchecked")
    private void loadEnvironmentProperties() {
        Path currentWorkingDir = Paths.get("").toAbsolutePath().normalize();
        final String TEST_PROPERTIES_PATH = currentWorkingDir + "/build/test.properties";
        try {
            FileInputStream inputStream = new FileInputStream(TEST_PROPERTIES_PATH);

            Properties props = new Properties();
            props.load(inputStream);
            Enumeration<String> enums = (Enumeration<String>) props.propertyNames();
            while (enums.hasMoreElements()) {
                String key = enums.nextElement();
                String value = props.getProperty(key);
                put(key, value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Additional Allure configuration
        System.setProperty("allure.link.tms.pattern", "https://github.com/kslysz/my-framework-for-gui-tests/issues/{}");
    }

    private void setupSelenideConfiguration() {
        try {
            Configuration.browser = getBrowser();
            Configuration.screenshots = true;
            Configuration.savePageSource = false;
            Configuration.webdriverLogsEnabled = false;
            Configuration.browserSize = browserSize();
            Configuration.browserPosition = "0x0";
            Configuration.headless = headless();
            Configuration.baseUrl = getAppUrl();

            AllureSelenide allureSelenide = new AllureSelenide();
//            allureSelenide.enableLogs(LogType.BROWSER, Level.ALL);
            allureSelenide.screenshots(true);
            allureSelenide.savePageSource(false);
            SelenideLogger.addListener("AllureSelenide", allureSelenide);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}