import java.util.InputMismatchException;
import java.util.Scanner;

public class PE04_CastellonAlbert {
    boolean lightH1 = false, lightH2 = false, lightH3 = false, lightKitchen = false, lightLivRoom = false;
    boolean cameraH1 = false, cameraH2 = false, cameraH3 = false, cameraKitchen = false, cameraLivRoom = false;
    double blindH1 = 0, blindH2 = 0, blindH3 = 0, blindKitchen = 0, blindLivRoom = 0;
    Scanner escaner = new Scanner(System.in);
    int mainMenu = 0, menuLights = 0, menuRooms = 0, menuTemp = 0, menuCameras = 0;
    String onOff = "";
    public static void main(String[] args) {
        PE04_CastellonAlbert p = new PE04_CastellonAlbert();
        p.principal();
    }

    public void principal() {

        double temperature = 25;
        do {
        System.out.println("Què vols controlar?");
        System.out.println("1. Llums");
        System.out.println("2. Temperatura");
        System.out.println("3. Cameres");
        System.out.println("4. Persianes");
        System.out.println("6. Sortir");
  
            System.out.println("Escull una opció");
            try {
                mainMenu = escaner.nextInt();
            }catch(InputMismatchException e) {
                System.out.println("Opció invàlida escull una altra vegada.");
                mainMenu = 0;
            }
            if (mainMenu > 6 || mainMenu < 1){
                System.out.println("Aquesta opció no esta disponeble encara.");
                mainMenu = 0;
            }
            switch (mainMenu) {
                case 1:
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
                                        lightKitchen = roomLights();
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
                                    onOffAllDevices(onOff, mainMenu);
                                }
                                break;
                            case 3:
                                System.out.println("Llums:");
                                System.out.println("Sala d'estar " + stateDevices(lightLivRoom));
                                System.out.println("Cuina " + stateDevices(lightKitchen));
                                System.out.println("Habitcació 1 " + stateDevices(lightH1));
                                System.out.println("Habitcació 2 " + stateDevices(lightH2));
                                System.out.println("Habitcació 3 " + stateDevices(lightH3));
                                break;
                            case 4:
                                menuLights = 0;
                                break;
                            default:
                                break;
                        }
                    }while (menuLights != 0);
                    break;
                case 2: 
                    System.out.println("La temperatura està establerta a "+ temperature + "ºC");
                    do {
                        System.out.println("Com vols controlar de la temperatura?");
                        System.out.println("1. Incrementar");
                        System.out.println("2. Disminuir");
                        System.out.println("3. Establir temperatura");
                        System.out.println("4. Comprovar temperatura");
                        System.out.println("5. Sortir");
                        menuTemp = escaner.nextInt();
                        switch (menuTemp) {
                            case 1:
                                System.out.println("Quan vols incrementar la temperatura?");
                                temperature = temperature + changeTemperature();
                                System.out.println("La temperatura s'ha establit a "+ temperature + "ºC");
                                break;
                            case 2:
                                System.out.println("Quan vols disminuir la temperatura?");
                                temperature = temperature - changeTemperature();
                                System.out.println("La temperatura s'ha establit a "+ temperature + "ºC");
                                break;
                            case 3:
                                System.out.println("Quina temperatura vols?");
                                double newTemp = escaner.nextDouble();
                                temperature = newTemp;
                                System.out.println("La temperatura s'ha establit a "+ temperature + "ºC");
                                break;
                            case 4:
                                System.out.println("La temperatura està establerta a "+ temperature + "ºC");
                                break;
                            case 5:
                                menuTemp = 0;
                                break;
                        
                            default:
                                break;
                        }
                    }while (menuTemp != 0);
                    break;
                case 3:
                    do {
                        System.out.println("Què vols gestionar de les cameres?");
                        System.out.println("1. Escollir una camera");
                        System.out.println("2. Apagar o encendre totes les cameres");
                        System.out.println("3. Comprovar l'estat de les cameres");
                        System.out.println("4. Sortir");
                        menuCameras = escaner.nextInt();
                        switch (menuCameras) {
                            case 1:
                            do {
                                System.out.println("De quina habitació vols controlar la camera?");
                                System.out.println("1. Cuina");
                                System.out.println("2. Sala d'estar");
                                System.out.println("3. Habitació 1");
                                System.out.println("4. Habitació 2");
                                System.out.println("5. Habitació 3");
                                System.out.println("6. Sortir");
                                menuRooms = escaner.nextInt();
                                int action = 0;
                                switch (menuRooms) {
                                    case 1:
                                        action = roomCameras(cameraKitchen);
                                        if( action== 1 ){
                                            System.out.println("Reproduciendo video...");
                                        }else if (action == 2) {
                                            cameraKitchen = !cameraKitchen;
                                        }else {
                                            menuRooms = 0;
                                        }
                                        
                                        break;
                                    case 2:
                                        action = roomCameras(cameraLivRoom);
                                        if(action== 1 ){
                                            System.out.println("Reproduciendo video...");
                                        }else if (action == 2) {
                                            cameraLivRoom = !cameraLivRoom;
                                        }else {
                                            menuRooms = 0;
                                        }
                                        break;
                                    case 3:
                                        action = roomCameras(cameraH1);
                                        if(action== 1 ){
                                            System.out.println("Reproduciendo video...");
                                        }else if (action == 2) {
                                            cameraH1 = !cameraH1;
                                        }else {
                                            menuRooms = 0;
                                        }
                                        break;
                                    case 4:
                                        action = roomCameras(cameraH2);
                                        if(action== 1 ){
                                            System.out.println("Reproduciendo video...");
                                        }else if (action == 2) {
                                            cameraH2 = !cameraH2;
                                        }else {
                                            menuRooms = 0;
                                        }
                                        break;
                                    case 5:
                                        action = roomCameras(cameraH3);
                                        if(action== 1 ){
                                            System.out.println("Reproduciendo video...");
                                        }else if (action == 2) {
                                            cameraH3 = !cameraH3;
                                        }else {
                                            menuRooms = 0;
                                        }
                                        break;
                                    case 6:
                                        menuRooms = 0;
                                        break;
                                    default:
                                        break;
                                }
                                
                            }while(menuRooms != 0);
                            break;
                            case 2:
                                 System.out.println("Apagar (off) o encendre (on) totes les cameres");
                                onOff = escaner.next();
                                if(!onOff.equals("on") && !onOff.equals("off")) {
                                    System.out.println("Escull una opció vàlida.");
                                }else {
                                    onOffAllDevices(onOff, mainMenu);
                                }
                                break;
                            case 3:
                                System.out.println("Cameres:");
                                System.out.println("Sala d'estar " + stateDevices(cameraLivRoom));
                                System.out.println("Cuina " + stateDevices(cameraKitchen));
                                System.out.println("Habitcació 1 " + stateDevices(cameraH1));
                                System.out.println("Habitcació 2 " + stateDevices(cameraH2));
                                System.out.println("Habitcació 3 " + stateDevices(cameraH3));
                                break;
                            case 4:
                                menuCameras = 0;
                                break;
                        }
                    }while (menuCameras != 0);
                    break;
                case 4:
                    
