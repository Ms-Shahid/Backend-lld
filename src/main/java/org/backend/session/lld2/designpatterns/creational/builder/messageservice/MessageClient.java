package org.backend.session.lld2.designpatterns.builder.messageservice;

public class MessageClient {

    public static void main(String[] args) {

        MessageBuilder message = MessageBuilder.getBuilder().messageType(MessageType.AUDIO)
                .content("Alan Walker").recipient("Facebook").sender("Person").isDelivered(true);

//        Message msg = new Message(message);
    }
}
