package cucumber;

import managers.DriverFactory;
import managers.PageObjectManager;

public class TestContext {

    private final DriverFactory webDriverManager;
    private final PageObjectManager pageObjectManager;

    public TestContext() throws Exception {
        webDriverManager = new DriverFactory();
        pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
    }

    public DriverFactory getWebDriverManager() {
        return webDriverManager;
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }


}
