package com.example.tell.entity;

import android.widget.TextView;

import java.io.Serializable;
import java.sql.Time;

public class Email implements Serializable {
    private int id;
    private String fro;
    private String sendto;
    private String detail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFro() {
        return fro;
    }

    public void setFro(String fro) {
        this.fro = fro;
    }

    public String getSendto() {
        return sendto;
    }

    public void setSendto(String sendto) {
        this.sendto = sendto;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}

