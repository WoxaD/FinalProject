package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class DashboardPage {

    private static final SelenideElement heading = $(".Order_cardPreview__47B2k");
    private final SelenideElement paymentByCard = $x("//*[contains(text(),'Купить')]");
    private final SelenideElement paymentByCredit = $x("//*[contains(text(),'Купить в кредит')]");

    public void setPaymentByCard() {
        paymentByCard.click();
    }

    public void setPaymentByCredit() {
        paymentByCredit.click();
    }
}
