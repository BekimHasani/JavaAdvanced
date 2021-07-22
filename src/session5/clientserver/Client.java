package session5.clientserver;

import javax.swing.*;

public class Client {
    public static void main(String[] args) {
        try {
            int value = 10;
            Server server = new Server();
            //System.out.println(server.processRequest(value));
            JOptionPane.showMessageDialog(null, server.processRequest(value));
        } catch(DBException dbe){
            JOptionPane.showMessageDialog(null, dbe.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//            System.out.println("CLINET"+dbe.getMessage());
        }
    }
}
