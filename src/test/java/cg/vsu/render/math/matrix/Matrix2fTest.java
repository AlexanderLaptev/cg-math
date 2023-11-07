package cg.vsu.render.math.matrix;

import cg.vsu.render.math.MathUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Matrix2fTest {
    private static final float[] VALUES_1 = {
            3.0f, 5.0f,
            -2.0f, 1.0f
    };

    private static final float[] VALUES_2 = {
            2.0f, 4.0f,
            -3.0f, 5.0f
    };

    private static final float DET_1 = 13.0f;
    private static final float DET_2 = 22.0f;

    private Matrix2f m1 = new Matrix2f();
    private Matrix2f m2 = new Matrix2f();

    @Test
    void unitMatrixDeterminantIsOne() {
        m1.setIdentity();

        assertEquals(1.0f, m1.det());
    }

    @Test
    void detReturnsExpectedValue() {
        m1.set(VALUES_1);
        m2.set(VALUES_2);

        assertEquals(DET_1, m1.det());
        assertEquals(DET_2, m2.det());
    }

    @Test
    void transposeDoesNotAffectDeterminant() {
        m1.set(VALUES_1);
        m2.set(m1.cpy().tra());

        assertEquals(m1.det(), m2.det());
    }

    @Test
    void transposedMultiplication() {
        m1.set(VALUES_1);
        m2.set(VALUES_2);

        Matrix2f r1 = m1.cpy().mul(m2).tra();
        Matrix2f r2 = m2.cpy().tra().mul(m1.cpy().tra());

        assertEquals(r1, r2);
    }

    @Test
    void inverseMatrixProperties() {
        m1.set(VALUES_1);
        m2 = m1.cpy().inv();

        Matrix2f r1 = m1.cpy().mul(m2);
        Matrix2f r2 = m2.cpy().mul(m1);

        assertTrue(r1.epsEquals(r2, MathUtils.EPSILON));
        assertTrue(r1.epsEquals(Matrix2f.identity(), MathUtils.EPSILON));
        assertTrue(r2.epsEquals(Matrix2f.identity(), MathUtils.EPSILON));
    }
}
