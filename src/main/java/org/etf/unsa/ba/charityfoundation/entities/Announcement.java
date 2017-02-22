package org.etf.unsa.ba.charityfoundation.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "announcements")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Announcement implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String text;

    private Date date;

    private String telephone;

    private Integer account;

    private String picture;

    @OneToMany(mappedBy = "announcement", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Comment> comments;

    public Announcement() {
    }

    public Announcement(String text, Date date, String telephone, Integer account, String picture, List<Comment> comments) {
        this.text = text;
        this.date = date;
        this.telephone = telephone;
        this.account = account;
        this.picture = picture;
        this.comments = comments;
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

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Announcement{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", date=" + date +
                ", telephone='" + telephone + '\'' +
                ", account=" + account +
                ", picture='" + picture + '\'' +
                ", comments=" + comments +
                '}';
    }
}
