package com.amayr.d2;

import com.amayr.FileUtil;
import com.amayr.Measuring;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

final class IdsTest {

    @Test
    void given1() {
        var ids = new Ids();

        Measuring.runMeasured("Given1",
                () -> {
                    var result = ids.sumInvalids(Ids::invalidIdsPart1,
                            new Ids.IdRange(11, 22),
                            new Ids.IdRange(95, 115),
                            new Ids.IdRange(998, 1012),
                            new Ids.IdRange(1188511880, 1188511890),
                            new Ids.IdRange(222220, 222224),
                            new Ids.IdRange(1698522, 1698528),
                            new Ids.IdRange(446443, 446449),
                            new Ids.IdRange(38593856, 38593862),
                            new Ids.IdRange(565653, 565659),
                            new Ids.IdRange(824824821, 824824827),
                            new Ids.IdRange(2121212118, 2121212124));
                    assertThat(result).isEqualTo(1227775554);
                });
    }

    @Test
    void task1() {
        var ids = new Ids();

        Measuring.runMeasured("Task1",
                () -> {
                    var result = ids.sumInvalids(Ids::invalidIdsPart1,
                            Arrays.stream(FileUtil.parseFile("d2_input").stream()
                                            .findFirst().get()
                                            .split(","))
                                    .map(Ids.IdRange::of)
                                    .toArray(Ids.IdRange[]::new));

                    assertThat(result).isEqualTo(19605500130L);
                });
    }

    @Test
    void given2() {
        var ids = new Ids();

        Measuring.runMeasured("Given2",
                () -> {
                    var result = ids.sumInvalids(Ids::invalidIdsPart2,
                            new Ids.IdRange(11, 22),
                            new Ids.IdRange(95, 115),
                            new Ids.IdRange(998, 1012),
                            new Ids.IdRange(1188511880, 1188511890),
                            new Ids.IdRange(222220, 222224),
                            new Ids.IdRange(1698522, 1698528),
                            new Ids.IdRange(446443, 446449),
                            new Ids.IdRange(38593856, 38593862),
                            new Ids.IdRange(565653, 565659),
                            new Ids.IdRange(824824821, 824824827),
                            new Ids.IdRange(2121212118, 2121212124)
                    );

                    assertThat(result).isEqualTo(4174379265L);
                });
    }

    @Test
    void task2() {
        var ids = new Ids();

        Measuring.runMeasured("Task2",
                () -> {
                    var result = ids.sumInvalids(Ids::invalidIdsPart2,
                            Arrays.stream(FileUtil.parseFile("d2_input").stream()
                                            .findFirst().get()
                                            .split(","))
                                    .map(Ids.IdRange::of)
                                    .toArray(Ids.IdRange[]::new));

                    assertThat(result).isEqualTo(36862281418L);
                });
    }
}