package selenium;

public class TestUser {
    private String userName;
    private String password;

    public TestUser(String username, String password) {
        this.userName = username;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
