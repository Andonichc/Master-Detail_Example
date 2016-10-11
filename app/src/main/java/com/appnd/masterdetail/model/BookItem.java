package com.appnd.masterdetail.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class BookItem implements Parcelable {
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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.identifier);
        dest.writeString(this.title);
        dest.writeString(this.author);
        dest.writeLong(this.publicationDate != null ? this.publicationDate.getTime() : -1);
        dest.writeString(this.description);
        dest.writeString(this.urlCover);
    }

    protected BookItem(Parcel in) {
        this.identifier = in.readInt();
        this.title = in.readString();
        this.author = in.readString();
        long tmpPublicationDate = in.readLong();
        this.publicationDate = tmpPublicationDate == -1 ? null : new Date(tmpPublicationDate);
        this.description = in.readString();
        this.urlCover = in.readString();
    }

    public static final Parcelable.Creator<BookItem> CREATOR = new Parcelable.Creator<BookItem>() {
        @Override
        public BookItem createFromParcel(Parcel source) {
            return new BookItem(source);
        }

        @Override
        public BookItem[] newArray(int size) {
            return new BookItem[size];
        }
    };
}
