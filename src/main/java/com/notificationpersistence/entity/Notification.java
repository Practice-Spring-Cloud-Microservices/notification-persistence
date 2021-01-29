package com.notificationpersistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "sent_at", nullable = false)
    private long sentAt;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "sender_id", nullable = false)
    private String senderId;

    @Column(name = "recipient_uids")
    private String recipientUids;

    @Column(name = "recipient_emails")
    private String recipientEmails;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "message", length = 4096, nullable = false)
    private String message;

    @Column(name = "details", length = 1024)
    private String details;

    public Notification() {
    }

    public Notification(long sentAt, String type, String senderId, String recipientUids, String recipientEmails, String title, String message, String details) {
        this.sentAt = sentAt;
        this.type = type;
        this.senderId = senderId;
        this.recipientUids = recipientUids;
        this.recipientEmails = recipientEmails;
        this.title = title;
        this.message = message;
        this.details = details;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getSentAt() {
        return sentAt;
    }

    public void setSentAt(long sentAt) {
        this.sentAt = sentAt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getRecipientUids() {
        return recipientUids;
    }

    public void setRecipientUids(String recipientUids) {
        this.recipientUids = recipientUids;
    }

    public String getRecipientEmails() {
        return recipientEmails;
    }

    public void setRecipientEmails(String recipientEmails) {
        this.recipientEmails = recipientEmails;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id=" + id +
                ", sentAt=" + sentAt +
                ", type='" + type + '\'' +
                ", senderId='" + senderId + '\'' +
                '}';
    }
}
