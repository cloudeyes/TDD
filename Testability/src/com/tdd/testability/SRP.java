package com.tdd.testability;

public class SRP {
  public static class Person {
    String _firstName;
    String _lastName;

    Person(String firstName, String lastName) {
      this._firstName = firstName;
      this._lastName = lastName;
    }

    public String getFullName() {
      return this._firstName + " " + this._lastName;
    }

    public String getReportRow() {
      return String.format("<tr><td>%s</td></tr>", this._firstName + " " + this._lastName);
    }
  }

  /** `Person` ver. 2.0 */
  public static class PersonV2 extends Person {
    String _middleName = "";
    String _title = "";

    PersonV2(String firstName, String lastName) {
      super(firstName, lastName);
    }

    @Override
    public String getFullName() {
      return this._title + " " + this._firstName + " " + this._middleName + " " + this._lastName;
    }

    public void setMiddleName(String middleName) {
      this._middleName = middleName;
    }

    public void setTitle(String title) {
      this._title = title;
    }
  }

  /** `Person` ver. 3.0 */
  public static class PersonV3 extends PersonV2 {

    PersonV3(String firstName, String lastName) {
      super(firstName, lastName);
    }

    @Override
    public String getReportRow() {
      return String.format("<div>%s</div>", this.getFullName());
    }
  }
}
