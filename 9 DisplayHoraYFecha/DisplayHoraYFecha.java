	public class DisplayHoraYFecha
{
	private NumberDisplay horas;
	private NumberDisplay minutos;
	private DisplayDosDigitos dia;
	private DisplayDosDigitos mes;
	private DisplayDosDigitos anyo;
	
	public DisplayHoraYFecha()
	{
		horas = new NumberDisplay(24);
		minutos = new NumberDisplay(60);
		dia = new DisplayDosDigitos(31);
		mes = new DisplayDosDigitos(13);
		anyo = new DisplayDosDigitos(100);
	}
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
	
	public String getMomento()
	{
		return horas.getDisplayValue() + ":" + minutos.getDisplayValue() + " " +
		       dia.getValorDelDisplay() + "/" + mes.getValorDelDisplay() + "/" +
		       anyo.getValorDelDisplay();
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