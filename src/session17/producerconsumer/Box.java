package session17.producerconsumer;

public interface Box {
    int MAX = 10000;

    void write(int value);

    int read();
}
