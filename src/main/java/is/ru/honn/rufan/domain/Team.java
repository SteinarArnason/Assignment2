package is.ru.honn.rufan.domain;


public class Team
{
  private int teamId;
  private String location;
  private String abbreviation;
  private String displayName;
  protected Venue venue;

  public Team() {
  }

  public Team(int teamId, String abbreviation, String displayName) {
    this.teamId = teamId;
    this.abbreviation = abbreviation;
    this.displayName = displayName;
  }

  public int getTeamId()
  {
    return teamId;
  }

  public void setTeamId(int teamId)
  {
    this.teamId = teamId;
  }

  public String getLocation()
  {
    return location;
  }

  public void setLocation(String location)
  {
    this.location = location;
  }

  public String getAbbreviation()
  {
    return abbreviation;
  }

  public void setAbbreviation(String abbreviation)
  {
    this.abbreviation = abbreviation;
  }

  public String getDisplayName()
  {
    return displayName;
  }

  public void setDisplayName(String displayName)
  {
    this.displayName = displayName;
  }


  public Venue getVenue()
  {
    return venue;
  }

  public void setVenue(Venue venue)
  {
    this.venue = venue;
  }
}
