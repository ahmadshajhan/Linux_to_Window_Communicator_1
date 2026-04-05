package com.chat.App.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

@RestController
@RequestMapping("/api")
public class FileUploadController {

    // Folder where files are saved — configure in application.properties
    @Value("${upload.dir:uploads}")
    private String uploadDir;

    @PostMapping("/upload")
    public ResponseEntity<Map<String, Object>> uploadFile(
            @RequestParam("file") MultipartFile file,
            @RequestParam(value = "sender", defaultValue = "Unknown") String sender,
            @RequestParam(value = "caption", defaultValue = "") String caption
    ) {
        try {
            // Create uploads directory if it doesn't exist
            Path uploadPath = Paths.get(uploadDir);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            // Generate unique filename to avoid conflicts
            String originalName = file.getOriginalFilename();
            String ext = "";
            if (originalName != null && originalName.contains(".")) {
                ext = originalName.substring(originalName.lastIndexOf("."));
            }
            String uniqueName = UUID.randomUUID().toString() + ext;

            // Save the file
            Path filePath = uploadPath.resolve(uniqueName);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            // Return file info
            Map<String, Object> response = new HashMap<>();
            response.put("fileUrl", "/uploads/" + uniqueName);
            response.put("fileName", originalName);
            response.put("fileSize", file.getSize());
            response.put("sender", sender);
            response.put("caption", caption);

            return ResponseEntity.ok(response);

        } catch (IOException e) {
            Map<String, Object> error = new HashMap<>();
            error.put("error", "Upload failed: " + e.getMessage());
            return ResponseEntity.status(500).body(error);
        }
    }
}