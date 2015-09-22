package is.ru.honn.rufan.domain;


public class Venue
{
  private int venueId;
  private String name;
  private String city;

  /**
   * Gets venue id
   * @return venue id
   */
  public int getVenueId()
  {
    return venueId;
  }

  /**
   * Sets venue id
   * @param venueId id of venue
   */
  public void setVenueId(int venueId)
  {
    this.venueId = venueId;
  }

  /**
   * Gets name of venue
   * @return venues name
   */
  public String getName()
  {
    return name;
  }

  /**
   * Sets name of venue
   * @param name name of venue
   */
  public void setName(String name)
  {
    this.name = name;
  }

  /**
   * Gets venue city
   * @return city of venue
   */
  public String getCity()
  {
    return city;
  }

  /**
   * Sets city of venue
   * @param city venues city
   */
  public void setCity(String city)
  {
    this.city = city;
  }
}
