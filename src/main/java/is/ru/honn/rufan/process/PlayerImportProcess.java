package is.ru.honn.rufan.process;

import is.ru.honn.rufan.domain.Player;
import is.ru.honn.rufan.reader.AbstractReader;
import is.ru.honn.rufan.reader.ReadHandler;
import is.ru.honn.rufan.reader.Reader;
import is.ru.honn.rufan.reader.ReaderFactory;
import is.ru.honn.rufan.service.PlayerService;
import is.ru.honn.rufan.service.TeamService;
import is.ru.honn.rufan.service.exception.ServiceException;
import is.ruframework.process.RuAbstractProcess;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.logging.Logger;

public class PlayerImportProcess extends RuAbstractProcess implements ReadHandler {
    Logger log = Logger.getLogger(this.getClass().getName());
    protected PlayerService playerService;
    protected TeamService teamService;
    ReadHandler readHandler;
    Reader reader;
    MessageSource msg;

    @Override
    public void beforeProcess() {
        System.out.println("BeforeProcess");
        log.info("processbefore: " + getProcessContext().getProcessName());
        ApplicationContext serviceCtx = new FileSystemXmlApplicationContext("classpath:service.xml");
        playerService = (PlayerService) serviceCtx.getBean("playerServiceStub");
        teamService = (TeamService) serviceCtx.getBean("teamServiceStub");
        ReaderFactory rf = new ReaderFactory();
        reader = rf.getReader("playerReader");
        reader.setReadHandler(this);
        reader.setURI("http://olafurandri.com/honn/players.json");
    }

    @Override
    public void startProcess() {
        System.out.println("StartProcess");
        reader.read();

    }

    @Override
    public void afterProcess() {
        super.afterProcess();
        System.out.println("AfterProcess");
        Player ronaldo = playerService.getPlayer(839802);
        System.out.println(ronaldo.getFirstName());
    }

    public void read(int count, Object object) {
        Player p = (Player) object;
        try {
            playerService.addPlayer(p);
        } catch (ServiceException e) {
            System.out.println("Failed to added reader, TODO: should probably do something");
        }
    }
}
