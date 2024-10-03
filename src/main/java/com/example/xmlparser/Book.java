package com.example.xmlparser;

import java.util.List;

public class Book {
    private String id;
    private String title;
    private String author;
    private String year;
    private String genre;
    private String price;
    private String currency;
    private String isbn;
    private String format;
    private Publisher publisher;
    private String language;
    private String translator;
    private List<String> awards;
    private List<Review> reviews;

    // Геттеры и сеттеры для всех атрибутов
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getYear() { return year; }
    public void setYear(String year) { this.year = year; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public String getPrice() { return price; }
    public void setPrice(String price) { this.price = price; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public String getFormat() { return format; }
    public void setFormat(String format) { this.format = format; }

    public Publisher getPublisher() { return publisher; }
    public void setPublisher(Publisher publisher) { this.publisher = publisher; }

    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }

    public String getTranslator() { return translator; }
    public void setTranslator(String translator) { this.translator = translator; }

    public List<String> getAwards() { return awards; }
    public void setAwards(List<String> awards) { this.awards = awards; }

    public List<Review> getReviews() { return reviews; }
    public void setReviews(List<Review> reviews) { this.reviews = reviews; }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year='" + year + '\'' +
                ", genre='" + genre + '\'' +
                ", price='" + price + '\'' +
                ", currency='" + currency + '\'' +
                ", isbn='" + isbn + '\'' +
                ", format='" + format + '\'' +
                ", publisher=" + publisher +
                ", language='" + language + '\'' +
                ", translator='" + translator + '\'' +
                ", awards=" + awards +
                ", reviews=" + reviews +
                '}';
    }
}
