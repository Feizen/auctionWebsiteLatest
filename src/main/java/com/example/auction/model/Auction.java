package com.example.auction.model;

import javax.persistence.*;


@Entity
public class Auction {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String rating;
    private double price;
    private String category;
    private String description;

    private String name;
    private String tag;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User author;

    public String getAuthorName(){
        return  author !=null ? author.getUsername() : "<none>";
    }

    public Auction(){
    }

    public Auction(String name, String category, String description, double price, String tag, User author) {
        this.price = price;
        this.category = category;
        this.description = description;
        this.name = name;
        this.tag = tag;
        this.author = author;
    }

//    public Auction(String name, String tag, User user) {
//        this.author = user;
//        this.name = name;
//        this.tag = tag;
//    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
