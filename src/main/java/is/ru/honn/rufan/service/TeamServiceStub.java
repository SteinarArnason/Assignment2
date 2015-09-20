package is.ru.honn.rufan.service;

import is.ru.honn.rufan.domain.Team;
import is.ru.honn.rufan.service.exception.ServiceException;

import java.util.*;

public class TeamServiceStub implements TeamService {
    private Map<Integer, List<Team>> myMap;
    public TeamServiceStub() {
        myMap = new HashMap<Integer, List<Team>>();
    }

    public int addTeam(int leagueId, Team team) throws ServiceException {
        if(!myMap.containsKey(leagueId)) {
            myMap.put(leagueId, new ArrayList<Team>());
        }
        if(myMap.get(leagueId).contains(team)) {
            throw new ServiceException();
        }
        else {
            myMap.get(leagueId).add(team);
        }
        return team.getTeamId();
    }

    public List<Team> getTeams(int leagueId) {
        return myMap.get(leagueId);
    }
}
