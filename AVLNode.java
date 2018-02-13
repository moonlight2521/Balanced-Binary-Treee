/**
 * Zun Lin
 * CMSC 256 Spring 2017
 * Programming Project 5
 * Java Keyword Identifier
 * AVLNode
 * this file is from blackboard I didn't write this file.
 */
// Basic node stored in AVL trees

class AVLNode<T extends Comparable<? super T>> {

    public AVLNode(T theElement)  {
        this( theElement, null, null );
    }

    public AVLNode(T theElement, AVLNode<T> lt, AVLNode<T> rt ) {
        element  = theElement;
        left     = lt;
        right    = rt;
        height   = 0;
    }

    T element;
    AVLNode<T> left;
    AVLNode<T> right;
    int height;
}
