package is.ru.honn.rufan.domain;

public class League
{
  private int leagueId;
  private String name;
  private String abbreviation;
  private String displayName;
  protected Season season;

  /**
   * Get leagueId
   * @return League id
   */
  public int getLeagueId()
  {
    return leagueId;
  }

  /**
   * Sets leagueId
   * @param leagueId id of league
   */
  public void setLeagueId(int leagueId)
  {
    this.leagueId = leagueId;
  }

  /**
   * Gets the name of league
   * @return name of the league
   */
  public String getName()
  {
    return name;
  }

  /**
   * Sets the name of league
   * @param name name of league
   */
  public void setName(String name)
  {
    this.name = name;
  }

  /**
   * Gets abbreviation of league
   * @return League abbreviation
   */
  public String getAbbreviation()
  {
    return abbreviation;
  }

  /**
   * Sets league abbreviaiton
   * @param abbreviation abbreviation
   */
  public void setAbbreviation(String abbreviation)
  {
    this.abbreviation = abbreviation;
  }

  /**
   * Gets displayName
   * @return displayName of league
   */
  public String getDisplayName()
  {
    return displayName;
  }

  /**
   * Sets display name of league
   * @param displayName displayname of league
   */
  public void setDisplayName(String displayName)
  {
    this.displayName = displayName;
  }

  /**
   * Gets season
   * @return season of league
   */
  public Season getSeason()
  {
    return season;
  }

  /**
   * Sets season of league
   * @param season season of league
   */
  public void setSeason(Season season)
  {
    this.season = season;
  }
}
