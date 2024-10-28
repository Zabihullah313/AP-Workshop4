public class Person {

    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        firstName = firstName;
    }
    public void setLastName(String lastName) {
        lastName = lastName;
    }

    public String toString() {
        return firstName + " " + lastName;
    }

}
