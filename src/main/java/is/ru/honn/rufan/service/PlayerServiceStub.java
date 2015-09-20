package is.ru.honn.rufan.service;

import is.ru.honn.rufan.domain.Player;
import is.ru.honn.rufan.domain.Position;
import is.ru.honn.rufan.service.exception.ServiceException;

import java.util.ArrayList;
import java.util.List;

public class PlayerServiceStub implements PlayerService {
    private List<Player> myList;
    public PlayerServiceStub() {
        super();
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

    public int addPlayer(Player player) throws ServiceException {
        if(myList.contains(player))
        {
            throw new ServiceException();
        }
        myList.add(player);
        // Not sure if we should return player id
        return player.getPlayerId();
    }
}
