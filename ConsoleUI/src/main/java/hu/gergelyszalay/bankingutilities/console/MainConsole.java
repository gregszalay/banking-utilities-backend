package hu.gergelyszalay.bankingutilities.console;

import hu.gergelyszalay.bankingutilities.mortgagecalculator.console.MortgageCalculatorConsole;
import hu.gergelyszalay.bankingutilities.paymentcardvalidator.console.CardValidatorConsole;
import hu.gergelyszalay.consoleui.ConsoleNavigator;
import hu.gergelyszalay.consoleui.ConsoleUI;

import java.util.ResourceBundle;
import java.util.Scanner;

public class MainConsole extends ConsoleUI {

    public MainConsole() {
        super(ResourceBundle.getBundle("i18n.bankingAppMainMessageBundle"));
    }

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            ConsoleNavigator navigator = new ConsoleNavigator(
                    new MainConsole(),
                    new QuitConsole(),
                    new MortgageCalculatorConsole(),
                    new CardValidatorConsole()
            );
            ConsoleUI firstConsoleUI = navigator.getDefaultConsoleUI();
            firstConsoleUI.runConsoleUI(navigator, scanner);

        }

    }

    @Override
    public void runConsoleUI(ConsoleNavigator navigator, Scanner scanner) {
        System.out.println(this.getResourceBundle().getString("mainWelcomeMessage"));
        ConsoleUI nextConsole = navigator.getNextConsoleUIFromUser(scanner);
        nextConsole.runConsoleUI(navigator, scanner);
    }
}
