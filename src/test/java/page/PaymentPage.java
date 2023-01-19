package page;

import com.codeborne.selenide.*;
import data.DataGenerator;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class PaymentPage {

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

    public void cleaning() {
        cardNumber.doubleClick().sendKeys(Keys.BACK_SPACE);
        cardMonth.doubleClick().sendKeys(Keys.BACK_SPACE);
        cardYear.doubleClick().sendKeys(Keys.BACK_SPACE);
        cardHolder.doubleClick().sendKeys(Keys.BACK_SPACE);
        cardCode.doubleClick().sendKeys(Keys.BACK_SPACE);
    }
}
