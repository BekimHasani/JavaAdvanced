package session9.services;

public abstract class Service {
    private long id;

    public Service(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Service: " + getClass().getSimpleName();
    }
}
