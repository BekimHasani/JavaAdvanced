package session4;

public class Printer extends Device implements Printable, Shtypet {

    public Printer(String model){
        super(model);
    }

    @Override
    public void print3D(int copy) {
        Printable.super.print3D(copy);
        Shtypet.super.print3D(copy);
    }

    public void print(){
        System.out.println("Printing from printer: "+Shtypet.COUNT);
    }

    @Override
    public int getCount() {
        return Printable.COUNT;
    }
}
