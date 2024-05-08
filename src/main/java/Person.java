public abstract class Person {
  protected String firstName;
  protected String lastName;

  public Person (String fs, String ls) {
    firstName = fs;
    lastName = ls;
  }

  public String getName() {
    return firstName;
  }

  public String getLname() {
    return lastName;
  }

  public String toString() {
    return firstName + " " + lastName;
  }
}