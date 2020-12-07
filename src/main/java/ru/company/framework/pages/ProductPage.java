package ru.company.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ProductPage extends BasePage{
    @FindBy(xpath = "//h1")
    WebElement productName;

    @FindBy(xpath = "//span[contains(@class, 'product-card-price__current')]")
    WebElement productCurrent;

    @FindBy(xpath = "//div[@class='price-item-description']/p")
    WebElement productDesc;

    @FindBy(xpath = "//select[@class='form-control']")
    WebElement selectingGarant;

    @FindBy(xpath = "//select[@class='form-control']/option[@value='1']")
    WebElement garant;

    @FindBy(xpath = "//button[text()='Купить']")
    WebElement buttonBuy;

    @FindBy(xpath = "//input[@placeholder='Поиск по сайту']")
    WebElement inputSearch;

    @FindBy(xpath = "//span[@class='cart-link__price']")
    WebElement basketCurrent;


    public ProductPage checkPS4(){
        assertEquals("Игровая консоль PlayStation 4 Slim Black 1 TB + 3 игры", productName.getText(),
                "Неправильный товар");
        return app.getProductPage();
    }

    public ProductPage setPS4Param(){
        ps4.setName(productName.getText());
        ps4.setCurrent(currentTransf(productCurrent.getText()));
        ps4.setWarranty("+ 24 мес.");
        ps4.setDescription(productDesc.getText());
        return app.getProductPage();
    }

    public ProductPage selectDopGarantAndBuy(){
        selectingGarant.click();
        elementToBeClickable(garant);
        garant.click();
        assertNotEquals(ps4.getCurrent(), productCurrent.getText());
        ps4.setEdCurrent(currentTransf(productCurrent.getText()));
        buttonBuy.click();
        return app.getProductPage();
    }

    public ProductPage searchDetroit(String value) {
        researchInput(inputSearch, value);
        return app.getProductPage();
    }

    public ProductPage setDetroitParam(){
        assertEquals("Игра Detroit: Стать человеком (PS4)", productName.getText(),
                "Неправильный товар");
        detroit.setName(productName.getText());
        detroit.setCurrent(currentTransf(productCurrent.getText()));
        detroit.setDescription(productDesc.getText());
        return app.getProductPage();
    }

    public BasketPage buyDetroit(){
        buttonBuy.click();
        int item_sum = ps4.getEdCurrent() + detroit.getCurrent();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(item_sum, currentTransf(basketCurrent.getText()));
        basketCurrent.click();
        return app.getBasketPage();
    }
}
