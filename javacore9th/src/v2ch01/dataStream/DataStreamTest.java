package v2ch01.dataStream;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by lujq on 6/30/2021.
 */
public class DataStreamTest {
    public static void main(String[] args) {
        dataInputStreamTest();
    }

    public static void dataInputStreamTest(){
        ByteArrayInputStream byteIs = new ByteArrayInputStream("112.3".getBytes());

        DataInputStream dataInputStream = new DataInputStream(byteIs);
        try {
            System.out.println(dataInputStream.readInt());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
