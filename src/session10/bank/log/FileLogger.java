package session10.bank.log;

import session10.bank.account.BankAccount;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.List;

public class FileLogger implements Logger<BankAccount> {
    private final String LOG_DIR = "D:/logs";

    public FileLogger(){
        File file = new File(LOG_DIR);
        if(!file.exists()){
            file.mkdir();
        }
    }

    @Override
    public void writeLog(Loggable<BankAccount> loggable, String action) throws IOException {
        File file = new File(LOG_DIR, loggable.getEntity().getAccountNr()+".log");
//        if(!file.exists()){
//            file.createNewFile();
//        }
        Files.write(file.toPath(), Collections.singleton(action), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

    @Override
    public List<String> getLogs(BankAccount entity) throws IOException {
        File file = new File(LOG_DIR, entity.getAccountNr()+".log");
        return Files.readAllLines(file.toPath());
    }
}
