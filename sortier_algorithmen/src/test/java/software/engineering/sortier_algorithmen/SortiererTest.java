package software.engineering.sortier_algorithmen;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SortiererTest {

    @ParameterizedTest
    @MethodSource("testDaten")
    public void bubbleSort_shouldReturnSorted(int input[]) {

    }

    static Stream<Arguments> testDaten() {
        return Stream.of(Arguments.of(new int[] {}, new int[] {}));
    }

}
