package Pages;

import PageBase.PageBase;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;


public class Startsida extends PageBase {

    Page page;
    String startsidaUrl;

    public Locator searchField;
    public Locator cookies;
    public Locator categoryResult;
    public Locator category;
    public Locator login;
    public Locator createaccount;


    public Startsida(Page page) {
        this.page = page;
        this.startsidaUrl = "https://www.inet.se/";
        this.cookies = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Jag förstår"));
        this.searchField = page.getByRole(AriaRole.SEARCHBOX, new Page.GetByRoleOptions().setName("Sök bland 13 556 produkter i 581 kategorier..."));
        this.category = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Bildskärm")).first();
        this.categoryResult = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Datorskärm").setExact(true));
        this.login = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Logga in"));
        this.createaccount = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Skapa konto"));
    }

    public void openPage() {
        page.navigate(startsidaUrl);
    }

    public void acceptCookies() {
        if (cookies.isVisible()) {
            cookies.click();
        }
    }

    public void search() {
        searchField.fill("asus");
        page.keyboard().press("Enter");
    }

    public void navigateCategory() {
        category.click();
    }

    public void loginPopup() {
        login.click();
    }




}
