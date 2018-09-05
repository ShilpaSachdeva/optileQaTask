package commonLibs.utils;

import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {
	public static String getDate(){
		Date date = new Date();
		
		String timeStamp = String.valueOf(date.getTime());
		return timeStamp;
	}
	
	 public static String getRandomDate() {

	        GregorianCalendar gc = new GregorianCalendar();

	        int year = randBetween(1900, 1997);

	        gc.set(gc.YEAR, year);

	        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));

	        gc.set(gc.DAY_OF_YEAR, dayOfYear);

	        return gc.get(gc.DAY_OF_MONTH) +  "-" + (gc.get(gc.MONTH) + 1)  + "-" + gc.get(gc.YEAR) ;
	       

	    }

	    private static int randBetween(int start, int end) {
	        return start + (int)Math.round(Math.random() * (end - start));
	    }
}
