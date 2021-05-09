package com.mahim.jokesapp;

public class FakeDataSource {
    private String user;
    private String password;
    private String dbUrl;

    public FakeDataSource() {
    }

    public FakeDataSource(String user, String password, String dbUrl) {
        this.user = user;
        this.password = password;
        this.dbUrl = dbUrl;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    @Override
    public String toString() {
        return "FakeDataSource{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", dbUrl='" + dbUrl + '\'' +
                '}';
    }
}
