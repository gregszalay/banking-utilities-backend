package hu.gergelyszalay.bankingutilities.console;

import hu.gergelyszalay.consoleui.ConsoleNavigator;
import hu.gergelyszalay.consoleui.ConsoleUI;

import java.util.ResourceBundle;
import java.util.Scanner;

public class QuitConsole extends ConsoleUI {

    public QuitConsole() {
        super(ResourceBundle.getBundle("i18n.bankingAppMainMessageBundle"),
                ResourceBundle.getBundle("i18n.bankingAppMainMessageBundle").getString("quitName"),
                ResourceBundle.getBundle("i18n.bankingAppMainMessageBundle").getString("quitUICode"));
    }

    @Override
    public void runConsoleUI(ConsoleNavigator navigator, Scanner scanner) {
        System.exit(0);
    }

    public String getNavigationPromptMessage() {
        if (this.getSecondaryResourceBundle() != null) {
            return String.format(this.getSecondaryResourceBundle().getString("quitOption"), this.getUICode());
        }
        return String.format(this.getResourceBundle().getString("quitOption"), this.getUICode());
    }

}
