package cg.vsu.render.math.vector;

/**
 * An interface for all mutable vectors.
 *
 * @author Alexander Laptev
 */
public interface Vector<T extends Vector<T>> {
    /**
     * @return A copy of the given vector.
     */
    T cpy();

    /**
     * Sets the coordinates of this vector to the coordinates of the given vector.
     * @param v The other vector.
     * @return This vector for chaining.
     */
    T set(T v);

    /**
     * Sets the coordinates of this vector to the given value.
     * @return This vector for chaining.
     */
    T set(float v);

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
     * Limits the length of this vector based on the desired maximum length.
     * @param limit The maximum length of this vector.
     * @return This vector for chaining.
     */
    T limit(float limit);

    /**
     * Limits the length of this vector based on the square of the desired maximum length.
     * @param limit2 The square of the maximum length of this vector.
     * @return This vector for chaining.
     */
    T limit2(float limit2);

    /**
     * Sets the length of this vector.
     * @param length The desired length of this vector.
     * @return This vector for chaining.
     */
    T setLength(float length);

    /**
     * Sets the square of the length of this vector.
     * @param length2 The desired square of the length of this vector.
     * @return This vector for chaining.
     */
    T setLength2(float length2);

    /**
     * Clamps the length of this vector between the min and max values.
     *
     * @param minLength The minimum length.
     * @param maxLength The maximum length.
     * @return This vector for chaining.
     */
    T clamp(float minLength, float maxLength);

    /**
     * Adds the given vector to this vector.
     * @param v The vector to add.
     * @return This vector for chaining.
     */
    T add(T v);

    /**
     * Adds the given value to each of the coordinates of this vector.
     * @param v The value to add.
     * @return This vector for chaining.
     */
    T add(float v);

    /**
     * Subtracts the given vector from this vector.
     * @param v The vector to subtract.
     * @return This vector for chaining.
     */
    T sub(T v);

    /**
     * Subtracts the given value from each of the coordinates of this vector.
     * @param v The value to subtract.
     * @return This vector for chaining.
     */
    T sub(float v);

    /**
     * Scales this vector by the given scalar.
     * @param scalar The scalar.
     * @return This vector for chaining.
     */
    T scl(float scalar);

    /**
     * Performs a coordinate-wise multiplication (Hadamard product) of this vector and the other vector.
     * @param v The other vector.
     * @return This vector for chaining.
     */
    T scl(T v);

    /**
     * Individually divides each coordinate of this vector by the given scalar.
     * @param divisor The scalar.
     * @return This vector for chaining.
     */
    T div(float divisor);

    /**
     * Performs a coordinate-wise division of this vector and the other vector.
     * @param v The other vector.
     * @return This vector for chaining.
     */
    T div(T v);

    /**
     * @param v The other vector.
     * @return The distance to the other vector.
     */
    float dst(T v);

    /**
     * @param v The other vector.
     * @return The square of the distance to the other vector.
     */
    float dst2(T v);

    /**
     * Linearly interpolates between this vector and the other vector based on the alpha coefficient.
     * @param v The other vector.
     * @param alpha The alpha coefficient.
     * @return This vector for chaining.
     */
    T lerp(T v, float alpha);

    /**
     * Scales the given vector and adds it to this vector.
     * @param v The given vector.
     * @param scalar The scale of the given vector.
     * @return This vector for chaining.
     */
    T addMul(T v, float scalar);

    /**
     * @param v The other vector.
     * @return The dot product between this and the other vector.
     */
    float dot(T v);

    /**
     * Sets this vector to the vector from this vector to the other vector.
     * @param v The other vector.
     * @return This vector for chaining.
     */
    T to(T v);

    /**
     * @param v The other vector.
     * @return Whether this vector is on the line described by the other vector.
     */
    boolean isOnLine(T v);

    /**
     * @param v The other vector.
     * @param epsilon The epsilon value.
     * @return Whether this vector is approximately on the line described by the other vector.
     */
    boolean isOnLine(T v, float epsilon);

    /**
     * @param v The other vector.
     * @return Whether this vector is collinear to the other vector and has the same direction.
     */
    boolean isCollinear(T v);

    /**
     * @param v The other vector.
     * @param epsilon The epsilon value.
     * @return Whether this vector is approximately collinear to the other vector and has the same direction.
     */
    boolean isCollinear(T v, float epsilon);

    /**
     * @param v The other vector.
     * @return Whether this vector is collinear to the other vector and has the opposite direction.
     */
    boolean isCollinearOpposite(T v);

    /**
     * @param v The other vector.
     * @param epsilon The epsilon value.
     * @return Whether this vector is approximately collinear to the other vector and has the opposite direction.
     */
    boolean isCollinearOpposite(T v, float epsilon);

    /**
     * @param v The other vector.
     * @return Whether this vector is orthogonal to the other vector (i.e. their dot product is =0).
     */
    boolean isOrthogonal(T v);

    /**
     * @param v The other vector.
     * @param epsilon The epsilon value.
     * @return Whether this vector is appoximately orthogonal to the other vector (i.e. their dot product is =0).
     */
    boolean isOrthogonal(T v, float epsilon);

    /**
     * @param v The other vector.
     * @return Whether this vector has the same direction as the other vector (i.e. their dot product is >0).
     */
    boolean hasSameDirection(T v);

    /**
     * @param v The other vector.
     * @return Whether this vector has the opposite direction as the other vector (i.e. their dot product is <0).
     */
    boolean hasOppositeDirection(T v);

    /**
     * @return Whether this vector is a unit vector.
     */
    boolean isUnit();

    /**
     * @return Whether this vector is a zero vector.
     */
    boolean isZero();

    /**
     * @param epsilon The epsilon value.
     * @return Whether the vectors are nearly equal based on the given epsilon value.
     */
    boolean epsEquals(float epsilon);

    /**
     * Sets this vector to zero.
     * @return This vector for chaining.
     */
    T setZero();
}
