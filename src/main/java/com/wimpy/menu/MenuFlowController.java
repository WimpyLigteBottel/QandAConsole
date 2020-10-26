package com.wimpy.menu;

import com.wimpy.menu.environment.Enviroment;
import com.wimpy.menu.environment.EnvironmentMenu;
import com.wimpy.menu.main.MainMenu;
import com.wimpy.menu.service.Service;
import com.wimpy.menu.service.ServiceDetails;
import com.wimpy.menu.service.ServiceDisplayer;
import com.wimpy.menu.viewdetails.ViewDetailsMenu;

import java.util.HashMap;
import java.util.Map;

public class MenuFlowController {

  static Map<Enviroment, Map<Service, ServiceDetails>> map = new HashMap<>();

  public void start() {

    setup();

    while (true) {
      String menuOption = new MainMenu().getMenu();
      switch (menuOption) {
        case "1":
          viewDetails();
          break;
        case "2":
          updateCreateDetails();
          break;
        default:
          throw new RuntimeException("SHOULD NOT HAPPEN");
      }
    }
  }

  private void setup() {
    Map<Service, ServiceDetails> intdev = new HashMap<>();
    for (int i = 0; i < Service.values().length; i++) {
      intdev.put(Service.values()[i], new ServiceDetails());
    }
    map.put(Enviroment.INT_DEV, intdev);

    Map<Service, ServiceDetails> intprd = new HashMap<>();
    for (int i = 0; i < Service.values().length; i++) {
      intprd.put(Service.values()[i], new ServiceDetails());
    }
    map.put(Enviroment.INT_PRD, intprd);

    Map<Service, ServiceDetails> qa = new HashMap<>();
    for (int i = 0; i < Service.values().length; i++) {
      qa.put(Service.values()[i], new ServiceDetails());
    }
    map.put(Enviroment.QA, qa);
  }

  private void viewDetails() {
    switch (new ViewDetailsMenu().getMenu()) {
      case "1": // INT-DEV
        viewDetails_environment(Enviroment.INT_DEV);
        break;
      case "2": // INT-PRD
        viewDetails_environment(Enviroment.INT_PRD);
        break;
      case "3": // QA
        viewDetails_environment(Enviroment.QA);
        break;
      default:
        throw new RuntimeException("SHOULD NOT HAPPEN");
    }
  }

  private void viewDetails_environment(Enviroment enviroment) {
    Map<Service, ServiceDetails> serviceMap = map.get(enviroment);
    switch (new EnvironmentMenu(enviroment).getMenu()) {
      case "1": // MBANK
        new ServiceDisplayer(serviceMap.get(Service.MBANK)).display();
        break;
      case "2": // IBANK
        new ServiceDisplayer(serviceMap.get(Service.IBANK)).display();
        break;
      case "3": // UNKNOWN
        new ServiceDisplayer(serviceMap.get(Service.UNKNOWN)).display();
        break;
      case "99":
        System.out.println("EXIT PROGRAMING");
        break;
      default:
        throw new RuntimeException("SHOULD NOT HAPPEN");
    }
  }

  private void updateCreateDetails_environment(Enviroment enviroment) {
    Map<Service, ServiceDetails> serviceMap = map.getOrDefault(enviroment, new HashMap<>());

    Service name;
    switch (new EnvironmentMenu(enviroment).getMenu()) {
      case "1": // MBANK
        name = Service.MBANK;
        serviceMap.put(name, new ServiceDisplayer(serviceMap.get(name)).askDetails(name));
        break;
      case "2": // IBANK
        name = Service.IBANK;
        serviceMap.put(name, new ServiceDisplayer(serviceMap.get(name)).askDetails(name));
        break;
      case "3": // UNKNOWN
        name = Service.UNKNOWN;
        serviceMap.put(name, new ServiceDisplayer(serviceMap.get(name)).askDetails(name));
        break;
      case "99":
        System.out.println("EXIT PROGRAMING");
        break;
      default:
        throw new RuntimeException("SHOULD NOT HAPPEN");
    }
    map.put(enviroment, serviceMap);
  }

  private void updateCreateDetails() {
    switch (new ViewDetailsMenu().getMenu()) {
      case "1": // INT-DEV
        updateCreateDetails_environment(Enviroment.INT_DEV);
        break;
      case "2": // INT-PRD
        updateCreateDetails_environment(Enviroment.INT_PRD);
        break;
      case "3": // QA
        updateCreateDetails_environment(Enviroment.QA);
        break;
      default:
        throw new RuntimeException("SHOULD NOT HAPPEN");
    }
  }
}
