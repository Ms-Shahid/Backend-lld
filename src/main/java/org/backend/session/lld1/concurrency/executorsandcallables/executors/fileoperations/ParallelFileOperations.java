package org.backend.session.concurrency.executorsandcallables.executors.fileoperations;

import org.backend.session.concurrency.IntroductiontoProcessesandThreads.fileoperations.FileHandling;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

        String sourceFile1 = "src/main/java/org/backend/session/concurrency/executorsandcallables/executors/fileoperations/samplefiles/a.txt";
        String sourceFile2 = "src/main/java/org/backend/session/concurrency/executorsandcallables/executors/fileoperations/samplefiles/b.txt";

        String destFile1 = "src/main/java/org/backend/session/concurrency/executorsandcallables/executors/fileoperations/samplefiles/c.txt";
        String destFile2 = "src/main/java/org/backend/session/concurrency/executorsandcallables/executors/fileoperations/samplefiles/d.txt";

        /*
            Assign the task to threads to run parallel
            Note: Thread creation is costly, as it includes creating a separate execution context, stack etc.
            Instead, we can create a pool of threads & effectively utilize them in executing the task.
            This can be achieved using ExecutorService
            If the thread is available in pool then it assigns this task to the thread otherwise task gets added into the blocking queue
        */

        ExecutorService executor = Executors.newFixedThreadPool(5); //creates for thread & reuse them efficeintly
        executor.execute( new ParallelFileOperationTask(sourceFile1, destFile1));
        executor.submit( new ParallelFileOperationTask(sourceFile2, destFile2));

        executor.shutdown();
    }
}
