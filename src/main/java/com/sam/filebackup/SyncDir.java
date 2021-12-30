package com.sam.filebackup;

import java.nio.file.Path;
import java.nio.file.Paths;

public class SyncDir {
    Path path1;
    Path path2;

    public SyncDir(String path1, String path2) {
        this.path1 = Paths.get(path1);
        this.path2 = Paths.get(path2);
    }

    public Path getPath1() {
        return path1;
    }

    public void setPath1(Path path1) {
        this.path1 = path1;
    }

    public Path getPath2() {
        return path2;
    }

    public void setPath2(Path path2) {
        this.path2 = path2;
    }
}
