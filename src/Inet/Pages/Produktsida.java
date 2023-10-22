package Pages;

import PageBase.PageBase;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class Produktsida extends PageBase {

    Page page;
    String produktsidaUrl;

    public Locator cookies;
    public Locator color;
    public Locator capacity;
    public Locator buyButton;
    public Locator cartItems;
    public Locator delete;
    public Locator cart;
    public Locator increase;

    public Produktsida(Page page) {
        this.page = page;
        this.produktsidaUrl = "https://www.inet.se/produkt/1975213/apple-iphone-15-pro-max-256gb-svart-titan";
        this.cookies = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Jag förstår"));
        this.color = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Svart titan"));
        this.capacity = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("1 TB"));
        this.buyButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Köp"));
        this.cartItems = page.locator("label.lb81bfe");
        this.delete = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ta bort produkt"));
        this.cart = page.locator("p.e13y5qg9");
        this.increase = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Öka antal"));
    }

    public void openPage() {
        page.navigate(produktsidaUrl);
    }

    public void acceptCookies() {
        if (cookies.isVisible()) {
            cookies.click();
        }
    }

    public void chooseColor() {
        color.click();
    }

    public void chooseCapacity() {
        capacity.click();
    }

    public void addToCart() {
        buyButton.click();
    }

    public void deleteFromCart() {
        delete.click();
    }

    public void increaseQuantity() {
        for (int i=0; i < 9; i ++) {
            increase.click();
        }
    }


}
