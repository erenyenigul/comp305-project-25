package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;


public class StringDifferenceTest {
    private class Expectation {
        public String s1;
        public String s2;
        public int distance;

        public Expectation(String s1, String s2, int distance) {
            this.s1 = s1;
            this.s2 = s2;
            this.distance = distance;
        }
    }

    @Test
    public void deletionDifferenceTest() {
        ArrayList<Expectation> expectations = new ArrayList<>(Arrays.asList(
                new Expectation("hello", "hell", 1),
                new Expectation("hello", "", 5),
                new Expectation("hello", "hello", 0)));

        expectations.forEach(e -> Assertions.assertEquals(e.distance, Utils.strDistance(e.s1, e.s2)));
    }

    @Test
    public void insertionDifferenceTest() {
        ArrayList<Expectation> expectations = new ArrayList<>(Arrays.asList(
                new Expectation("hal", "halo", 1),
                new Expectation("tes", "testing is important", 17),
                new Expectation("pri", "privet", 3),
                new Expectation("hello", "hello", 0)));

        expectations.forEach(e -> Assertions.assertEquals(e.distance, Utils.strDistance(e.s1, e.s2)));
    }

    @Test
    public void replaceDifferenceTest() {
        ArrayList<Expectation> expectations = new ArrayList<>(Arrays.asList(
                new Expectation("kalo", "halo", 1),
                new Expectation("oliver", "aliver", 1),
                new Expectation("soliverp", "polivery", 2),
                new Expectation("hello", "hello", 0)));

        expectations.forEach(e -> Assertions.assertEquals(e.distance, Utils.strDistance(e.s1, e.s2)));
    }

    @Test
    public void overallDifferenceTest() {
        ArrayList<Expectation> expectations = new ArrayList<>(Arrays.asList(
                new Expectation("ali", "veli", 2),
                new Expectation("good", "godd", 1),
                new Expectation("hello", "help me", 4)));
        expectations.forEach(e -> Assertions.assertEquals(e.distance, Utils.strDistance(e.s1, e.s2)));

    }
}
