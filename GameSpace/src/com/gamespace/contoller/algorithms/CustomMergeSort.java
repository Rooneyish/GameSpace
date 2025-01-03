package com.gamespace.contoller.algorithms;

import com.gamespace.model.GameModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ronish Prajapati
 * LMU ID: 23048584
 */
public class CustomMergeSort {
    private List<GameModel> sortList;
    private String sortBy;
    
    public CustomMergeSort(){
        this.sortList = new ArrayList<>();
        this.sortBy=sortBy;
    }
    
    public List<GameModel> sortGames(List<GameModel> sortList){
        
        if(sortList==null||sortList.size()<=1){
            return sortList;
        }
        
        int firstLength=sortList.size()/2;
        
        List<GameModel> first= new ArrayList<GameModel>(sortList.subList(0, firstLength));
        List<GameModel> second= new ArrayList<GameModel>(sortList.subList(firstLength, sortList.size()));
        
        first = sortGames(first);
        second = sortGames(second);
        merge(first,second,sortList);
        return sortList;
    }
    
    public void merge(List<GameModel> first, List<GameModel> second, List<GameModel> sortList){
        int fCounter=0;
        int sCounter=0;
        
        sortList.clear();
        
        while(fCounter<first.size()&&sCounter<second.size()){
            if (first.get(fCounter).getGameName().compareTo(second.get(sCounter).getGameName())<0) {
                sortList.add(first.get(fCounter));
                fCounter++;
            }else{
                sortList.add(second.get(sCounter));
                sCounter++;
            }
        }
        
        while (fCounter<first.size()) {
            sortList.add(first.get(fCounter));
            fCounter++;
        }
        
        while (sCounter<second.size()) {
            sortList.add(second.get(sCounter));
            sCounter++;
        }
    }
    
    public compare 
}
