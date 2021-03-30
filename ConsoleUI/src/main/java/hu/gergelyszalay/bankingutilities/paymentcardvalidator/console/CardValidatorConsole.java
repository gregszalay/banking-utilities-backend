package hu.gergelyszalay.bankingutilities.paymentcardvalidator.console;

import hu.gergelyszalay.bankingutilities.paymentcardvalidator.api.ValidatorApi;
import hu.gergelyszalay.bankingutilities.paymentcardvalidator.api.dto.ValidationResult;
import hu.gergelyszalay.consoleui.ConsoleNavigator;
import hu.gergelyszalay.consoleui.ConsoleUI;

import java.util.ResourceBundle;
import java.util.Scanner;

public class CardValidatorConsole extends ConsoleUI {

    public CardValidatorConsole() {
        super(ResourceBundle.getBundle("i18n.paymentCardValidatorMessageBundle"),
                ResourceBundle.getBundle("i18n.bankingAppMainMessageBundle"));
    }

    @Override
    public void runConsoleUI(ConsoleNavigator navigator, Scanner scanner) {
        System.out.println(this.getResourceBundle().getString("cardValidatorWelcomeMessage"));

        String messageToUser = this.getResourceBundle().getString("enterCardNumberPrompt");
        String cardNumber = getNextInputFromUser(messageToUser, scanner);

        ValidationResult result = new ValidatorApi() {
        }.validate(cardNumber);

        System.out.println(result.getValidationMessage());

        ConsoleUI nextConsole = navigator.getNextConsoleUIFromUser(scanner);
        nextConsole.runConsoleUI(navigator, scanner);

    }

    private String getNextInputFromUser(String promptText, Scanner scanner) {
        System.out.print(promptText);
        return scanner.next();
    }

}

