
package com.gamespace.controller.algorithms;

import com.gamespace.model.GameModel;
import java.util.List;

/**
 *
 * @author Ronish Prajapati
 */
public class CustomBinarySearch {
        public GameModel searchByName(String searchValue, List<GameModel> gameList,
            int left, int right) {

        // Base Case
        if (right < left) {
            return null;
        }

        // mid value
        int mid = (left + right) / 2;

        // checks whether searchKey lies on mid point
        if (searchValue.compareToIgnoreCase(gameList.get(mid).getGameName()) == 0) {
            return gameList.get(mid);
        } else if (searchValue.compareToIgnoreCase(gameList.get(mid).getGameName()) < 0) {
            return searchByName(searchValue, gameList, left, mid - 1);
        } else {
            return searchByName(searchValue, gameList, mid + 1, right);
        }

    }
}
