package is.ru.honn.rufan.service;

import is.ru.honn.rufan.domain.Player;
import is.ru.honn.rufan.domain.Position;
import is.ru.honn.rufan.observer.PlayerObserver;
import is.ru.honn.rufan.observer.Subject;
import is.ru.honn.rufan.service.exception.ServiceException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Stub for PlayerService
 */
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

    /**
     * Gets a specific player
     * @param playerId id of the player
     * @return player or null of player wasn't found
     */
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

    /**
     * Gets players from a team
     * @param teamId id of the team
     * @return List of players from the specific team
     */
    public List<Player> getPlayers(int teamId) {
        List<Player> team = new ArrayList<Player>();
        for(Player m : myList) {
            if(m.getTeamId() == teamId) {
                team.add(m);
            }
        }
        return team;
    }

    /**
     * Gets a list of players by team abbreviation
     * @param abbreviation the team abbreviation
     * @return list of players for that team
     */
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

    /**
     * Adds a player to our list
     * @param player the player information
     * @return size of the list
     * @throws ServiceException
     */
    public int addPlayer(Player player) throws ServiceException {

        if(myList.contains(player)) {
            String msg = "Player '" + player.getPlayerId() + "' already exists";
            log.info(msg);
            throw new ServiceException(msg);
        }
        myList.add(player);


        subject.setState(player);
        return myList.size()-1;
    }
}
