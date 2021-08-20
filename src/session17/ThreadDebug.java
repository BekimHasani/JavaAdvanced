package session17;

public class ThreadDebug {
    public static void main(String[] args) {
        Runtime rt = Runtime.getRuntime();
        System.out.printf("CPU: %s, Total memory: %d, free memory: %d", rt.availableProcessors(), rt.totalMemory(), rt.freeMemory());
        try {
            Thread.sleep(1000 * 60 * 15);
        } catch(InterruptedException ie){}
    }
}

//jps -lm (Kthen "java process status" et)
//jstack <PID> (PID = Process ID) shfleton gjendjen e atij Java procesi
//jvisualvm eshte vegel me te cilen ju mundesohet ne menyre vizuele t'i shfletoni Java proceset

//Versioni 1.8 e me i larte kerkon qe ju vet ta beni set variablen TMP
//p.sh. SET TMP=C:/tmp