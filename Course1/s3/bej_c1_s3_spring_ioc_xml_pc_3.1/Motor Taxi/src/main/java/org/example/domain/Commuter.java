package org.example.domain;

public class Commuter {
    private int comId;
    private String comName;
    private long comContact;

    public Commuter(int comId, String comName, long comContact) {
        this.comId = comId;
        this.comName = comName;
        this.comContact = comContact;
    }

    public Commuter() {
    }

    public int getComId() {
        return comId;
    }

    public void setComId(int comId) {
        this.comId = comId;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public long getComContact() {
        return comContact;
    }

    public void setComContact(long comContact) {
        this.comContact = comContact;
    }

    @Override
    public String toString() {
        return "Commuter{" +
                "comId=" + comId +
                ", comName='" + comName + '\'' +
                ", comContact=" + comContact +
                '}';
    }
}
