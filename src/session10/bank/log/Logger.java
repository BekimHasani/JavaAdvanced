package session10.bank.log;

import java.util.List;

public interface Logger<T> {
    void writeLog(Loggable<T> loggable, String action) throws Exception;
    List<String> getLogs(T entity) throws Exception;
}
