package ru.company.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class BasketPage extends BasePage{

    @FindBy(xpath = "//span[contains(@class, 'base-ui-radio') and contains(@class, 'checked')]")
    WebElement radiocheck;

    @FindBy(xpath = "//div[@class='cart-items__product-info']//div[contains(@class, 'name')]/a")
    WebElement productName;

    @FindBy(xpath = "//div[@class='cart-items__product-info']//div[contains(@class, 'price')]/span[contains(@class, 'current')]")
    List<WebElement> currentsList;

    @FindBy(xpath = "//div[@class='total-amount']//span[contains(@class, 'current')]")
    WebElement sumProducts;

    @FindBy(xpath = "//a[contains(@class, 'product-name')]")
    List<WebElement> itemsNames;

    @FindBy(xpath = "//div[@class='cart-items__product-info']//button[@data-commerce-action='CART_ADD']")
    List<WebElement> plusButtons;

    @FindBy(xpath = "//div[@class='cart-items__product-info']//button[@data-commerce-action='CART_REMOVE']")
    List<WebElement> minusButtons;

    @FindBy(xpath = "//div[@class='cart-items__product-info']//input")
    WebElement inputValue;

    @FindBy(xpath = "//span[@class='group-tabs-menu__item group-tabs-menu__item_print-basket']/span")
    WebElement removeDeleted;



    public BasketPage checkedGarant () {
        assertEquals(ps4.getWarranty(), radiocheck.getText(), "неправильная гарантия");
        return app.getBasketPage();
    }

    public BasketPage checkCurrents() {

        int sun_items = ps4.getCurrent() + detroit.getCurrent();
        if (productName.getText().equalsIgnoreCase(ps4.getName())){
            assertEquals(ps4.getCurrent(), currentTransf(currentsList.get(0).getText()));
        }
        if (productName.getText().equalsIgnoreCase(detroit.getName())){
            assertEquals(detroit.getCurrent(), currentTransf(currentsList.get(1).getText()));
        }

        assertEquals(sun_items, currentTransf(sumProducts.getText().trim()));
        return app.getBasketPage();
    }

    public void removeDetroitAndCheck(int amount){
        int ps4Amount = ps4.getCurrent() * amount;
        scrollToElementJs(currentsList.get(0));
        for (int i = 0; i < currentsList.size(); i++) {
            if (itemsNames.get(i).getText().equalsIgnoreCase("Игра Detroit: Стать человеком (PS4)")) {
                minusButtons.get(i).click();
                break;
            }
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        scrollPageUp();

        if (currentsList.size() == 1) {
            assertEquals(ps4.getCurrent(), currentTransf(sumProducts.getText().trim()));
        } else
            fail("Товар не был удален");

        for (int i = 0; i < currentsList.size(); i++) {
            if (itemsNames.get(i).getText().equalsIgnoreCase("Игровая консоль PlayStation 4 Slim Black 1 TB + 3 игры")) {
                for (int j = 1; j < amount; j++) {
                    plusButtons.get(i).click();
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        assertEquals(amount, currentTransf(inputValue.getAttribute("value")));
        assertEquals(ps4Amount, currentTransf(sumProducts.getText().trim()));

        removeDeleted.click();

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(ps4Amount + detroit.getCurrent(), currentTransf(sumProducts.getText().trim()));
    }
}
