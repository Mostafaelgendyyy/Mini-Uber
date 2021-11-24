public abstract class User {
    private String userName;
    private String mobileNum;
    private String email;
    private String passWord;

    public User() {
    }

    public User(String userName, String mobileNum, String email, String passWord) {
        this.userName = userName;
        this.mobileNum = mobileNum;
        this.email = email;
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
