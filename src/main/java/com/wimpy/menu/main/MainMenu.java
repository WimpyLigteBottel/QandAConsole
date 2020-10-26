package com.wimpy.menu.main;

import com.wimpy.menu.Menu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainMenu extends Menu {

  @Override
  public String getMenu() {

    String awaitInput = "";

    do {
      System.out.println("Welcome please choose");
      System.out.println("+++++++++++++++++++++++");

      getValidOptions().forEach((key, value) -> System.out.println(value));

      awaitInput = new Scanner(System.in).next();
    } while (!Menu.validateInput(awaitInput, getValidOptions().keySet()));

    return awaitInput;
  }

  @Override
  public Map<String, String> getValidOptions() {
    var map = new HashMap<String, String>();

    int counter = 1;
    map.put(String.valueOf(counter++), "1. View details");
    map.put(String.valueOf(counter++), "2. Update or create details");

    return map;
  }
}
