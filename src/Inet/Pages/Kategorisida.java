package Pages;

import PageBase.PageBase;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class Kategorisida extends PageBase {

    Page page;
    String kategorisidaUrl;

    public Locator category;
    public Locator cookies;
    public Locator inStock;
    public Locator clearButton;



    public Kategorisida(Page page) {
        this.page = page;
        this.kategorisidaUrl = "https://www.inet.se/kategori/30/bildskarm";
        this.cookies = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Jag förstår"));
        this.category = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Bildskärm")).first();
        this.inStock = page.locator("[data-test-id=\"filter_only_in_stock_checkbox\"] div").first();
        this.clearButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Rensa filter"));
    }

    public void openPage() {
        page.navigate(kategorisidaUrl);
    }

    public void acceptCookies() {
        if (cookies.isVisible()) {
            cookies.click();
        }
    }

    public void navigateCategory() {
        category.click();
    }
    public void filter() {
        inStock.click();
    }

    public void clearFilter() {
        clearButton.click();
    }
}