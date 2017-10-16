package br.com.wishlister.model;

import java.io.Serializable;

/**
 * Created by wallace on 14/10/2017.
 *
 * Representing the data to display on the web page
 */
public class ResponsePage implements Serializable {

    private String id;
    private String vanueName;
    private String vanuePhoto;
    private String userName;
    private String userPhoto;

    public ResponsePage() {}

    public ResponsePage(String vanueName) {
        this.vanueName = vanueName;
    }

    public ResponsePage(String id, String vanueName) {
        this.id = id;
        this.vanueName = vanueName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVanueName() {
        return vanueName;
    }

    public void setVanueName(String vanueName) {
        this.vanueName = vanueName;
    }

    public String getVanuePhoto() {
        return vanuePhoto;
    }

    public void setVanuePhoto(String vanuePhoto) {
        this.vanuePhoto = vanuePhoto;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResponsePage page = (ResponsePage) o;

        return id != null ? id.equals(page.id) : page.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ResponsePage{" +
                "id='" + id + '\'' +
                ", vanueName='" + vanueName + '\'' +
                ", vanuePhoto='" + vanuePhoto + '\'' +
                ", userName='" + userName + '\'' +
                ", userPhoto='" + userPhoto + '\'' +
                '}';
    }

}