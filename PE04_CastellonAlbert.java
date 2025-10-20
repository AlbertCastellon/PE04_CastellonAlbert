import java.util.InputMismatchException;
import java.util.Scanner;

public class PE04_CastellonAlbert {
    boolean lighth1 = false, lighth2 = false, lighth3 = false, lightkitchen = false, lightlivroom = false;
    static Scanner escaner = new Scanner(System.in);
    static int mainMenu = 0;
    static int menuStrate = 0;
    public static void main(String[] args) {
        System.out.println("Què vols controlar?");
        System.out.println("1. Llums");
  
            System.out.println("Escull una opció");
            try {
                mainMenu = escaner.nextInt();
                menuStrate ++;
            }catch(InputMismatchException e) {
                System.out.println("Opció invàlida escull una altra vegada.");
            }
            if (mainMenu > 1 || mainMenu < 1){
                System.out.println("Aquesta opció no esta disponeble encara.");
            }
        
    }
}