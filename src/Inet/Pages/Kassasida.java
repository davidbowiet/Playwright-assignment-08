package Pages;

import PageBase.PageBase;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class Kassasida extends PageBase {

    Page page;
    String kassasidaUrl;

    public Locator cookies;
    public Locator buyButton;
    public Locator checkout;
    public Locator giftCard;
    public Locator giftCardPopup;
    public Locator completePurchase;


    public Kassasida(Page page) {
        this.page = page;
        this.kassasidaUrl = "https://www.inet.se/produkt/1975213/apple-iphone-15-pro-max-256gb-svart-titan\"";
        this.cookies = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Jag förstår"));
        this.buyButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Köp"));
        this.checkout = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Till kassan"));
        this.giftCard = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("+ Presentkort"));
        this.giftCardPopup = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Lägg till presentkort"));
        this.completePurchase = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Slutför köp"));
    }

    public void openPage() {
        page.navigate(kassasidaUrl);
    }

    public void acceptCookies() {
        if (cookies.isVisible()) {
            cookies.click();
        }
    }

    public void addToCart() {
        buyButton.click();
    }

    public void goToCart() {
        checkout.click();
    }

    public void addGiftcard() {
        giftCard.click();
    }

}