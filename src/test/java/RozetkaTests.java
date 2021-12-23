import io.qameta.allure.Description;
import org.junit.Test;
import pages.StartPage;

import static com.codeborne.selenide.Selenide.open;
import static constans.Urls.BASE_URL_ROZETKA;

public class RozetkaTests {
    @Test
    @Description("Проверка что корзина без добавления товаров пуста")
    public void checkThatCartIsEmpty() {
        open(BASE_URL_ROZETKA);
        new StartPage()
                .openTheCart()
                .verifyThatCardHaveHeaderText("Корзина пуста");
    }

    @Test
    @Description("Проверка что поля Логин и Пароль отображаються на форме логина")
    public void checkThatLoginFormHaveLoginAndPasswordFields() {
        open(BASE_URL_ROZETKA);
        new StartPage()
                .openTheAuthForm()
                .checkThatEmailAndPasswordFieldIsDisplayed();

    }

    @Test
    @Description("Проверка что Поля Формы регистрации отображаються на форме")
    public void checkRegistrationForm() {
        open(BASE_URL_ROZETKA);
        new StartPage()
                .openTheAuthForm()
                .openTheRegisterForm()
                .checkThatRegistrationFieldsIsDisplayed();
    }
    @Test
    @Description("Проверка что Поля Формы восстановления Пароля отображаються на форме")
    public void checkRestorePasswordForm() {
        open(BASE_URL_ROZETKA);
        new StartPage()
                .openTheAuthForm()
                .openTheRestorePasswordForm()
                .checkThatEmailFieldIsDisplayedOnRestorePasswordForm();
    }

    @Test
    @Description("Проверка что Ошибка Валидации отображается под полем имя")
    public void checkThatValidationErrorIsShownInNameField() {
        open(BASE_URL_ROZETKA);
        new StartPage()
                .openTheAuthForm()
                .openTheRegisterForm()
                .checkThatValidationErrorIsShownInNameField("Введите свое имя на кириллице");
    }



}
