package org.backend.session.lld2.designpatterns.singelton.version1;

public class Client {

    public static void main(String[] args) {
//        DatabaseConnection databaseConnection = new DatabaseConnection();


        DatabaseConnection.getInstance();

    }

}
