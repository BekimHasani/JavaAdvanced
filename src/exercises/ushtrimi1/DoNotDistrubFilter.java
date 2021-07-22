package exercises.ushtrimi1;

public class DoNotDistrubFilter implements Filter{

    @Override
    public boolean isValid(Contact contact) {
        if(contact.isDisturbMode()){
            return false;
        }
        return true;
    }
}
