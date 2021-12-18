package com.sam.filebackup;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {
	static List<SyncDir> syncDirs = new ArrayList<>();
	
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
		
		}
	}
	
}
