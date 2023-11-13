/**
 * User.java
 * 
 * Handles the information about the user object which is user in other classes
 *
 * @version April 11, 2022
 */
public class User {
    private String username;
    private String password;
    private boolean teacher;

    public User(String username, String password, boolean teacher) {
        this.username = username;
        this.password = password;
        this.teacher = teacher;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isTeacher() {
        return teacher;
    }

    public void setTeacher(boolean teacher) {
        this.teacher = teacher;
    }
}
