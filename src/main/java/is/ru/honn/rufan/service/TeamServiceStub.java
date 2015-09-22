package is.ru.honn.rufan.service;

import is.ru.honn.rufan.domain.Team;
import is.ru.honn.rufan.service.exception.ServiceException;

import java.util.*;
import java.util.logging.Logger;

public class TeamServiceStub implements TeamService {
    Logger log = Logger.getLogger(TeamServiceStub.class.getName());
    private Map<Integer, List<Team>> myMap;
    public TeamServiceStub() {
        myMap = new HashMap<Integer, List<Team>>();
    }

    public int addTeam(int leagueId, Team team) throws ServiceException {
        if(leagueId < 0) {
            String msg = "LeagueID '" + leagueId + "' is an illegal id";
            log.info(msg);
            throw new ServiceException(msg);
        }
        if(team.getAbbreviation().equals(""))
        {
            throw new ServiceException("Missing team abbreviation");
        }
        if(!myMap.containsKey(leagueId)) {
            myMap.put(leagueId, new ArrayList<Team>());
        }
        if(myMap.get(leagueId).contains(team)) {
            String msg = "Team '" + team.getTeamId() + "' already in league '" + leagueId + "'";
            log.info(msg);
            throw new ServiceException(msg);
        }
        else {
            myMap.get(leagueId).add(team);
        }
        return team.getTeamId();
    }

    public List<Team> getTeams(int leagueId) throws ServiceException{
        if(!myMap.containsKey(leagueId)) {
            String msg = "League '" + leagueId + "' does not exist so no team could be retrieved";
            log.info(msg);
            throw new ServiceException(msg);
        }
        return myMap.get(leagueId);
    }
}
