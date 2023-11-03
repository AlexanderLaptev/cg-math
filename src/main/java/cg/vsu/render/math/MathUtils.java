package cg.vsu.render.math;

/**
 * Common math operations.
 */
public class MathUtils {
    /**
     * The default epsilon value used for equality comparisons.
     */
    public static final float EPSILON = 1E-7f;
    public static final double EPSILON_D = 1E-7;

    private MathUtils() {}

    /**
     * Performs an accurate floating-point equals comparison using epsilon.
     * @param a The first value.
     * @param b The second value.
     * @param epsilon The epsilon value.
     * @return Whether the two given values are nearly equal.
     */
    public static boolean epsEquals(float a, float b, float epsilon) {
        float diff = Math.abs(a - b);
        return diff <= epsilon;
    }

    /**
     * Performs an accurate floating-point equals comparison using epsilon.
     * @param a The first value.
     * @param b The second value.
     * @return Whether the two given values are nearly equal.
     */
    public static boolean epsEquals(float a, float b) {
        return epsEquals(a, b, EPSILON);
    }

    /**
     * Performs an accurate floating-point equals comparison using epsilon.
     * @param a The first value.
     * @param b The second value.
     * @param epsilon The epsilon value.
     * @return Whether the two given values are nearly equal.
     */
    public static boolean epsEquals(double a, double b, double epsilon) {
        double diff = Math.abs(a - b);
        return diff <= epsilon;
    }

    /**
     * Performs an accurate floating-point equals comparison using epsilon.
     * @param a The first value.
     * @param b The second value.
     * @return Whether the two given values are nearly equal.
     */
    public static boolean epsEquals(double a, double b) {
        return epsEquals(a, b, EPSILON_D);
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
