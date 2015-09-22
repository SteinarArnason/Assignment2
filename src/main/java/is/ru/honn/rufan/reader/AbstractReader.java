package is.ru.honn.rufan.reader;

import org.json.simple.JSONObject;

import javax.ws.rs.client.ClientBuilder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Abstract class for object readers (e.g. PlayerReader)
 */
public abstract class AbstractReader implements Reader {

    protected ReadHandler readHandler;
    protected String URI;

    public AbstractReader() {
    }

    /**
     * Gets the json object from a URI and parses it
     * @return json object
     */
    public Object read() { return parse(new ClientRequest().getRequest(URI)); }

    /**
     * Sets the URI
     * @param URI json content
     */
    public void setURI(String URI) {this.URI = URI;}

    /**
     * Sets the ReadHandler
     * @param readHandler read handler
     */
    public void setReadHandler(ReadHandler readHandler) {
        this.readHandler = readHandler;
    }

    /**
     * Gets an integer
     * @param jParent parent object
     * @param name name of parent object
     * @return 0 or object value
     */
    protected int getInt(JSONObject jParent, String name)
    {
        if(jParent == null)
            return 0;
        Long value = (Long)jParent.get(name);
        if(value == null)
            return 0;
        return value.intValue();
    }

    /**
     * Gets a new date
     * @param year example: 1993
     * @param month example: 04
     * @param date example: 24
     * @return A date put together by year, month date; example: 1993-04-24
     */
    protected Date newDate(int year, int month, int date)
    {
        Calendar cal = new GregorianCalendar();
        cal.set(year, month, date);
        return cal.getTime();
    }

    //

    /**
     * Converts date
     * @param strDate Format example 2015-08-21T16:19:30.6967613Z
     * @return A date with time
     */
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
