package io.swagger.model.impl;

import hu.gergelyszalay.bankingutilities.mortgagecalculator.api.dto.MortgageInput;
import hu.gergelyszalay.bankingutilities.mortgagecalculator.loan.LoanDto;
import hu.gergelyszalay.bankingutilities.mortgagecalculator.mortgage.HomeMortgageDto;

public class MortgageInputAdapter {

    public MortgageInput convert(io.swagger.model.MortgageInput webserviceInput) {
        MortgageInput conversionResult = new MortgageInput();
        conversionResult.convertInputFrom(
                new LoanDto(
                        webserviceInput.getPrincipalAmountBorrowed(),
                        webserviceInput.getDownPayment(),
                        webserviceInput.getLoanTermInYears(),
                        webserviceInput.getAnnualInterestRatePercent()),
                new HomeMortgageDto(
                        webserviceInput.getMonthlyPropertyTaxes(),
                        webserviceInput.getMonthlyPropertyInsurance(),
                        webserviceInput.getMonthlyHomeownersAssociationFee())
        );
        return conversionResult;
    }

}
