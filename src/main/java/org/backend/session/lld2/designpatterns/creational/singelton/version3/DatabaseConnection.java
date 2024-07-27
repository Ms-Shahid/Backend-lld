package org.backend.session.lld2.designpatterns.singelton.version3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DatabaseConnection {

    private String userName;
    private String password;
    private String url;

    private static DatabaseConnection db = null;

    private DatabaseConnection(String userName, String password){
        this.userName = userName;
        this.password = password;
    }

    public DatabaseConnection getInstance(){

        if( db == null ){
            Lock lock = new ReentrantLock();
            lock.lock();
            if( db == null ){
                db = new DatabaseConnection(userName, password);
            }
            lock.unlock();
        }
        return db;
    }

    /*
    * Here, double check is implemented before creating an object
    * Say, there are threads T1, T2, T3, T4. wants to get executed
    * Initially, all the threads enter first if block simultaneously, as thats not locked
    * Now, T1 acquires the lock & check is db is null, initially db is null it create an object
    * and T1 is released, then say T3 comes in & acquires the lock, now db is not null hence no object creation
    * similarly T2, T4 does the same.
    * Result : if the object is already in memory, then Threads just check whether the object exists in memory or not.
    * if it does, then lock is released, else lock is acquired to create object.
    * */
}
