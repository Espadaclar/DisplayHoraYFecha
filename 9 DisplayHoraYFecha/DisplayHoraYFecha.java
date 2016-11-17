public class DisplayHoraYFecha
{
    private NumberDisplay horas;
    private NumberDisplay minutos;
    private DisplayDosDigitos dia;
    private DisplayDosDigitos mes;
    private DisplayDosDigitos anyo;
    //////////////
    private boolean horaYFecha; //true devuelve hora y fecha;  false no devuelve nada.
    private boolean mostraHora;   //true muestra la hora, false no muestra nada.

    public DisplayHoraYFecha(boolean mostraHora2, boolean horaYFecha2)
    {
        horas = new NumberDisplay(24);
        minutos = new NumberDisplay(60);
        dia = new DisplayDosDigitos(31);
        mes = new DisplayDosDigitos(13);
        anyo = new DisplayDosDigitos(100); 
        horaYFecha = horaYFecha2;//true devuelve hora y fecha;  false no devuelve nada.
        mostraHora = mostraHora2;    //true devuelve solo la hora, false devuelve solo la fecha.
    }
    
    /**
     * constructor sin parámetros
     */
    public DisplayHoraYFecha()
    {
        horas = new NumberDisplay(24);
        minutos = new NumberDisplay(60);
        dia = new DisplayDosDigitos(31);
        mes = new DisplayDosDigitos(13);
        anyo = new DisplayDosDigitos(100); 
    }

    /**
     * Modifiques el código de tal forma que cuando creemos un objeto de la clase DisplayHoraYFecha podamos elegir por medio de dos parametros 
     * booleanos si ese objeto va a devolver la hora y la fecha, solo la hora, solo la fecha o nada cuando invoquemos el método que devuelve 
     * una cadena con la hora y la fecha.
     */

    public void avanzarMomento()
    {
        minutos.increment();
        if(minutos.getValue() == 0){
            horas.increment();
            if(horas.getValue() == 0){
                dia.incrementaValor();
                if(dia.getValor() == 1){
                    mes.incrementaValor();
                    if(mes.getValor() == 1) {
                        anyo.incrementaValor();
                    }                   
                }
            }
        }   
    }

    /**
     * si mostrarHora == true muestra hora si no no hace nada.
     * si horaYFecha == true muestra hora y fecha, si falso muestra solo la hora
     */
    public String getMomento()
    {
        String fechaHora = horas.getDisplayValue() + ":" + minutos.getDisplayValue() + " " +
                     dia.getValorDelDisplay() + "/" + mes.getValorDelDisplay() + "/" +
                    anyo.getValorDelDisplay();
  
        if(mostraHora == true){
            if(horaYFecha == true){
                fechaHora = horas.getDisplayValue() + ":" + minutos.getDisplayValue() + " " +
                dia.getValorDelDisplay() + "/" + mes.getValorDelDisplay() + "/" +
                anyo.getValorDelDisplay();
            }
            else{
                fechaHora = fechaHora = horas.getDisplayValue() + ":" + minutos.getDisplayValue();
            }
        }
        return fechaHora;
        //      return horas.getDisplayValue() + ":" + minutos.getDisplayValue() + " " +
        //             dia.getValorDelDisplay() + "/" + mes.getValorDelDisplay() + "/" +
        //             anyo.getValorDelDisplay();
    }

    public void setMomento(int nuevaHora, int nuevoMinuto, 
    int nuevoDia, int nuevoMes, int nuevoAnyo)
    {
        if (nuevaHora >= 0 && nuevaHora < 24 && 
        nuevoMinuto >= 0 && nuevoMinuto < 60 && 
        nuevoDia > 0 && nuevoDia < 31 &&
        nuevoMes > 0 && nuevoMes < 13 && 
        nuevoAnyo >= 0 && nuevoAnyo < 100) 
        {
            minutos.setValue(nuevoMinuto);
            horas.setValue(nuevaHora);
            dia.setValor(nuevoDia);
            mes.setValor(nuevoMes);
            anyo.setValor(nuevoAnyo);

        }   

    }

    public void setMomentoVersion2(int nuevaHora, int nuevoMinuto, 
    int nuevoDia, int nuevoMes, int nuevoAnyo)
    {
        boolean seDebeCambiarElMomentoTemporal = true;

        if (nuevaHora < 0 || nuevaHora > 23) {
            seDebeCambiarElMomentoTemporal = false;
        }
        if (nuevoMinuto < 0 || nuevoMinuto > 59) {
            seDebeCambiarElMomentoTemporal = false;
        }
        if (nuevoDia < 1 || nuevoDia > 30) {
            seDebeCambiarElMomentoTemporal = false;
        }
        if (nuevoMes < 1 || nuevoMes > 12) {
            seDebeCambiarElMomentoTemporal = false;
        }
        if (nuevoAnyo < 1 || nuevoAnyo > 99) {
            seDebeCambiarElMomentoTemporal = false;
        }
        if (seDebeCambiarElMomentoTemporal == true){
            minutos.setValue(nuevoMinuto);
            horas.setValue(nuevaHora);
            dia.setValor(nuevoDia);
            mes.setValor(nuevoMes);
            anyo.setValor(nuevoAnyo);
        }
    }

}