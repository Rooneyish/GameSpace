package com.gamespace.controller.datastructure;

import com.gamespace.model.GameModel;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * <b>Custom implementation of a stack data structure for managing GameModel objects.</b>
 * 
 * <p>Features include:</p>
 * <ul>
 *      <li>Capacity limit for the stack.</li>
 *      <li>Ability to check if the stack is empty or full.</li>
 * </ul>
 * 
 * <p>Note: This implementation assumes that the stack operations are not accessed concurrently.</p>
 * 
 * @author Ronish Prajapati
 * LMU ID: 23048584
 */
public class CustomStack {

    private LinkedList<GameModel> stackList; // Internal storage for the stack
    private int capacity; // Maximum number of elements the stack can hold

    /**
     * Constructs a CustomStack with the specified capacity.
     * 
     * @param capacity the maximum number of elements the stack can hold.
     * @throws IllegalArgumentException if the specified capacity is negative.
     */
    public CustomStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than zero");
        }
        stackList = new LinkedList<>();
        this.capacity = capacity;
    }

    /**
     * Adds a new element to the end of the stack if it is not full.
     * 
     * @param gameModel the GameModel to be added to the stack.
     * @throws IllegalStateException if the stack is full.
     */
    public void push(GameModel gameModel) {
        if (isFull()) {
            throw new IllegalStateException("Cannot push to a full stack");
        }
        stackList.addLast(gameModel);
    }

    /**
     * Removes and returns the last element from the stack.
     * 
     * @return the last GameModel in the stack.
     * @throws NoSuchElementException if the stack is empty.
     */
    public GameModel pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot pop from an empty stack");
        }
        return stackList.removeLast();
    }

    /**
     * Checks if the stack is empty.
     * 
     * @return true if the stack contains no elements, false otherwise.
     */
    public boolean isEmpty() {
        return stackList.isEmpty();
    }

    /**
     * Checks if the stack is full.
     * 
     * @return true if the stack has reached its capacity, false otherwise.
     */
    public boolean isFull() {
        return stackList.size() == capacity;
    }

    /**
     * Retrieves, but does not remove, the last element of the stack.
     * 
     * @return the last GameModel in the stack.
     * @throws NoSuchElementException if the stack is empty.
     */
    public GameModel peek() {
        return stackList.getLast();
    }

    /**
     * Returns the current size of the stack.
     * 
     * @return the number of elements in the stack.
     */
    public int size() {
        return stackList.size();
    }
}
