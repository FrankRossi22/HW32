 
import components.queue.Queue;
import components.queue.QueueKernel;
import components.standard.Standard;
 
/**
 * First-in-first-out (FIFO) waiting line kernel component with primary methods. (Note:
 * by package-wide convention, all references are non-null.)
 *
 * @param <T>
 *            type of {@code WaitingLineKernel} entries
 * @mathmodel type WaitingLineKernel is modeled by queue of T
 * @initially {@code
 * ():
 *  ensures
 *   this = <>
 * }
 * @iterator ~this.seen * ~this.unseen = this
 */
public interface WaitingLineKernel<T> extends QueueKernel<T>, Iterable<T>, Queue<T> {
 
    /**
     * Gets position of {@code x} from {@code this}.
     *
     * @param x
     *            the data at desired position
     * @aliases reference {@code x}
     * @return the position of x in {@code this}
     */
    int linePosition(T x);
    
    /**
     * Removes {@code x} from {@code this}.
     *
     * @param x
     *            the entry to be removed
     * @aliases reference {@code x}
     * @updates this
     * @ensures {@code this = #this * <x>}
     */
    void removeFromLine(T x);
 
    /**
     * Adds {@code x} to the end of {@code this}.
     *
     * @return the entry removed
     * @updates this
     * @requires {@code this /= <>}
     * @ensures {@code this = #this * <x>}
     */
    void addToLine(T x);
    
 
    /**
     * Reports length of {@code this}.
     *
     * @return the length of {@code this}
     * @ensures length = |this|
     */
    int length();
 
}