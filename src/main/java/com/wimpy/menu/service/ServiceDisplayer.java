package com.wimpy.menu.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ServiceDisplayer {

  private ServiceDetails serviceDetails;

  public ServiceDisplayer(ServiceDetails serviceDetails) {
    this.serviceDetails = serviceDetails;
  }

  public void display() {
    System.out.println();
    System.out.printf("Service: %s", serviceDetails.getService().name());
    System.out.println();
    System.out.printf("Name: %s", serviceDetails.getReleaseName());
    System.out.println();
    System.out.printf(
        "Last updated: %s",
        DateTimeFormatter.ISO_DATE_TIME.format(serviceDetails.getLastUpdated()));
    System.out.println();
    System.out.println();
    System.out.println("People currently testing");
    serviceDetails.getPeopleTesting().forEach(System.out::println);
    System.out.println();
    System.out.println("Additional comments:");
    System.out.println(serviceDetails.getComments());
    System.out.println();
    System.out.println();
  }

  public ServiceDetails askDetails(Service service) {
    System.out.println("Release name? (REL2020-10-16)");
    String releaseName = new Scanner(System.in).next();

    System.out.println("Who is currently testing? (xxx,zzz separated names)");

    Scanner peopleInput = new Scanner(System.in);
    List<String> people = Arrays.stream(peopleInput.next().split(",")).collect(Collectors.toList());

    System.out.println("Any additionalInfo?");
    String comment = new Scanner(System.in).next();

    return new ServiceDetails(service, releaseName, LocalDateTime.now(), people, comment);
  }

  public ServiceDetails getServiceDetails() {
    return serviceDetails;
  }
}
