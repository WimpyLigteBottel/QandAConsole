package com.wimpy.menu.viewdetails;

import com.wimpy.menu.Menu;

import java.util.*;

public class ViewDetailsMenu extends Menu {

  @Override
  public String getMenu() {

    String awaitInput = "";
    do {
      System.out.println("View Details");
      System.out.println("+++++++++++++++++++++++");
      System.out.println("Choose the environment you would like to see");

      getValidOptions().forEach((key, value) -> System.out.println(value));

      awaitInput = new Scanner(System.in).next();
    } while (!Menu.validateInput(awaitInput, getValidOptions().keySet()));

    return awaitInput;
  }

  @Override
  public Map<String, String> getValidOptions() {
    var map = new HashMap<String, String>();

    int counter = 1;
    map.put(String.valueOf(counter++), "1. INT-DEV");
    map.put(String.valueOf(counter++), "2. INT-PRD");
    map.put(String.valueOf(counter++), "3. QA");

    return map;
  }
}