                    break;
                case 6:
                    mainMenu = 0;
                    break;
            } 
            

        }while(mainMenu != 0);
    }

    public void onOffAllDevices(String turn, int menu) {
        if(menu == 1){
            if (turn.equals("on")){
                lightH1 = true;
                lightH2 = true;
                lightH3 = true;
                lightKitchen = true;
                lightLivRoom = true;
                System.out.println("Les llums s'han encès correctament.");
            }else {
                lightH1 = false;
                lightH2 = false;
                lightH3 = false;
                lightKitchen = false;
                lightLivRoom = false;
                System.out.println("Les llums s'han apagat correctament.");
            }
        }else {
            if (turn.equals("on")){
                cameraH1 = true;
                cameraH2 = true;
                cameraH3 = true;
                cameraKitchen = true;
                cameraLivRoom = true;
                System.out.println("Les cameres s'han encès correctament.");
            }else {
                cameraH1 = false;
                cameraH2 = false;
                cameraH3 = false;
                cameraKitchen = false;
                cameraLivRoom = false;
                System.out.println("Les cameres s'han apagat correctament.");
            }
        }
    }
    public boolean roomLights() {
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
    public int roomCameras(boolean room) {
        if(room) {
            System.out.println("La camera està encesa, vols apagar-la veure el video?");
            System.out.println("1. Veure video");
            System.out.println("2. Apagar la camera");
            return escaner.nextInt();
        }else {
            System.out.println("La camera està apagada vols encendre-la?(s/n)");
            String answer = escaner.next();
            if(answer.equals("s")){
                return 2;
            }else {
                return 0;
            }
            

        }
    }
    public double changeTemperature() {
        double tempChange = 0;
        tempChange = escaner.nextDouble();
        return tempChange;
        
    }
    public String stateDevices(boolean room) {
        if(room) {
            return "on";
        }else {
            return "off";
        }
    }
}