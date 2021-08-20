package exercises.ushtrimi3;

class DummyService {

    public static int getNum() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 1;
    }
}