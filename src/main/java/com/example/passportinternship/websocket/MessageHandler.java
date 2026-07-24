package com.example.passportinternship.websocket;

import com.example.passportinternship.job.TransactionJobLauncher;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;


@Component
public class MessageHandler extends TextWebSocketHandler {

    private final TransactionJobLauncher transactionJobLauncher;

    public MessageHandler(TransactionJobLauncher transactionJobLauncher) {
        this.transactionJobLauncher = transactionJobLauncher;
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println("Server received: " + message.getPayload());
        session.sendMessage(new TextMessage("Server reply: " + message.getPayload()));

//             newly added
        transactionJobLauncher.runTransJob();

    }

}
