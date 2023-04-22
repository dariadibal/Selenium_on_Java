package parser;

import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import shop.Cart;

import java.io.File;

import static org.testng.Assert.*;

public class JsonParserTest {
    private static File file;

    @BeforeSuite(groups = {"happy"})
    public static void fileCreation() {
        file = new File("src/main/resources/raccoon-cart.json");
    }

    @Test(groups = "happy", description = "Testing that reading from file is done")
    public void readFromFile() {
        JsonParser parser = new JsonParser();
        Cart cart = parser.readFromFile((new File("src/main/resources/eugen-cart.json")));
        SoftAssert assertsoft = new SoftAssert();
        assertsoft.assertNotNull(cart, "Cart object is not created correctly");
        assertsoft.assertEquals(cart.getClass(), Cart.class, "Created class is NOT Cart");
        assertsoft.assertEquals("eugen-cart", cart.getCartName(), "Cart is named incorrectly");
        assertsoft.assertAll();
    }

    @Test(groups = "negative", description = "Testing that custom exception is thrown")
    public void exceptionTest() {
        JsonParser parser = new JsonParser();
        assertThrows("Thrown exception is incorrect", NoSuchFileException.class, () -> parser.readFromFile((new File("raccoons address"))));
    }

    @Test(groups = "happy", description = "Testing that new file is added", enabled = false)
    public void writeToFile() {
        JsonParser parser = new JsonParser();
        Cart raccoonCart = new Cart("raccoon-cart");
        parser.writeToFile(raccoonCart);
        assertTrue(file.exists(), "File is NOT created");
    }

    @AfterSuite(groups = {"happy"})
    public static void deleteFile() {
        file.delete();
    }
}