package hu.gergelyszalay.consoleui;

import java.util.*;

public class ConsoleNavigator {

    private final List<ConsoleUI> consoles = new LinkedList<>();
    private final ResourceBundle resourceBundle = ResourceBundle.getBundle("i18n.consoleNavigatorMessageBundle");

    public ConsoleNavigator(ConsoleUI defaultConsoleUI, ConsoleUI quitConsole) {
        this.consoles.add(defaultConsoleUI);
        this.consoles.add(quitConsole);
    }

    public ConsoleNavigator(ConsoleUI defaultConsoleUI, ConsoleUI quitConsole, ConsoleUI... consoleUIs) {
        this(defaultConsoleUI, quitConsole);
        this.consoles.addAll(Arrays.asList(consoleUIs));
    }

    public ConsoleUI getConsoleUI(String consoleKey) {
        if (consoleKey == null || consoleKey.isEmpty())
            throw new IllegalArgumentException("Console key must not be null or empty!");
        for (ConsoleUI consoleUI : consoles) {
            if (consoleUI.getUICode().equals(consoleKey)) return consoleUI;
        }
        return getDefaultConsoleUI();
    }

    public ConsoleUI getDefaultConsoleUI() {
        return consoles.get(0);
    }


    public ConsoleUI getNextConsoleUIFromUser(Scanner scanner) {
        printNavigationMenu();
        String chosenOption = scanner.next();
        return getConsoleUI(chosenOption);
    }

    private void printNavigationMenu() {
        System.out.println(resourceBundle.getString("navigationMenuText"));
        for (ConsoleUI consoleUI : consoles) {
            System.out.println(consoleUI.getNavigationPromptMessage());
        }
    }

}
