package com.chat.App.controller;

import com.chat.App.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Controller
public class ChatController {

    // Receives from /app/sendMessage → broadcasts to /topic/messages ->
    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public ChatMessage sendMessage(ChatMessage message) {
        // Reject completely empty messages (no text, no file)
        boolean hasContent = message.getContent() != null && !message.getContent().trim().isEmpty();
        boolean hasFile = message.getFileUrl() != null && !message.getFileUrl().isEmpty();

        if (!hasContent && !hasFile) {
            return null;
        }

        if (message.getContent() != null) {
            message.setContent(message.getContent().trim());
        }

        // Stamp server time
        message.setTime(LocalDateTime.now());

        return message;
    }



    // Serve the chat page
    @GetMapping("/chat")
    public String chat() {
        return "chat";
    }



}