package hu.gergelyszalay.bankingutilities.mortgagecalculator.mortgage;

import hu.gergelyszalay.bankingutilities.mortgagecalculator.currencyparserapi.CurrencyParserApi;
import hu.gergelyszalay.bankingutilities.mortgagecalculator.loan.AbstractFixedRateLoan;
import hu.gergelyszalay.bankingutilities.mortgagecalculator.loan.LoanDto;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class HomeMortgage extends AbstractFixedRateLoan {

    private final Number monthlyPropertyTax;
    private final Number monthlyPropertyInsurance;
    private final Number monthlyHOAFee;

    public HomeMortgage(CurrencyParserApi currencyParserApi, LoanDto loanDto, HomeMortgageDto homeMortgageDto) {
        super(currencyParserApi, loanDto);

        this.monthlyPropertyTax = parseStringParam(homeMortgageDto.getMonthlyPropertyTaxes());
        if (this.monthlyPropertyTax.doubleValue() < 0) {
            throw new IllegalArgumentException("Property tax is negative!");
        }

        this.monthlyPropertyInsurance = parseStringParam(homeMortgageDto.getMonthlyPropertyInsurance());
        if (this.monthlyPropertyInsurance.doubleValue() < 0) {
            throw new IllegalArgumentException("Insurance fee is negative!");
        }

        this.monthlyHOAFee = parseStringParam(homeMortgageDto.getMonthlyHOAFee());
        if (this.monthlyHOAFee.doubleValue() < 0) {
            throw new IllegalArgumentException("HOA fee is negative!");
        }

    }

    private Number parseStringParam(String amountString) {
        if (amountString == null || amountString.isEmpty()) {
            return 0;
        } else {
            return currencyParserApi.parseAmount(amountString);
        }
    }

    @Override
    public BigDecimal getMonthlyPayment() {

        BigDecimal basePayment = calculateMonthlyPayment();
        double addedAmounts = monthlyPropertyTax.doubleValue()
                + monthlyPropertyInsurance.doubleValue()
                + monthlyHOAFee.doubleValue();

        BigDecimal finalResult = new BigDecimal(basePayment.doubleValue() + addedAmounts);
        return finalResult.setScale(basePayment.scale(), RoundingMode.HALF_EVEN);
    }

}
