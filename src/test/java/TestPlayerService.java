import is.ru.honn.rufan.domain.Player;
import is.ru.honn.rufan.reader.ReaderFactory;
import is.ru.honn.rufan.service.PlayerService;
import is.ru.honn.rufan.service.exception.ServiceException;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.logging.Logger;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:app-test-stub.xml")
//@ContextConfiguration("file:src/main/resources/service.xml")
public class TestPlayerService extends TestCase {

    Logger log = Logger.getLogger(TestPlayerService.class.getName());
    @Autowired
    private PlayerService servicePlayer;

    @Test
    public void testPlayer() {
        Player player1 = new Player(0, "Memphis", "Depay",1);
        Player player2 = new Player(1, "Theo", "Walcott", 2);

        /**Testing addPlayer*/
        try {
            servicePlayer.addPlayer(player1);
            servicePlayer.addPlayer(player2);
        } catch (ServiceException e) {
            String msg = "Adding players failed";
            log.info(msg);
        }

        /**Testing addPlayer failure*/
        try {
            servicePlayer.addPlayer(player1);
        } catch (ServiceException e) {
            assertSame(ServiceException.class, e.getClass());
        }

        /**Testing getPlayer existing*/
        Player player3 = servicePlayer.getPlayer(0);
        assertSame(player1, player3);

        /**Testing getPlayer non-existing*/
  /*      Player player4 = servicePlayer.getPlayer(2);
        assertNull(player4);
    */}

}
