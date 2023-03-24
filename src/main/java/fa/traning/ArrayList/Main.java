package fa.traning.ArrayList;

public class Main {
    public static void main( String args[] ) {
        Double DoubleValue = 322.6987;
        Integer IntValue = (int) Math.round(DoubleValue);
        Integer d = Math.toIntExact(Math.round(IntValue));
        System.out.println(DoubleValue + " is now " + d);
    }
}