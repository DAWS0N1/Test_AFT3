package ru.company;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import ru.company.framework.managers.InitManager;
import ru.company.framework.managers.PageManager;

public class BaseTest {

    protected PageManager app = PageManager.getPageManager();

    @BeforeEach
    void before(){
        InitManager.initFramework();
    }

    @AfterEach
    void after(){
        InitManager.quitFramework();
    }
}
