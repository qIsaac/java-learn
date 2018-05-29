package com.isaac.Java8.demo;

import java.util.stream.Stream;
import static java.util.stream.Stream.concat;

/**
 * @Author : Isaac
 * @Description:
 * @Date :Created in 16:21 2018/5/28
 */
public interface Performance {
    public String getName();

    public Stream<Artist> getMusicians();

    // TODO: test
    public default Stream<Artist> getAllMusicians() {
        return getMusicians().flatMap(artist -> {
            return concat(Stream.of(artist), artist.getMembers());
        });
    }
}
