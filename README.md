# Linux_to_Window_Communicator_1
# TigerChat LAN - Spring Boot WebSocket File Sharing & Chat

## 🚀 Overview

TigerChat LAN is a real-time LAN-based chat and file-sharing application built using:

* Java Spring Boot
* WebSocket (STOMP + SockJS)
* HTML5
* CSS3
* JavaScript
* Local Storage

The application allows multiple devices connected to the same network (LAN/WiFi) to communicate instantly.

Users can:

✅ Send text messages

✅ Share images

✅ Share documents

✅ Share videos

✅ Share audio files

✅ View chat history

✅ Upload files up to 50MB

✅ Auto reconnect on connection loss

✅ Fast LAN communication

---

## 🌟 Features

### Real-Time Messaging

* Instant message delivery
* WebSocket communication
* STOMP messaging protocol
* Automatic reconnect

### File Sharing

Supports:

* Images (.jpg, .png, .gif, .webp)
* PDF Documents
* Word Documents
* Excel Files
* PowerPoint Files
* ZIP Archives
* Audio Files
* Video Files
* Any custom file type

### Cross Platform

Works between:

* Linux ↔ Linux
* Linux ↔ Windows
* Linux ↔ MacOS
* Linux ↔ Android
* Linux ↔ iPhone
* Windows ↔ Android
* Windows ↔ MacOS

Any device with a browser can connect.

---

## 🏗 System Architecture

```text
                    ┌──────────────────────┐
                    │     Host Machine     │
                    │  Spring Boot Server  │
                    │   WebSocket Server   │
                    └──────────┬───────────┘
                               │
                   LAN / WiFi Network
                               │
        ┌─────────────┬─────────┼─────────┬─────────────┐
        │             │         │         │             │
        ▼             ▼         ▼         ▼             ▼

 ┌───────────┐ ┌───────────┐ ┌───────────┐ ┌───────────┐
 │ Windows   │ │ Linux     │ │ Android   │ │ MacOS     │
 │ Browser   │ │ Browser   │ │ Browser   │ │ Browser   │
 └─────┬─────┘ └─────┬─────┘ └─────┬─────┘ └─────┬─────┘
       │             │             │             │
       └─────────────┴─────────────┴─────────────┘
                     WebSocket Connection

```

---

## 📂 File Storage

Uploaded files are stored on the Host Machine.

```text
Host Machine
│
├── uploads/
│   ├── image1.png
│   ├── report.pdf
│   ├── video.mp4
│   └── music.mp3
│
└── chat-history
```

Benefits:

* Centralized storage
* Easy backup
* Fast LAN access
* No cloud dependency

---

## 🔄 Communication Flow

```text
User A
  │
  │ Send Message/File
  ▼
Spring Boot WebSocket Server
  │
  │ Broadcast
  ▼
All Connected Clients

```

---

## 💾 Chat History

Messages are stored locally using:

```javascript
localStorage
```

Features:

* Message persistence
* Automatic loading
* Offline viewing
* Fast retrieval

Maximum:

```text
200 Messages
```

---

## 🔌 WebSocket Endpoints

### Connection Endpoint

```text
/chat
```

### Publish Message

```text
/app/sendMessage
```

### Subscribe

```text
/topic/messages
```

---

## 📤 File Upload API

### Upload Endpoint

```text
POST /api/upload
```

Request:

```http
multipart/form-data
```

Parameters:

```text
file
sender
caption
```

Response:

```json
{
  "fileUrl": "/uploads/photo.png",
  "fileName": "photo.png",
  "fileSize": 12045
}
```

---

## 🖥 Running On Linux

### Find Host IP

```bash
hostname -I
```

Example:

```bash
192.168.1.79
```

### Start Spring Boot

```bash
./mvnw spring-boot:run
```

or

```bash
java -jar tigerchat.jar
```

### Access

```text
http://192.168.1.79:8080
```

---

## 🪟 Running On Windows

### Start Server

```cmd
mvnw spring-boot:run
```

or

```cmd
java -jar tigerchat.jar
```

Open browser:

```text
http://localhost:8080
```

---

## 📱 Connect Another Device

Example Host IP:

```text
192.168.1.79
```

Connect from:

### Windows

```text
http://192.168.1.79:8080
```

### Linux

```text
http://192.168.1.79:8080
```

### Android

```text
http://192.168.1.79:8080
```

### MacOS

```text
http://192.168.1.79:8080
```

All devices must be on the same WiFi/LAN.

---

## ⚡ Performance

* Very low latency
* LAN-speed file transfer
* Real-time broadcasting
* No external server required
* No cloud dependency
* Lightweight architecture

---

## 🛡 Security Notes

Recommended for:

* Home networks
* School labs
* College campuses
* Offices
* Local development

For Internet deployment add:

* Spring Security
* HTTPS
* Authentication
* JWT
* File scanning

---

## 🛠 Technology Stack

Backend:

* Java 21+
* Spring Boot
* Spring WebSocket
* STOMP
* SockJS

Frontend:

* HTML5
* CSS3
* JavaScript

Storage:

* Local Storage
* Host File System

Communication:

* TCP/IP
* WebSocket
* HTTP Multipart Upload

---

## 📸 Supported Sharing Types

| Type         | Supported |
| ------------ | --------- |
| Text         | ✅         |
| Images       | ✅         |
| PDF          | ✅         |
| Word         | ✅         |
| Excel        | ✅         |
| ZIP          | ✅         |
| Audio        | ✅         |
| Video        | ✅         |
| Custom Files | ✅         |

---

## 🎯 Use Cases

* Office LAN Messenger
* School Computer Labs
* Local Team Collaboration
* Home Network File Sharing
* Offline Communication
* Local Chat Server
* Development Team Communication

---

## 👨‍💻 Author

Ahmad Shajahan

Mrcode Programming Universe (MPU)

Built with Java Spring Boot, WebSocket, HTML, CSS, and JavaScript.
