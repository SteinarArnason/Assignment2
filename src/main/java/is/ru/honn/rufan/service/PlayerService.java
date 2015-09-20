package is.ru.honn.rufan.service;

import is.ru.honn.rufan.domain.Player;
import is.ru.honn.rufan.service.exception.ServiceException;

import java.util.List;

public interface PlayerService {
    Player getPlayer(int playerId);
    List<Player> getPlayers(int teamId);
    List<Player> getPlayersByAbbreviation(String abbreviation);
    int addPlayer(Player player) throws ServiceException;

}
