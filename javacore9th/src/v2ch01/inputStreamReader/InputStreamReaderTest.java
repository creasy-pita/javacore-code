package v2ch01.inputStreamReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * Created by lujq on 6/30/2021.
 */
public class InputStreamReaderTest {

    public static void main(String[] args) {
        testReaderWithCharset();
    }

    public static void testReaderWithCharset(){
        try (InputStreamReader input = new InputStreamReader(new FileInputStream("helloWorld_gb2312.txt"), Charset.forName("GB2312"))) {
            int data = input.read();
            while (data != -1) {
                //do something with data; e.g. append it to StringBuffer
                System.out.print((char) data);
                data = input.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void test03(){
        try (InputStreamReader input = new InputStreamReader(new FileInputStream("helloWorld.txt"))) {
            int data = input.read();
            while (data != -1) {
                //do something with data; e.g. append it to StringBuffer
                System.out.print((char) data);
                data = input.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void test02(){
        // auto-closable feature  :try-with-resources
        try (InputStreamReader input =
                     new InputStreamReader(new FileInputStream("helloWorld.txt"))) {
            char[] chars = new char[150];
            input.read(chars);
            System.out.print(chars);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void test01(){
        FileInputStream fileInputStream = null;
        try {
//            fileInputStream = new FileInputStream("E:\\work\\myproject\\java\\javacore-code\\javacore9th\\resources\\helloWorld.txt");
            //文件名可以相对于工作目录  working directory 或者 使用全路径
            System.out.println(System.getProperty("user.dir"));
            fileInputStream = new FileInputStream("helloWorld.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        char[] chars = new char[150];
        try {
            inputStreamReader.read(chars);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(chars);
    }


}
