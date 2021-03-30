package hu.gergelyszalay.bankingutilities.mortgagecalculator.api;

import hu.gergelyszalay.bankingutilities.mortgagecalculator.api.dto.MortgageInput;
import hu.gergelyszalay.bankingutilities.mortgagecalculator.api.dto.MortgageResult;
import hu.gergelyszalay.bankingutilities.mortgagecalculator.api.impl.MortgageCalculator;

public interface MortgageCalculatorApi {

    default MortgageResult calculatePayment(MortgageInput inputApi) {
        return new MortgageCalculator().calculatePayment(inputApi);
    }

}
