package cg.vsu.render.math.vector;

import cg.vsu.render.math.MathUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Vector4fTest {
    private Vector4f v = new Vector4f();

    @Test
    void zeroVectorHasZeroLength() {
        v = Vector4f.zero();

        assertEquals(0.0f, v.len());
        assertEquals(0.0f, v.len2());
    }

    @Test
    void zeroVectorIsZero() {
        v = Vector4f.zero();

        assertTrue(v.isZero());
    }

    @Test
    void zeroConstructorConstructsZeroVector() {
        v = new Vector4f();

        assertTrue(v.isZero());
    }

    @Test
    void unitVectorsHaveUnitLength() {
        Vector4f i = Vector4f.unitX();
        Vector4f j = Vector4f.unitY();
        Vector4f k = Vector4f.unitZ();
        Vector4f l = Vector4f.unitW();

        assertEquals(1.0f, i.len());
        assertEquals(1.0f, i.len2());
        assertEquals(1.0f, j.len());
        assertEquals(1.0f, j.len2());
        assertEquals(1.0f, k.len());
        assertEquals(1.0f, k.len2());
        assertEquals(1.0f, l.len());
        assertEquals(1.0f, l.len2());
    }

    @Test
    void unitVectorsAreUnit() {
        Vector4f i = Vector4f.unitX();
        Vector4f j = Vector4f.unitY();
        Vector4f k = Vector4f.unitZ();
        Vector4f l = Vector4f.unitW();

        assertTrue(i.isUnit());
        assertTrue(j.isUnit());
        assertTrue(k.isUnit());
        assertTrue(l.isUnit());
    }

    @Test
    void testComponentConstructor() {
        v = new Vector4f(5.0f, -2.0f, 1.0f, 9.0f);

        assertEquals(5.0f, v.x);
        assertEquals(-2.0f, v.y);
        assertEquals(1.0f, v.z);
        assertEquals(9.0f, v.w);
    }

    @Test
    void testArrayConstructor() {
        float[] vector = {1.0f, 2.0f, 3.0f, 4.0f, 5.0f};
        v = new Vector4f(vector);

        assertEquals(1.0f, v.x);
        assertEquals(2.0f, v.y);
        assertEquals(3.0f, v.z);
        assertEquals(4.0f, v.w);
    }

    @Test
    void testCopyConstructor() {
        Vector4f other = new Vector4f(5.0f, -2.0f, 1.0f, 9.0f);
        v = new Vector4f(other);

        assertEquals(5.0f, v.x);
        assertEquals(-2.0f, v.y);
        assertEquals(1.0f, v.z);
        assertEquals(9.0f, v.w);
    }

    @Test
    void testConstructorFromV2f() {
        Vector2f v2f = new Vector2f(2.0f, 3.0f);
        v = new Vector4f(v2f);
        Vector4f v1 = new Vector4f(v2f, 5.0f, 6.0f);

        assertEquals(2.0f, v.x);
        assertEquals(2.0f, v1.x);
        assertEquals(3.0f, v.y);
        assertEquals(3.0f, v1.y);

        assertEquals(0.0f, v.z);
        assertEquals(0.0f, v.w);

        assertEquals(5.0f, v1.z);
        assertEquals(6.0f, v1.w);
    }

    @Test
    void testConstructorFromV3f() {
        Vector3f v3f = new Vector3f(2.0f, 3.0f, 4.0f);
        v = new Vector4f(v3f);
        Vector4f v1 = new Vector4f(v3f, 5.0f);

        assertEquals(2.0f, v.x);
        assertEquals(2.0f, v1.x);
        assertEquals(3.0f, v.y);
        assertEquals(3.0f, v1.y);
        assertEquals(4.0f, v1.z);
        assertEquals(4.0f, v1.z);

        assertEquals(1.0f, v.w);
        assertEquals(5.0f, v1.w);
    }

    @Test
    void equalVectorsAreEqual() {
        Vector4f v1 = new Vector4f(2.0f, 1.0f, 3.0f, 10.0f);
        v.set(2.0f, 1.0f, 3.0f, 10.f);

        assertEquals(v1, v);
        assertEquals(v, v1);
    }

    @Test
    void equalVectorsAreIdentical() {
        Vector4f v1 = new Vector4f(2.0f, 1.0f, 3.0f, 10.0f);
        v.set(2.0f, 1.0f, 3.0f, 10.f);

        assertTrue(v1.idt(v));
        assertTrue(v.idt(v1));
    }

    @Test
    void zeroVectorIsEqualToZeroVector() {
        v = Vector4f.zero();
        Vector4f z = new Vector4f(0.0f, 0.0f, 0.0f, 0.0f);

        assertEquals(v, z);
    }

    @Test
    void nearlyEqualVectorsAreEpsEqual() {
        v = new Vector4f();
        v.x = 200.0f;
        Vector4f v1 = Vector4f.unitX();
        Vector4f a = Vector4f.zero();
        for (int i = 0; i < 200; i++) {
            a.add(v1);
        }

        assertTrue(v.epsEquals(a, MathUtils.EPSILON));
        assertTrue(a.epsEquals(v, MathUtils.EPSILON));
    }

    @Test
    void nearlyEqualVectorsAreEpsIdt() {
        v = new Vector4f();
        v.x = 200.0f;
        Vector4f v1 = Vector4f.unitX();
        Vector4f a = Vector4f.zero();
        for (int i = 0; i < 200; i++) {
            a.add(v1);
        }

        assertTrue(v.epsIdt(a, MathUtils.EPSILON));
        assertTrue(a.epsIdt(v, MathUtils.EPSILON));
    }

    @Test
    void testToString() {
        v.set(1.0f, 2.0f, 3.0f, 4.0f);

        assertEquals("v4f(x=1.0, y=2.0, z=3.0, w=4.0)", v.toString());
    }

    @Test
    void testCopy() {
        Vector4f v1 = new Vector4f(1.0f, 2.0f, 3.0f, 4.0f);
        v = v1.cpy();

        assertEquals(1.0f, v.x);
        assertEquals(2.0f, v.y);
        assertEquals(3.0f, v.z);
        assertEquals(4.0f, v.w);
    }

    @Test
    void testSetZero() {
        v = new Vector4f(33.0f, 12.0f, 42.0f, 14.0f);
        v.setZero();

        assertTrue(v.isZero());
    }

    @Test
    void testSetValue() {
        v.set(10.0f);

        assertEquals(10.0f, v.x);
        assertEquals(10.0f, v.y);
        assertEquals(10.0f, v.z);
        assertEquals(10.0f, v.w);
    }

    @Test
    void testSetValues() {
        v.set(1.0f, 2.0f, 3.0f, 4.0f);

        assertEquals(1.0f, v.x);
        assertEquals(2.0f, v.y);
        assertEquals(3.0f, v.z);
        assertEquals(4.0f, v.w);
    }

    @Test
    void testSetVector() {
        Vector4f v1 = new Vector4f(11.0f, 20.0f, 35.0f, 82.0f);
        v.set(v1);

        assertEquals(11.0f, v.x);
        assertEquals(20.0f, v.y);
        assertEquals(35.0f, v.z);
        assertEquals(82.0f, v.w);
    }

    @Test
    void testSetFromArray() {
        float[] vector = {1.0f, 2.0f, 3.0f, 4.0f};
        v.set(vector);

        assertEquals(1.0f, v.x);
        assertEquals(2.0f, v.y);
        assertEquals(3.0f, v.z);
        assertEquals(4.0f, v.w);
    }

    @Test
    void testSetFromV2f() {
        Vector2f v2f = new Vector2f(3.0f, -5.0f);

        v.set(v2f);
        assertEquals(3.0f, v.x);
        assertEquals(-5.0f, v.y);
        assertEquals(0.0f, v.z);
        assertEquals(0.0f, v.w);

        v.set(v2f, 2.0f, 9.0f);
        assertEquals(3.0f, v.x);
        assertEquals(-5.0f, v.y);
        assertEquals(2.0f, v.z);
        assertEquals(9.0f, v.w);
    }

    @Test
    void testSetFromV3f() {
        Vector3f v3f = new Vector3f(3.0f, -5.0f, 4.0f);

        v.set(v3f);
        assertEquals(3.0f, v.x);
        assertEquals(-5.0f, v.y);
        assertEquals(4.0f, v.z);
        assertEquals(1.0f, v.w);

        v.set(v3f, -11.0f);
        assertEquals(3.0f, v.x);
        assertEquals(-5.0f, v.y);
        assertEquals(4.0f, v.z);
        assertEquals(-11.0f, v.w);
    }

    @Test
    void testLength() {
        v.set(1.0f, 1.0f, 3.0f, 5.0f);

        assertEquals(6.0f, v.len());
        assertEquals(6.0f, Vector4f.len(1.0f, 1.0f, 3.0f, 5.0f));
    }

    @Test
    void testLength2() {
        v.set(1.0f, 1.0f, 3.0f, 5.0f);

        assertEquals(36.0f, v.len2());
        assertEquals(36.0f, Vector4f.len2(1.0f, 1.0f, 3.0f, 5.0f));
    }

    @Test
    void length2IsSquareOfLength() {
        v.set(1.0f, 1.0f, 3.0f, 5.0f);
        float len = v.len();

        assertEquals(len * len,  v.len2());
    }

    @Test
    void normalizeMakesVectorWithUnitLength() {
        v.set(1.0f, 1.0f, 7.0f, 0.0f);
        v.nor();

        assertEquals(1.0f, v.len());
        assertEquals(1.0f, v.len2());
    }

    @Test
    void testLimitEffective() {
        v.set(420.0f, -421.0f, 1006.0f, 96.0f);
        v.limit(25.0f);
        assertTrue(MathUtils.epsEquals(25.0f, v.len()));
    }

    @Test
    void testLimitIneffective() {
        v = new Vector4f(1.0f, 3.0f, 5.0f, 1.0f);
        v.limit(10.0f);
        assertEquals(6.0f, v.len());
    }

    @Test
    void testLimit2Effective() {
        v.set(420.0f, -421.0f, 1006.0f, 96.0f);
        v.limit2(25.0f);
        assertTrue(MathUtils.epsEquals(25.0f, v.len2()));
    }

    @Test
    void testLimit2Ineffective() {
        v = new Vector4f(3.0f, 2.0f, 0.0f, 0.0f);
        v.limit(10.0f);
        assertEquals(13.0f, v.len2());
    }

    @Test
    void testSetLength() {
        v.set(15.0f, 39.0f, -42.0f, 13.0f);
        v.setLength(14.0f);

        assertEquals(14.0f, v.len());
    }

    @Test
    void testSetLength2() {
        v.set(15.0f, 39.0f, -42.0f, 13.0f);
        v.setLength2(21.0f);

        assertEquals(21.0f, v.len2());
    }

    @Test
    void testClampGreater() {
        v.set(109.0f, 4.0f, 55.0f, -31.0f);
        v.clamp(20.f, 30.f);

        assertTrue(MathUtils.epsEquals(30.0f, v.len()));
    }

    @Test
    void testClampLess() {
        v.set(-2.0f, 3.0f, 4.0f, -3.0f);
        v.clamp(20.f, 30.f);

        assertEquals(20.0f, v.len());
    }

    @Test
    void testClampInBounds() {
        v.set(25.0f, 0.0f, 0.0f, 0.0f);
        v.clamp(20.f, 30.f);

        assertEquals(25.0f, v.len());
    }
}
