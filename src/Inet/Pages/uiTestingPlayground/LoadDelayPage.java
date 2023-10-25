package Pages.uiTestingPlayground;

import PageBase.PageBase;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class LoadDelayPage extends PageBase {

    Page page;
    String loadDelayUrl;

    public Locator homepageButton;
    public Locator loadDelayLink;
    public Locator loadDelayButton;

    public LoadDelayPage(Page page) {
        this.page = page;
        this.loadDelayUrl = "http://uitestingplayground.com/loaddelay";
        this.homepageButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Home"));
        this.loadDelayLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Load Delay"));
        this.loadDelayButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Button Appearing After Delay"));
    }

    public void openPage() {
        page.navigate(loadDelayUrl);
    }

    public void navigateHomePage() {
        homepageButton.click();
    }

    public void navigateLoadDelay() {
        loadDelayLink.click();
    }

    public void clickButton() {
        loadDelayButton.click();
    }
}