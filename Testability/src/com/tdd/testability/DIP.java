package com.tdd.testability;

import java.util.concurrent.ThreadLocalRandom;

public class DIP {
  interface Service {
    int getId() throws Exception;
  }

  static class ServiceImpl implements Service {
    // Simulating a slow and non-deterministic service call.
    public int getId() throws Exception {
      int i = 0;
      while (i++ < 5) {
        Thread.sleep(500);
      }
      return ThreadLocalRandom.current().nextInt(0, 1000);
    }
  }

  static class ClientToBeFixed {
    Service _service;

    public ClientToBeFixed() {
      this._service = new ServiceImpl();
    }

    public int getId() throws Exception {
      return 100 + _service.getId();
    }
  }

  static class Client {
    Service _service;

    public Client(Service service) {
      this._service = service;
    }

    public int getId() throws Exception {
      return 100 + _service.getId();
    }
  }

  static class UtilsToFixed {
    public static int getId() throws Exception {
      Service service = new ServiceImpl();
      return 100 + service.getId();
    }
  }

  static class Utils {

    public static int getId(Service service) throws Exception {
      return 100 + service.getId();
    }
  }
}
