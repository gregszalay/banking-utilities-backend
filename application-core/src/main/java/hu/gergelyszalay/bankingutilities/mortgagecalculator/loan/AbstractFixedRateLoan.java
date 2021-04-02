package hu.gergelyszalay.bankingutilities.mortgagecalculator.loan;

import hu.gergelyszalay.bankingutilities.mortgagecalculator.currencyparserapi.CurrencyParserApi;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.ParseException;

public abstract class AbstractFixedRateLoan {

    protected final CurrencyParserApi currencyParserApi;
    private final BigDecimal principalAmount;
    private final Integer loanTermInYears;
    private final BigDecimal downPayment;
    private final Number annualInterestRatePercent;

    public AbstractFixedRateLoan(CurrencyParserApi currencyParserApi, LoanDto loanDto) {
        this.currencyParserApi = currencyParserApi;

        this.principalAmount = currencyParserApi.parseAmount(loanDto.getPrincipalAmount());
        if (this.principalAmount.doubleValue() < 0) throw new IllegalArgumentException("Principal amount is negative!");

        this.downPayment = currencyParserApi.parseAmount(loanDto.getDownPayment());
        if (this.downPayment.doubleValue() < 0) throw new IllegalArgumentException("Down payment is negative!");

        this.loanTermInYears = parseLoanTerm(loanDto.getLoanTermInYears());
        if (this.loanTermInYears < 1) throw new IllegalArgumentException("Loan term cannot be shorter than 1 year!");
        if (this.loanTermInYears > 50) throw new IllegalArgumentException("Loan term cannot be longer than 50 years!");

        this.annualInterestRatePercent = parseAnnualInterestRate(loanDto.getAnnualInterestRate());
        if (this.annualInterestRatePercent.doubleValue() < 0)
            throw new IllegalArgumentException("Interest rate is negative!");

    }

    private Integer parseLoanTerm(String loanTermString) {
        if (loanTermString == null || loanTermString.equals(""))
            throw new IllegalArgumentException("Loan term is not a number!");

        try {
            return Integer.parseInt(loanTermString);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("Loan term is not a parsable integer!");
        }

    }

    private Number parseAnnualInterestRate(String percentString) {
        Number result;

        try {
            result = NumberFormat.getPercentInstance().parse(percentString.trim() + "%");
        } catch (ParseException parseException) {
            throw new IllegalArgumentException(percentString + " is not a valid percentage!");
        }

        return result;

    }

    public BigDecimal getMonthlyPayment() {
        return calculateMonthlyPayment();
    }

    public final BigDecimal calculateMonthlyPayment() {

        int numberOfTotalPayments = loanTermInYears * 12;
        double principalOutstanding = principalAmount.doubleValue() - this.downPayment.doubleValue();
        double monthlyInterestRate = annualInterestRatePercent.doubleValue() / 12;
        double geometricSequence = Math.pow(1 + monthlyInterestRate, numberOfTotalPayments);
        double result;

        if (monthlyInterestRate == 0.0) {
            result = principalOutstanding / numberOfTotalPayments;
        } else {
            result = (principalOutstanding * monthlyInterestRate * geometricSequence) / (geometricSequence - 1);
        }

        return new BigDecimal(result).setScale(this.principalAmount.scale(), RoundingMode.HALF_EVEN);

    }

}
