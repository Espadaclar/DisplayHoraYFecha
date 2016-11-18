public class DisplayHoraYFecha
{
    private NumberDisplay horas;
    private NumberDisplay minutos;
    private DisplayDosDigitos dia;
    private DisplayDosDigitos mes;
    private DisplayDosDigitos anyo;
    //////////////
    private boolean sinHora;   
    private boolean sinFecha;   

    /**
     * si sinHora == false && sinFecha == false --------------- aparece la hora y la fecha.
     * si sinHora2 = true && sinFecha = true   --------------- aparece "-------------".
     * si sinHoar2 = false && sinFecha = true  --------------- solo aparece la hora.
     * si sinHora2 = true && sinFecha = false ---------------  aparece la fecha.
     */
    public DisplayHoraYFecha(boolean sinHora2, boolean sinFecha2)
    {
        horas = new NumberDisplay(24);
        minutos = new NumberDisplay(60);
        dia = new DisplayDosDigitos(31);
        mes = new DisplayDosDigitos(13);
        anyo = new DisplayDosDigitos(100); 
        sinHora = sinHora2;    
        sinFecha = sinFecha2;       

       
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
     * si sinHora == false && sinFecha == false --------------- solo aparece la hora y la fecha.
     * si sinHoar2 = false && sinFecha = true   --------------- aparece la hora.
     * si soloHoar2 = false && soloFecha = true  --------------- solo aparece la fecha.
     * si soloHora2 = false && soloFecha = false --------------- aparece "-------------".
     */
    public String getMomento()
    {
        String fechaHora ="-----------------";
         
        if( sinHora == false && sinFecha == true){
            fechaHora = horas.getDisplayValue() + ":" + minutos.getDisplayValue();
        }
        if(sinHora == false && sinFecha == false){
            fechaHora = horas.getDisplayValue() + ":" + minutos.getDisplayValue() + " " +
                dia.getValorDelDisplay() + "/" + mes.getValorDelDisplay() + "/" +
                anyo.getValorDelDisplay();
            
        }
        if(sinHora == true && sinFecha == false){
            fechaHora = dia.getValorDelDisplay() + "/" + mes.getValorDelDisplay() + "/" +
                    anyo.getValorDelDisplay();
        }
        return fechaHora;
        //      return horas.getDisplayValue() + ":" + minutos.getDisplayValue() + " " +
        //             dia.getValorDelDisplay() + "/" + mes.getValorDelDisplay() + "/" +
        //             anyo.getValorDelDisplay();
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

    
      public void setMomento(int nuevaHora, int nuevoMinuto, int nuevoDia, int nuevoMes, int nuevoAnyo)
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