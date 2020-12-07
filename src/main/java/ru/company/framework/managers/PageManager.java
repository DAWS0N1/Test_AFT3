package ru.company.framework.managers;

import ru.company.framework.pages.BasketPage;
import ru.company.framework.pages.ProductPage;
import ru.company.framework.pages.ResearchPage;
import ru.company.framework.pages.StartPage;

public class PageManager {
    /**
     * Менеджер страничек
     */
    private static PageManager pageManager;

    /**
     * Стартовая страничка
     */
    StartPage startPage;

    /**
     * Страничка страхование путественников
     */
    ResearchPage researchPage;

    /**
     * Страничка выбора полиса или тарифа
     */
    ProductPage productPage;

    BasketPage basketPage;

    /**
     * Конструктор специально запривейтили (синглтон)
     */
    private PageManager() {
    }

    /**
     * Ленивая инициализация ManagerPages
     *
     * @return ManagerPages
     */
    public static PageManager getPageManager() {
        if (pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }

    /**
     * Ленивая инициализация {@link ru.company.framework.pages.StartPage}
     *
     * @return StartPage
     */
    public StartPage getStartPage() {
        if (startPage == null) {
            startPage = new StartPage();
        }
        return startPage;
    }

    /**
     * Ленивая инициализация {@link ru.company.framework.pages.ResearchPage}
     *
     * @return StrahovaniePage
     */
    public ResearchPage getResearchPage() {
        if (researchPage == null) {
            researchPage = new ResearchPage();
        }
        return researchPage;
    }

    /**
     * Ленивая инициализация {@link ru.company.framework.pages.ProductPage}
     *
     * @return TarifPage
     */
    public ProductPage getProductPage() {
        if (productPage == null) {
            productPage = new ProductPage();
        }
        return productPage;
    }

    public BasketPage getBasketPage() {
        if (basketPage == null){
            basketPage = new BasketPage();
        }
        return basketPage;
    }
}
