package io.swagger.model.impl;

import hu.gergelyszalay.bankingutilities.mortgagecalculator.api.dto.MortgageResult;
import io.swagger.model.MortgageCalculatorResult;

public class MortgageResultAdapter {

    public MortgageCalculatorResult convert(MortgageResult coreApplicationResult) {

        MortgageCalculatorResult conversionResult = new MortgageCalculatorResult();

        conversionResult.setMortgageMonthlyPayment(coreApplicationResult.getMonthlyPayment());
        conversionResult.setMortgageCalculatorMessage(coreApplicationResult.getMessage());

        return conversionResult;

    }

}
