package exercises.ushtrimi2.services;

public abstract class Service {

    private String id;
    private String subscriptionId;

    public Service(String subscriptionId, String id) {
        this.id = id;
        this.subscriptionId = subscriptionId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    @Override
    public String toString() {
        return "(Service) ["+id+"] - " + getClass().getSimpleName();
    }
}
