package com.sam.filebackup;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    static List<SyncDir> syncDirs = new ArrayList<>();
    Logger logger = LogManager.getLogger(this.getClass());

    static {
        syncDirs.add(new SyncDir("C:\\Temp\\Sync1-1", "C:\\Temp\\Sync1-2"));
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        App me = new App();
        me.start();
    }

    private void start() {
        for (SyncDir syncDir : syncDirs) {

            Path path1 = syncDir.getPath1();


        }
    }

    private void parseDirectory(Path dirPath){
        File dir = dirPath.toFile();
        dir.isDirectory();
        dir.isFile();


    }


}
