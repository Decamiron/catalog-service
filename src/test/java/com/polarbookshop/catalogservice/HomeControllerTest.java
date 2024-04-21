package com.polarbookshop.catalogservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HomeControllerTest {

  @Autowired private TestRestTemplate restTemplate;

  @Test
  public void testGetGreeting() {
    String response = restTemplate.getForObject("/", String.class);
    assertEquals("Welcome to the book catalog!", response);
  }
}
