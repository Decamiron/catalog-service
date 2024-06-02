package com.polarbookshop.catalogservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.polarbookshop.catalogservice.config.PolarProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HomeControllerTest {
  @Autowired private TestRestTemplate restTemplate;
  @Autowired private PolarProperties polarProperties;

  @Test
  public void testGetGreeting() {
    String response = restTemplate.getForObject("/", String.class);
    assertEquals(polarProperties.getGreeting(), response);
  }
}
