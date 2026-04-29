import com.example.Feline;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParameterizedTest {
    @ExtendWith(MockitoExtension.class)
    @Spy
    private Feline felineSpy;
    @ValueSource(ints = {5, -1, 0, 9999})

    @org.junit.jupiter.params.ParameterizedTest

    @DisplayName("Метод getKittens с параметром должен возвращать указанное количество котят")
    void getKittens_withAnyIntParam_shouldReturnSameIntValue(int expectedCount) {
        int actualResult = felineSpy.getKittens(expectedCount);
        assertEquals(expectedCount, actualResult, "Ожидаем " + expectedCount + " котят");
    }
}

