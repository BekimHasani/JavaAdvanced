package session5.clientserver;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
    Logger logger = Logger.getLogger(Server.class.getName());

//    public String processRequest(int value) throws DBException{
//        DBServer db = new DBServer();
//        try {
//            int multiple = db.getMultiple();
//            System.out.println("multiple = " + multiple);
//            return String.format("%d * %d = %d", value, multiple, value * multiple);
//        } catch (DBException dbe){
//            logger.log(Level.SEVERE, "SERVER: "+dbe.getMessage());
//            throw dbe;
//        } finally {
////            if(Objects.nonNull(db)) {
//                db.close();
////            }
//        }
//    }

//    public String processRequest(int value) throws DBException{
//        DBServer db = new DBServer();
//        int multiple = db.getMultiple();
//        return String.format("%d * %d = %d", value, multiple, value * multiple);
//    }

    public String processRequest(int value) throws DBException{
        try (DBServer db = new DBServer()){
            int multiple = db.getMultiple();
            System.out.println("multiple = " + multiple);
            return String.format("%d * %d = %d", value, multiple, value * multiple);
        } catch (DBException dbe){
            logger.log(Level.SEVERE, "SERVER: "+dbe.getMessage());
            throw dbe;
        }
    }
}
