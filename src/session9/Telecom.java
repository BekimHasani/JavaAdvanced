package session9;

import session9.entity.Contact;
import session9.entity.Contract;
import session9.entity.Customer;
import session9.services.Cable;
import session9.services.SMS;
import session9.services.Service;
import session9.subscription.Fix;
import session9.subscription.Mobile;
import session9.subscription.Subscription;

import java.io.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Telecom {

    public static void main(String[] args) {

        Contact customerContact = new Contact();
        customerContact.setFirstName("John");
        customerContact.setLastName("Doe");
        customerContact.setPhoneNumber("044111222");
        Customer raiffeisenCustomer = new Customer(1000L);
        raiffeisenCustomer.setContact(customerContact);

        Contract raiffeisenContractHR = new Contract(2000L);
        Contact hrContact = new Contact();
        hrContact.setFirstName("Agron");
        hrContact.setLastName("Ferizi");
        hrContact.setPhoneNumber("044111333");
        raiffeisenContractHR.setContact(hrContact);

        Subscription subscription = new Mobile(3000L);
        Contact frContact = new Contact();
        frContact.setFirstName("Fidan");
        frContact.setLastName("Rexhepi");
        frContact.setPhoneNumber("044111444");
        subscription.setContact(frContact);

        Service sms = new SMS(4000L);
        subscription.addService(sms);

        Subscription subscription2 = new Fix(3001L);
        Contact alContact = new Contact();
        alContact.setFirstName("Arianit");
        alContact.setLastName("Lubishtani");
        alContact.setPhoneNumber("044111555");
        subscription2.setContact(alContact);
        Service cable = new Cable(4001L);
        subscription2.addService(cable);

        raiffeisenContractHR.add(subscription);
        raiffeisenContractHR.add(subscription2);

        raiffeisenCustomer.addContract(raiffeisenContractHR);

        System.out.println(raiffeisenCustomer);

    }

}
