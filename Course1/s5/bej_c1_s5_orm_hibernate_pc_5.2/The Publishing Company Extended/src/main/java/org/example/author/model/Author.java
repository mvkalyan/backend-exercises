package org.example.author.model;

import javax.persistence.*;

@Entity
@Table(name = "AUTHOR")
public class Author {
    @Id
    @GeneratedValue
    private int authId;
    @Column(name = "AUTHOR_NAME")
    private String authName;
    @Column(name = "AUTHOR_FAMOUS")
    private String authFam;

    public Author() {
    }

    public Author(int authId, String authName, String authFam) {
        this.authId = authId;
        this.authName = authName;
        this.authFam = authFam;
    }

    public int getAuthId() {
        return authId;
    }

    public void setAuthId(int authId) {
        this.authId = authId;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    public String getAuthFam() {
        return authFam;
    }

    public void setAuthFam(String authFam) {
        this.authFam = authFam;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authId=" + authId +
                ", authName='" + authName + '\'' +
                ", authFam='" + authFam + '\'' +
                '}';
    }
}
