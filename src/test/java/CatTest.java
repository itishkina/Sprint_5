import com.example.Cat;
import com.example.Feline;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CatTest {
    @Test
    @DisplayName("getSound() должен возвращать 'Мяу'")
    public void getSoundReturnMyaWhenCalled(){
        Cat cat = new Cat(null);
        String actualResult = cat.getSound();
        assertEquals("Мяу", actualResult, "Кот должен мяукать");
    }

    @Test
    @DisplayName("getFood() должен возвращать результат вызова predator.eatMeat()")
    public void getFoodReturnMeatFoodList_whenCalled() throws Exception {
        Feline mockFeline = mock(Feline.class);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(mockFeline.eatMeat()).thenReturn(expectedFood);
        Cat cat = new Cat(mockFeline);
        List<String> actualResult = cat.getFood();
        assertEquals(expectedFood, actualResult, "Кот должен есть мясо");
        verify(mockFeline).eatMeat();
    }

}
