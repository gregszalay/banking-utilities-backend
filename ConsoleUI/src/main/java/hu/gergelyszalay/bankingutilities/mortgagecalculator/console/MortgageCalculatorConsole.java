package hu.gergelyszalay.bankingutilities.mortgagecalculator.console;

import hu.gergelyszalay.bankingutilities.mortgagecalculator.api.MortgageCalculatorApi;
import hu.gergelyszalay.bankingutilities.mortgagecalculator.api.dto.MortgageInput;
import hu.gergelyszalay.bankingutilities.mortgagecalculator.api.dto.MortgageResult;
import hu.gergelyszalay.bankingutilities.mortgagecalculator.loan.LoanDto;
import hu.gergelyszalay.bankingutilities.mortgagecalculator.mortgage.HomeMortgageDto;
import hu.gergelyszalay.consoleui.ConsoleNavigator;
import hu.gergelyszalay.consoleui.ConsoleUI;

import java.util.ResourceBundle;
import java.util.Scanner;

public class MortgageCalculatorConsole extends ConsoleUI {

    public MortgageCalculatorConsole() {
        super(ResourceBundle.getBundle("i18n.mortgageCalculatorMessageBundle"),
                ResourceBundle.getBundle("i18n.bankingAppMainMessageBundle"));
    }

    @Override
    public void runConsoleUI(ConsoleNavigator navigator, Scanner scanner) {
        System.out.println(this.getResourceBundle().getString("mortgageCalculatorWelcomeMessage"));

        String messageToUser;

        messageToUser = this.getResourceBundle().getString("principalAmountBorrowedPrompt");
        String principalAmount = getNextInputFromUser(messageToUser, scanner);

        messageToUser = this.getResourceBundle().getString("downPaymentPrompt");
        String downPayment = getNextInputFromUser(messageToUser, scanner);

        messageToUser = this.getResourceBundle().getString("loanTermInYearsPrompt");
        String loanTermInYears = getNextInputFromUser(messageToUser, scanner);

        messageToUser = this.getResourceBundle().getString("annualInterestRatePrompt");
        String annualInterestRate = getNextInputFromUser(messageToUser, scanner);

        messageToUser = this.getResourceBundle().getString("monthlyPropertyTaxesPrompt");
        String monthlyPropertyTaxes = getNextInputFromUser(messageToUser, scanner);

        messageToUser = this.getResourceBundle().getString("monthlyPropertyInsurancePrompt");
        String monthlyPropertyInsurance = getNextInputFromUser(messageToUser, scanner);

        messageToUser = this.getResourceBundle().getString("monthlyHomeownersAssociationFeePrompt");
        String monthlyHOAFee = getNextInputFromUser(messageToUser, scanner);

        LoanDto loanDto = new LoanDto(principalAmount, downPayment, loanTermInYears, annualInterestRate);

        HomeMortgageDto homeMortgageDto = new HomeMortgageDto(monthlyPropertyTaxes, monthlyPropertyInsurance, monthlyHOAFee);

        MortgageInput calculatorInput = new MortgageInput();
        calculatorInput.convertInputFrom(loanDto, homeMortgageDto);

        MortgageResult result = new MortgageCalculatorApi() {
        }.calculatePayment(calculatorInput);
        System.out.print(result.getMessage());

        String resultMessage = buildResultMessage(result.getMonthlyPayment());
        System.out.print(resultMessage);

        ConsoleUI nextConsole = navigator.getNextConsoleUIFromUser(scanner);
        nextConsole.runConsoleUI(navigator, scanner);

    }

    private String getNextInputFromUser(String promptText, Scanner scanner) {
        System.out.print(promptText);
        return scanner.next();
    }

    private String buildResultMessage(String result) {
        String template = this.getResourceBundle().getString("monthlyPaymentResultMessage");
        return String.format(template, result);
    }

}
