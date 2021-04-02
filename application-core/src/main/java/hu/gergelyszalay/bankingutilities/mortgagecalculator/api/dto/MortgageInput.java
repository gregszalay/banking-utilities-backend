package hu.gergelyszalay.bankingutilities.mortgagecalculator.api.dto;

import hu.gergelyszalay.bankingutilities.mortgagecalculator.loan.LoanDto;
import hu.gergelyszalay.bankingutilities.mortgagecalculator.mortgage.HomeMortgageDto;

public class MortgageInput {

    private LoanDto loanDto;
    private HomeMortgageDto homeMortgageDto;

    public void convertInputFrom(LoanDto loanDto, HomeMortgageDto homeMortgageDto) {
        this.loanDto = loanDto;
        this.homeMortgageDto = homeMortgageDto;
    }

    public LoanDto getLoanDto() {
        return this.loanDto;
    }

    public HomeMortgageDto getHomeMortgageDto() {
        return this.homeMortgageDto;
    }
}
