package kr.co.tjeit.sociallogin2.data;

/**
 * Created by tjoeun on 2017-08-30.
 */

public class User {
    private String userId;
    private String name;
    private String profileURL;

    public User() {
    }



    public User(String userId, String name, String profileURL) {
        this.userId = userId;
        this.name = name;
        this.profileURL = profileURL;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfileURL() {
        return profileURL;
    }

    public void setProfileURL(String profileURL) {
        this.profileURL = profileURL;
    }
}
