package my_demo;

import java.io.File;

import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.io.Zip;

public class Zipfile {
	public static void main(String[] args) {
		Zip zip =new Zip();
		try{
			//���ƶ��ļ�ѹ����һ��zipѹ������
			zip.zip(new File("D:\\��¼"),new File("E:\\��¼.zip"));
			//�ж�һ���ļ��Ƿ���ѹ���ļ���
			System.out.println(FileHandler.isZipped("E:\\��¼.zip"));
			//��һ���ļ���ѹ
			//zip.unzip(new File("E:\\��¼.zip"),new File("E:\\gg"));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
