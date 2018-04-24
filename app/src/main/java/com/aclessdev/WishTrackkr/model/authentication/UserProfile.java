package com.aclessdev.WishTrackkr.model.authentication;

import io.realm.RealmObject;

/**
 * Created by AlvinTan on 31/03/18.
 */

public class UserProfile{
    String profilePicture;
    String name;
    String id;
    String email;
    String birthday;

    public UserProfile(String profilePicture, String name, String id, String email, String birthday) {
        this.profilePicture = profilePicture;
        this.name = name;
        this.id = id;
        this.email = email;
        this.birthday = birthday;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
