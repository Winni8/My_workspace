package my_demo;

import java.io.File;

import org.openqa.selenium.io.FileHandler;

public class Copyfile1 {
	public static void main(String[] args) {
		try{
			String file =FileHandler.readAsString(new File("D:\\��¼\\sfsfs.txt"));
			System.out.println(file);
		}catch(Exception  e){
			e.printStackTrace();
		}
	}
}
