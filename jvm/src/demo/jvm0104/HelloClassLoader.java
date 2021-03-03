package demo.jvm0104;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;

/**
 * @ClassName: HelloClassLoader
 * @Description: 关键点是defineClass,读取字节码的字节流，生成class，思路就是转化class文件为字节流，传入defineClass中
 *
 * 参考：https://github.com/xiaohaowudi/JAVA-000/blob/main/Week_01/homework2/HelloClassloader.java
 * @author: zhoujian
 * @date: 2021/2/15 15:32
 * @version: 1.0
 */
public class HelloClassLoader extends ClassLoader{

    private byte[] readClassFile(String path){
        URL url = getClass().getClassLoader().getResource(path);
        if (null != url) {
            File file = new File(url.getFile());
            byte[] readBuf = new byte[(int) file.length()];
            InputStream inputStream = null;

            try {
                inputStream = new FileInputStream(url.getFile());
                int val, idx = 0;

                while (true) {
                    try {
                        val = inputStream.read();
                        if (val == -1){
                            break;
                        }
                        readBuf[idx++] = (byte) val;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return readBuf;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }finally {
                try {
                    if (inputStream != null){
                        inputStream.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    private byte[] decodeClass(){
        byte[] encodeResult = readClassFile("demo/jvm0104/Hello.xlass");
        if (null == encodeResult) {
            return null;
        }

        byte[] decodeResult = new byte[encodeResult.length];
        for (int index = 0; index < encodeResult.length; index++) {
            // 解码
            decodeResult[index] = (byte) (255 - encodeResult[index]);
        }

        return decodeResult;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] result = decodeClass();
        if (null == result){
            return null;
        }
        return defineClass(name, result, 0, result.length);
    }

    public static void main(String[] args) {
        try {
            Object target = new HelloClassLoader().findClass("Hello").newInstance();
            target.getClass().getDeclaredMethod("hello").invoke(target);
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }


}
