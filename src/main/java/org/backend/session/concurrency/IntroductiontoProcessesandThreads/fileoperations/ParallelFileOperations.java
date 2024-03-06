package org.backend.session.concurrency.IntroductiontoProcessesandThreads.fileoperations;

import java.io.IOException;

class ParallelFileOperationTask implements Runnable{

    String sourceFile;
    String destFile;

    public ParallelFileOperationTask(String sourceFile, String destFile){
        this.sourceFile = sourceFile;
        this.destFile = destFile;
    }

    @Override
    public void run() {
        try{
            FileHandling.copyFile(sourceFile, destFile);
            System.out.println("Copied from " + this.sourceFile + " to " + this.destFile);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
public class ParallelFileOperations {

    public static void main(String[] args) {

        String sourceFile1 = "src/main/java/org/backend/session/concurrency/IntroductiontoProcessesandThreads/fileoperations/samplefiles/a.txt";
        String sourceFile2 = "src/main/java/org/backend/session/concurrency/IntroductiontoProcessesandThreads/fileoperations/samplefiles/b.txt";

        String destFile1 = "src/main/java/org/backend/session/concurrency/IntroductiontoProcessesandThreads/fileoperations/samplefiles/c.txt";
        String destFile2 = "src/main/java/org/backend/session/concurrency/IntroductiontoProcessesandThreads/fileoperations/samplefiles/d.txt";

        //assign the task to threads to run parallelly

        new Thread( new ParallelFileOperationTask(sourceFile1, destFile1)).start();

        new Thread( new ParallelFileOperationTask(sourceFile2, destFile2)).start();

    }
}
