package is.ru.honn.rufan.reader;


import is.ru.honn.rufan.reader.Reader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ReaderFactory {
    public ReaderFactory() {

    }
    public Reader getReader(String s)
    {
        ApplicationContext ctx = new FileSystemXmlApplicationContext("classpath:reader.xml");
        Reader r = (Reader) ctx.getBean(s);
        return r;
    }
}
