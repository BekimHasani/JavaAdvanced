package exercises.ushtrimi2.entity;

public class Contact {

    private String contactId;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public Contact(String contactId, String firstName, String lastName, String phoneNumber) {
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return contactId;
    }

    public void setReferenceId(String id) {
        this.contactId = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    @Override
    public String toString() {
        return "(Contact) "+firstName + " " + lastName;
    }
}
