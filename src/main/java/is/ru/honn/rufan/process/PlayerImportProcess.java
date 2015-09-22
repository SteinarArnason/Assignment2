package is.ru.honn.rufan.process;

import is.ru.honn.rufan.domain.Player;
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
    Reader reader;
    MessageSource msg;
    int numberReads;
    Locale localis;

    /**
     * Initialize all the variables that the process is going to use and log that we are in the beforeprocess
     */
    @Override
    public void beforeProcess() {
        numberReads = 0;
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

    /**
     * Starts the process and logs that the process has started
     */
    @Override
    public void startProcess() {
        log.info(msg.getMessage("processstart", new Object[]{getProcessContext().getProcessName()}, Locale.ENGLISH));
        log.info(msg.getMessage("processstart", new Object[]{getProcessContext().getProcessName()}, localis));
        reader.read();

    }

    /**
     * Logs that the process is over
     */
    @Override
    public void afterProcess() {
        super.afterProcess();
        log.info(msg.getMessage("processstartdone", new Object[]{numberReads}, Locale.ENGLISH));
        log.info(msg.getMessage("processstartdone", new Object[]{numberReads}, localis));
    }

    /**
     * Process implements so this gets called when we read new player in PlayerReader
     * @param count count of player
     * @param object player object
     */
    public void read(int count, Object object) {
        Player p = (Player) object;
        try {
            playerService.addPlayer(p);
            numberReads++;
        } catch (ServiceException e) {
            log.severe(msg.getMessage("processreaderror", new Object[]{count}, Locale.ENGLISH));
            log.severe(msg.getMessage("processreaderror", new Object[]{count}, localis));
            log.info(e.getMessage());
        }
    }
}
