package ru.company.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartPage extends BasePage{
    @FindBy(xpath = "//input[@placeholder='Поиск по сайту']")
    WebElement inputResearch;


    public ResearchPage researchProduct(String value){
        researchInput(inputResearch, value);
        return app.getResearchPage();
    }
}
