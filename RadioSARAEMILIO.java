import java.security.cert.TrustAnchor;

public class RadioSARAEMILIO implements IRadio{

    private boolean estaEncendido;
    private String frecuencia = "AM"; 
    private double[] memoriasFM = new double [12]; 
    private int[] memoriasAM = new int [12]; 
    private int canalActualAM = 530; 
    private double canalActualFM = 87.9; 

    @Override
    public void on() {
        estaEncendido = true;
    }

    @Override
    public void off() {
        estaEncendido = false;
    }

    @Override
    public boolean isOn() {
        return estaEncendido;
    }

    @Override
    public void setFrequence(String freq) throws Exception {
        if(estaEncendido){
            if(freq=="FM" || freq=="AM"){
                frecuencia = freq; 
            }
            else{
                throw new Exception("Frecuencia invalida"); 
            }
        }
        else{
            throw new Exception("El radio esta apagado."); 

        }
    }

    @Override
    public String getFrequence() {
            return frecuencia;
    }

    @Override
    public void Forward() {
        if(estaEncendido){
            if(frecuencia == "AM"){
                if(canalActualAM == 1610){
                    canalActualAM = 530; 
                }
                else{
                    canalActualAM += 10; 
                }
                
            }
            else{
                if(canalActualFM== 107.9){
                    canalActualFM= 87.9; 
                }
                else{
                    canalActualFM += 0.2; 
                }
            }
        }
        else{
            System.out.println("El radio esta apagado"); 

        }
    }

    @Override
    public void Backward() {
        if(estaEncendido){
            if(frecuencia == "AM"){
                if(canalActualAM == 530){
                    canalActualAM = 1610; 
                }
                else{
                    canalActualAM -= 10; 
                }
                
            }
            else{
                if(canalActualFM== 87.9){
                    canalActualFM= 107.9; 
                }
                else{
                    canalActualFM -= 0.2; 
                }
            }
        }
        else{
            System.out.println("El radio esta apagado"); 

        }
    }

    @Override
    public double getFMActualStation() {
            return canalActualFM;
    }

    @Override
    public int getAMActualStation() {
            return canalActualAM;
    }

    @Override
    public void setFMActualStation(double actualStation) {
        if(estaEncendido){
            if(actualStation >= 87.9 && actualStation <= 107.9){
                canalActualFM = actualStation; 
            }
        }
        else{
            System.out.println("El radio esta apagado"); 

        }
        
    }

    @Override
    public void setAMActualStation(int actualStation) {
        if(estaEncendido){
            if(actualStation >= 530 && actualStation <= 1610){
                canalActualAM = actualStation;  
            }
        }
        else{
            System.out.println("El radio esta apagado"); 

        }
    }

    @Override
    public void saveFMStation(double actualStation, int slot) {
        if(estaEncendido){
            if(slot >0 && slot < 13){
                memoriasFM[slot - 1] = actualStation; 
            }
        }
        else{
            System.out.println("El radio esta apagado"); 

        }
    }

    @Override
    public void saveAMStation(int actualStation, int slot){
        if(estaEncendido){
            if(slot >0 && slot < 13){
                memoriasAM[slot - 1] = actualStation; 
            }
        }
        else{
            System.out.println("El radio esta apagado"); 

        }
    }

    @Override
    public double getFMSlot(int slot) {
        return memoriasFM[slot - 1]; 
    }

    @Override
    public int getAMSlot(int slot) {
        return memoriasAM[slot - 1]; 
    }
    
}
