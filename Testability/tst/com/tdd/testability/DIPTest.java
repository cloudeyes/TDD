/*
Dependency Inversion Principle: https://en.wikipedia.org/wiki/Dependency_inversion_principle

Definition:
	A. High-level modules should not depend on low-level modules. Both should depend on abstractions.
	B. Abstractions should not depend on details. Details should depend on abstractions.

Context: We have a Service class that makes a live service call. The Client class depends on the Service.
We also have an independent class Utils that has a collection of static utility methods.

Goal: Implement givenInvertedClient_whenGetId_thenNoRealServiceCallsOccurs
and givenUtils_whenGetId_thenNoRealServiceCallOccurs test cases.
*/
package com.tdd.testability;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.tdd.testability.DIP.ClientToBeFixed;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class DIPTest {
  @Test
  public void givenClient_whenGetId_thenIdIsPositive() throws Exception {

    // GIVEN
    ClientToBeFixed clientToBeFixed = new ClientToBeFixed();

    // WHEN
    int clientId = clientToBeFixed.getId();

    // THEN
    assertTrue(clientId > 0);
  }

  // Given: A Client class that accepts a Service dependency
  // When: We retrieve getId() from the Service dependency
  // Then: We should not make a call to a real service
  @Test
  public void givenInvertedClient_whenGetId_thenNoRealServiceCallsOccurs() throws Exception {
    // GIVEN
    final DIP.Service serviceDouble = Mockito.mock(DIP.ServiceImpl.class);
    DIP.Client client = new DIP.Client(serviceDouble);

    // WHEN
    client.getId();

    // THEN
    Mockito.verify(serviceDouble).getId();
  }

  // Given: Our static utility method, Utils.getId()
  // When: We call it to retrieve an arbitrary id
  // Then: We should not make a call to a real service
  @Test
  public void givenUtils_whenGetId_thenNoRealServiceCallOccurs() throws Exception {
    // GIVEN
    final DIP.Service serviceDouble = Mockito.mock(DIP.ServiceImpl.class);

    // WHEN
    DIP.Utils.getId(serviceDouble);

    // THEN
    Mockito.verify(serviceDouble).getId();
  }
}
