package com.example;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Collectible {
    private String id;
    private String name;
    private String description;
    private Rarity rarity;
    private String type;
    private String image;
    private Date firstSaleDate;
    private String first_sale_date;
    private List<Crate> crates;

    public Date getFirstSaleDate() {
        return firstSaleDate;
    }

    public void setFirstSaleDate(Date firstSaleDate) {
        this.firstSaleDate = firstSaleDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Crate> getCrates() {
        return crates;
    }

    public void setCrates(List<Crate> crates) {
        this.crates = crates;
    }

    public String getFirst_sale_date() {
        return first_sale_date;
    }

    public void setFirst_sale_date(String first_sale_date) {
        this.first_sale_date = first_sale_date;
    }

}
