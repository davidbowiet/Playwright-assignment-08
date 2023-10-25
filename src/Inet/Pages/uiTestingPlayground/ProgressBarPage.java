package Pages.uiTestingPlayground;

import PageBase.PageBase;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class ProgressBarPage extends PageBase {

    Page page;
    String ProgressBarUrl;

    public Locator startButton;
    public Locator stopButton;
    public Locator progressBar;
    public Locator progressValue;
    public Locator result;

    public ProgressBarPage(Page page) {
        this.page = page;
        this.ProgressBarUrl = "http://uitestingplayground.com/progressbar";
        this.startButton = page.locator("#startButton");
        this.stopButton = page.locator("#stopButton");
        this.progressBar = page.locator("#progressBar");
        this.result = page.locator("#result");
    }

    public void openPage() {
        page.navigate(ProgressBarUrl);
    }

    public void startProgress() {
        startButton.click();
        page.waitForSelector("#progressBar[aria-valuenow='75']");
    }

    public void stopProgress() {
        stopButton.click();
    }
}



