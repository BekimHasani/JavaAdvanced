package exercises.ushtrimi1;

public class EndsWithFilter implements Filter{
    @Override
    public boolean isValid(Contact contact) {
        if(contact.getNumber().endsWith("5")){
            return false;
        }
        return true;
    }
}
