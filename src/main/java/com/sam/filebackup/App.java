package com.sam.filebackup;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    static List<SyncDir> syncDirs = new ArrayList<>();
    static Logger logger = LogManager.getLogger(App.class.getName());

    static {
        syncDirs.add(new SyncDir("C:\\Temp\\Sync1-1\\ToSync", "C:\\Temp\\Sync1-2\\ToSync"));
    }

    public static void main(String[] args) throws IOException {
        App me = new App();
        me.start();
    }

    private void start() throws IOException {
        for (SyncDir syncDir : syncDirs) {
            Path path1 = syncDir.getPath1();
            Path path2 = syncDir.getPath2();
            String path1FileName = path1.getFileName().toString();
            String path2FileName = path1.getFileName().toString();
            logger.info("{} <=> {}", path1, path2);
            logger.info("FileNames: {} & {}", path1FileName, path2FileName);

            if (!path1FileName.equals(path2FileName)) {
                logger.error("Sync Folders should be same name: {}, {}", path1, path2);
                return;
            }
            boolean isDir1 = Files.isDirectory(path1);
            boolean isDir2 = Files.isDirectory(path2);
            if (!isDir1 || !isDir2) {
                logger.error("Both Sync Paths should be Directory: {}, {}", path1, path2);
                return;
            }
        }
    }

    private void diff(Path path1, Path path2) {
        boolean isExists1 = Files.exists(path1);
        boolean isExists2 = Files.exists(path2);
        Path parent1 = path1.getParent();
        Path parent2 = path2.getParent();
        Path path1Rel = path1.relativize(parent1);
        Path path2Rel = path2.relativize(parent2);

        if (isExists1 && isExists2) {
            logger.info("Both Exists");
        } else if (isExists1) {
            logger.info("{} Exists", path1);
        } else {
            logger.info("{} Exists", path2);
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
        logger.info("*********************************************");
        logger.info("Type: {}", (file.isDirectory() ? "Directory" : "File"));
        logger.info("getAbsolutePath: {}", file.getAbsolutePath());
        logger.info("getPath: {}", file.getPath());
        logger.info("getCanonicalPath: {}", file.getCanonicalPath());
        logger.info("getName: {}", file.getName());
        logger.info("getParent: {}", file.getParent());
        logger.info("getFreeSpace: {}", file.getFreeSpace());
        logger.info("getTotalSpace: {}", file.getTotalSpace());
        logger.info("getUsableSpace: {}", file.getUsableSpace());
        logger.info("canExecute: {}", file.canExecute());
        logger.info("canRead: {}", file.canRead());
        logger.info("canWrite: {}", file.canWrite());
        logger.info("isAbsolute: {}", file.isAbsolute());
        logger.info("isHidden: {}", file.isHidden());
        logger.info("exists: {}", file.exists());

        logger.info("***** Basic Attributes: -");
        BasicFileAttributes attributes = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
        logger.info("isDirectory : {}", attributes.isDirectory());
        logger.info("isOther : {}", attributes.isOther());
        logger.info("isRegularFile : {}", attributes.isRegularFile());
        logger.info("isSymbolicLink : {}", attributes.isSymbolicLink());
        logger.info("creationTime : {}", attributes.creationTime());
        logger.info("lastAccessTime : {}", attributes.lastAccessTime());
        logger.info("lastModifiedTime : {}", attributes.lastModifiedTime());
        logger.info("size : {}", attributes.size());
    }


}
