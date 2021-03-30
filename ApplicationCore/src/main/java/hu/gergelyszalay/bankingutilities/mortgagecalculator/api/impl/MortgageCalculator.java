package hu.gergelyszalay.bankingutilities.mortgagecalculator.api.impl;

import hu.gergelyszalay.bankingutilities.mortgagecalculator.api.MortgageCalculatorApi;
import hu.gergelyszalay.bankingutilities.mortgagecalculator.api.dto.MortgageInput;
import hu.gergelyszalay.bankingutilities.mortgagecalculator.api.dto.MortgageResult;
import hu.gergelyszalay.bankingutilities.mortgagecalculator.currencyparserapi.impl.CurrencyParser;
import hu.gergelyszalay.bankingutilities.mortgagecalculator.mortgage.HomeMortgage;

public class MortgageCalculator implements MortgageCalculatorApi {

    public MortgageResult calculatePayment(MortgageInput mortgageInput) {
        MortgageResult calculatorResult = new MortgageResult();
        try {
            HomeMortgage homeMortgage = new HomeMortgage(
                    new CurrencyParser(),
                    mortgageInput.getLoanDto(),
                    mortgageInput.getHomeMortgageDto()
            );
            calculatorResult.setMonthlyPayment(homeMortgage.getMonthlyPayment().toString());
        } catch (Exception e) {
            calculatorResult.setMessage("Error: " + e.getMessage());
            return calculatorResult;
        }
        calculatorResult.setMessage("Calculation was successful!");
        return calculatorResult;

    }

}
