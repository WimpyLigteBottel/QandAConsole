package com.wimpy.menu.environment;

import com.wimpy.menu.Menu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EnvironmentMenu extends Menu {

  public final Enviroment enviroment;

  public EnvironmentMenu(Enviroment enviroment) {
    this.enviroment = enviroment;
  }

  @Override
  public String getMenu() {
    String awaitInput = "";
    do {
      System.out.println(enviroment.toString());
      System.out.println("+++++++++++++++++++++++");
      System.out.println("Choose the service you would like to know about");

      getValidOptions().forEach((key, value) -> System.out.println(value));

      awaitInput = new Scanner(System.in).next();
    } while (!Menu.validateInput(awaitInput, getValidOptions().keySet()));

    return awaitInput;
  }

  @Override
  public Map<String, String> getValidOptions() {
    var map = new HashMap<String, String>();

    int counter = 1;
    map.put(String.valueOf(counter++), "1. Mbank");
    map.put(String.valueOf(counter++), "2. Ibank");
    map.put(String.valueOf(counter++), "3. Random service");
    map.put(String.valueOf(99), "99. exit");

    return map;
  }
}
