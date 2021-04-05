package com.example.autobice.Models;

public class MessageData {
    //    "MessageData": {
    //        "Email": "lama@g1.com",
    //        "Id": 8,
    //        "Name": "lama alzoubi",
    //        "UserType": 2
    //    }
    private  String Email;
    private int Id;
    private String Name;
    private int UserType;

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getUserType() {
        return UserType;
    }

    public void setUserType(int userType) {
        UserType = userType;
    }

    public MessageData() {
    }

    public MessageData(String email, int id, String name, int userType) {
        Email = email;
        Id = id;
        Name = name;
        UserType = userType;
    }
}
