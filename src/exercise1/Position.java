package exercise1;

/** An abstraction representing a location that holds an element. */
public interface Position<E> {
    /** Returns the element stored at this position. */
    E getElement() throws IllegalStateException;
}
