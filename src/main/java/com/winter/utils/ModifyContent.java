package com.winter.utils;

import java.io.IOException;
import java.io.RandomAccessFile;

public class ModifyContent {
    public static boolean modifyFileContent(String file, String oldstr, String newStr) {
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(file, "rw");
            String line = null;
            long lastPoint = 0; //记住上一次的偏移量
            while ((line = raf.readLine()) != null) {
                final long ponit = raf.getFilePointer();
                if(line.contains(oldstr)){
                    String str=line.replace(oldstr, newStr);
                    raf.seek(lastPoint);
                    raf.writeBytes(str);
                }
                lastPoint = ponit;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                raf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public static void main(String[] args) {
        modifyFileContent("C:\\Users\\T460s\\git\\app-smcv-newrvm\\src\\main\\java\\com\\zxq\\iov\\cloud\\app\\newrvm\\service\\impl\\HQWInfoServiceImpl.java","YFInfoServiceImpl","HQWInfoServiceImpl");
    }
}