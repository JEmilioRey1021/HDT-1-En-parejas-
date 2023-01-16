import java.util.ArrayList;
import java.util.concurrent.atomic.DoubleAccumulator;
import java.util.Scanner;
public class Main {
    public static void main(String args[]){ 

        IRadio miRadio = new RadioEmilio();
        Scanner scan = new Scanner(System.in); 
        boolean continuar = true; 
        while (continuar){
            System.out.println("1. Prende el Radio"); 
            System.out.println("2. Cambia de AM a FM a AM"); 
            System.out.println("3. Avanzar en el dial de las emisoras. "); 
            System.out.println("4. Permite guardar una emisora en uno de los 12 botones"); 
            System.out.println("5. Permite seleccionar la emisora puesta en un botón"); 
            System.out.println("6. Apagar el radio"); 
		    String opcionElegida = scan.nextLine();

            switch(opcionElegida){
                case "1": 
                miRadio.on();
                System.out.println(""); 
                System.out.println("La radio esta encendida."); 
                System.out.println(""); 
                break; 

                case "2": 
                cambiarFrecuencia(miRadio); 
                break; 

                case "3":
                radioForward(miRadio);
                break; 

                case "4":
                guardarEmisora(miRadio); 
                break; 

                case "5": 
                seleccionarEmisora(miRadio); 
                break; 

                case "6":
                miRadio.off();
                System.out.println(""); 
                System.out.println("La radio esta apagada."); 
                System.out.println(""); 
                break;
            }
}
}

public static void cambiarFrecuencia(IRadio miRadio){
    miRadio.getFrequence(); 
    String frecuenciaActual = miRadio.getFrequence();
    try{
        if(frecuenciaActual == "AM"){
            miRadio.setFrequence("FM");
        }
        else{
            miRadio.setFrequence("AM");
        }
    }
    catch(Exception e){
        System.out.println(e.getMessage());
    }
    System.out.println(""); 
    System.out.println("La frecuencia actual es " + miRadio.getFrequence()); 
    System.out.println(""); 

}

public static void radioForward(IRadio miRadio){
    String frecuenciaActual = miRadio.getFrequence(); 

    if(frecuenciaActual == "AM"){
        miRadio.Forward();
        System.out.println(""); 
        System.out.println("Ha avanzado a la estacion" + miRadio.getAMActualStation()); 
        System.out.println(""); 
    }
    else{
        miRadio.Forward();
        System.out.println(""); 
        System.out.println("Ha avanzado a la estacion" + miRadio.getFMActualStation()); 
        System.out.println(""); 
    }
}


public static void guardarEmisora(IRadio miRadio){ 
    Scanner scan = new Scanner(System.in); 
    System.out.println("Elija el numero de memoria entre 1 y 12 donde desea guardar la emisora actual."); 
    String numeroElegidoString = scan.nextLine();
    try{
        int slot = Integer.parseInt(numeroElegidoString); 
        if(slot < 1 || slot >12){
            throw new Exception("Valor ingresado no es valido."); 
        }
        else{
            String frecuenciaActual = miRadio.getFrequence(); 
            if(frecuenciaActual == "AM"){
                int estacionActualAM = miRadio.getAMActualStation();
                miRadio.saveAMStation(estacionActualAM, slot);
                System.out.println(""); 
                System.out.println("El dial actual de la emisora es " + miRadio.getAMActualStation() + " y se ha guardado en " + numeroElegidoString); 
                System.out.println(""); 
            }
            else{
                double estacionActualFM = miRadio.getFMActualStation(); 
                miRadio.saveFMStation(estacionActualFM, slot);
                System.out.println(""); 
                System.out.println("El dial actual de la emisora es " + miRadio.getFMActualStation()  + " y se ha guardado en " + numeroElegidoString); 
                System.out.println(""); 
            }
        }
    }
    catch(Exception e){
        System.out.println(e.getMessage());
    }
}

public static void seleccionarEmisora(IRadio miRadio){
    Scanner scan = new Scanner(System.in); 
    String frecuenciaActual = miRadio.getFrequence(); 
    System.out.println("Elija el numero de memoria entre 1 y 12 donde desea reproducir la emisora actual."); 
    String numeroElegidoString = scan.nextLine();
    try{
        int slot = Integer.parseInt(numeroElegidoString); 

        if(frecuenciaActual == "AM"){
            int emisoraGuardadaAM = miRadio.getAMSlot(slot); 
            System.out.println(""); 
            System.out.println("Reproduciendo "+ emisoraGuardadaAM + " en el slot " + slot); 
            System.out.println(""); 
        }
        else{
            double emisoraGuardadaFM = miRadio.getFMSlot(slot); 
            System.out.println(""); 
            System.out.println("Reproduciendo "+ emisoraGuardadaFM + " en el slot " + slot); 
            System.out.println(""); 
        }
    }
    catch(Exception e){
        System.out.println(e.getMessage());
    }
    
}
}
