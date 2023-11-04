package cg.vsu.render.math.vector;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector4fTest {
    private Vector4f v;

    @BeforeEach
    void setUp() {
        v.set(0);
    }

    @Test
    void zeroVectorHasZeroLength() {
        assertEquals(0.0f, v.len());
        assertEquals(0.0f, v.len2());
    }

    @Test
    void zeroVectorIsZero() {
        assertTrue(v.isZero());
    }

    @Test
    void unitVectorsAreUnit() {
        var i = Vector4f.unitX();
        var j = Vector4f.unitY();
        var k = Vector4f.unitZ();
        var l = Vector4f.unitW();

        assertTrue(i.isUnit());
        assertTrue(j.isUnit());
        assertTrue(k.isUnit());
        assertTrue(l.isUnit());
    }

    @Test
    void unitVectorsHaveUnitLength() {
        var i = Vector4f.unitX();
        var j = Vector4f.unitY();
        var k = Vector4f.unitZ();
        var l = Vector4f.unitW();

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
    void zeroConstructsZeroVector() {
        v = Vector4f.zero();

        assertTrue(v.isZero());
    }

    @Test
    void defaultConstructorConstructsZeroVector() {
        v = new Vector4f();

        assertTrue(v.isZero());
    }

    @Test
    void testFromV3f() {
        var v3f = new Vector3f(-1.0f, 2.0f, 3.0f);
        var v1 = Vector4f.fromV3f(v3f);
        var v2 = Vector4f.fromV3f(v3f, 4.0f);

        assertEquals(-1.0f, v1.x);
        assertEquals(2.0f, v1.y);
        assertEquals(3.0f, v1.z);
        assertEquals(1.0f, v1.w);

        assertEquals(-1.0f, v2.x);
        assertEquals(2.0f, v2.y);
        assertEquals(3.0f, v2.z);
        assertEquals(4.0f, v2.w);
    }

    @Test
    void cpyReturnsCopy() {
        v.set(1.0f, 2.0f, 3.0f, 4.0f);
        var v1 = v.cpy();

        assertEquals(v1, v);
    }

    @Test
    void testSetCoords() {
        v.set(1.0f, 2.0f, 3.0f, 4.0f);

        assertEquals(1.0f, v.x);
        assertEquals(2.0f, v.y);
        assertEquals(3.0f, v.z);
        assertEquals(4.0f, v.w);
    }

    @Test
    void testSetValue() {
        v.set(5.0f);

        assertEquals(5.0f, v.x);
        assertEquals(5.0f, v.y);
        assertEquals(5.0f, v.z);
        assertEquals(5.0f, v.w);
    }

    @Test
    void testSetVector() {
        var v1 = new Vector4f(4.0f, 3.0f, 2.0f, 1.0f);
        v.set(v1);

        assertEquals(4.0f, v.x);
        assertEquals(3.0f, v.y);
        assertEquals(2.0f, v.z);
        assertEquals(1.0f, v.w);
    }

    @Test
    void testNormalizeNonNull() {
        v.set(5.0f, 0.0f, 0.0f, 0.0f);
        v.nor();

        assertEquals(1.0f, v.x);
        assertEquals(0.0f, v.x);
        assertEquals(0.0f, v.x);
        assertEquals(0.0f, v.x);
        assertTrue(v.isUnit());
        assertFalse(v.isZero());
    }

    @Test
    void normalizeIsIneffectiveForZeroVectors() {
        v.set(0.0f);

        assertDoesNotThrow(() -> v.nor());
        assertTrue(v.isZero());
    }

    @Test
    void testLen() {
        v.set(1.0f, 1.0f, 1.0f, 1.0f);

        assertEquals(2.0f, v.len());
    }

    @Test
    void testLen2() {
        v.set(1.0f, 1.0f, 1.0f, 1.0f);

        assertEquals(4.0f, v.len());
    }

    @Test
    void testAdd() {
        v.set(2.0f, 4.0f, 6.0f, 8.0f);
        var v1 = new Vector4f(1.0f, 2.0f, 3.0f, 4.0f);
        v.add(v1);

        assertEquals(3.0f, v.x);
        assertEquals(6.0f, v.y);
        assertEquals(9.0f, v.z);
        assertEquals(12.0f, v.w);
    }
}
