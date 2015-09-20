package is.ru.honn.rufan.reader;

import org.json.simple.JSONObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class AbstractReader {

    public AbstractReader() {
    }

    protected int getInt(JSONObject jParent, String name)
    {
        if(jParent == null)
            return 0;
        Long value = (Long)jParent.get(name);
        if(value == null)
            return 0;
        return value.intValue();
    }

    protected Date newDate(int year, int month, int date)
    {
        Calendar cal = new GregorianCalendar();
        cal.set(year, month, date);
        return cal.getTime();
    }

    protected Date convertDate(String strDate)
    {
        DateFormat format = new SimpleDateFormat("yyyy.MM.dd'T'HH:mm:ss", Locale.ENGLISH);
        Date date = null;

        try
        {
            date = format.parse(strDate);
        }
        catch (ParseException e)
        {
            System.out.println("FAIL");
        }
        return date;
    }
}
