import static org.junit.Assert.fail;

import org.junit.Assert;

import static org.junit.Assert.assertTrue;
import  org.junit.Test;
 

public class RadioTestSaraEmilio {
    @Test
    public void seEsperaQueEsteEncendidoElRadio() {
        //arrange
        final boolean esperoUnValorVerdadero = true; 
        IRadio miRadio = new RadioSARAEMILIO(); 
        //action
        miRadio.on();
        //assert
        Assert.assertEquals(esperoUnValorVerdadero, miRadio.isOn());
    }

    @Test
    public void seEsperaQueEsteApagadoElRadio() {
        //arrange
        final boolean esperoUnValorFalso = false; 
        IRadio miRadio = new RadioSARAEMILIO(); 
        //action
        miRadio.off();
        //assert
        Assert.assertEquals(esperoUnValorFalso, miRadio.isOn());
    }

    @Test
    public void seEsperaQueAvanceElDialSegunLaEstacionAM() {
        //arrange
        IRadio miRadio = new RadioSARAEMILIO(); 
        miRadio.on();
        try {
            miRadio.setFrequence("AM");
        } catch (Exception e) {
            e.printStackTrace();
        }
        final int esperoUnValorSiguiente = miRadio.getAMActualStation() + 10; 
        //action
        miRadio.Forward();
        int estacionActualAM = miRadio.getAMActualStation(); 
        //assert
        Assert.assertEquals(esperoUnValorSiguiente, estacionActualAM);
    }
}
