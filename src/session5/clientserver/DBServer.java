package session5.clientserver;

import java.util.concurrent.ThreadLocalRandom;

public class DBServer implements AutoCloseable{
    public int getMultiple() throws DBException{
        int value = ThreadLocalRandom.current().nextInt(-50, 50);
        if(value < 0){
            throw new DBException(String.format("Negative value [%d]", value));
        }
        return value;
    }

    @Override
    public void close() throws DBException{
        if(ThreadLocalRandom.current().nextInt(-5, 5) < 0){
            throw new DBException("Exception while closing the DB");
        }
        System.out.println("DB CLOSED...");
    }
}
