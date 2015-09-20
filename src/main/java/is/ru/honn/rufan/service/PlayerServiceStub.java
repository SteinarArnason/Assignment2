package is.ru.honn.rufan.service;

import is.ru.honn.rufan.domain.Player;
import is.ru.honn.rufan.service.exception.ServiceException;

import java.util.List;

public class PlayerServiceStub implements PlayerService {
    public PlayerServiceStub() {
        super();
    }

    public Player getPlayer(int playerId) {
        return null;
    }

    public List<Player> getPlayers(int teamId) {
        return null;
    }

    public List<Player> getPlayersByAbbreviation(String abbreviation) {
        return null;
    }

    public int addPlayer(Player player) throws ServiceException {
        return 0;
    }
}
