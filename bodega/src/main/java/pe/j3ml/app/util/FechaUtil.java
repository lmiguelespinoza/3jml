package pe.j3ml.app.util;


import java.text.ParseException;
import java.util.Calendar;


public class FechaUtil {

	public static String getCurrentDateTime() throws ParseException {
		
		Calendar Calendario = Calendar.getInstance();
	    
	    String anio = Integer.toString(Calendario.get(Calendar.YEAR));
	    String mes = Integer.toString(Calendario.get(Calendar.MONTH) + 1);
	    String dia = Integer.toString(Calendario.get(Calendar.DATE));
	    String hora = Integer.toString(Calendario.get(Calendar.HOUR));
	    String minuto = Integer.toString(Calendario.get(Calendar.MINUTE));
	    String segundo = Integer.toString(Calendario.get(Calendar.SECOND));
	    
		
		String strFecha = anio + "-" + mes + "-" + dia + " " +  hora + ":" + minuto + ":" + segundo;
                System.out.println("Str Fecha: " + strFecha);

		return strFecha;
	}

        public static String getCurrentDate() throws ParseException {

            Calendar Calendario = Calendar.getInstance();

	    String anio = Integer.toString(Calendario.get(Calendar.YEAR));
	    String mes = Integer.toString(Calendario.get(Calendar.MONTH) + 1);
	    String dia = Integer.toString(Calendario.get(Calendar.DATE));

            String diaAdd = "";
            if (dia.length() < 2) diaAdd = "0";
            String mesAdd = "";
            if (mes.length() < 2) mesAdd = "0";

            String strFecha = diaAdd + dia + "/" + mesAdd + mes + "/" + anio;
            System.out.println("Str Fecha: " + strFecha);

	    return strFecha;
	}
}
