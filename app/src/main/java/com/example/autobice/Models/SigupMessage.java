package com.example.autobice.Models;

import com.google.gson.annotations.SerializedName;

public class SigupMessage {
    private  int Code;
    private String Message;
    @SerializedName("MessageData")
    public   MessageData messageData;

    public MessageData getMessageData() {
        return messageData;
    }

    public void setMessageData(MessageData messageData) {
        this.messageData = messageData;
    }

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }


    //{
    //    "Code": 200,
    //    "Message": "User Created",
    //    "MessageData": {
    //        "Email": "lama@g1.com",
    //        "Id": 8,
    //        "Name": "lama alzoubi",
    //        "UserType": 2
    //    }
    //}
}
