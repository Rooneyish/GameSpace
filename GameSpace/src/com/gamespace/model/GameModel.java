
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
    private ArrayList<String> mainDevelopers;
    private String publishers;
    private String releasedDate;
    private ArrayList<String> genres;
    private double rating;
    private String link;
    
    public GameModel(){
        mainDevelopers=new ArrayList<>();
        genres= new ArrayList<>();
    }

    public GameModel(int gameNum, String gameName, ArrayList<String> mainDevelopers, String publishers, String releasedDate, ArrayList<String> genres, double rating, String link) {
        this.gameNum = gameNum;
        this.gameName = gameName;
        this.mainDevelopers = mainDevelopers != null? new ArrayList<>(mainDevelopers):new ArrayList<>();
        this.publishers = publishers;
        this.releasedDate = releasedDate;
        this.genres = genres != null? new ArrayList<>(genres):new ArrayList<>();
        this.rating = rating;
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

    public ArrayList<String> getMainDevelopers() {
        return mainDevelopers;
    }

    public void setMainDevelopers(ArrayList<String> mainDevelopers) {
        this.mainDevelopers = mainDevelopers != null? new ArrayList<>(mainDevelopers):new ArrayList<>();
    }

    public String getPublishers() {
        return publishers;
    }

    public void setPublishers(String publishers) {
        this.publishers = publishers;
    }

    public String getReleasedDate() {
        return releasedDate;
    }

    public void setReleasedDate(String releasedDate) {
        this.releasedDate = releasedDate;
    }

    public ArrayList<String> getGenres() {
        return genres != null? new ArrayList<>(genres):new ArrayList<>();
    }

    public void setGenres(ArrayList<String> genres) {
        this.genres = genres;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    
    
}



