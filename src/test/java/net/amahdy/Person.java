package net.amahdy;

public class Person {
  String firstName;
  String lastName;

  public Person() {

  }

  public Person(String firstName, String lastName) {
    setFirstName(firstName);
    setLastName(lastName);
  }

  /**
   * @return the firstName
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * @return the lastName
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * @param firstName the firstName to set
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * @param lastName the lastName to set
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
}