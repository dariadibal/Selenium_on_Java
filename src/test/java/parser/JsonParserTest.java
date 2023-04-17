package parser;

import org.junit.jupiter.api.*;
import shop.Cart;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class JsonParserTest {
    static File file;
    @BeforeAll
    static void fileCreation(){
        file = new File("src/main/resources/raccoon-cart.json");
    }

    @Tag("happy")
    @Test
    void readFromFile() {
        JsonParser parser = new JsonParser();
        Cart cart = parser.readFromFile((new File("src/main/resources/eugen-cart.json")));

        assertAll(
                "group assertion for JsonParser read",
                ()->assertNotNull(cart),
                ()->assertEquals(cart.getClass(), Cart.class),
                ()->assertEquals("eugen-cart", cart.getCartName())
        );
    }

    @Tag("negative")
    @Test
    void exceptionTest() {
        JsonParser parser = new JsonParser();
        assertThrows(NoSuchFileException.class, () -> parser.readFromFile((new File("raccoons address"))));
    }

    @Disabled("due to task 5")
    @Test
    @Tag("happy")
    void writeToFile() {
        JsonParser parser = new JsonParser();
        Cart raccoonCart = new Cart("raccoon-cart");
        parser.writeToFile(raccoonCart);
        assertTrue(file.exists());
    }

    @AfterAll
    static void deleteFile (){
        file.delete();
    }
}