package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import data.DataGenerator;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CreditPage {

    private final ElementsCollection fields = $$(".input__control");
    private final SelenideElement cardNumber = fields.get(0);
    private final SelenideElement cardMonth = fields.get(1);
    private final SelenideElement cardYear = fields.get(2);
    private final SelenideElement cardHolder = fields.get(3);
    private final SelenideElement cardCode = fields.get(4);
    private final ElementsCollection button = $$(".button");
    private final SelenideElement paymentButton = button.get(2);
    private final SelenideElement notOk = $(".notification_status_ok");
    private final SelenideElement notError = $(".notification_status_error");
    private final SelenideElement notMustFill = $(".input__sub");

    public void setCardNumber(int id) {
        cardNumber.setValue(DataGenerator.getCardNumber(id));
    }

    public void getPay() {
        paymentButton.click();
    }

    public void fillingInTheFields(int month, int year, int holder, int code) {
        cardMonth.setValue(DataGenerator.generateMonth(month));
        cardYear.setValue(DataGenerator.generateYear(year));
        cardHolder.setValue(DataGenerator.generateHolder(holder));
        cardCode.setValue(DataGenerator.generateCode(code));
    }

    public void getApprove() {
        notOk.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public void getError() {
        notError.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public void getFillTheForm() {
        notMustFill.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }
}
