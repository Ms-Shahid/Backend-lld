package org.backend.session.lld2.designpatterns.singelton.version2;

public class DatabaseConnection {

    private String userName;
    private String password;
    private String url;

    private static DatabaseConnection db = null;
    private DatabaseConnection(){}

    public synchronized DatabaseConnection getInstance(){
        if( db == null ){
            db = new DatabaseConnection();
        }
        return db;
    }
    /*
    * Here this method acquires the lock on the entire method,
    * If suppose multiple threads are waiting in the queue to get executed,
    * say, T1, T2, T3. T4 are in queue initially
    * T1 gets into syc method & acquires lock & initially db is null hence a object is created
    * When T1 is release, T2 comes & check db is not null now, T2 release, T3 comes & releases & same for T4
    * Even through the object is created at T1 release, still T2, T3, T4 wait in queue to acquire the lock
    * Hence its a waste of resources & performance is degraded since multiple threads are in queue waiting...*/
}
