package com.appnd.masterdetail.model;

import java.util.Date;

public class BookItem {
    private int identifier;
    private String title;
    private String author;
    private Date publicationDate;
    private String description;
    private String urlCover;

    public BookItem(int identifier, String title, String author, Date publicationDate, String description, String urlCover) {
        this.identifier = identifier;
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
        this.description = description;
        this.urlCover = urlCover;
    }

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlCover() {
        return urlCover;
    }

    public void setUrlCover(String urlCover) {
        this.urlCover = urlCover;
    }
}
