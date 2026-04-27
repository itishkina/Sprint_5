import com.example.Feline;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class FelineTest {
    @Spy
    private Feline felineSpy;

    @Test
    @DisplayName("Метод eatMeat должен возвращать группу еды для хищника")
    public void eatMeat_shouldReturnMeatFoodList_whenCalled() throws Exception{
        List<String> mockFood = List.of("Животные", "Птицы", "Рыба");
        doReturn(mockFood).when(felineSpy).getFood("Хищник");

        List<String> actualResult = felineSpy.eatMeat();

        assertEquals(mockFood, actualResult,  "Должна быть группа мясной еды: Животные, Птицы, Рыба.");
        verify(felineSpy).getFood("Хищник"); // проверяем, что метод действительно вызван
    }

    @Test
    @DisplayName("Метод getFamily должен возвращать семейство Кошачьи")
    public void getFamily_shouldReturnFelineFamily_whenCalled() {
        String actualResult = felineSpy.getFamily();
        assertEquals( "Кошачьи", actualResult, "Должно быть семейство Кошачьи");
    }

    @Test
    @DisplayName("Метод getKittens по умолчанию должен возвращать 1 животное")
        public void getKittens_withoutParams_shouldReturnOne()  {
        int actualResult = felineSpy.getKittens();
        assertEquals(1, actualResult,  "Ожидаем 1 животное");
    }



}
