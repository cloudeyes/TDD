/*
Single Responsibility Principle: https://en.wikipedia.org/wiki/Single_responsibility_principle

Definition: A class should have only one reason to change.

Context: We have a Person class. It stores some data about a person and can print a person report row in HTML.

Goal: Implement givenPersonWithTwoNewFields_whenGetReportRow_thenOnlyTheClassWhichIsResponsibleOfFullNameChanges
 and givenNewReportLogicWithDivs_whenGetReportRow_thenOnlyTheClassWhichIsResponsibleOfGeneratingReportsChanges.
*/
package com.tdd.testability;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SRPTest {

  @Test
  public void givenPersonWithFirstAndLastName_whenGetFullName_thenOutputIsExpected() {
    // GIVEN
    SRP.Person person = new SRP.Person("Buster", "Posey");

    // WHEN
    String fullName = person.getFullName();
    System.out.print(person.getReportRow());
    // THEN
    assertEquals("Buster Posey", fullName);
  }

  // Given: A Person object
  // When: We add two new fields, middle name and title (Mr., Mrs., etc.)
  // Then: Only the class which is responsible for the full name changes without changing the logic
  // about generating reports.
  @Test
  public void
      givenPersonWithTwoNewFields_whenGetReportRow_thenOnlyTheClassWhichIsResponsibleOfFullNameChanges() {
    // GIVEN
    SRP.PersonV2 person = new SRP.PersonV2("Joseph", "Kim");

    // WHEN
    person.setMiddleName("Y.");
    person.setTitle("Mr.");

    // THEN
    String fullName = person.getFullName();
    assertEquals("Mr. Joseph Y. Kim", fullName);
  }

  // Given: A Person object with first name, last name, middle name, title (complete previous test
  // case first)
  // When: The HTML rows change from <tr>'s to <div>'s
  // Then: It changes without depending on details of how a fullName is calculated
  @Test
  public void
      givenNewReportLogicWithDivs_whenGetReportRow_thenOnlyTheClassWhichIsResponsibleOfGeneratingReportsChanges()
          throws NoSuchMethodException {
    // GIVEN, WHEN
    SRP.PersonV3 person = new SRP.PersonV3("Joseph", "Kim");

    // THEN
    assertEquals("<div>" + person.getFullName() + "</div>", person.getReportRow());
    // - check `getFullName` is not overidden(modified)
    assertEquals(
        SRP.PersonV2.class, SRP.PersonV3.class.getMethod("getFullName").getDeclaringClass());
  }
}
