package exercises.ushtrimi1;

public class Contact {

    private String number;
    private boolean disturbMode;

    public Contact(String number, boolean disturbMode){
        this.number = number;
        this.disturbMode = disturbMode;
    }

    public boolean isDisturbMode() {
        return disturbMode;
    }

    public String getNumber() {
        return number;
    }
}
