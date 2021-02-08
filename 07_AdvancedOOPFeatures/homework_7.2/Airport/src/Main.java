import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        Calendar d1 = new GregorianCalendar();
        Date now = d1.getTime();

        Calendar d2 = new GregorianCalendar();
        d2.add(Calendar.HOUR, -2);
        Date lastTwoHours = d2.getTime();

        Airport pulkovo = Airport.getInstance();

        pulkovo.getTerminals().stream()
                .flatMap(terminal -> terminal.getFlights().stream())
                .filter(f -> (f.getDate().after(lastTwoHours) & f.getDate().before(now) & f.getType().equals (Flight.Type.ARRIVAL)))
                .forEach(f -> System.out.println(f.getAircraft().getModel() + "  /  " +  f.getDate()));
        System.out.println("\n" + now);
    }
    }

