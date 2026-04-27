
import com.example.Lion;
import com.example.Predator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LionTest {

    @Mock
    private Predator predator;


    @Test
    @DisplayName("hasMane = true, если пол = Самец")
    public void constructorShouldSetHasManeTrueForMale() throws Exception {
        Lion lion = new Lion("Самец", predator);
        assertTrue(lion.doesHaveMane(), "У самца должна быть грива");
    }
    @Test
    @DisplayName("hasMane = false, если пол = Самка")
    public void constructorShouldSetHasManeFalseForFemale() throws Exception {
        Lion lion = new Lion("Самка", predator);
        assertFalse(lion.doesHaveMane(), "У самки нет гривы");
    }
    @Test
    @DisplayName("Недопустимое значение пола животного")
    public void constructorShouldThrowExceptionForInvalidSex() {
        Exception exception = assertThrows(Exception.class, () -> {
            new Lion("Неизвестный", predator);
        });
        assertEquals("Используйте допустимые значения пола животного - самец или самка",
                exception.getMessage());
    }

    @Test
    @DisplayName("getKittens() возвращает 1 животное")
    void getKittensShouldReturnDefaultValue() throws Exception {
        when(predator.getKittens()).thenReturn(1);
        Lion lion = new Lion("Самец", predator);
        assertEquals(1, lion.getKittens(), "Количество животных должно быть 1");
    }

    @Test
    @DisplayName("getFood() возвращает еду хищника")
    void getFoodShouldReturnCustomFoodFromPredator() throws Exception {
        List<String> expectedFood = List.of("Мясо", "Птица", "Рыба");
        when(predator.eatMeat()).thenReturn(expectedFood);

        Lion lion = new Lion("Самка", predator);
        List<String> food = lion.getFood();

        assertEquals(expectedFood, food, "Список еды должен включать мясо, птицу и рыбу");
    }

}
