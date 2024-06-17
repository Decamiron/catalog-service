package com.polarbookshop.catalogservice;

import static org.assertj.core.api.Assertions.assertThat;

import com.polarbookshop.catalogservice.domain.Book;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class BookValidationTest {
  private static Validator validator;

  @BeforeAll
  static void setUp() {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    validator = factory.getValidator();
  }

  @Test
  public void testAllFieldsAreValid() {
    var book = Book.of("1234567890", "Book 1", "Author 1", 9.90);
    var result = validator.validate(book);
    assertThat(result).isEmpty();
  }

  @Test
  public void testNotAllFieldsAreValid() {
    var book = Book.of("12345678q90", "Book 1", "Author 1", 9.90);
    var result = validator.validate(book);
    assertThat(result).hasSize(1);
    assertThat(result.iterator().next().getMessage()).isEqualTo("The ISBN format must be valid.");
  }
}
