package hu.gergelyszalay.bankingutilities.mortgagecalculator.loan;

public class LoanDto {

    private final String principalAmount;
    private final String downPayment;
    private final String loanTermInYears;
    private final String annualInterestRate;

    public LoanDto(String principalAmount, String downPayment,
                   String loanTermInYears, String annualInterestRate) {
        this.principalAmount = principalAmount;
        this.downPayment = downPayment;
        this.loanTermInYears = loanTermInYears;
        this.annualInterestRate = annualInterestRate;
    }

    public String getPrincipalAmount() {
        return principalAmount;
    }

    public String getDownPayment() {
        return downPayment;
    }

    public String getLoanTermInYears() {
        return loanTermInYears;
    }

    public String getAnnualInterestRate() {
        return annualInterestRate;
    }
}
