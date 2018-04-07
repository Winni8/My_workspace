package my_demo;

import java.io.File;

import org.openqa.selenium.io.FileHandler;

public class Copyfile {
	public static void main(String[] args) {
		try{
			//�����ļ���
			FileHandler.copy(new File("D:\\��¼"), new File("D:\\��¼1"));
			//��ԴĿ¼�µ������ļ��к��ļ�(��׺Ϊ.txt)���Ƶ�Ŀ��Ŀ¼��
			FileHandler.copy(new File("D:\\��¼"), new File("D:\\��¼2"), ".txt");
			//����ĳ���ļ�
			FileHandler.copy(new File("D:\\��¼3\\asd.txt"), new File("D:\\��¼2\\1.txt"));
			
			
			/*//�h���ļ�
			FileHandler.delete(new File("D:\\��¼2\\asd.txt"));
			//ɾ���ļ���
			FileHandler.delete(new File("D:\\��¼2\\hfh"));*/
			
			/*//����Ŀ¼
			FileHandler.createDir(new File("D:\\test Ŀ¼��"));
			*/
			
	        //�ж��ļ��Ƿ�Ϊ��ִ���ļ�
	        //����ǿ�ִ���ļ������ӡ���ļ��ǿ�ִ���ļ���
	        //���򣬽��ļ���Ϊ��ִ���ļ�
	        if (FileHandler.canExecute(new File("D:\\��¼"))) {
	            System.out.println("�ļ��ǿ�ִ���ļ�");
	        } else {
	            FileHandler.makeExecutable(new File("D:\\��¼"));
	        }
	        //�޸��ļ���Ȩ��ʹ���Ϊ��д�ļ�
	        //FileHandler.makeWritable(new File("D:\\��¼"));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
