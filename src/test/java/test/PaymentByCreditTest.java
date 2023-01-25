package test;

import com.codeborne.selenide.logevents.SelenideLogger;
import data.SQLHelper;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import page.CreditPage;
import page.DashboardPage;

import static com.codeborne.selenide.Selenide.open;
import static data.SQLHelper.cleanDatabase;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaymentByCreditTest {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeAll
    static void setUp() {
        cleanDatabase();
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @Test
    void shouldApproveThePaymentByCredit() {
        open("http://localhost:8080");
        var dashboardPage = new DashboardPage();
        dashboardPage.setPaymentByCredit();
        var creditPage = new CreditPage();
        creditPage.setCardNumber(1);
        creditPage.fillingInTheFields(1, 1, 1, 1);
        creditPage.getPay();
        creditPage.getApprove();

        assertEquals("APPROVED", SQLHelper.getCreditStatus());
    }

    @Test
    void shouldDeclinePaymentByCreditWithTheRightCard() {
        open("http://localhost:8080");
        var dashboardPage = new DashboardPage();
        dashboardPage.setPaymentByCredit();
        var creditPage = new CreditPage();
        creditPage.setCardNumber(2);
        creditPage.fillingInTheFields(1, 1, 1, 1);
        creditPage.getPay();
        creditPage.getError();

        assertEquals("DECLINED", SQLHelper.getCreditStatus());
    }

    @Test
    void shouldDeclinePaymentByCreditWithMissingCardNumber() {
        open("http://localhost:8080");
        var dashboardPage = new DashboardPage();
        dashboardPage.setPaymentByCredit();
        var creditPage = new CreditPage();
        creditPage.setCardNumber(0);
        creditPage.fillingInTheFields(1, 1, 1, 1);
        creditPage.getPay();
        creditPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCreditWithACardNumberEqualToZero() {
        open("http://localhost:8080");
        var dashboardPage = new DashboardPage();
        dashboardPage.setPaymentByCredit();
        var creditPage = new CreditPage();
        creditPage.setCardNumber(3);
        creditPage.fillingInTheFields(1, 1, 1, 1);
        creditPage.getPay();
        creditPage.getFillTheForm();
    }

    @Test
    void shouldDeclineAPaymentByCreditWithTextInsteadOfCardNumber() {
        open("http://localhost:8080");
        var dashboardPage = new DashboardPage();
        dashboardPage.setPaymentByCredit();
        var creditPage = new CreditPage();
        creditPage.setCardNumber(4);
        creditPage.fillingInTheFields(1, 1, 1, 1);
        creditPage.getPay();
        creditPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCreditWithAMissingMonth() {
        open("http://localhost:8080");
        var dashboardPage = new DashboardPage();
        dashboardPage.setPaymentByCredit();
        var creditPage = new CreditPage();
        creditPage.setCardNumber(1);
        creditPage.fillingInTheFields(0, 1, 1, 1);
        creditPage.getPay();
        creditPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCreditWithAWrongMonth() {
        open("http://localhost:8080");
        var dashboardPage = new DashboardPage();
        dashboardPage.setPaymentByCredit();
        var creditPage = new CreditPage();
        creditPage.setCardNumber(1);
        creditPage.fillingInTheFields(2, 1, 1, 1);
        creditPage.getPay();
        creditPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCreditWithTextInsteadOfMonth() {
        open("http://localhost:8080");
        var dashboardPage = new DashboardPage();
        dashboardPage.setPaymentByCredit();
        var creditPage = new CreditPage();
        creditPage.setCardNumber(1);
        creditPage.fillingInTheFields(3, 1, 1, 1);
        creditPage.getPay();
        creditPage.getFillTheForm();
    }

    @Test
    void shouldDeclineAPaymentByCreditWithAMissingYear() {
        open("http://localhost:8080");
        var dashboardPage = new DashboardPage();
        dashboardPage.setPaymentByCredit();
        var creditPage = new CreditPage();
        creditPage.setCardNumber(1);
        creditPage.fillingInTheFields(1, 0, 1, 1);
        creditPage.getPay();
        creditPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCreditWithWrongYearMaxYear() {
        open("http://localhost:8080");
        var dashboardPage = new DashboardPage();
        dashboardPage.setPaymentByCredit();
        var creditPage = new CreditPage();
        creditPage.setCardNumber(1);
        creditPage.fillingInTheFields(1, 2, 1, 1);
        creditPage.getPay();
        creditPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCreditWithTextInsteadOfYear() {
        open("http://localhost:8080");
        var dashboardPage = new DashboardPage();
        dashboardPage.setPaymentByCredit();
        var creditPage = new CreditPage();
        creditPage.setCardNumber(1);
        creditPage.fillingInTheFields(1, 3, 1, 1);
        creditPage.getPay();
        creditPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCreditWithMissingHolder() {
        open("http://localhost:8080");
        var dashboardPage = new DashboardPage();
        dashboardPage.setPaymentByCredit();
        var creditPage = new CreditPage();
        creditPage.setCardNumber(1);
        creditPage.fillingInTheFields(1, 1, 0, 1);
        creditPage.getPay();
        creditPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCreditWithNumberInsteadOfHolder() {
        open("http://localhost:8080");
        var dashboardPage = new DashboardPage();
        dashboardPage.setPaymentByCredit();
        var creditPage = new CreditPage();
        creditPage.setCardNumber(1);
        creditPage.fillingInTheFields(1, 1, 2, 1);
        creditPage.getPay();
        creditPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCreditWithWrongHolder() {
        open("http://localhost:8080");
        var dashboardPage = new DashboardPage();
        dashboardPage.setPaymentByCredit();
        var creditPage = new CreditPage();
        creditPage.setCardNumber(1);
        creditPage.fillingInTheFields(1, 1, 3, 1);
        creditPage.getPay();
        creditPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCreditWithMissingCode() {
        open("http://localhost:8080");
        var dashboardPage = new DashboardPage();
        dashboardPage.setPaymentByCredit();
        var creditPage = new CreditPage();
        creditPage.setCardNumber(1);
        creditPage.fillingInTheFields(1, 1, 1, 0);
        creditPage.getPay();
        creditPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCreditWithWrongCodeTwoDigitNumber() {
        open("http://localhost:8080");
        var dashboardPage = new DashboardPage();
        dashboardPage.setPaymentByCredit();
        var creditPage = new CreditPage();
        creditPage.setCardNumber(1);
        creditPage.fillingInTheFields(1, 1, 1, 2);
        creditPage.getPay();
        creditPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCreditWithWrongHolderFourDigitNumber() {
        open("http://localhost:8080");
        var dashboardPage = new DashboardPage();
        dashboardPage.setPaymentByCredit();
        var creditPage = new CreditPage();
        creditPage.setCardNumber(1);
        creditPage.fillingInTheFields(1, 1, 1, 3);
        creditPage.getPay();
        creditPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCreditWithTextInsteadOfCode() {
        open("http://localhost:8080");
        var dashboardPage = new DashboardPage();
        dashboardPage.setPaymentByCredit();
        var creditPage = new CreditPage();
        creditPage.setCardNumber(1);
        creditPage.fillingInTheFields(1, 1, 1, 4);
        creditPage.getPay();
        creditPage.getFillTheForm();
    }
}