package cg.vsu.render.math;

/**
 * A mutable two-dimensional float vector.
 *
 * @author Alexander Laptev
 */
public class Vector2f implements Vector<Vector2f> {
    /**
     * The x coordinate of this vector.
     */
    public float x;

    /**
     * The y coordinate of this vector.
     */
    public float y;

    /**
     * @return A zero vector.
     */
    public static Vector2f zero() {
        return new Vector2f();
    }

    /**
     * @return An x unit vector.
     */
    public static Vector2f unitX() {
        return new Vector2f(1.0f, 0.0f);
    }

    /**
     * @return A y unit vector.
     */
    public static Vector2f unitY() {
        return new Vector2f(0.0f, 1.0f);
    }

    /**
     * Constructs a zero vector.
     */
    public Vector2f() { }

    /**
     * Constructs a vector with the given coordinates.
     * @param x The x coordinate of the vector.
     * @param y The y coordinate of the vector.
     */
    public Vector2f(float x, float y) {

    }

    @Override
    public Vector2f cpy() {
        return new Vector2f(this.x, this.y);
    }

    /**
     * Sets the coordinates of this vector to the specified values.
     * @param x The new x coordinate of this vector.
     * @param y The new y coordinate of this vector.
     * @return This vector for chaining.
     */
    public Vector2f set(float x, float y) {
        this.x = x;
        this.y = y;
        return this;
    }

    @Override
    public Vector2f set(Vector2f v) {
        this.x = v.x;
        this.y = v.y;
        return this;
    }

    @Override
    public Vector2f nor() {
        if (x == 0.0f && y == 0.0f) return this;

        float len = len();
        this.x /= len;
        this.y /= len;
        return this;
    }

    @Override
    public float len() {
        return (float) Math.sqrt(x * x + y * y);
    }

    @Override
    public float len2() {
        return x * x + y * y;
    }

    @Override
    public Vector2f add(Vector2f v) {
        this.x += v.x;
        this.y += v.y;
        return this;
    }

    @Override
    public Vector2f sub(Vector2f v) {
        this.x -= v.x;
        this.y -= v.y;
        return this;
    }

    @Override
    public Vector2f scl(float scalar) {
        this.x *= scalar;
        this.y *= scalar;
        return this;
    }

    /**
     * Individually scales the coordinates of this vector.
     * @param scaleX The x coordinate scale.
     * @param scaleY The y coordinate scale.
     * @return This vector for chaining.
     */
    public Vector2f scl(float scaleX, float scaleY) {
        this.x *= scaleX;
        this.y *= scaleY;
        return this;
    }

    @Override
    public Vector2f mul(Vector2f v) {
        this.x *= v.x;
        this.y *= v.y;
        return this;
    }

    @Override
    public Vector2f div(float divisor) {
        this.x /= divisor;
        this.y /= divisor;
        return this;
    }

    @Override
    public Vector2f div(Vector2f v) {
        this.x /= v.x;
        this.y /= v.y;
        return this;
    }

    /**
     * Individually divides the coordinates of this vector by the given scalars.
     * @param scaleX The x coordinate scale.
     * @param scaleY The y coordinate scale.
     * @return This vector for chaining.
     */
    public Vector2f div(float scaleX, float scaleY) {
        this.x /= scaleX;
        this.y /= scaleY;
        return this;
    }

    @Override
    public float dot(Vector2f v) {
        return this.x * v.x + this.y * v.y;
    }

    /**
     * @param v The other vector.
     * @return The 2D-cross product of the two vectors.
     */
    public float crs(Vector2f v) {
        return this.x * v.y - this.y * v.x;
    }

    @Override
    public Vector2f to(Vector2f v) {
        this.x = v.x - this.x;
        this.y = v.y - this.y;
        return this;
    }

    @Override
    public boolean isUnit() {
        return (x * x + y * y) == 1.0f;
    }

    @Override
    public boolean isZero() {
        return x == 0f && y == 0.0f;
    }
}
