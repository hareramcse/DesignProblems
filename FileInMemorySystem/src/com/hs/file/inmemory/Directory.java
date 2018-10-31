package com.hs.file.inmemory;

import java.util.ArrayList;

public class Directory extends FileEntry {
	protected ArrayList<FileEntry> contents;

	public Directory(String n, Directory p) {
		super(n, p);
		contents = new ArrayList<FileEntry>();
	}

	public int size() {
		int size = 0;
		for (FileEntry e : contents)
			size += e.size();

		return size;
	}

	public int numberOfFiles() {
		int count = 0;
		for (FileEntry e : contents) {
			if (e instanceof Directory) {
				count++; // Directory counts as a file
				Directory d = (Directory) e;
				count += d.numberOfFiles();
			} else if (e instanceof File)
				count++;
		}
		return count;
	}

	public boolean deleteEntry(FileEntry entry) {
		return contents.remove(entry);
	}

	public void addEntry(FileEntry entry) {
		contents.add(entry);
	}

	protected ArrayList<FileEntry> getContents() {
		return contents;
	}
}