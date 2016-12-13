/*
 *  Copyright 2016 Google Inc. All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.google.engedu.ghost;

import junit.framework.Assert;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class SimpleDictionaryTest {

    String[] wordsArray = {"apple", "cat", "caterwaul", "caterwauled", "caterwauling", "caterwauls",
            "catfish", "catfishes", "cats", "dog", "dogs", "dogfish", "dogfishes", "life", "lives"};

    @Test
    public void testIsWord() {
        ArrayList<String> words = new ArrayList<>(Arrays.asList(wordsArray));
        SimpleDictionary dict = new SimpleDictionary(words, 0);

        assertTrue(dict.isWord("cat"));
        assertFalse(dict.isWord("c"));
        assertFalse(dict.isWord("fish"));
    }

    @Test
    public void testGetAnyWordStartingWith() {
        ArrayList<String> words = new ArrayList<>(Arrays.asList(wordsArray));
        SimpleDictionary dict = new SimpleDictionary(words, 0);

        // Edge cases
        assertNull(dict.getAnyWordStartingWith("notaword"));
        assertNull(dict.getAnyWordStartingWith("caq"));
        assertNotNull(dict.getAnyWordStartingWith(""));

        // A word that cannot grow returns null -- nothing has this substring and is longer.
        assertNull(dict.getAnyWordStartingWith("catfishes"));

        // Check some substrings
        assertEquals("catfishes", dict.getAnyWordStartingWith("catfish"));
        assertTrue(dict.getAnyWordStartingWith("cat").startsWith("cat"));

        // Check last word in the dict
        assertEquals("lives", dict.getAnyWordStartingWith("liv"));

        // Check first word
        assertEquals("apple", dict.getAnyWordStartingWith("a"));
        assertEquals("apple", dict.getAnyWordStartingWith("ap"));
        assertEquals("apple", dict.getAnyWordStartingWith("app"));
        assertEquals("apple", dict.getAnyWordStartingWith("appl"));
        assertNull(dict.getAnyWordStartingWith("apple"));
    }
}
