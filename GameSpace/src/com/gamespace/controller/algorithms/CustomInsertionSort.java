package com.gamespace.controller.algorithms;

import com.gamespace.model.GameModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ronish Prajapati 
 * LMU ID: 23048584
 */
public class CustomInsertionSort {
    private List<GameModel> gameSortedList;
    public CustomInsertionSort(){
        gameSortedList = new ArrayList<>();
    }
    
    
    /**
     * Sorts a list of GameModel objects by their GameNum in ascending or descending order.
     * 
     * @param gameList the list of GameModel objects to be sorted
     * @param isDesc specifies the sort order (true for descending, false for ascending)
     * @return the sorted list
    */
    public List<GameModel> sortByGameNum(List<GameModel> gameList, boolean isDesc){
        this.gameSortedList.clear();
        this.gameSortedList.addAll(gameList);
        if (gameSortedList == null || gameSortedList.isEmpty()){
            throw new IllegalArgumentException("Game list cannot be null or empty.");
        }
        
        for(int i = 1; i < gameSortedList.size();i++){
            GameModel key = gameSortedList.get(i);
            int keyNum = key.getGameNum();
            int j = i-1;
            
            while (j >= 0 && shouldSwap(gameSortedList.get(j).getGameNum(),keyNum,isDesc)){
            gameSortedList.set(j+1, gameSortedList.get(j));
            j--;
        }
            gameSortedList.set(j+1, key);
        }
        return gameSortedList;
    }
    
    /**
     * Determines whether two elements should be rearranged based on the sorting order
     * 
     * @param currentNum the current index 
     * @param keyNum the index of element being inserted int the sorted part
     * @param isDesc specifies the sort order (true for descending, false for ascending)
     * 
     * @return true if the values should rearranged and false if not
     * 
     * 
    */
    private boolean shouldSwap(int currentNum, int keyNum, boolean isDesc){
        return isDesc? currentNum < keyNum: currentNum>keyNum;
    }
}
