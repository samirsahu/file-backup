package com.sam.filebackup;

public class SyncDir {
	String path1;
	String path2;
	
	public SyncDir(String path1, String path2) {
		this.path1 = path1;
		this.path2 = path2;
	}
	
	public String getPath1() {
		return path1;
	}
	
	public void setPath1(String path1) {
		this.path1 = path1;
	}
	
	public String getPath2() {
		return path2;
	}
	
	public void setPath2(String path2) {
		this.path2 = path2;
	}
	
}
