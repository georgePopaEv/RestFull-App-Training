package com.RestFull.example.RestfullWebservices.versioning;

public class Name {
    private String fistname;
    private String lastname;

    public Name() {
    }

    public Name(String fistname, String lastname) {
        this.fistname = fistname;
        this.lastname = lastname;
    }

    public String getFistname() {
        return fistname;
    }

    public void setFistname(String fistname) {
        this.fistname = fistname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
