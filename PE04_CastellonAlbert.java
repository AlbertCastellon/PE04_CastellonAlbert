import java.util.InputMismatchException;
import java.util.Scanner;

public class PE04_CastellonAlbert {
    static boolean lightH1 = false, lightH2 = false, lightH3 = false, lightkitchen = false, lightLivRoom = false;
    static Scanner escaner = new Scanner(System.in);
    static int mainMenu = 0, menuLights = 0, menuRooms = 0;
    static String onOff = "";
    public static void main(String[] args) {
        do {
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
            do {
            System.out.println("LLums: Què vols fer");
            System.out.println("1. Controlar els llums d'una habitació");
            System.out.println("2. Controlar tots els llums");
            System.out.println("3. Mostra l'estat dels llums");
            System.out.println("4. Sortir");
            menuLights = escaner.nextInt();
        
            switch (menuLights) {
                case 1:
                do {
                    System.out.println("De quina habitació vols controlar les llums?");
                    System.out.println("1. Cuina");
                    System.out.println("2. Sala d'estar");
                    System.out.println("3. Habitació 1");
                    System.out.println("4. Habitació 2");
                    System.out.println("5. Habitació 3");
                    System.out.println("6. Sortir");
                    menuRooms = escaner.nextInt();
                    switch (menuRooms) {
                        case 1:
                            lightkitchen = roomLights();
                            break;
                        case 2:
                            lightLivRoom = roomLights();
                            break;
                        case 3:
                            lightH1 = roomLights();
                            break;
                        case 4:
                            lightH2 = roomLights();
                            break;
                        case 5:
                            lightH3 = roomLights();
                            break;
                        case 6:
                            menuRooms = 0;
                            break;
                        default:
                            break;
                    }
        

                } while(menuRooms != 0);
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
                    System.out.println("Habitcació 2 " + stateLights(lightH2));
                    System.out.println("Habitcació 3 " + stateLights(lightH3));
                    break;
                case 4:
                    menuLights = 0;
                    break;
                default:
                    break;
            }
        }while (menuLights != 0);
    } while(mainMenu != 0);
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
    public static boolean roomLights() {
        System.out.println("Vols apagar (off) o encendre (on) el llum?");
        onOff = escaner.next();
        boolean result = false;
        if(!onOff.equals("on") && !onOff.equals("off")) {
                System.out.println("Escull una opció vàlida.");
            }else if (onOff.equals("on")){
                System.out.println("El llum de l'habitació s'ha encès correctament");
                result = true;
            }else {
                System.out.println("El llum de l'habitació s'ha apagat correctament");
                result = false;
            }
        return result;
    }
    public static String stateLights(boolean room) {
        if(room) {
            return "on";
        }else {
            return "off";
        }
    }
}