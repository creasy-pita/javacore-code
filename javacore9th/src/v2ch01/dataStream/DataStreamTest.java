package v2ch01.dataStream;

import java.io.*;

/**
 * Created by lujq on 6/30/2021.
 */
public class DataStreamTest {
    public static void main(String[] args) {
//        readDoubleTest();
        readByteTest();
    }

    public static void readByteTest() {

        String path = "files\\byteData.txt";
        InputStream is = null;
        DataInputStream dis = null;
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        byte[] bytes = "我".getBytes();

        try {
            // create file output stream
            fos = new FileOutputStream(path);

            // create data output stream
            dos = new DataOutputStream(fos);

            // for each byte in the buffer
            for (byte b : bytes) {

                // write double to the data output stream
                dos.writeByte(b);
            }

            // force bytes to the underlying stream
            dos.flush();

            // create file input stream
            is = new FileInputStream(path);

            // create new data input stream
            dis = new DataInputStream(is);

            // read till end of the stream
            while (dis.available() > 0) {

                // read character
                byte b = dis.readByte();

                // print
                System.out.print(b + " ");
            }

        } catch (Exception e) {
            // if any I/O error occurs
            e.printStackTrace();
        } finally {
            // releases all system resources from the streams
            try {
                if (is != null)
                    is.close();
                if (dos != null)
                    is.close();
                if (dis != null)
                    dis.close();
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void readDoubleTest() {
        String path = "files\\doubleData.txt";
        InputStream is = null;
        DataInputStream dis = null;
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        double[] dbuf = {65.56, 66.89, 67.98, 68.82, 69.55, 70.37};

        try {
            // create file output stream
            fos = new FileOutputStream(path);

            // create data output stream
            dos = new DataOutputStream(fos);

            // for each byte in the buffer
            for (double d : dbuf) {

                // write double to the data output stream
                dos.writeDouble(d);
            }

            // force bytes to the underlying stream
            dos.flush();

            // create file input stream
            is = new FileInputStream(path);

            // create new data input stream
            dis = new DataInputStream(is);

            // read till end of the stream
            while (dis.available() > 0) {

                // read character
                double c = dis.readDouble();

                // print
                System.out.print(c + " ");
            }

        } catch (Exception e) {
            // if any I/O error occurs
            e.printStackTrace();
        } finally {
            // releases all system resources from the streams
            try {
                if (is != null)
                    is.close();
                if (dos != null)
                    is.close();
                if (dis != null)
                    dis.close();
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
