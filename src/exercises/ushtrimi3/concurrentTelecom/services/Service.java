package exercises.ushtrimi3.concurrentTelecom.services;

public abstract class Service {

    private long id;
    private long subscriptionId;

    public Service(long id, long subscriptionId) {
        this.id = id;
        this.subscriptionId = subscriptionId;
    }

    public long getId() {
        return id;
    }

    public long getSubscriptionId() {
        return subscriptionId;
    }

    @Override
    public String toString() {
        return String.format("(Service)[%d] - %s", getId(), getClass().getSimpleName());
    }
}
