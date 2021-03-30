package hu.gergelyszalay.bankingutilities.paymentcardvalidator.paymentsystems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PaymentSystemsTest {

    @Test
    void getPaymentSystem_ShouldReturn_CHINA_UNIONPAY_WhenCardNumberMatches_CHINA_UNIONPAY() {
        String expected = PaymentSystems.CHINA_UNIONPAY.getName();
        String actual = PaymentSystems.getPaymentSystemByID("6250411244954072").getName();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getPaymentSystem_ShouldReturn_DINERS_CLUB_US_CANADA_WhenCardNumberMatches_DINERS_CLUB_US_CANADA() {
        String expected = PaymentSystems.DINERS_CLUB_US_CANADA.getName();
        String actual = PaymentSystems.getPaymentSystemByID("5490710276340551").getName();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getPaymentSystem_ShouldReturn_DISCOVER_CARD_WhenCardNumberMatches_DISCOVER_CARD() {
        String expected = PaymentSystems.DISCOVER_CARD.getName();
        String actual = PaymentSystems.getPaymentSystemByID("6504459678537164").getName();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getPaymentSystem_ShouldReturn_UKR_CARD_WhenCardNumberMatches_UKR_CARD() {
        String expected = PaymentSystems.UKR_CARD.getName();
        String actual = PaymentSystems.getPaymentSystemByID("6041329841902191").getName();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getPaymentSystem_ShouldReturn_RU_PAY_WhenCardNumberMatches_RU_PAY() {
        String expected = PaymentSystems.RU_PAY.getName();
        String actual = PaymentSystems.getPaymentSystemByID("6078397330921424").getName();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getPaymentSystem_ShouldReturn_INTERPAYMENT_WhenCardNumberMatches_INTERPAYMENT() {
        String expected = PaymentSystems.INTERPAYMENT.getName();
        String actual = PaymentSystems.getPaymentSystemByID("6364805987252144").getName();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getPaymentSystem_ShouldReturn_INSTAPAYMENT_WhenCardNumberMatches_INSTAPAYMENT() {
        String expected = PaymentSystems.INSTAPAYMENT.getName();
        String actual = PaymentSystems.getPaymentSystemByID("6397751584967059").getName();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getPaymentSystem_ShouldReturn_JCB_WhenCardNumberMatches_JCB() {
        String expected = PaymentSystems.JCB.getName();
        String actual = PaymentSystems.getPaymentSystemByID("3562399864814405").getName();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getPaymentSystem_ShouldReturn_MAESTRO_UK_WhenCardNumberMatches_MAESTRO_UK() {
        String expected = PaymentSystems.MAESTRO_UK.getName();
        String actual = PaymentSystems.getPaymentSystemByID("6759366150905201").getName();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getPaymentSystem_ShouldReturn_MAESTRO_WhenCardNumberMatches_MAESTRO() {
        String expected = PaymentSystems.MAESTRO.getName();
        String actual = PaymentSystems.getPaymentSystemByID("6761098933526857").getName();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getPaymentSystem_ShouldReturn_DANKORT_WhenCardNumberMatches_DANKORT() {
        String expected = PaymentSystems.DANKORT.getName();
        String actual = PaymentSystems.getPaymentSystemByID("4571344073595020").getName();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getPaymentSystem_ShouldReturn_MIR_WhenCardNumberMatches_MIR() {
        String expected = PaymentSystems.MIR.getName();
        String actual = PaymentSystems.getPaymentSystemByID("2200094986422092").getName();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getPaymentSystem_ShouldReturn_NPS_WhenCardNumberMatches_NPS() {
        String expected = PaymentSystems.NPS.getName();
        String actual = PaymentSystems.getPaymentSystemByID("6054741617575262").getName();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getPaymentSystem_ShouldReturn_MASTERCARD_WhenCardNumberMatches_MASTERCARD() {
        String expected = PaymentSystems.MASTERCARD.getName();
        String actual = PaymentSystems.getPaymentSystemByID("5211627651898060").getName();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getPaymentSystem_ShouldReturn_TROY_WhenCardNumberMatches_TROY() {
        String expected = PaymentSystems.TROY.getName();
        String actual = PaymentSystems.getPaymentSystemByID("9792085492401066").getName();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getPaymentSystem_ShouldReturn_VISA_WhenCardNumberMatches_VISA() {
        String expected = PaymentSystems.VISA.getName();
        String actual = PaymentSystems.getPaymentSystemByID("4841876426370928").getName();
        Assertions.assertEquals(expected, actual);
    }

}
