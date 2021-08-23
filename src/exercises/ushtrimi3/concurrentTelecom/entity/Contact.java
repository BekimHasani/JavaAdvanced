package exercises.ushtrimi3.concurrentTelecom.entity;

public class Contact {

    private long referenceId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
//    private String email;
//    private String address;


    public Contact(long id, String firstName, String lastName, String phoneNumber) {
        this.referenceId = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public long getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(long id) {
        this.referenceId = id;
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

//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
