package org.backend.session.lld2.designpatterns.singelton.version1;

public class DatabaseConnection {

    private String userName;
    private String password;
    private String url;

//    List<TCP> connections;

    private DatabaseConnection(){}

    public static DatabaseConnection getInstance(){
        return new DatabaseConnection();
    }
}
