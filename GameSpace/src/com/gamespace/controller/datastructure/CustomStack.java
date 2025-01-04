
package com.gamespace.controller.datastructure;

import com.collegeapp.model.StudentModel;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * <b>Custom implementation of a stack data structure for managing StudentModel objects.
 * This stack is implemented using a LinkedList and supports basic operations 
 * like push, poop, poll, and peek</b>
 * 
 * <p>Features include:</p>
 * <ul>
 *      <li> Capacity limit for the stack.</li>
 *      <li>Ability to check if the stack is empty or full.</li>
 * </ul>
 * 
 * <p>Note: This implementation assumes that the stack operations are not accessed concurrently.</p>
 * @author Ronish Prajapati
 */
public class CustomStack {
    
    private LinkedList<StudentModel> stackList; //Internal storage for the stack.
    private int capacity; //Maximum number of elements the stack can hold.
    
    
    /**
    * Constructs a CustomStack with the specified capacity.
    * 
    * @param capacity the maximum number of elements the stack can hold.
    * @throws IllegalArgumentException if the specified capacity is negative.
    */
    public CustomStack(int capacity){
        if(capacity <=0){
            throw new IllegalArgumentException("Capacity must be greater than zero");
        }
        stackList=new LinkedList<>();
        this.capacity=capacity;
    }
    
    /**
     * Adds a new element to the end of the stack if it is not full.
     * 
     * @param studentModel the StudentModel to be added to the stack.
     * @return the current size of the stack after the operation, or -1 if the stack is full.
     */
    public int push(StudentModel studentModel){
        if(isFull()){
            return -1;
        }
        stackList.addLast(studentModel);
        return poll();
    }
    
    /**
     * Removes and returns the last element from the stack.
     * 
     * @return the last StudentModel in the queue, or null if the stack is empty.
     * @throws IllegalStateException if the queue is empty.
     */
    public StudentModel pop(){
        if(isEmpty()){
            throw new NoSuchElementException("Cannon pop from an empty stack");
        }
        return stackList.removeLast();
    }
    
    /**
     * Checks if the stack is Empty or not.
     * 
     * @return true if the stack contains no elements, false otherwise.
     */
    public boolean isEmpty(){
        return stackList.isEmpty();
    }
    
    /**
     * Checks if the stack is Full or not.
     * @return true if the stack has reached its capacity, false otherwise.
     */
    public boolean isFull(){
        return stackList.size()==capacity;
    }
    
    /**
     * Retrieves, but does not remove, the last element of the stack.
     * 
     * @return the last StudentModel in the stack, or null if the stack is empty.
     * @throws IllegalStateException if the queue is empty.
     */
    public StudentModel peek(){
        try{
            return stackList.getLast();
        }catch(NoSuchElementException ex){
            throw new NoSuchElementException("Cannot peek into an empty stack.");
        }
    }
    
    /**
     * Returns the current size of the queue.
     * 
     * @return the number of elements in the stack.
     */
    public int poll(){
        return stackList.size();
    }
}
