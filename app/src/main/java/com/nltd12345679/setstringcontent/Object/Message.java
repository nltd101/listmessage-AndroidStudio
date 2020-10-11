package com.nltd12345679.setstringcontent.Object;

public class Message {

    private String Content;
    private String Sender;
    private String Receiver;
    private int AvtSender;

    public Message(int AvtSender,String content, String sender, String receiver) {
        this.AvtSender=AvtSender;
        this.Content = content;
        this.Sender = sender;
        this.Receiver = receiver;
    }

    public int getAvtSender() {
        return AvtSender;
    }

    public String getSender() {
        return Sender;
    }

    public String getContent() {
        return Content;
    }


}
