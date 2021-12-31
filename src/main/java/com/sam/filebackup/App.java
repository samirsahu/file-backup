package com.sam.filebackup;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
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

    public static void main(String[] args) throws IOException {
        App me = new App();
        me.start();
    }

    private void start() throws IOException {
        for (SyncDir syncDir : syncDirs) {
            Path path1 = syncDir.getPath1();
            logger.info("Start Parsing: " + path1);

            parseDirectory(path1);

        }
    }

    private void parseDirectory(Path dirPath) throws IOException {
        Files.newDirectoryStream(dirPath).forEach(subFile -> {
            try {
                File file = subFile.toFile();
                printFileInfo(file);
                if (file.isDirectory()) {
                    parseDirectory(file.toPath());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void printFileInfo(File file) throws IOException {
        logger.info("Type: " + (file.isDirectory() ? "Directory" : "File"));
        logger.info("getAbsolutePath: " + file.getAbsolutePath());
        logger.info("getPath: " + file.getPath());
        logger.info("getCanonicalPath: " + file.getCanonicalPath());
        logger.info("getName: " + file.getName());
        logger.info("getParent: " + file.getParent());
        logger.info("getFreeSpace: " + file.getFreeSpace());
        logger.info("getTotalSpace: " + file.getTotalSpace());
        logger.info("getUsableSpace: " + file.getUsableSpace());
        logger.info("canExecute: " + file.canExecute());
        logger.info("canRead: " + file.canRead());
        logger.info("canWrite: " + file.canWrite());
        logger.info("isAbsolute: " + file.isAbsolute());
        logger.info("isHidden: " + file.isHidden());
        logger.info("exists: " + file.exists());
    }


}
