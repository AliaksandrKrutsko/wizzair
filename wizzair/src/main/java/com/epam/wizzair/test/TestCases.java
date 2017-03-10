package com.epam.wizzair.test;

import com.epam.wizzair.helper.Config;
import com.epam.wizzair.page.impl.Passenger;
import com.epam.wizzair.page.impl.RejectPaymentPage;
import com.epam.wizzair.page.util.BaggageCabinOptions;
import com.epam.wizzair.page.util.BaggageCheckedOptions;
import com.epam.wizzair.page.util.CheckInMethod;
import com.epam.wizzair.step.impl.MainPageSteps;
import junit.framework.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.epam.wizzair.driver.DriverSingleton.open;
import static com.epam.wizzair.driver.DriverSingleton.quit;
import static org.testng.Assert.assertEquals;


public class TestCases{

    private MainPageSteps steps = new MainPageSteps();


    private String origin = "Vilnius";
    private String destination = "Tel-Aviv";
    private int departureDay = 22;
    private int returnDay = 28;

    @BeforeTest
    public void setup(){
        open(Config.url());

    }

//    @BeforeTest(description = "Init browser")
//    public void setUp() {
//        steps = new MainPageSteps();
//        steps.initBrowser();
//        DriverSingleton.getDriver();
//        DriverSingleton.open(Config.url());
//    }

    @Test
    public void flitsSum() {
        steps = new MainPageSteps();
        steps.findFlight(origin, destination, departureDay, returnDay);
        Assert.assertEquals(steps.getTwoFlightPrices(), steps.getFlightSumFromLeftWindow());
    }

    @Test
    public void pay() throws InterruptedException {


        steps.getRidOfStickBar();

        steps.login();

        steps.findFlight(origin, destination, departureDay, returnDay);
        steps.getFlights();
        Passenger passenger = new Passenger();

        passenger.setCheckedInBaggage(BaggageCheckedOptions.NONE);

        passenger.setCabinBaggage(BaggageCabinOptions.SMALL);

        passenger.setSportEquipment(true);

        passenger.setCheckInMethod(CheckInMethod.ONLINE);

        passenger.submit();

        steps.continueFromSeats();//currently not working; click this manually
        steps.continueFromSeats();

        steps.continueFromServicesPage();
        steps.declineWiz();
        steps.enterPayment();
        RejectPaymentPage rejectPaymentPage = new RejectPaymentPage();
        String message = rejectPaymentPage.getRejectMessage();
        assertEquals(message, "It seems your bank rejected the payment.");


    }

    @AfterTest
    public void tearDown(){
        quit();
    }


}
