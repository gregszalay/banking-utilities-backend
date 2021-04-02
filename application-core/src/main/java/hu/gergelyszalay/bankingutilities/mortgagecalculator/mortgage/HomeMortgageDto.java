package hu.gergelyszalay.bankingutilities.mortgagecalculator.mortgage;

public class HomeMortgageDto {

    private final String monthlyPropertyTaxes;
    private final String monthlyPropertyInsurance;
    private final String monthlyHOAFee;

    public HomeMortgageDto(String monthlyPropertyTaxes, String monthlyPropertyInsurance, String monthlyHOAFee) {
        this.monthlyPropertyTaxes = monthlyPropertyTaxes;
        this.monthlyPropertyInsurance = monthlyPropertyInsurance;
        this.monthlyHOAFee = monthlyHOAFee;
    }

    public String getMonthlyPropertyTaxes() {
        return monthlyPropertyTaxes;
    }

    public String getMonthlyPropertyInsurance() {
        return monthlyPropertyInsurance;
    }

    public String getMonthlyHOAFee() {
        return monthlyHOAFee;
    }
}
