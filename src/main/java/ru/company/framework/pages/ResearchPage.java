package ru.company.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ResearchPage  extends BasePage{
    @FindBy(xpath = "//a[contains(text(), 'Игровая консоль PlayStation 4 Slim Black 1 TB + 3 игры')]")
    List<WebElement> searchList;



    //найти нужный товар и открыть

    public ProductPage searchPS4(){
        for (int i = 0; i < searchList.size(); i++) {
            if (searchList.get(i).getText().equalsIgnoreCase("Игровая консоль PlayStation 4 Slim Black 1 TB + 3 игры")) {
                searchList.get(i).click();
                break;
            }
        }

        return app.getProductPage();
    }
}
