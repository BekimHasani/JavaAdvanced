package session10.bank.log;

import java.util.HashMap;
import java.util.Map;

public class LoggerFactory {
    private static Map<String, Logger> loggers = new HashMap<>();

    public static Logger getLogger(String type){
        switch(type.toUpperCase()){
            case "FILE": {
                Logger logger = loggers.getOrDefault(type.toUpperCase(), new FileLogger());
                loggers.putIfAbsent(type.toUpperCase(), logger);
                return logger;
            }
            case "IN_MEMORY": {
                Logger logger = loggers.getOrDefault(type.toUpperCase(), new InMemoryLogger());
                loggers.putIfAbsent(type.toUpperCase(), logger);
                return logger;
            }
            default:
                throw new UnsupportedOperationException(type+" logger not supported!");
        }
    }
}
