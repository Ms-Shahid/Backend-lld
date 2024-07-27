package org.backend.session.lld2.designpatterns.builder.messageservice;

public class Message {


    private MessageType messageType;
    private String content;
    private String sender;
    private String recipient;
    private boolean isDelivered;
    private  long timeStamp;

    private Message(MessageBuilder messageBuilder){
        this.messageType = messageBuilder.getMessageType();
        this.content = messageBuilder.getContent();
        this.recipient = messageBuilder.getRecipient();
        this.sender = messageBuilder.getSender();
        this.isDelivered = messageBuilder.isDelivered();
        this.timeStamp = messageBuilder.getTimestamp();
    }
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

    public long getTimeStamp() {
        return timeStamp;
    }
}
