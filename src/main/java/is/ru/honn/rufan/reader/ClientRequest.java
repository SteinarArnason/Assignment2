package is.ru.honn.rufan.reader;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * A request from the client
 */
public class ClientRequest
{
  public ClientRequest()
  {
  }

  /**
   * Gets a URL requested by the client
   * @param url A link to a website
   * @return a string from the website
   */
  public String getRequest(String url)
  {
    Client client = ClientBuilder.newClient();
    Response response = client.target(url).request().get();

    String result = response.readEntity(String.class);
    client.close();

    return result;
  }

  public String getFileContent(String fileName) throws ReaderException
  {
    StringBuilder content = new StringBuilder();
    try
    {
      java.io.FileReader fileReader = new FileReader(fileName);
      BufferedReader bufferedReader = new BufferedReader(fileReader);

      String line;
      while((line = bufferedReader.readLine()) != null)
      {
        content.append(line);
      }
      bufferedReader.close();
    }
    catch(FileNotFoundException ex)
    {
      String msg = "Unable to open file '" + fileName + "'";
      throw new ReaderException(msg, ex);
    }
    catch(IOException ex)
    {
      String msg = "Error reading file '" + fileName + "'";
      throw new ReaderException(msg, ex);
    }
    return content.toString();
  }

}
