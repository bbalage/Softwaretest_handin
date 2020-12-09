package com.softwaretest.retrogameshop.controllers.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class DTOGame {
    private Long id;
    @NotBlank
    private String title;
    private Integer releaseYear;
    private String genre;
    private Integer price;
    List<Long> customerIds;

    public DTOGame(){
        super();
    }

    public DTOGame(Long id, String title, Integer releaseYear, String genre, Integer price, List<Long> customerIds){
        this.id = id;
        this.title = title;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.customerIds = customerIds;
        this.price = price;
    }

    public DTOGame(Long id, String title, Integer releaseYear, String genre, Integer price){
        this.id = id;
        this.title = title;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.price = price;
    }

    public DTOGame(String title, Integer releaseYear, String genre, Integer price){
        this.title = title;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.price = price;
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

    public List<Long> getCustomerIds(){
        return customerIds;
    }

    public void setCustomerIds(List<Long> customerIds){
        this.customerIds = customerIds;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
