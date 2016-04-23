/*******************************************************************************
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package com.intercom.io.flattenarray;

import org.junit.Assert;
import org.junit.Test;



/**
 * The Class ArrayFlattenerTest.
 * @author Yasith Lokuge
 */
public class ArrayFlattenerTest {

    /** The expected array. */
    Integer[] expectedArray = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    /**
     * Test null returns null.
     *
     * @throws IllegalArgumentException the illegal argument exception
     */
    @Test
    public void testNullReturnsNull() throws IllegalArgumentException {
        Assert.assertNull(
                "Testing a null argument",
                ArrayFlattener.flatten(null)
        );
    }

    /**
     * Test empty array.
     *
     * @throws IllegalArgumentException the illegal argument exception
     */
    @Test
    public void testEmptyArray() throws IllegalArgumentException {
        Assert.assertArrayEquals(
                "Testing an empty array",
                new Integer[]{},
                ArrayFlattener.flatten(new Object[]{})
        );
    }

    /**
     * Test flat array.
     *
     * @throws IllegalArgumentException the illegal argument exception
     */
    @Test
    public void testFlatArray() throws IllegalArgumentException {
        Assert.assertArrayEquals(
                "Testing a flat array",
                expectedArray,
                ArrayFlattener.flatten(new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
        );
    }

    /**
     * Test nested array.
     *
     * @throws IllegalArgumentException the illegal argument exception
     */
    @Test
    public void testNestedArray() throws IllegalArgumentException {
        Assert.assertArrayEquals(
                "Testing nested array",
                expectedArray,
                ArrayFlattener.flatten(new Object[]{1, 2, 3, 4, new Object[]{5, 6, 7, 8}, 9, 10})
        );
    }

    /**
     * Test multiple nested arrays.
     *
     * @throws IllegalArgumentException the illegal argument exception
     */
    @Test
    public void testMultipleNestedArrays() throws IllegalArgumentException {
        Assert.assertArrayEquals(
                "Testing multiple nested arrays",
                expectedArray,
                ArrayFlattener.flatten(new Object[]{1, 2, new Object[]{3, 4, new Object[]{5}, 6, 7}, 8, 9, 10})
        );
    }

    /**
     * Throws exception for object in array.
     *
     * @throws IllegalArgumentException the illegal argument exception
     */
    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionForObjectInArray() throws IllegalArgumentException {
    	ArrayFlattener.flatten(
                new Object[]{new Object()}
        );
    }

    /**
     * Throws exception for object in nested array.
     *
     * @throws IllegalArgumentException the illegal argument exception
     */
    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionForObjectInNestedArray() throws IllegalArgumentException {
    	ArrayFlattener.flatten(
                new Object[]{1, 2, new Object[]{3, new Object()}}
        );
    }

    /**
     * Throws exception for null in array.
     *
     * @throws IllegalArgumentException the illegal argument exception
     */
    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionForNullInArray() throws IllegalArgumentException {
    	ArrayFlattener.flatten(
                new Object[]{null}
        );
    }

    /**
     * Throws exception for null in nested array.
     *
     * @throws IllegalArgumentException the illegal argument exception
     */
    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionForNullInNestedArray() throws IllegalArgumentException {
    	ArrayFlattener.flatten(
                new Object[]{1, 2, new Object[]{3, null}}
        );
    }

}
