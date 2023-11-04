package cg.vsu.render.math.vector;

/**
 * A mutable three-dimensional float vector.
 *
 * @author Alexander Laptev
 */
public class Vector4f implements Vector<Vector4f> {
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
     * The w coordinate of this vector.
     */
    public float w;

    /**
     * @return A zero vector.
     */
    public static Vector4f zero() {
        return new Vector4f();
    }

    /**
     * @return An x unit vector.
     */
    public static Vector4f unitX() {
        return new Vector4f(1.0f, 0.0f, 0.0f, 0.0f);
    }

    /**
     * @return A y unit vector.
     */
    public static Vector4f unitY() {
        return new Vector4f(0.0f, 1.0f, 0.0f, 0.0f);
    }

    /**
     * @return A z unit vector.
     */
    public static Vector4f unitZ() {
        return new Vector4f(0.0f, 0.0f, 1.0f, 0.0f);
    }

    /**
     * @return A w unit vector.
     */
    public static Vector4f unitW() {
        return new Vector4f(0.0f, 0.0f, 0.0f, 1.0f);
    }

    /**
     * Constructs a zero vector.
     */
    public Vector4f() { }

    /**
     * Constructs a vector with the given coordinates.
     * @param x The x coordinate of the vector.
     * @param y The y coordinate of the vector.
     * @param z The z coordinate of the vector.
     * @param w The w coordinate of the vector.
     */
    public Vector4f(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    @Override
    public Vector4f cpy() {
        return new Vector4f(this.x, this.y, this.z, this.w);
    }

    /**
     * Sets the coordinates of this vector to the specified values.
     * @param x The new x coordinate of this vector.
     * @param y The new y coordinate of this vector.
     * @param z The new z coordinate of this vector.
     * @param w The new z coordinate of this vector.
     * @return This vector for chaining.
     */
    public Vector4f set(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        return this;
    }

    @Override
    public Vector4f set(Vector4f v) {
        this.x = v.x;
        this.y = v.y;
        this.z = v.z;
        this.w = v.w;
        return this;
    }

    @Override
    public Vector4f nor() {
        if (x == 0.0f && y == 0.0f && z == 0.0f && w == 0.0f) return this;

        float len = len();
        this.x /= len;
        this.y /= len;
        this.z /= len;
        this.w /= len;
        return this;
    }

    @Override
    public float len() {
        return (float) Math.sqrt(x * x + y * y + z * z + w * w);
    }

    @Override
    public float len2() {
        return x * x + y * y + z * z + w * w;
    }

    @Override
    public Vector4f add(Vector4f v) {
        this.x += v.x;
        this.y += v.y;
        this.z += v.z;
        this.w += v.w;
        return this;
    }

    @Override
    public Vector4f sub(Vector4f v) {
        this.x -= v.x;
        this.y -= v.y;
        this.z -= v.z;
        this.w -= v.w;
        return this;
    }

    @Override
    public Vector4f scl(float scalar) {
        this.x *= scalar;
        this.y *= scalar;
        this.z *= scalar;
        this.w *= scalar;
        return this;
    }

    /**
     * Individually scales the coordinates of this vector.
     * @param scaleX The x coordinate scale.
     * @param scaleY The y coordinate scale.
     * @param scaleZ The z coordinate scale.
     * @param scaleW The w coordinate scale.
     * @return This vector for chaining.
     */
    public Vector4f scl(float scaleX, float scaleY, float scaleZ, float scaleW) {
        this.x *= scaleX;
        this.y *= scaleY;
        this.z *= scaleZ;
        this.w *= scaleW;
        return this;
    }

    @Override
    public Vector4f mul(Vector4f v) {
        this.x *= v.x;
        this.y *= v.y;
        this.z *= v.z;
        this.w *= v.w;
        return this;
    }

    @Override
    public Vector4f div(float scalar) {
        this.x /= scalar;
        this.y /= scalar;
        this.z /= scalar;
        this.w /= scalar;
        return this;
    }

    @Override
    public Vector4f div(Vector4f v) {
        this.x /= v.x;
        this.y /= v.y;
        this.z /= v.z;
        this.w /= v.w;
        return this;
    }

    /**
     * Individually divides the coordinates of this vector by the given scalars.
     * @param scaleX The x coordinate scale.
     * @param scaleY The y coordinate scale.
     * @param scaleZ The z coordinate scale.
     * @param scaleW The w coordinate scale.
     * @return This vector for chaining.
     */
    public Vector4f div(float scaleX, float scaleY, float scaleZ, float scaleW) {
        this.x /= scaleX;
        this.y /= scaleY;
        this.z /= scaleZ;
        this.w /= scaleW;
        return this;
    }

    @Override
    public float dot(Vector4f v) {
        return this.x * v.x + this.y * v.y + this.z * v.z + this.w * v.w;
    }

    @Override
    public Vector4f to(Vector4f v) {
        this.x = v.x - this.x;
        this.y = v.y - this.y;
        this.z = v.z - this.z;
        this.w = v.w - this.w;
        return this;
    }

    @Override
    public boolean isUnit() {
        return (x * x + y * y + z * z + w * w) == 1.0f;
    }

    @Override
    public boolean isZero() {
        return x == 0f && y == 0.0f && z == 0.0f && w == 0.0f;
    }
}
