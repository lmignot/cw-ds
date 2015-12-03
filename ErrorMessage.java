public enum ErrorMessage {
    /**
     * No error. 
     */
    NO_ERROR,
   
    /**
     * This error is produced e.g. when the programmer tries to
     * retrieve an element from an empty data structure.
     */
    EMPTY_STRUCTURE,

    /**
     * This error is produced e.g. when the programmer tries to
     * insert an element on a negative index of a list. 
     */

    INDEX_OUT_OF_BOUNDS,

    /**
     * This error is produced e.g. when the programmer tries to insert
     * a null element in a list that does not allow null elements.
     */
    INVALID_ARGUMENT;
}
