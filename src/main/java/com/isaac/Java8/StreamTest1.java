package com.isaac.Java8;

import com.isaac.Java8.demo.Track;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.junit.Assert.*;

/**
 * @Author : Isaac
 * @Description:
 * @Date :Created in 14:26 2018/5/28
 */
public class StreamTest1 {
    public static void collectTest() {
        List<String> collected = Stream.of("a", "b", "c").collect(toList());
        assertEquals(Arrays.asList("a", "b", "c"),collected);
    }
    public static void mapTest() {
        List<String> collected = Stream.of("a", "b", "hello").map(string -> string.toUpperCase()).collect(toList());
        assertEquals(Arrays.asList("A", "B", "HELLO"),collected);
        List<String> beginningWithNumbers = Stream.of("a", "1abc", "abc1").filter(value -> Character.isDigit(value.charAt(0))).collect(toList());
        assertEquals(Arrays.asList("1abc"),beginningWithNumbers);
    }

    public static void flatMap(){
        List<Integer> together = Stream.of(Arrays.asList(1,2),Arrays.asList(3,4)).flatMap(numbers -> numbers.stream()).collect(toList());
        assertEquals(Arrays.asList(1,2,3,4),together);
    }
    public static void imperativeMaxLength() {
        List<Track> tracks = asList(new Track("Bakai", 524),
                new Track("Violets for Your Furs", 378),
                new Track("Time Was", 451));

        Track shortestTrack = tracks.stream()
                .min(Comparator.comparing(track -> track.getLength()))
                .get();

        assertEquals(tracks.get(1), shortestTrack);
    }
    public static void main(String[] args) {
//        collectTest();
//        mapTest();
//        flatMap();
        imperativeMaxLength();
    }
}
