import is.ru.honn.rufan.reader.PlayerReader;
import is.ru.honn.rufan.reader.ReaderFactory;
import is.ru.honn.rufan.reader.TeamReader;
import is.ru.honn.rufan.service.TeamService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.logging.Logger;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:app-test-factory.xml")
public class TestReaderFactory extends TestCase {
    Logger log = Logger.getLogger(TestTeamService.class.getName());

    @Autowired
    private ReaderFactory rf;
    private PlayerReader playerReader;
    private TeamReader teamReader;
    @Test
    public void TestReadFactory()
    {
        playerReader = (PlayerReader) rf.getReader("playerReader");
        assertNotNull(playerReader);

        teamReader = (TeamReader) rf.getReader("teamReader");
        assertNotNull(teamReader);

    }
}