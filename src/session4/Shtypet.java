package session4;

public interface Shtypet {
    int COUNT = 200;
    void print();
    int getCount();

    default void print3D(int copy){
        System.out.printf("Jemi duke shtypur ne 3D %d%n", copy);
    }
}
