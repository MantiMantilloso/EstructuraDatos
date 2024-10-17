package ADT;

public interface Stack <E>{
    int size(); //Returns number of elements in the stack

    boolean isEmpty();// Tests whether the stack is empty

    E top();// Returns and does not remove the element at the top of the stack

    void push(E element); // Inserts a parameter E at the top of the stack

    E pop(); // Removes the element at the top of the stack
}
