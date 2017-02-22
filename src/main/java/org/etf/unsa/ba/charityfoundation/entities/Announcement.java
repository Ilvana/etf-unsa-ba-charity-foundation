package org.etf.unsa.ba.charityfoundation.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "announcements")
public class Announcement implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String text;

    private Date date;

    private String telephone;

    private Integer account;

    private String picture;

    public Announcement(String text, Date date, String telephone, Integer account, String picture) {
        this.text = text;
        this.date = date;
        this.telephone = telephone;
        this.account = account;
        this.picture = picture;
    }

    public Announcement() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getAccount() {
        return account;
    }

    public void setAccount(Integer account) {
        this.account = account;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
