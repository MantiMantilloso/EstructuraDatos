package ADT;

public interface Position <E>{
    /*
    *Returns the element stored at this position.
    *
    * @return the stored element
    * @throws IllegalStateException
     */
    E getElement() throws IllegalStateException;
}
