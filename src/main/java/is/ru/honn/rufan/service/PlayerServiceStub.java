package is.ru.honn.rufan.service;

import is.ru.honn.rufan.domain.Player;
import is.ru.honn.rufan.domain.Position;
import is.ru.honn.rufan.observer.PlayerObserver;
import is.ru.honn.rufan.observer.Subject;
import is.ru.honn.rufan.service.exception.ServiceException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class PlayerServiceStub implements PlayerService {
    Logger log = Logger.getLogger(PlayerServiceStub.class.getName());
    private List<Player> myList;
    private Subject subject;
    public PlayerServiceStub() {
        super();
        subject = new Subject();
        new PlayerObserver(subject);
        myList = new ArrayList<Player>();
    }

    public Player getPlayer(int playerId) {
        for(Player m : myList)
        {
            if(m.getPlayerId() == playerId)
            {
                return m;
            }
        }
        return null;
    }

    public List<Player> getPlayers(int teamId) {
        List<Player> team = new ArrayList<Player>();
        for(Player m : myList) {
            if(m.getTeamId() == teamId) {
                team.add(m);
            }
        }
        return team;
    }

    // We're assuming that the abbreviation here is for the players' position
    public List<Player> getPlayersByAbbreviation(String abbreviation) {
        List<Player> p = new ArrayList<Player>();
        for(Player m : myList) {
            List<Position> abb = m.getPositions();
            for(Position pos : abb) {
                if(pos.getAbbreviation().equals(abbreviation)) {
                    p.add(m);
                    break;
                }
            }

        }
        return p;
    }

    public List<Player> getPlayersByTeam(String s, TeamService ts)
    {
        List<Player> p = new ArrayList<Player>();
        int teamID = ts.getTeamIdByAbbriveation(s);
        for(int i = 0; i < myList.size(); i++)
        {
            if(myList.get(i).getTeamId() == teamID)
            {
                p.add(myList.get(i));
            }
        }
        return p;
    }

    public int addPlayer(Player player) throws ServiceException {

        if(myList.contains(player)) {
            String msg = "Player '" + player.getPlayerId() + "' already exists";
            log.info(msg);
            throw new ServiceException(msg);
        }
        myList.add(player);


        subject.setState(player);
        // Not sure if we should return player id
        return player.getPlayerId();
    }
}
