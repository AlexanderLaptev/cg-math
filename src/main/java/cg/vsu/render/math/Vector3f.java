package cg.vsu.render.math;

/**
 * A mutable three-dimensional float vector.
 */
public class Vector3f implements Vector<Vector3f> {
    /**
     * The x coordinate of this vector.
     */
    public float x;

    /**
     * The y coordinate of this vector.
     */
    public float y;

    /**
     * The z coordinate of this vector.
     */
    public float z;

    /**
     * @return A zero vector.
     */
    public static Vector3f zero() {
        return new Vector3f();
    }

    /**
     * @return An x unit vector.
     */
    public static Vector3f unitX() {
        return new Vector3f(1.0f, 0.0f, 0.0f);
    }

    /**
     * @return A y unit vector.
     */
    public static Vector3f unitY() {
        return new Vector3f(0.0f, 1.0f, 0.0f);
    }

    /**
     * @return A z unit vector.
     */
    public static Vector3f unitZ() {
        return new Vector3f(0.0f, 0.0f, 1.0f);
    }

    /**
     * Constructs a zero vector.
     */
    public Vector3f() { }

    /**
     * Constructs a vector with the given coordinates.
     * @param x The x coordinate of the vector.
     * @param y The y coordinate of the vector.
     * @param z The z coordinate of the vector.
     */
    public Vector3f(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public Vector3f cpy() {
        return new Vector3f(this.x, this.y, this.z);
    }

    /**
     * Sets the coordinates of this vector to the specified values.
     * @param x The new x coordinate of this vector.
     * @param y The new y coordinate of this vector.
     * @param z The new z coordinate of this vector.
     * @return This vector for chaining.
     */
    public Vector3f set(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
        return this;
    }

    @Override
    public Vector3f set(Vector3f v) {
        this.x = v.x;
        this.y = v.y;
        this.z = v.z;
        return this;
    }

    @Override
    public Vector3f nor() {
        if (x == 0.0f && y == 0.0f && z == 0.0f) return this;

        float len = len();
        this.x /= len;
        this.y /= len;
        this.z /= len;
        return this;
    }

    @Override
    public float len() {
        return MathUtils.sqrt(x * x + y * y + z * z);
    }

    @Override
    public float len2() {
        return x * x + y * y + z * z;
    }

    @Override
    public Vector3f add(Vector3f v) {
        this.x += v.x;
        this.y += v.y;
        this.z += v.z;
        return this;
    }

    @Override
    public Vector3f sub(Vector3f v) {
        this.x -= v.x;
        this.y -= v.y;
        this.z -= v.z;
        return this;
    }

    @Override
    public Vector3f scl(float scalar) {
        this.x *= scalar;
        this.y *= scalar;
        this.z *= scalar;
        return this;
    }

    /**
     * Individually scales the coordinates of this vector.
     * @param scaleX The x coordinate scale.
     * @param scaleY The y coordinate scale.
     * @param scaleZ The z coordinate scale.
     * @return This vector for chaining.
     */
    public Vector3f scl(float scaleX, float scaleY, float scaleZ) {
        this.x *= scaleX;
        this.y *= scaleY;
        this.z *= scaleZ;
        return this;
    }

    @Override
    public Vector3f mul(Vector3f v) {
        this.x *= v.x;
        this.y *= v.y;
        this.z *= v.z;
        return this;
    }

    @Override
    public Vector3f div(float scalar) {
        this.x /= scalar;
        this.y /= scalar;
        this.z /= scalar;
        return this;
    }

    @Override
    public Vector3f div(Vector3f v) {
        this.x /= v.x;
        this.y /= v.y;
        this.z /= v.z;
        return this;
    }

    /**
     * Individually divides the coordinates of this vector by the given scalars.
     * @param scaleX The x coordinate scale.
     * @param scaleY The y coordinate scale.
     * @param scaleZ The z coordinate scale.
     * @return This vector for chaining.
     */
    public Vector3f div(float scaleX, float scaleY, float scaleZ) {
        this.x /= scaleX;
        this.y /= scaleY;
        this.z /= scaleZ;
        return this;
    }

    @Override
    public float dot(Vector3f v) {
        return this.x * v.x + this.y * v.y + this.z * v.z;
    }

    /**
     * Sets this vector to the cross product of the two vectors.
     * @param v The other vector.
     * @return This vector for chaining.
     */
    public Vector3f crs(Vector3f v) {
        this.x = this.y * v.z - this.z * v.y;
        this.y = this.z * v.x - this.x * v.z;
        this.z = this.x * v.y - this.y * v.x;
        return this;
    }

    @Override
    public Vector3f to(Vector3f v) {
        return new Vector3f(v.x - this.x, v.y - this.y, v.z - this.z);
    }

    @Override
    public boolean isUnit() {
        return (x * x + y * y + z * z) == 1.0f;
    }

    @Override
    public boolean isZero() {
        return x == 0f && y == 0.0f && z == 0.0f;
    }
}
