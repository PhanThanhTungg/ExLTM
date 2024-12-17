package fullws;
import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class test {

    public static void main(String[] args) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse("01-09-2023",formatter);
        DayOfWeek day = date.getDayOfWeek();
        
        System.out.println(date.plusDays(1).getDayOfWeek().toString());
        
        
    }
    
}
