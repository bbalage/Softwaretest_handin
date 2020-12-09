package com.softwaretest.retrogameshop.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotNull
    private String title;
    private Integer releaseYear;
    private String genre;
    private Integer price;
    @ManyToMany
    @JoinTable(
            name = "purchases",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id")
    )
    private List<Customer> purchases;

    //constructors, getters and setters...

    public Game(){
        super();
    }

    public Game(String title, Integer releaseYear, String genre, Integer price){
        this.title = title;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (!obj.getClass().getCanonicalName().equals(this.getClass().getCanonicalName())){
            return false;
        }
        else{
            Game game = (Game) obj;
            if(
                game.getGenre().equals(this.genre) &&
                game.getReleaseYear().equals(this.getReleaseYear()) &&
                game.getTitle().equals(this.getTitle()) &&
                game.getPrice().equals(this.getPrice())
            ){
                return true;
            }
        }
        return false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Customer> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Customer> purchases) {
        this.purchases = purchases;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
