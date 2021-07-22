package exercises.ushtrimi1;

public class Central{


    static class Vala implements Operator{
        @Override
        public String sendSMS(String message) {
            return "Vala: "+ message;
        }
    }

    static class Ipko implements Operator{
        @Override
        public String sendSMS(String message) {
            return "IPKO: "+ message;
        }
    }
}
