package org.backend.session.concurrency.IntroductiontoProcessesandThreads.fileoperations;

import java.io.IOException;

public class SerialFileOperations {

    //serial way of utilizing file operations
    public static void main(String[] args) throws IOException {

        String sourceFile1 = "src/main/java/org/backend/session/concurrency/IntroductiontoProcessesandThreads/fileoperations/samplefiles/a.txt";
        String sourceFile2 = "src/main/java/org/backend/session/concurrency/IntroductiontoProcessesandThreads/fileoperations/samplefiles/b.txt";

        String destFile1 = "src/main/java/org/backend/session/concurrency/IntroductiontoProcessesandThreads/fileoperations/samplefiles/c.txt";
        String destFile2 = "src/main/java/org/backend/session/concurrency/IntroductiontoProcessesandThreads/fileoperations/samplefiles/d.txt";

        //copy a.txt to c.txt
        FileHandling.copyFile(sourceFile1, destFile1);

        //copy b.txt to d.txt
        FileHandling.copyFile(sourceFile2, destFile2);

        System.out.println("Successful ! ");
    }
}
