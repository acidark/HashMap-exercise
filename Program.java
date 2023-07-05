
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // You can test the class here

        HashMap<Object,Object> nuevoMapa = new HashMap<>();
        nuevoMapa.add("america", "ny");
        nuevoMapa.add("italy", "rome");

        System.out.println(nuevoMapa.get("america"));
        System.out.println(nuevoMapa.getListBasedOnKey(nuevoMapa));
        System.out.println(nuevoMapa.getIndexOfKey(nuevoMapa.getListBasedOnKey(nuevoMapa), "america"));
        for(int i=0;i<33;i++){
            
        }


    }

}
