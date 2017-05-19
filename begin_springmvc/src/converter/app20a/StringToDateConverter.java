package converter.app20a;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lambor on 17-5-19.
 */
public class StringToDateConverter implements Converter<String,Date> {

    private String datePattern;

    public StringToDateConverter(String datePattern) {
        this.datePattern = datePattern;
        System.out.println("instantiating ... converter with pattern:*" + datePattern);
    }

    @Override
    public Date convert(String s) {
        DateFormat dateFormat = new SimpleDateFormat(datePattern);
        dateFormat.setLenient(false);
        try {
            return dateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("invalid date format. Please use this pattern\""+datePattern+"\"");
        }
    }
}
