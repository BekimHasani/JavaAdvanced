package session4;

public interface Printable {
     int COUNT = 100;
     void print();

     default void print3D(int copy){
          System.out.printf("Printing in 3D, copies %d%n", copy);
     }
}
