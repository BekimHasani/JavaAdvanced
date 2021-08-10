package exercises.ushtrimi2.subscription;


public abstract class Subscription {

    private String contractId;
    private String subscriptionId;

    public Subscription( String contactId, String subscriptionId) {
        this.contractId = contactId;
        this.subscriptionId = subscriptionId;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contactId) {
        this.contractId = contactId;
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    @Override
    public String toString() {
        return String.format("(Subscription) (%s):%s ", getClass().getSimpleName(), subscriptionId);
    }
}
