package cg.vsu.render.math;

/**
 * Common math operations.
 */
public class MathUtils {
    private MathUtils() {}

    /**
     * @return The square root of the given value.
     */
    public static float sqrt(float a) {
        return (float) Math.sqrt(a);
    }

    /**
     * @return The square root of the given value.
     */
    public static double sqrt(double a) {
        return Math.sqrt(a);
    }

    /**
     * Clamps the given value between min and max.
     * @param v The value to clamp.
     * @param min The min value.
     * @param max The max value.
     * @return The clamped value.
     */
    public static float clamp(float v, float min, float max) {
        if (v > max) return max;
        if (v < min) return min;
        return v;
    }

    /**
     * Clamps the given value between min and max.
     * @param v The value to clamp.
     * @param min The min value.
     * @param max The max value.
     * @return The clamped value.
     */
    public static double clamp(double v, double min, double max) {
        if (v > max) return max;
        if (v < min) return min;
        return v;
    }

    /**
     * Clamps the given value between min and max.
     * @param v The value to clamp.
     * @param min The min value.
     * @param max The max value.
     * @return The clamped value.
     */
    public static int clamp(int v, int min, int max) {
        if (v > max) return max;
        if (v < min) return min;
        return v;
    }

    /**
     * Clamps the given value between min and max.
     * @param v The value to clamp.
     * @param min The min value.
     * @param max The max value.
     * @return The clamped value.
     */
    public static short clamp(short v, short min, short max) {
        if (v > max) return max;
        if (v < min) return min;
        return v;
    }

    /**
     * Clamps the given value between min and max.
     * @param v The value to clamp.
     * @param min The min value.
     * @param max The max value.
     * @return The clamped value.
     */
    public static long clamp(long v, long min, long max) {
        if (v > max) return max;
        if (v < min) return min;
        return v;
    }

    /**
     * Clamps the given value between 0 and 1.
     * @param v The value to clamp.
     * @return The clamped value.
     */
    public static float clamp01(float v) {
        if (v > 1.0f) return 1.0f;
        if (v < 0.0f) return 0.0f;
        return v;
    }

    /**
     * Clamps the given value between 0 and 1.
     * @param v The value to clamp.
     * @return The clamped value.
     */
    public static double clamp01(double v) {
        if (v > 1.0) return 1.0;
        if (v < 0.0) return 0.0;
        return v;
    }

    /**
     * Maps the given value from one range to another.
     * @param v The value to map.
     * @param inMin The start of the input range.
     * @param inMax The end of the input range.
     * @param outMin The start of the output range.
     * @param outMax The end of the output range.
     * @return The mapped value.
     */
    public static float map(float v, float inMin, float inMax, float outMin, float outMax) {
        return outMin + (v - inMin) / (inMax - inMin) * (outMax - outMin);
    }
}
