package com.chat.App.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessage {
    private Long id;
    private String sender;
    private String content;
    private LocalDateTime time;
    private String type;        // JOIN, CHAT, LEAVE

    // File fields
    private String fileUrl;     // e.g. /uploads/abc123.png
    private String fileName;    // original filename
    private Long fileSize;      // bytes
}