package org.example.domain;

public class Author {
    private String authName;
    private int authId;

    public Author(String authName, int authId) {
        this.authName = authName;
        this.authId = authId;
    }

    public Author() {
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    public int getAuthId() {
        return authId;
    }

    public void setAuthId(int authId) {
        this.authId = authId;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authName='" + authName + '\'' +
                ", authId=" + authId +
                '}';
    }
}
