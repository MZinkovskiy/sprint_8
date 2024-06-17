package ru.yandex.praktikum;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccountParameterizedTest {
    String cardHolder;
    boolean result;

    @Parameterized.Parameters
    public static Object[][] cardHolder() {
        return new Object[][] {
                {"VASYA PUPKIN", true},
                {"VASYAPUPKIN", false},
                {" VASYAPUPKIN", false},
                {"VASYAPUPKIN ", false},
                {"VASYA PUP KIN", false},
                {"VP", false},
                {"VASILISACHKA PUPKINA", false},
                {"VASILISACHKA PUPKIN", true},
                {"V P", true},
        };
    }

    public AccountParameterizedTest(String cardHolder, boolean result) {
        this.cardHolder = cardHolder;
        this.result = result;
    }

    @Test
    @DisplayName("Проверка валидного name на карте")
    public void checkAccount() {
        Account account = new Account(cardHolder);
        assertEquals(result, account.checkNameToEmboss());
    }
}
