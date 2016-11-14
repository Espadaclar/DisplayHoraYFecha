
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
        dia = new NumberDisplay(30);
        mes = new NumberDisplay(12);
        anno = new NumberDisplay(99);
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
}

