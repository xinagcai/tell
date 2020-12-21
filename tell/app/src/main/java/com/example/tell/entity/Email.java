package com.example.tell.entity;

import java.sql.Time;

public class Email {
    private User fro;
    private User sendto;
    private String detail;
    private Email next;
    private Email pre;

    public User getFro() {
        return fro;
    }

    public void setFro(User fro) {
        this.fro = fro;
    }

    public User getSendto() {
        return sendto;
    }

    public void setSendto(User sendto) {
        this.sendto = sendto;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Email getNext() {
        return next;
    }

    public void setNext(Email next) {
        this.next = next;
    }

    public Email getPre() {
        return pre;
    }

    public void setPre(Email pre) {
        this.pre = pre;
    }

}

