package hu.gergelyszalay.bankingutilities.paymentcardvalidator.api.dto.paymentcard;

import hu.gergelyszalay.bankingutilities.paymentcardvalidator.api.dto.ValidationResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PaymentCardTest {

    @Test
    void constructor_ShouldRemoveAllWhiteSpaces_WhenParameterContainsWhiteSpaces() {
        String expected = "9792088544527995";
        String actual = runConstructor(" 9792 0885 44  52   7995   ").getCardNumber();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void constructor_ShouldThrowEmptyCardException_WhenParameterContainsOnlyWhiteSpaces() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> runConstructor("  "));
    }

    @Test
    void constructor_ShouldThrowEmptyCardException_WhenParameterIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> runConstructor(null));
    }

    @Test
    void printNumber_ShouldAddWhiteSpacesBetweenEvery4Digits_WhenNumberDoesNotContainWhiteSpaces() throws EmptyCardNumberException {
        String expected = "9792 0885 4452 7995";
        String actual = new ValidationResult().formatCardNumber("9792088544527995");
        Assertions.assertEquals(expected, actual);
    }

    private PaymentCard runConstructor(String testString) {
        return new PaymentCard(testString);
    }

}