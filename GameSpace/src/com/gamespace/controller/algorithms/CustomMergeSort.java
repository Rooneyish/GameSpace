package com.gamespace.controller.algorithms;

import com.gamespace.model.GameModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ronish Prajapati 
 * LMU ID: 23048584
 */
public class CustomMergeSort {

    private List<GameModel> sortList;// Internal storae for the sorted list
    private String sortBy;// option to sort

    /**
     * Constructs a CustomMergeSort that initializes sort list and sort by option
     * 
     */
    public CustomMergeSort() {
        this.sortList = new ArrayList<>();
        this.sortBy = "";
    }

    /**
     * Sorts game using recursion.
     * 
     * @param sortList the list to sort
     * @param dataList type of the dataList
     * @param isDesc value to sort in ascending or descending order
     * 
     * @return the sorted list
     */
    public List<GameModel> sortGames(List<GameModel> sortList, String dataList, boolean isDesc) {

        if (sortList == null || sortList.size() <= 1) {
            return sortList;
        }

        int firstLength = sortList.size() / 2;

        List<GameModel> first = new ArrayList<>(sortList.subList(0, firstLength));
        List<GameModel> second = new ArrayList<>(sortList.subList(firstLength, sortList.size()));

        first = sortGames(first, dataList, isDesc);
        second = sortGames(second, dataList, isDesc);
        merge(first, second, sortList, dataList, isDesc);
        return sortList;
    }

    /**
     * Combines the list of single element to a single sorted list
     * 
     * @param first first half of the list
     * @param second second half of the list
     * @param sortList the sorted list
     * @param dataList type of the dataList
     * @param isDesc value to sort in ascending or descending order
     */
    public void merge(List<GameModel> first, List<GameModel> second, List<GameModel> sortList, String dataList, boolean isDesc) {
        int fCounter = 0;
        int sCounter = 0;

        sortList.clear();

        while (fCounter < first.size() && sCounter < second.size()) {
            if ((compare(first.get(fCounter), second.get(sCounter), dataList) < 0)^isDesc) {
                sortList.add(first.get(fCounter));
                fCounter++;
            } else {
                sortList.add(second.get(sCounter));
                sCounter++;
            }
        }

        while (fCounter < first.size()) {
            sortList.add(first.get(fCounter));
            fCounter++;
        }

        while (sCounter < second.size()) {
            sortList.add(second.get(sCounter));
            sCounter++;
        }
    }

    /**
     * Compares the data list 
     * 
     * @param  first first half of the list
     * @param second second half of the list
     * @param dataList type of dataList
     * @return a negative integer, zero, or a positive integer as the
     *          specified String is greater than, equal to, or less
     *          than this String, ignoring case considerations. 
     */
    public int compare(GameModel first, GameModel second, String dataList) {
        switch (dataList) {
            case "gameTitle":
                return first.getGameName().compareToIgnoreCase(second.getGameName());
            case "gameNum":
                int gameNum1 = first.getGameNum();
                int gameNum2 = second.getGameNum();
                if (gameNum1 < gameNum2) {
                    return -1;
                } else if (gameNum1 > gameNum2) {
                    return 1;
                } else {
                    return 0;
                }
            case "releasedDate":
                return first.getReleasedDate().compareToIgnoreCase(second.getReleasedDate());
            case "rating":
                return Integer.compare(first.getRating(), second.getRating());
            case "price":
                String price1 = first.getPrice();
                String price2 = second.getPrice();
                if (price1.equalsIgnoreCase("Free") && price2.equalsIgnoreCase("Free")) {
                    return 0;
                } else if (price1.equalsIgnoreCase("Free")) {
                    return -1;
                } else if (price2.equalsIgnoreCase("Free")) {
                    return 1;
                } else {
                    try {
                        Double priceVal1 = Double.valueOf(price1.replace("$", ""));
                        Double priceVal2 = Double.valueOf(price2.replace("$", ""));
                        return Double.compare(priceVal1, priceVal2);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("Invalid price format: " + price1 + " or " + price2);
                    }
                }

            default:
                throw new IllegalArgumentException("Invalid soring dataList: " + dataList);
        }
    }
}
