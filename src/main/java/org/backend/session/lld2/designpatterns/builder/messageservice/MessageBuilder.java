package org.backend.session.lld2.designpatterns.builder.messageservice;

public class MessageBuilder {

    private MessageType messageType;
    private String content;
    private String sender;
    private String recipient;
    private boolean isDelivered;
    private  long timestamp;


    public MessageBuilder(){}

    public MessageType getMessageType() {
        return messageType;
    }

    public String getContent() {
        return content;
    }

    public String getSender() {
        return sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public boolean isDelivered() {
        return isDelivered;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public MessageBuilder messageType(MessageType messageType){
        this.messageType = messageType;
        return this;
    }

    public MessageBuilder content(String content){
        this.content = content;
        return this;
    }

    public MessageBuilder sender(String sender){
        this.sender = sender;
        return this;
    }

    public MessageBuilder recipient(String recipient){
        this.recipient = recipient;
        return this;
    }

    public MessageBuilder isDelivered(boolean isDelivered){
        this.isDelivered = isDelivered;
        return this;
    }

    public MessageBuilder timestamp(long timestamp){
        this.timestamp = timestamp;
        return this;
    }

    public static MessageBuilder getBuilder(){
        return new MessageBuilder();
    }
}
