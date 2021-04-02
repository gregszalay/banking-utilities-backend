package hu.gergelyszalay.bankingutilities.mortgagecalculator.api.dto;

public class MortgageResult {

    private String monthlyPayment;
    private String message;

    public String getMonthlyPayment() {
        return this.monthlyPayment;
    }

    public void setMonthlyPayment(String monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
