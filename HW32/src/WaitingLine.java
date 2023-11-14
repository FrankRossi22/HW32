
import java.util.Comparator;
 
/**
 * {@code WaitingLineKernel} enhanced with secondary methods.
 *
 * @param <T>
 *            type of {@code WaitingLine} entries
 * @mathdefinitions {@code
 * IS_TOTAL_PREORDER (
 *   r: binary relation on T
 *  ) : boolean is
 *  for all x, y, z: T
 *   ((r(x, y) or r(y, x))  and
 *    (if (r(x, y) and r(y, z)) then r(x, z)))
 *
 * IS_SORTED (
 *   s: string of T,
 *   r: binary relation on T
 *  ) : boolean is
 *  for all x, y: T where (<x, y> is substring of s) (r(x, y))
 * }
 */
public interface WaitingLine<T> extends WaitingLineKernel<T> {
 
    /**
     * Concatenates ("appends") {@code w} to the end of {@code this}.
     *
     * @param q
     *            the {@code WaitingLine} to be appended to the end of {@code this}
     * @updates this
     * @clears q
     * @ensures this = #this * #q
     */
    void append(WaitingLine<T> w);
 
    /**
     * Reverses ("flips") {@code this}.
     *
     * @updates this
     * @ensures this = rev(#this)
     */
    void flip();
  
    /**
     * Rotates {@code this}.
     *
     * @param distance
     *            distance by which to rotate
     * @updates this
     * @ensures {@code
     * if #this = <> then
     *  this = #this
     * else
     *  this = #this[distance mod |#this|, |#this|) * #this[0, distance mod |#this|)
     * }
     */
    void rotate(int distance);
 
}