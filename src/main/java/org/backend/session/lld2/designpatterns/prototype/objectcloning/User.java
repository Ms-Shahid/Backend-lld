package org.backend.session.lld2.designpatterns.prototype.objectcloning;

public class User implements ObjectClonable<User>{

    private long userId;

    private String username;
    private String email;
    private String displayName;
    private int age;
    private UserType type;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    //copy constructor
//    public User(User user){
//        this.userId = user.userId;
//        this.age = user.age;
//        this.displayName = user.displayName;
//        this.type = user.type;
//        this.email = user.email;
//        this.username = user.username;
//    }

    public User(long userId, String username, String email, String displayName, int age, UserType type) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.displayName = displayName;
        this.age = age;
        this.type = type;
    }
    @Override
    public User cloneObject() {
        return new User(this.userId, this.username, this.email, this.displayName, this.age, this.type);
    }
}
