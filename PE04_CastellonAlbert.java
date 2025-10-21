import java.util.InputMismatchException;
import java.util.Scanner;

public class PE04_CastellonAlbert {
    static boolean lightH1 = false, lightH2 = false, lightH3 = false, lightkitchen = false, lightLivRoom = false;
    static Scanner escaner = new Scanner(System.in);
    static int mainMenu = 0, menuLights = 0, menuRooms = 0;
    static String onOff = "";
    public static void main(String[] args) {
        System.out.println("Què vols controlar?");
        System.out.println("1. Llums");
  
            System.out.println("Escull una opció");
            try {
                mainMenu = escaner.nextInt();
            }catch(InputMismatchException e) {
                System.out.println("Opció invàlida escull una altra vegada.");
            }
            if (mainMenu > 1 || mainMenu < 1){
                System.out.println("Aquesta opció no esta disponeble encara.");
            }
            System.out.println("LLums: Què vols fer");
            System.out.println("1. Controlar els llums d'una habitació");
            System.out.println("2. Controlar tots els llums");
            System.out.println("3. Mostra l'estat dels llums");
            System.out.println("4. Sortir");
            menuLights = escaner.nextInt();
            switch (menuLights) {
                case 1:
                    System.out.println("De quina habitació vols controlar les llums?");
                    System.out.println("1. Cuina");
                    System.out.println("2. Sala d'estar");
                    System.out.println("3. Habitació 1");
                    System.out.println("4. Habitació 2");
                    System.out.println("5. Habitació 3");
                    menuRooms = escaner.nextInt();
                    switch (menuRooms) {
                        case 1:
                            roomLights(lightkitchen);
                            break;
                        case 2:
                            roomLights(lightLivRoom);
                            break;
                        case 3:
                            roomLights(lightH1);
                            break;
                        case 4:
                            roomLights(lightH2);
                            break;
                        case 5:
                            roomLights(lightH3);
                            break;
                        default:
                            break;
                    }
        
                    break;
                case 2 :
                    System.out.println("Apagar (off) o encendre (on) tots els llums");
                    onOff = escaner.next();
                    if(!onOff.equals("on") && !onOff.equals("off")) {
                        System.out.println("Escull una opció vàlida.");
                    }else {
                        allLights(onOff);
                    }
                    break;
                case 3:
                    System.out.println("Llums:");
                    System.out.println("Sala d'estar " + stateLights(lightLivRoom));
                    System.out.println("Cuina " + stateLights(lightkitchen));
                    System.out.println("Habitcació 1 " + stateLights(lightH1));
                    System.out.println("Habitcació 2 " + stateLights(lightH1));
                    System.out.println("Habitcació 3 " + stateLights(lightH3));
                    break;
                default:
                    break;
            }
            
    }

    public static void allLights(String turn) {
        if (turn.equals("on")){
            lightH1 = true;
            lightH2 = true;
            lightH3 = true;
            lightkitchen = true;
            lightLivRoom = true;
            System.out.println("Les llums s'han encès correctament.");
        }else {
            lightH1 = false;
            lightH2 = false;
            lightH3 = false;
            lightkitchen = false;
            lightLivRoom = false;
            System.out.println("Les llums s'han apagat correctament.");
        }
    }
    public static void roomLights(boolean room) {
        System.out.println("Vols apagar (off) o encendre (on) el llum?");
        onOff = escaner.next();
        if(!onOff.equals("on") && !onOff.equals("off")) {
                System.out.println("Escull una opció vàlida.");
            }else if (onOff.equals("on")){
                room = true;
                System.out.println("El llum de l'habitació s'ha encès correctament");
            }else {
                room = false;
                System.out.println("El llum de l'habitació s'ha apagat correctament");
            }
    }
    public static String stateLights(boolean room) {
        if(room) {
            return "on";
        }else {
            return "off";
        }
    }
}