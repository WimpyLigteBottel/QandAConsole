package com.wimpy.menu.service;

import java.time.LocalDateTime;
import java.util.List;

public class ServiceDetails {

  private final Service service;
  private final String releaseName;
  private final LocalDateTime lastUpdated;
  private final List<String> peopleTesting;
  private final String comments;

  public ServiceDetails(
      Service service,
      String releaseName,
      LocalDateTime lastUpdated,
      List<String> peopleTesting,
      String comments) {
    this.service = service;
    this.releaseName = releaseName;
    this.lastUpdated = lastUpdated.withNano(0);
    this.peopleTesting = peopleTesting;
    this.comments = comments;
  }

  public ServiceDetails() {
    this.service = Service.UNKNOWN;
    this.lastUpdated = LocalDateTime.now().withNano(0);
    this.peopleTesting = List.of();
    this.comments = "NOT SET";
    this.releaseName = "NOT SET";
  }

  public Service getService() {
    return service;
  }

  public String getReleaseName() {
    return releaseName;
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
