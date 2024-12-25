
package com.gamespace.model;

import java.util.ArrayList;

/**
 *
 * @author Ronish Prajapati
 * LMU ID: 23048584
 */
public class GameModel {
    private int gameNum;
    private String gameName;
    private String mainDevelopers;
    private String publishers;
    private String platform;
    private String releasedDate;
    private String genres;
    private int rating;
    private String price;
    private String link;

    public GameModel(int gameNum, String gameName, String mainDevelopers, String publishers, String platform, String releasedDate, String genres, int rating,String price, String link) {
        this.gameNum = gameNum;
        this.gameName = gameName;
        this.mainDevelopers = mainDevelopers;
        this.publishers = publishers;
        this.platform = platform;
        this.releasedDate = releasedDate;
        this.genres = genres;
        this.rating = rating;
        this.price = price;
        this.link = link;
    }

    public int getGameNum() {
        return gameNum;
    }

    public void setGameNum(int gameNum) {
        this.gameNum = gameNum;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getMainDevelopers() {
        return mainDevelopers;
    }

    public void setMainDevelopers(String mainDevelopers) {
        this.mainDevelopers = mainDevelopers;
    }

    public String getPublishers() {
        return publishers;
    }

    public void setPublishers(String publishers) {
        this.publishers = publishers;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getReleasedDate() {
        return releasedDate;
    }

    public void setReleasedDate(String releasedDate) {
        this.releasedDate = releasedDate;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
    
    public String getPrice(){
        return price;
    }
    
    public void setPrice(String price){
        this.price = price;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

}

