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

import java.util.Locale;
import java.util.logging.Logger;

public class PlayerImportProcess extends RuAbstractProcess implements ReadHandler {
    Logger log = Logger.getLogger(this.getClass().getName());
    protected PlayerService playerService;
    protected TeamService teamService;
    ReadHandler readHandler;
    Reader reader;
    MessageSource msg;
    int numberReads;
    Locale localis;

    @Override
    public void beforeProcess() {
        numberReads = 0;
        //System.out.println("BeforeProcess");
        //log.info("processbefore: " + getProcessContext().getProcessName());
        ApplicationContext serviceCtx = new FileSystemXmlApplicationContext("classpath:service.xml");
        msg = (MessageSource) serviceCtx.getBean("messageSource");

        playerService = (PlayerService) serviceCtx.getBean("playerServiceStub");
        teamService = (TeamService) serviceCtx.getBean("teamServiceStub");
        ReaderFactory rf = new ReaderFactory();
        reader = rf.getReader("playerReader");
        reader.setReadHandler(this);
        reader.setURI("http://olafurandri.com/honn/players.json");
        localis = new Locale("is", "IS");
        log.info(msg.getMessage("processbefore", new Object[]{getProcessContext().getProcessName()}, Locale.ENGLISH));
        log.info(msg.getMessage("processbefore", new Object[]{getProcessContext().getProcessName()}, localis));
    }

    @Override
    public void startProcess() {
        //System.out.println("StartProcess");
        log.info(msg.getMessage("processstart", new Object[]{getProcessContext().getProcessName()}, Locale.ENGLISH));
        log.info(msg.getMessage("processstart", new Object[]{getProcessContext().getProcessName()}, localis));
        reader.read();

    }

    @Override
    public void afterProcess() {
        super.afterProcess();
        //System.out.println("AfterProcess");
        Player ronaldo = playerService.getPlayer(839802);
       // System.out.println(ronaldo.getFirstName());
        log.info(msg.getMessage("processstartdone", new Object[]{numberReads}, Locale.ENGLISH));
        log.info(msg.getMessage("processstartdone", new Object[]{numberReads}, localis));
    }

    public void read(int count, Object object) {
        Player p = (Player) object;
        try {
            playerService.addPlayer(p);
            numberReads ++;
        } catch (ServiceException e) {
            log.severe(msg.getMessage("processreaderror", new Object[]{count}, Locale.ENGLISH));
            log.severe(msg.getMessage("processreaderror", new Object[]{count}, localis));
            log.info(e.getMessage());
        }
    }
}
