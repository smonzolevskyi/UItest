package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;

public class StartPage {
    private final By cartButton = By.xpath("//*[@href='#icon-header-basket']/../..");
    private final By cartHeader = By.cssSelector(".cart-dummy .cart-dummy__heading");
    private final By loginFormButton = By.xpath("//*[@href='#icon-user-simple']/../..");
    private final By loginField = By.xpath("//*[@formcontrolname='login']");
    private final By passwordField = By.xpath("//*[@formcontrolname='password']");
    private final By registrationButton = By.cssSelector("button.auth-modal__register-link");
    private final By nameRegisterFormField = By.xpath("//*[@formcontrolname='name']");
    private final By surnameRegisterFormField = By.xpath("//*[@formcontrolname='surname']");
    private final By phoneNumberRegisterFormField = By.xpath("//*[@formcontrolname='phone']");
    private final By emailAddressRegisterFormField = By.xpath("//*[@formcontrolname='email']");
    private final By passwordRegisterFormField = By.xpath("//*[@formcontrolname='password']");
    private final By restorePasswordButton = By.cssSelector(".link-dotted.auth-modal__restore-link");
    private final By validationErrorMessage = By.cssSelector(".validation-message .ng-star-inserted");

    @Step("Открыть Корзину")
    public StartPage openTheCart() {
        $(cartButton).should(Condition.enabled).click();
        return this;
    }

    @Step("Открыть страницу авторизации")
    public StartPage openTheAuthForm() {
        $(loginFormButton).should(Condition.enabled).click();
        return this;
    }

    @Step("Проверка что корзина пуста,и текст {text} отображается")
    public StartPage verifyThatCardHaveHeaderText(final String text) {
        $(cartHeader).shouldBe(Condition.visible);
        Assert.assertEquals($(cartHeader).getText(), text);
        return this;
    }

    @Step("Проверка что Email и Password поля отображаются на форме логин")
    public StartPage checkThatEmailAndPasswordFieldIsDisplayed() {
        $(loginField).shouldBe(Condition.visible);
        $(passwordField).shouldBe(Condition.visible);
        return this;
    }

    @Step("Открыть форму регистрации")
    public StartPage openTheRegisterForm() {
        $(registrationButton).shouldBe(Condition.visible).click();
        return this;
    }

    @Step("Проверить что поля формы регистрации отображаются")
    public StartPage checkThatRegistrationFieldsIsDisplayed() {
        $(nameRegisterFormField).shouldBe(Condition.visible);
        $(surnameRegisterFormField).shouldBe(Condition.visible);
        $(phoneNumberRegisterFormField).shouldBe(Condition.visible);
        $(emailAddressRegisterFormField).shouldBe(Condition.visible);
        $(passwordRegisterFormField).shouldBe(Condition.visible);
        return this;
    }

    @Step("Открыть форму восстановление пароля")
    public StartPage openTheRestorePasswordForm() {
        $(restorePasswordButton).shouldBe(Condition.visible).click();
        return this;
    }

    @Step("Проверить что поле Эл. почта отображается на форме восстановления пароля")
    public StartPage checkThatEmailFieldIsDisplayedOnRestorePasswordForm() {
        $(loginField).shouldBe(Condition.visible);
        return this;
    }

    @Step("Проверить что ошибка валидации отображается под полем Имя")
    public StartPage checkThatValidationErrorIsShownInNameField(String text) {
        $(nameRegisterFormField).shouldBe(Condition.visible).sendKeys("Test");
        $(validationErrorMessage).shouldBe(Condition.visible);
        Assert.assertEquals($(validationErrorMessage).getText(), text);
        return this;
    }

}


