package org.backend.session.concurrency.IntroductiontoProcessesandThreads.fileoperations;

import java.io.*;

public class FileHandling {

    //To copy contents of src file to dest file
    public static void copyFileContent(InputStream src, OutputStream dest ) throws IOException {
        int value;
        while( (value = src.read()) != -1 ){
            dest.write(value);
        }
    }

    //copy file from src to dest
    public static void copyFile( String srcFile, String destFile ) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(srcFile);
        FileOutputStream fileOutputStream = new FileOutputStream(destFile);

        copyFileContent(fileInputStream, fileOutputStream);
        fileInputStream.close();
        fileOutputStream.close();

    }
}
