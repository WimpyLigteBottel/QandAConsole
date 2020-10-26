package com.wimpy.menu.service;

import java.time.LocalDateTime;
import java.util.List;

public class ServiceDetails {

  private final String name;
  private final LocalDateTime lastUpdated;
  private final List<String> peopleTesting;
  private final String comments;

  public ServiceDetails(
      String name, LocalDateTime lastUpdated, List<String> peopleTesting, String comments) {
    this.name = name;
    this.lastUpdated = lastUpdated.withNano(0);
    this.peopleTesting = peopleTesting;
    this.comments = comments;
  }

  public ServiceDetails() {
    this.name = "NOT SET";
    this.lastUpdated = LocalDateTime.now().withNano(0);
    this.peopleTesting = List.of();
    this.comments = "NOT SET";
  }

  public String getName() {
    return name;
  }

  public LocalDateTime getLastUpdated() {
    return lastUpdated;
  }

  public List<String> getPeopleTesting() {
    return peopleTesting;
  }

  public String getComments() {
    return comments;
  }
}
