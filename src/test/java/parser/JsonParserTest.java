package parser;

import org.junit.jupiter.api.*;
import shop.Cart;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class JsonParserTest {
    private static File file;

    @BeforeAll
    public static void fileCreation(){
        file = new File("src/main/resources/raccoon-cart.json");
    }

    @Tag("happy")
    @Test
    @DisplayName("Testing that reading from file is done")
    public void readFromFile() {
        JsonParser parser = new JsonParser();
        Cart cart = parser.readFromFile((new File("src/main/resources/eugen-cart.json")));

        assertAll(
                "group assertion for JsonParser read",
                ()->assertNotNull(cart, "Cart object is not created correctly"),
                ()->assertEquals(cart.getClass(), Cart.class, "Created class is NOT Cart"),
                ()->assertEquals("eugen-cart", cart.getCartName(),"Cart is named incorrectly")
        );
    }

    @Tag("negative")
    @Test
    @DisplayName("Testing that custom exception is thrown")
    public void exceptionTest() {
        JsonParser parser = new JsonParser();
        assertThrows(NoSuchFileException.class, () -> parser.readFromFile((new File("raccoons address"))),
                "Thrown exception is incorrect");
    }

    @Disabled("due to task 5")
    @Test
    @Tag("happy")
    @DisplayName("Testing that new file is added")
    public void writeToFile() {
        JsonParser parser = new JsonParser();
        Cart raccoonCart = new Cart("raccoon-cart");
        parser.writeToFile(raccoonCart);
        assertTrue(file.exists(),"File is NOT created");
    }

    @AfterAll
    public static void deleteFile (){
        file.delete();
    }
}