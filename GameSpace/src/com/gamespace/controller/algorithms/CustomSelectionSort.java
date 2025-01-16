package com.gamespace.controller.algorithms;

import com.gamespace.model.GameModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ronish Prajapati
 */
public class CustomSelectionSort {
    private List<GameModel> gameSortedList;
    
    public CustomSelectionSort(){
        gameSortedList = new ArrayList<>();
    }
    /**
     * Sorts a list of GameModel objects by their properties in ascending or
     * descending order.
     *
     * @param gameList the list of GameModel objects to be sorted
     * @param isDesc specifies the sort order (true for descending, false for
     * ascending)
     * @return the sorted list
     */
    public List<GameModel> sortByGameName(List<GameModel> gameList, boolean isDesc){
        this.gameSortedList.clear();
        this.gameSortedList.addAll(gameList);
        if (gameSortedList == null || gameSortedList.isEmpty()){
            throw new IllegalArgumentException("Game list cannot be null or empty.");
        }
        
        for(int i = 0; i<gameSortedList.size()-1; i++){
            int extremumIndex= findExtremumIndex(gameSortedList, i , isDesc);
            if(i != extremumIndex){
                swap(gameSortedList, i ,extremumIndex);
            }
        }
        return gameSortedList;
    }
    
    /**
     * Finds the index of the extremum value (minimum or maximum) in the list
     * from the start index.
     *
     * @param gameList the list of GameModel objects
     * @param startIndex the index to start searching from
     * @param isDesc specifies whether to find the maximum (true) or minimum
     * (false)
     * @return the index of the extremum value
     */
    private int findExtremumIndex(List<GameModel> gameSortedList, int startIndex, boolean isDesc) {
        int extremumIndex = startIndex;

        for (int j = startIndex + 1; j < gameSortedList.size(); j++) {
            if (shouldSwap(gameSortedList.get(j).getGameName(), gameSortedList.get(extremumIndex).getGameName(), isDesc)) {
                extremumIndex = j;
            }
        }

        return extremumIndex;
    }

    /**
     * Determines whether the current value should replace the current extremum
     * based on sort order.
     *
     * @param current the current value
     * @param extremum the current extremum value
     * @param isDesc specifies the sort order (true for descending, false for
     * ascending)
     * @return true if the current value should replace the extremum; false
     * otherwise
     */
    private boolean shouldSwap(String current, String extremum, boolean isDesc) {
        int compare= current.compareToIgnoreCase(extremum);
        return isDesc?compare>0:compare<0;
    }

    /**
     * Swaps two elements in the list.
     *
     * @param gameList the list of GameModel objects
     * @param i the index of the first element
     * @param j the index of the second element
     */
    private void swap(List<GameModel> gameSortedList, int i, int j) {
        GameModel temp = gameSortedList.get(i);
        gameSortedList.set(i, gameSortedList.get(j));
        gameSortedList.set(j, temp);
    }
}
