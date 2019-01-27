package node;

/**
 *
 * @param <T>:this is the type of the object Node
 */
public class Node<T> {
    private double priority;
    private T element;

    /**
     *
     * this is the default constructor
     */
    public Node(){
        this.element = null;
        this.priority = 0;
    }//Node

    /**
     * this is the second type of constructor
     * @param priority: this is the priority of the element
     * @param element: this is the element of the Node
     */
    public Node(double priority, T element){
        this.priority = priority;
        this.element = element;
    }//Node

    /**
     *
     * @return: this method returns the priority of the calling object
     */
    public double getPr(){
        return priority;
    }//getPr

    /**
     *
     * @return: this method returns the element of the calling object
     */
    public T getElem(){
        return element;
    }//getElem

    /**
     * this method changes the priority of the caller object
     * @param pr: this is the new priority of the object
     */
    public void setPr(double pr) { this.priority = pr; }//setPr

    /**
     * this method changes the element of the caller object
     * @param elem: this is the new elem of the object
     */
    public void setElem(T elem) { this.element = elem; }//setElem

    /**
     * this method compare the priority between two object
     * @param node2: this is the object which compare the calling object
     * @return: this method returns true if the calling object has a priority greater respect the second object
     */
    public boolean compareTo(Node node2){
        if (this.getPr() > node2.getPr())
            return true;
        else
            return false;
    }//compareTo

}//class
