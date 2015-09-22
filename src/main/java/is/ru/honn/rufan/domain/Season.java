package is.ru.honn.rufan.domain;


import java.util.ArrayList;

public class Season
{
  private int season;
  private String name;
  private boolean isActive;
  private ArrayList<Team> teams = new ArrayList<Team>();

  /**
   * Gets season
   * @return season
   */
  public int getSeason()
  {
    return season;
  }

  /**
   * Sets season
   * @param season integer that represents a season
   */
  public void setSeason(int season)
  {
    this.season = season;
  }

  /**
   * Gets the name of a season
   * @return season name
   */
  public String getName()
  {
    return name;
  }

  /**
   * Sets the name of a season
   * @param name name of a season
   */
  public void setName(String name)
  {
    this.name = name;
  }

  /**
   * Checks if season is actvice
   * @return true if season is active, false otherwise
   */
  public boolean isActive()
  {
    return isActive;
  }

  /**
   * Set active status
   * @param isActive active if season is supposed to be active, false otherwise
   */
  public void setIsActive(boolean isActive)
  {
    this.isActive = isActive;
  }

  /**
   * Gets all teams in season
   * @return list of teams
   */
  public ArrayList<Team> getTeams()
  {
    return teams;
  }

  /**
   * Adds team to season
   * @param team team that you are going to add to a season
   */
  public void addTeam(Team team)
  {
    teams.add(team);
  }

}
