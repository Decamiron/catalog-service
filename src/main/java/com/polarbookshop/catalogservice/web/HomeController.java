package com.polarbookshop.catalogservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.polarbookshop.catalogservice.config.PolarProperties;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class HomeController {
  private final PolarProperties polarProperties;

  @GetMapping("/")
  public String getGreeting() {
    return polarProperties.getGreeting();
  }
}
