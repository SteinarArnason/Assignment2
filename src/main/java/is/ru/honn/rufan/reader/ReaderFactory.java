package is.ru.honn.rufan.reader;


import is.ru.honn.rufan.reader.Reader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * A factory for Reader
 */
public class ReaderFactory {
    public ReaderFactory() {

    }

    /**
     * Gets the reader from xml
     * @param s specified reader
     * @return specific Reader
     */
    public Reader getReader(String s)
    {
        ApplicationContext ctx = new FileSystemXmlApplicationContext("classpath:reader.xml");
        Reader r = (Reader) ctx.getBean(s);
        return r;
    }
}
