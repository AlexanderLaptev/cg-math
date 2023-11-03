package cg.vsu.render.math;

/**
 * An interface for all vectors.
 */
public interface Vector<T extends Vector<T>> {
    /**
     * @return A copy of the given vector.
     */
    T cpy();

    /**
     * Sets the components of this vector to the components of the given vector.
     * @param v The other vector.
     * @return This vector for chaining.
     */
    T set(T v);

    /**
     * Normalizes the given vector. Does nothing if the length is zero.
     * @return This vector for chaining.
     */
    T nor();

    /**
     * @return The length of this vector.
     */
    float len();

    /**
     * This method avoids calculating the square root, which is faster.
     * This method should generally be preferred when doing comparisons.
     * @return The squared length of this vector.
     */
    float len2();

    /**
     * Adds the given vector to this vector.
     * @param v The vector to add.
     * @return This vector for chaining.
     */
    T add(T v);

    /**
     * Subtracts the given vector from this vector.
     * @param v The vector to subtract.
     * @return This vector for chaining.
     */
    T sub(T v);

    /**
     * Scales this vector by the given scalar.
     * @param scalar The scalar.
     * @return This vector for chaining.
     */
    T scl(float scalar);

    /**
     * Scales this vector by the reciprocal of the given scalar.
     * @param scalar The scalar.
     * @return This vector for chaining.
     */
    T sclinv(float scalar);

    /**
     * Performs a component-wise multiplication (Hadamard product) of this vector and the other vector.
     * @param v The other vector.
     * @return This vector for chaining.
     */
    T mul(T v);

    /**
     * Performs a component-wise division of this vector and the other vector.
     * @param v The other vector.
     * @return This vector for chaining.
     */
    T div(T v);

    /**
     * @param v The other vector.
     * @return The dot product between this and the other vector.
     */
    T dot(T v);

    /**
     * @param v The other vector.
     * @return The vector from this vector to the other vector.
     */
    T to(T v);

    /**
     * @return Whether this vector is a unit vector.
     */
    boolean isUnit();

    /**
     * @return Whether this vector is a zero vector.
     */
    boolean isZero();
}
