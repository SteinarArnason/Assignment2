import is.ru.honn.rufan.domain.Team;
import is.ru.honn.rufan.service.TeamService;
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
public class TestTeamService extends TestCase {
    Logger log = Logger.getLogger(TestTeamService.class.getName());

    @Autowired
    private TeamService serviceTeam;

    @Test
    public void testTeam() {
        Team team1 = new Team(0, "MANU", "Manchester United");
        Team team2 = new Team(1, "ARS", "Arsenal");

        /**Testing addTeam*/
        try {
            serviceTeam.addTeam(39 ,team1);
            serviceTeam.addTeam(39, team2);
        } catch (ServiceException e) {
            String msg = "Adding teams failed";
            log.info(msg);
        }

        /**Testing addTeam failure*/
        try {
            serviceTeam.addTeam(39, team1);
        } catch (ServiceException e) {
            assertSame(ServiceException.class, e.getClass());
        }

        /**Testing addTeam with no known league (-1 is in this case the same as not known)*/
        try {
            serviceTeam.addTeam(-1, team1);
        } catch (ServiceException e) {
            assertSame(ServiceException.class, e.getClass());
        }

        /**Testing getTeams, the league doesn't exist and therefor no teams are found*/
        try {
            serviceTeam.getTeams(-1);
        } catch (ServiceException e) {
            assertSame(ServiceException.class, e.getClass());
        }


    }



}
