package session4;

public abstract class Device {
    private String model;

    public Device(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

//    public abstract void print3D(int copy);
}
