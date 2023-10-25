package Pages.uiTestingPlayground;

import PageBase.PageBase;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class TextInputPage extends PageBase {

    Page page;
    String TextInputUrl;

    public Locator nameButtonField;
    public Locator button;

    public TextInputPage(Page page) {
        this.page = page;
        this.TextInputUrl = "http://uitestingplayground.com/textinput";
        this.nameButtonField = page.locator("#newButtonName");
        this.button = page.locator("#updatingButton");
    }

    public void openPage() {
        page.navigate(TextInputUrl);
    }

    public void setButtonName() {
        nameButtonField.fill("Button name is changed!");
    }

    public void clickButton() {
        button.click();
    }


}