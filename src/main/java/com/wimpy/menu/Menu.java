package com.wimpy.menu;

import java.util.Map;
import java.util.Set;

public abstract class Menu {

  public abstract String getMenu();

  public abstract Map<String, String> getValidOptions();

  public static boolean validateInput(String input, Set<String> validAnswers) {

    if (validAnswers.contains(input)) {
      return true;
    }

    System.out.println("");
    System.out.println("WRONG INPUT TRY AGAIN!");
    System.out.println("");
    clearConsole();
    return false;
  };

  static void clearConsole() {
    System.out.println("");
    System.out.println("");
    System.out.println("");
    System.out.println("");
    System.out.println("");
  }
}
