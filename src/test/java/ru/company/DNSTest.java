package ru.company;

import org.junit.jupiter.api.Test;


public class DNSTest extends BaseTest{

    @Test
    void dnsScenario() {


        app.getStartPage()
                .researchProduct("Playstation 4")
                .searchPS4()
                .checkPS4()
                .setPS4Param()
                .selectDopGarantAndBuy()
                .searchDetroit("detroit")
                .setDetroitParam()
                .buyDetroit()
                .checkedGarant()
                .checkCurrents()
                .removeDetroitAndCheck(3);
    }
}
