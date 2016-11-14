
/**
 * Write a description of class DisplayHoraYFecha here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DisplayHoraYFecha
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private NumberDisplay dia;
    private NumberDisplay mes;
    private NumberDisplay anno;
    private String displayString;    // simulates the actual display

    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 00:00.
     */
    public DisplayHoraYFecha()
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        dia = new NumberDisplay(31);
        mes = new NumberDisplay(13);
        anno = new NumberDisplay(100);
        inicializaHora();
        updateDisplay();
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0) {  // it just rolled over!
            hours.increment();
        }
        updateDisplay();
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void inicializaHora()
    {
        hours.setValue(0);
        minutes.setValue(0);
        dia.setValue(1);
        mes.setValue(1);
        anno.setValue(01);
        updateDisplay();
    }

    /**
     * Return the current time of this display in the format HH:MM.
     */
    public String getTime()
    {
        return displayString;
    }

    /**
     * Update the internal string that represents the display.
     */
    private void updateDisplay()
    {
        displayString = hours.getDisplayValue() + ":" + 
        minutes.getDisplayValue() + ":" + dia.getDisplayValue() + ":" + mes.getDisplayValue() + ":" +
        anno.getDisplayValue() ;
    }  
    
    /**
     * avanzarMomento que permita avanzar un minuto el momento temporal. Hemos de tener en cuenta que los meses 
     * tienen todos 30 días.
     */
    public void avanzarMomento(){
         minutes.increment();
        if(minutes.getValue() == 0) {  // it just rolled over!
            hours.increment();
        }
        if(hours.getValue() == 0) {  // it just rolled over!
            dia.increment();
        }
        if(dia.getValue() == 0) {  // it just rolled over!
            mes.increment();
        }
        if(mes.getValue() == 0) {  // it just rolled over!
            anno.increment();
        }
        updateDisplay();
    }
    
    /**
     * setMomento que debe permitir fijar un momento temporal completo. En este caso sí hemos de comprobar que 
     * los parámetros tienen valores legales; en caso de que algún parámetro no tenga un valor legal, no se modifica 
     * nada del estado del objeto.
     */
    public void setMomento(int hour, int minute, int dia2, int mes2, int anno2){
        hours.setValue(hour);
        minutes.setValue(minute);
        if(dia2 > 1 && dia2 >= 30){
            dia.setValue(dia2);
        }
        if(mes2 > 1 && mes2 <= 12){
            mes.setValue(mes2);
        }
        if(anno2 >= 0 && anno2 < 100){
            anno.setValue(anno2);
        }
        
        updateDisplay();
    }
}



















