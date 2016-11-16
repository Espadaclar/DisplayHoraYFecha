
/**
 * Write a description of class DisplayHoraYFecha here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DisplayHoraYFecha
{
    // instance variables - replace the example below with your own
    private NumberDisplay hora;
    private NumberDisplay minuto;
    private NumberDisplay dia;
    private NumberDisplay mes;
    private NumberDisplay anno;
    private String horaYFecha;

    /**
     * Constructor for objects of class DisplayHoraYFecha
     */
    public DisplayHoraYFecha()
    {
        
        hora = new  NumberDisplay(24);
        minuto = new  NumberDisplay(60);
        dia = new  NumberDisplay(31);
        mes = new  NumberDisplay(13);
        anno = new  NumberDisplay(100);
        dia1Mes1Anno1();
        iniciaHoraFecha();
    }

    /**
     * mt para asignar un valor inicial a dia, mes y año en el constructor.
     */
    private void dia1Mes1Anno1(){
        dia.setValue(1);
        mes.setValue(1);
        anno.setValue(1);
    }

    /**
     *mt para inicializar hora y fecha en el constructor 
     */
    private void iniciaHoraFecha()
    {
        horaYFecha =  hora.getDisplayValue()+ ":" +minuto.getDisplayValue()+ "  " +dia.getDisplayValue()+ "/" +
        mes.getDisplayValue()+ "/" +anno.getDisplayValue();
    }

    /**
     * mt que permite avanzar un minuto el momento temporal.
     */
    public void avanzarMomento(){
        minuto.increment();
        if(minuto.getValue() == 0){
            hora.increment();
            if(hora.getValue() == 0){
                dia.increment();
                if(dia.getValue() == 0){
                    mes.increment();
                    if(mes.getValue() == 0){
                        anno.increment();
                    }
                }
            }
        }
        dia1Mes1Anno1();   // paso este mt para que cuando llegue 0, dia, mes y anno tomen valor 1 en getMomento();
        iniciaHoraFecha();// paso el incremento al mét iniciaHoraFecha() 
    }

    /**
     * mt que permite fijar un momento temporal completo
     */
    public void setMomento(int hora2, int minuto2, int dia2, int mes2, int anno2){

        hora.setValue(hora2);
        minuto.setValue(minuto2);
        dia.setValue(dia2);
        mes.setValue(mes2);
        anno.setValue(anno2);
        iniciaHoraFecha(); // paso el valor que doy a los atributos al método iniciaHoraFecha()
    }
    
    /**
     * mt que cuando se invoca devuelve una cadena de caracteres de 14 caracteres
     */
    public String getMomento(){
        return horaYFecha;
    }
}