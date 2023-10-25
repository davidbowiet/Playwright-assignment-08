package Test;

import Pages.Kassasida;
import Pages.Kategorisida;
import Pages.Produktsida;
import Pages.Startsida;
import Pages.uiTestingPlayground.LoadDelayPage;
import Pages.uiTestingPlayground.ProgressBarPage;
import Pages.uiTestingPlayground.TextInputPage;
import TestBase.TestBase;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class TestCase extends TestBase {

    @Test
    public void searchTest() {
        Startsida startsida = new Startsida(page);
        startsida.openPage();
        startsida.acceptCookies();
        startsida.search();
        assertThat(page).hasURL("https://www.inet.se/hitta?q=asus");
    }

    @Test
    public void categoryTest() {
        Startsida startsida = new Startsida(page);
        startsida.openPage();
        startsida.acceptCookies();
        startsida.navigateCategory();
        assertThat(startsida.categoryResult).containsText("Datorskärm");
    }

    @Test
    public void loginPopupTest() {
        Startsida startsida = new Startsida(page);
        startsida.openPage();
        startsida.acceptCookies();
        startsida.loginPopup();
        assertThat(startsida.createaccount).isVisible();
    }

    @Test
    public void addToCartTest() {
        Produktsida produktsida = new Produktsida(page);
        produktsida.openPage();
        produktsida.acceptCookies();
        produktsida.chooseColor();
        produktsida.chooseCapacity();
        produktsida.addToCart();
        assertThat(produktsida.cartItems).containsText("1");
    }

    @Test
    public void deleteFromCartTest() {
        Produktsida produktsida = new Produktsida(page);
        produktsida.openPage();
        produktsida.acceptCookies();
        produktsida.chooseColor();
        produktsida.chooseCapacity();
        produktsida.addToCart();
        produktsida.deleteFromCart();
        assertThat(produktsida.cart).containsText("Din kundvagn är tom");
    }

    @Test
    public void quantityTest() {
        Produktsida produktsida = new Produktsida(page);
        produktsida.openPage();
        produktsida.acceptCookies();
        produktsida.chooseColor();
        produktsida.chooseCapacity();
        produktsida.addToCart();
        produktsida.increaseQuantity();
        assertThat(produktsida.cartItems).containsText("10");
    }

    @Test
    public void filterTest() {
        Kategorisida kategorisida = new Kategorisida(page);
        kategorisida.openPage();
        kategorisida.acceptCookies();
        kategorisida.navigateCategory();
        kategorisida.filter();
        assertThat(page).hasURL("https://www.inet.se/kategori/30/bildskarm?filter=%7B%22onlyInStock%22%3Atrue%7D");
    }

    @Test
    public void clearFilterTest() {
        Kategorisida kategorisida = new Kategorisida(page);
        kategorisida.openPage();
        kategorisida.acceptCookies();
        kategorisida.navigateCategory();
        kategorisida.filter();
        kategorisida.clearFilter();
        assertThat(page).hasURL("https://www.inet.se/kategori/30/bildskarm");
    }

    @Test
    public void giftCardTest() {
        Kassasida kassasida = new Kassasida(page);
        kassasida.openPage();
        kassasida.acceptCookies();
        kassasida.addToCart();
        kassasida.goToCart();
        kassasida.addGiftcard();
        assertThat(kassasida.giftCardPopup).containsText("Lägg till presentkort");
    }

    @Test
    public void completePurchase() {
        Kassasida kassasida = new Kassasida(page);
        kassasida.openPage();
        kassasida.acceptCookies();
        kassasida.addToCart();
        kassasida.goToCart();
        assertThat(kassasida.completePurchase).isVisible();
    }

    @Test
    public void loadDelayTest() {
        LoadDelayPage loadDelayPage = new LoadDelayPage(page);
        loadDelayPage.openPage();
        loadDelayPage.navigateHomePage();
        loadDelayPage.navigateLoadDelay();
        loadDelayPage.clickButton();
        assertThat(loadDelayPage.loadDelayButton).isVisible();
    }

    @Test
    public void textInputTest() {
        TextInputPage textInputPage = new TextInputPage(page);
        textInputPage.openPage();
        textInputPage.setButtonName();
        textInputPage.clickButton();
        assertThat(textInputPage.button).containsText("Button name is changed!");
    }

    @Test
    public void progressBarTest() {
        ProgressBarPage progressBarPage = new ProgressBarPage(page);
        progressBarPage.openPage();
        progressBarPage.startProgress();
        progressBarPage.stopProgress();
        assertThat(progressBarPage.result).containsText("Result: 0");
    }

}
