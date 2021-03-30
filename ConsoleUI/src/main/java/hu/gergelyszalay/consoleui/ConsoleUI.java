package hu.gergelyszalay.consoleui;

import java.util.ResourceBundle;
import java.util.Scanner;

public abstract class ConsoleUI {

    private final String name;
    private final String UICode;
    private final ResourceBundle resourceBundle;
    private ResourceBundle secondaryResourceBundle;

    protected ConsoleUI(ResourceBundle resourceBundle, String name, String UICode) {
        this.name = name;
        this.UICode = UICode;
        this.resourceBundle = resourceBundle;
    }

    public ConsoleUI(ResourceBundle resourceBundle) {
        this(resourceBundle, resourceBundle.getString("name"), resourceBundle.getString("UICode"));
    }

    public ConsoleUI(ResourceBundle resourceBundle, ResourceBundle secondaryResourceBundle) {
        this(resourceBundle);
        this.secondaryResourceBundle = secondaryResourceBundle;
    }

    public abstract void runConsoleUI(ConsoleNavigator navigator, Scanner scanner);


    public String getUICode() {
        return UICode;
    }

    public String getName() {
        return name;
    }

    public ResourceBundle getSecondaryResourceBundle() {
        return secondaryResourceBundle;
    }

    public ResourceBundle getResourceBundle() {
        return resourceBundle;
    }

    public String getNavigationPromptMessage() {
        if (secondaryResourceBundle != null) {
            return String.format(secondaryResourceBundle.getString("navigationOption"), this.UICode, this.name);
        }
        return String.format(resourceBundle.getString("navigationOption"), this.UICode, this.name);
    }

}
