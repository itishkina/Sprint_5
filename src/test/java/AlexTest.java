import com.example.Alex;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class AlexTest {


    @Test
    @DisplayName("У Алекса есть грива")
    void constructorShouldCreateAlexAsMale() throws Exception {
        Alex alex = new Alex();
        assertTrue(alex.doesHaveMane(), "Алекс должен быть самцом с гривой");
    }

    @Test
    @DisplayName("В списке друзей Алекса есть три друга Марти, Глория и Мелман")
    void getFriendsShouldReturnCorrectFriendsList() throws Exception {
        Alex alex = new Alex();
        List<String> actualFriends = alex.getFriends();
        List<String> expectedFriends = List.of("Марти", "Глория", "Мелман");

        assertEquals(expectedFriends, actualFriends, "В списке друзей Алекса Марти, Глория и Мелман");

    }


    @Test
    @DisplayName("Алекс живет в зоопарке Нью-Йорка")
    void getPlaceOfLivingShouldReturnNewYorkZoo() throws Exception {
        Alex alex = new Alex();
        String place = alex.getPlaceOfLiving();

        assertEquals("Нью-Йоркский зоопарк", place, "Алекс должен жить в Нью-Йоркском зоопарке");
    }

    @Test
    @DisplayName("У Алекса нет котят")
    void getKittensShouldReturnZero() throws Exception {
        Alex alex = new Alex();
        int kittens = alex.getKittens();

        assertEquals(0, kittens, "У Алекса не должно быть котят");
    }

    @Test
    @DisplayName("Алекс ест еду хищника")
    void getFoodShouldReturnPredatorFood() throws Exception {
        Alex alex = new Alex();
        List<String> food = alex.getFood();

        assertTrue(food.contains("Животные"), "В списке должны быть Животные");
        assertTrue(food.contains("Птицы"), "В списке должны быть Птицы");
        assertTrue(food.contains("Рыба"), "В списке должна быть Рыба");
    }

}
