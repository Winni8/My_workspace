package my_demo;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
public class ScreenShot {
    public WebDriver driver;
    public ScreenShot(WebDriver _driver){
        driver=_driver;
    }
    private void takeScreenshot(String screenPath){
        try {
            //��ȡ��ͼfile
            File scrFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            //��ͼƬ�ƶ���ָ��λ��
            FileUtils.moveFile(scrFile, new File(screenPath));
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void takeScreenshot(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd(hh_mm_ss)SSS");
        String fileName=dateFormat.format( new Date());
        //�����µ��ļ���
        String screenName=fileName+".jpg";
        //�����ļ���
        File dir = new File("test-output/snapshot");
        if (!dir.exists()){
            dir.mkdirs();
        }
        //��ȡ���ļ����ľ���·��
        String screenPath= dir.getAbsolutePath()+"/"+screenName;
        //��ͼ
        this.takeScreenshot(screenPath);
    }
}