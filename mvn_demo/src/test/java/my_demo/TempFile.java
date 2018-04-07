package my_demo;

import java.io.File;

import org.openqa.selenium.io.TemporaryFilesystem;

public class TempFile {
	public static void main(String[] args) {
		File temp =TemporaryFilesystem.getDefaultTmpFS().createTempDir("prefix", "suffix");
		System.out.println(temp.getAbsolutePath());
		System.out.println("���ÿռ䣺"+temp.getFreeSpace());
	}
}
