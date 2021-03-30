package hu.gergelyszalay.bankingutilities.mortgagecalculator.mortgage;

import hu.gergelyszalay.bankingutilities.mortgagecalculator.api.MortgageCalculatorApi;
import hu.gergelyszalay.bankingutilities.mortgagecalculator.api.dto.MortgageInput;
import hu.gergelyszalay.bankingutilities.mortgagecalculator.api.dto.MortgageResult;
import hu.gergelyszalay.bankingutilities.mortgagecalculator.currencyparserapi.CurrencyParserApi;
import hu.gergelyszalay.bankingutilities.mortgagecalculator.currencyparserapi.impl.CurrencyParser;
import hu.gergelyszalay.bankingutilities.mortgagecalculator.loan.LoanDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HomeMortgageTest {

    @Test
    void getMonthlyPayment_shouldCalculateExactMonthlyPayment_WhenCalledOnMortgageObject() {
        LoanDto loanDto = new LoanDto(
                "$1500000.87",
                "$300000.50",
                "15",
                "2.8"
        );
        HomeMortgageDto mortgageDetails = new HomeMortgageDto(
                "$80",
                "$100",
                "$50"
        );

        MortgageInput input = new MortgageInput();
        input.convertInputFrom(loanDto, mortgageDetails);
        MortgageResult result = new MortgageCalculatorApi() {
        }.calculatePayment(input);

        String expectedMonthlyPayment = "8402.04";
        String actualMonthlyPayment = result.getMonthlyPayment();
        assertEquals(expectedMonthlyPayment, actualMonthlyPayment);
    }

    @Test
    void constructor_ShouldThrowIllegalArgumentException_PrincipalAmountIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> runConstructor(
                new CurrencyParser(),
                new LoanDto(
                        "-1000000",
                        "300000",
                        "15",
                        "2.8"),
                new HomeMortgageDto(
                        "80",
                        "100",
                        "50"))
        );
    }

    @Test
    void constructor_ShouldThrowIllegalArgumentException_DownPaymentIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> runConstructor(
                new CurrencyParser(),
                new LoanDto(
                        "1000000",
                        "-300000",
                        "15",
                        "2.8"),
                new HomeMortgageDto(
                        "80",
                        "100",
                        "50"))
        );
    }

    @Test
    void constructor_ShouldThrowIllegalArgumentException_AnnualInterestRateIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> runConstructor(
                new CurrencyParser(),
                new LoanDto(
                        "1000000",
                        "300000",
                        "15",
                        "-2.8"),
                new HomeMortgageDto(
                        "80",
                        "100",
                        "50"))
        );
    }

    @Test
    void constructor_ShouldThrowIllegalArgumentException_MonthlyPropertyTaxesIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> runConstructor(
                new CurrencyParser(),
                new LoanDto(
                        "1000000",
                        "300000",
                        "15",
                        "2.8"),
                new HomeMortgageDto(
                        "-80",
                        "100",
                        "50"))
        );
    }

    @Test
    void constructor_ShouldThrowIllegalArgumentException_MonthlyPropertyInsuranceIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> runConstructor(
                new CurrencyParser(),
                new LoanDto(
                        "1000000",
                        "300000",
                        "15",
                        "2.8"),
                new HomeMortgageDto(
                        "80",
                        "-100",
                        "50"))
        );
    }

    @Test
    void constructor_ShouldThrowIllegalArgumentException_MonthlyHomeOwnersAssociationFeeIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> runConstructor(
                new CurrencyParser(),
                new LoanDto(
                        "1000000",
                        "300000",
                        "15",
                        "2.8"),
                new HomeMortgageDto(
                        "80",
                        "100",
                        "-50"))
        );
    }

    private HomeMortgage runConstructor(CurrencyParserApi currencyParserApi, LoanDto loanDto, HomeMortgageDto mortgageDetails) {
        return new HomeMortgage(currencyParserApi, loanDto, mortgageDetails);
    }

}