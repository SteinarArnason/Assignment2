package is.ru.honn.rufan.domain;

public class Team
{
  private int teamId;
  private String location;
  private String abbreviation;
  private String displayName;
  protected Venue venue;

  /**
   * Empty constructor
   */
  public Team() {
  }

  /**
   * Constructor with all variables except venue
   * @param teamId id of team
   * @param abbreviation abbriveation of a team
   * @param displayName display name of a team
   */
  public Team(int teamId, String abbreviation, String displayName) {
    this.teamId = teamId;
    this.abbreviation = abbreviation;
    this.displayName = displayName;
  }

  /**
   * Gets team id
   * @return team id
   */
  public int getTeamId()
  {
    return teamId;
  }

  /**
   * Sets the team id
   * @param teamId
   */
  public void setTeamId(int teamId)
  {
    this.teamId = teamId;
  }

  /**
   * Gets the location of a team
   * @return teams location
   */
  public String getLocation()
  {
    return location;
  }

  /**
   * Sets team location
   * @param location location of team
   */
  public void setLocation(String location)
  {
    this.location = location;
  }

  /**
   * Gets team abbriveation
   * @return teams abbriveation
   */
  public String getAbbreviation()
  {
    return abbreviation;
  }

  /**
   * Sets abbreviation of a team
   * @param abbreviation abbriveation of a team
   */
  public void setAbbreviation(String abbreviation)
  {
    this.abbreviation = abbreviation;
  }

  /**
   * Gets diasplay name of team
   * @return teams displayname
   */
  public String getDisplayName()
  {
    return displayName;
  }

  /**
   * Sets displayname of team
   * @param displayName team displayname
   */
  public void setDisplayName(String displayName)
  {
    this.displayName = displayName;
  }

  /**
   * Gets venue of a team
   * @return teams venu
   */
  public Venue getVenue()
  {
    return venue;
  }

  /**
   * Sets venue of a team
   * @param venue teams venue
   */
  public void setVenue(Venue venue)
  {
    this.venue = venue;
  }
}
