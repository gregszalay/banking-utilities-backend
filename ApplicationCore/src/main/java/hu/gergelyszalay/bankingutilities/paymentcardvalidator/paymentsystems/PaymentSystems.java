package hu.gergelyszalay.bankingutilities.paymentcardvalidator.paymentsystems;

import java.util.ArrayList;
import java.util.List;

public enum PaymentSystems {

    CHINA_UNIONPAY("China UnionPay", "62"),
    DINERS_CLUB_US_CANADA("Diners Club United States & Canada", "54"),
    DISCOVER_CARD("Discover Card", "6(011|2212[6-9]|221[3-9]|22[2-8]|229[0-1]|2292[0-5]|4[4-9]|5)"),
    UKR_CARD("UkrCard", "604(0[0]{0,1}[1-9]|1|200)"),
    RU_PAY("RuPay", "6(0|521|522)"),
    INTERPAYMENT("InterPayment", "636"),
    INSTAPAYMENT("InstaPayment", "63[7-9]"),
    JCB("JCB", "35(2[8-9]|[3-8][0-9])"),
    MAESTRO_UK("Maestro UK", "67(59|6770|6774)"),
    MAESTRO("Maestro", "(5018|5020|5038|5893|6304|6759|676[1-3])"),
    DANKORT("Dankort", "(5019|4571)"),
    MIR("MIR", "220[0-4]"),
    NPS("NPS Pridnestrovie", "605474[0-4]"),
    MASTERCARD("Mastercard", "(5[1-5]|222[1-9]|22[3-9]|2[3-6]|27[0-1]|2720)"),
    TROY("Troy", "9792[0-8]"),
    VISA("Visa", "4"),
    UNKNOWN("Unknown payment system", ".");

    private final String name;
    private final String IDRegex;

    PaymentSystems(String name, String IDRegex) {
        this.name = name;
        this.IDRegex = IDRegex;
    }

    public static PaymentSystems getPaymentSystemByID(String cardNumber) {
        if (cardNumber == null) throw new IllegalArgumentException("Card number must not be null!");

        List<PaymentSystems> matchingPaymentSystems = getMatchingPaymentSystems(cardNumber);
        PaymentSystems smallestMatchingPaymentSystem = getSmallestPaymentSystem(matchingPaymentSystems, cardNumber);
        return smallestMatchingPaymentSystem;

    }

    private static List<PaymentSystems> getMatchingPaymentSystems(String cardNumber) {
        if (cardNumber == null) throw new IllegalArgumentException("Card number must not be null!");
        List<PaymentSystems> results = new ArrayList<>();

        final String onlyDigitsPattern = "[0-9]+$";
        for (PaymentSystems paymentSystems : PaymentSystems.values()) {
            if (cardNumber.matches("^" + paymentSystems.IDRegex + onlyDigitsPattern)) {
                results.add(paymentSystems);
            }
        }

        return results;

    }

    private static PaymentSystems getSmallestPaymentSystem(List<PaymentSystems> paymentSystemsList, String cardNumber) {
        if (paymentSystemsList == null) throw new IllegalArgumentException("paymentSystemsList must not be null!");
        if (paymentSystemsList.isEmpty()) throw new IllegalArgumentException("paymentSystemsList must not be empty");

        PaymentSystems finalResult = paymentSystemsList.iterator().next();
        int previousLength = Integer.MAX_VALUE;
        for (PaymentSystems paymentSystems : paymentSystemsList) {
            String personalAccountNumber = cardNumber.replaceAll("^" + paymentSystems.IDRegex, "");
            if (personalAccountNumber.length() < previousLength) {
                previousLength = personalAccountNumber.length();
                finalResult = paymentSystems;
            }
        }

        return finalResult;

    }

    public String getName() {
        return name;
    }

}
