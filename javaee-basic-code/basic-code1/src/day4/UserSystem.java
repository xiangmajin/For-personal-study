package day4;

public class UserSystem {
        String username;
        String password;
        String identityNumber;
        int phoneNumber;


    public UserSystem() {
    }

    public UserSystem(String username, String password, String identityNumber, int phoneNumber) {
        this.username = username;
        this.password = password;
        this.identityNumber = identityNumber;
        this.phoneNumber = phoneNumber;
    }

    /**
     * 获取
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取
     * @return identityNumber
     */
    public String getIdentityNumber() {
        return identityNumber;
    }

    /**
     * 设置
     * @param identityNumber
     */
    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    /**
     * 获取
     * @return phoneNumber
     */
    public int getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 设置
     * @param phoneNumber
     */
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


}
