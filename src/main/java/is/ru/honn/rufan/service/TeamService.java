package is.ru.honn.rufan.service;

import is.ru.honn.rufan.domain.Team;
import is.ru.honn.rufan.service.exception.ServiceException;

import java.util.List;

public interface TeamService
{
    int addTeam(int leagueId, Team team) throws ServiceException;
    List<Team> getTeams(int leagueId);
}

