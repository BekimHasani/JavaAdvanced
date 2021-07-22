package exercises.ushtrimi1;

import sun.awt.image.ImageWatched;

import java.time.LocalDateTime;

public class MarketingCenter {

    private static String message = "Black Friday 90% sale";
    private static Central.Vala vala = new Central.Vala();
    private static Central.Ipko ipko = new Central.Ipko();
    private static Filter endsWith = new EndsWithFilter();
    private static Filter disturbFilter = new DoNotDistrubFilter();
    private static Policy restrictedDays = new RestictedDaysPolicy();
    private static Policy businessHours = new BusinessHoursPolicy();

    public static void main(String[] args) {
        Contact[] contacts = {
                new Contact("045123123", true),
                new Contact("044123123", false),
                new Contact("049432432", false),
                new Contact("044321321", true),
                new Contact("045654654", true),
        };

        LocalDateTime dateTime = LocalDateTime.now();
        for (Contact contact:contacts) {
            System.out.println(sendMessage(contact,dateTime, message))  ;
        }

    }

    private static String sendMessage(Contact contact, LocalDateTime dateTime, String message) {
        if (!endsWith.isValid(contact)) {
            return "Number should not end with '5'!";
        } else if (!disturbFilter.isValid(contact)) {
            return "Contact is in 'do not disturb mode'";
        } else if (!restrictedDays.isPermitted(dateTime)) {
            return "Messages in "+dateTime.getDayOfWeek()+" are not allowed!";
        } else if (!businessHours.isPermitted(dateTime)) {
            return "Messages in "+dateTime.getHour()+" are not allowed!";
            //below conditions are not good practise
        }else if(contact.getNumber().startsWith("044") || contact.getNumber().startsWith("045")){
            return vala.sendSMS(message);
        }else if(contact.getNumber().startsWith("049")){
            return ipko.sendSMS(message);
        }
        return "Contact is not valid";
    }
}
