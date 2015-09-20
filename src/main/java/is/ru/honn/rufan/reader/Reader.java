package is.ru.honn.rufan.reader;

public interface Reader
{
    Object read();
    Object parse(String content);
    void setURI(String URI);
    void setReadHandler(ReadHandler readHandler);
}
