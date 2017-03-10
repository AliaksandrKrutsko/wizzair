package com.epam.wizzair.step.impl;

import com.epam.wizzair.driver.DriverSingleton;
import com.epam.wizzair.page.impl.*;
import org.openqa.selenium.WebDriver;

import com.epam.wizzair.page.impl.LoginPage;


public class MainPageSteps {

    private WebDriver driver;

    public void initBrowser() {
        driver = DriverSingleton.getDriver();
    }

    public void closeBrowser() {
        driver.quit();
    }

    public void findFlight(String origin, String destination, int departureDay, int returnDay) {
        MainPage mainPage = new MainPage();


        mainPage.fillOrigin(origin);
        mainPage.fillDestination(destination);
        mainPage.fillDepartureDate(departureDay);
        mainPage.fillReturnDate(returnDay);
        mainPage.search();
    }

    public String getTwoFlightPrices() {
        SearchResult searchResult = new SearchResult();
        String firstFlightPrice = searchResult.chooseFirstFlight().substring(1);
        String secondFlightPrice = searchResult.chooseSecondFlight().substring(1);
        double sum = Double.parseDouble(firstFlightPrice) + Double.parseDouble(secondFlightPrice);
        return (sum + "").substring(0,6);
    }

    public String getFlightSumFromLeftWindow() {
        SearchResult searchResult = new SearchResult();
        String s = searchResult.getTotalPrice().substring(1);
        return s;
    }



    public void login() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("tatester@12storage.com", "qwerty12345");

    }





    public void continueFromServicesPage() {
        ServicesPage servicesPage = new ServicesPage();
        servicesPage.continueToNextPage();
    }



    public void enterPayment() throws InterruptedException {

        PaymentPage paymentPage = new PaymentPage();
        paymentPage.setStreet("AnyStreet");
        paymentPage.setCity("Minsk");
        paymentPage.setPostcode("111111");
        paymentPage.chooseCountryFromMenu();
        paymentPage.setCardNumber("4954-5913-5717-8298");
        paymentPage.setCardName("Tester");
        paymentPage.setCardCvv("512");
        paymentPage.acceptPolicy();
        Thread.sleep(1000);
        paymentPage.confirmPayment();
        Thread.sleep(5000);


    }


//    public String getRejectMessage() {
//        RejectPaymentPage rejectPaymentPage = new RejectPaymentPage();
//
//        String message = rejectPaymentPage.getRejectMessage();
//        return message;
//    }

    public void getFlights() {
        SearchResult searchResult = new SearchResult();
        searchResult.chooseFirstFlight();
        searchResult.chooseSecondFlight();
        searchResult.continueToNextPage();
    }



    public void declineWiz() {
        WizzDiscountPage wizzDiscountPage = new WizzDiscountPage();
        wizzDiscountPage.declineOffer();
    }


    public void continueFromSeats() {

        SeatPage seatPage = new SeatPage();
        seatPage.continueToNextPage();


    }
    public void getRidOfStickBar() {
        MainPage mainPage = new MainPage();
        mainPage.stickyBarClose();
    }




}
