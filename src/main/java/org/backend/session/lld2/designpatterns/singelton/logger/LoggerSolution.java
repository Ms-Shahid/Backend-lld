package org.backend.session.lld2.designpatterns.singelton.logger;

public class LoggerSolution {

    private volatile LoggerSolution loggerSolution = null;

    public LoggerSolution getInstance(){

        if( loggerSolution == null ){

            synchronized (LoggerSolution.class){
                if( loggerSolution == null ){
                    loggerSolution = new LoggerSolution();
                }
            }
        }
        return loggerSolution;
    }

    public LoggerSolution restInstance(){

        if( loggerSolution != null ){

            synchronized (LoggerSolution.class){
                if( loggerSolution != null ){
                    loggerSolution = null;
                }
            }
        }
        return loggerSolution;
    }
}
