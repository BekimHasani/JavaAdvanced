package session3.nested;

public class Out {
    private int value = 0;

    class In {
        private int value = 100;
        public void print(){
            System.out.printf("OUT VALUE: %d, IN VALUE: %d%n", ++Out.this.value, ++value);
        }
    }
}
