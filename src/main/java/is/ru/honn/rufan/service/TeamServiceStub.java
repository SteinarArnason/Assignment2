package is.ru.honn.rufan.service;

import is.ru.honn.rufan.domain.Team;
import is.ru.honn.rufan.service.exception.ServiceException;

import java.util.List;

public class TeamServiceStub implements TeamService {
    public int addTeam(int leagueId, Team team) throws ServiceException {
        return 0;
    }

    public List<Team> getTeams(int leagueId) {
        return null;
    }
}
