package exercises.ushtrimi3.concurrentTelecom.builders;

import exercises.ushtrimi3.concurrentTelecom.subscription.Subscription;

import java.util.List;

public final class DataIO extends Data {

    private List<String> contactData;
    private List<String> contractData;
    private List<String> customerData;
    private List<String> subscriptionData;
    private List<String> serviceData;

    public DataIO(){
        init();
        contacts = BuilderFactory.createContacts(contactData);
        services = BuilderFactory.createServices(serviceData);
        subscriptions = BuilderFactory.createSubscription(subscriptionData);
        contracts = BuilderFactory.createContract(contractData);
        customers = BuilderFactory.createCustomers(customerData);
    }

    private void init() {
        contactData = readFile("\\contact.csv");
        contractData = readFile("\\contract.csv");
        customerData = readFile("\\customer.csv");
        subscriptionData = readFile("\\subscription.csv");
        serviceData = readFile("\\service.csv");
    }

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }
}
