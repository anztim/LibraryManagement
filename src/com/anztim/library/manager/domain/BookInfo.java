package com.anztim.library.manager.domain;

import java.sql.Blob;

/**
 * @author anztim
 */
@SuppressWarnings("unused")
public class BookInfo {
    private Integer	infoId;
    private String	isbn;
    private Integer	copies;
    private String	title;
    private String	subtitle;
    private String	originalTitle;
    private String	author;
    private String	translator;
    private String	publish;
    private String	publishDate;
    private Integer	pages;
    private Integer	price;
    private String	binding;
    private String	series;
    private String	doubanId;
    private String	bookIntro;
    private String	authorIntro;
    private byte[] cover;

    public BookInfo() {
    }

    public Integer getInfoId() {
        return infoId;
    }

    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getCopies() {
        return copies;
    }

    public void setCopies(Integer copies) {
        this.copies = copies;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getBinding() {
        return binding;
    }

    public void setBinding(String binding) {
        this.binding = binding;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getDoubanId() {
        return doubanId;
    }

    public void setDoubanId(String doubanId) {
        this.doubanId = doubanId;
    }

    public String getBookIntro() {
        return bookIntro;
    }

    public void setBookIntro(String bookIntro) {
        this.bookIntro = bookIntro;
    }

    public String getAuthorIntro() {
        return authorIntro;
    }

    public void setAuthorIntro(String authorIntro) {
        this.authorIntro = authorIntro;
    }

    public byte[] getCover() {
        return cover;
    }

    public void setCover(byte[] cover) {
        this.cover = cover;
    }
}
