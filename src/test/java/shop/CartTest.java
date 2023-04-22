package shop;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class CartTest {
    private RealItem book;
    private VirtualItem flash;
    private static final double TAX = 0.2;

    @BeforeSuite
    public void setupData() {
        book = new RealItem();
        book.setName("Harry Potter");
        book.setPrice(150);
        book.setWeight(200);

        flash = new VirtualItem();
        flash.setName("Linux");
        flash.setPrice(15);
        flash.setSizeOnDisk(25);
    }

    @Test(description = "Testing that total price in the cart is counted correctly when item is added")
    public void realItemAndVirtualItemTotalPriceCheck() {
        double expectedTotal = 0;

        Cart raccoonCart = new Cart("raccoon-cart");

        raccoonCart.addRealItem(book);
        raccoonCart.addVirtualItem(flash);
        expectedTotal += book.getPrice() + book.getPrice() * TAX;
        expectedTotal += flash.getPrice() + flash.getPrice() * TAX;
        assertEquals(expectedTotal, raccoonCart.getTotalPrice(), "Total is counted incorrectly");
    }


    @Test(description = "Testing that total price in the cart is counted correctly when item is deleted")
    public void deleteItemCheck() {
        Cart raccoonCart = new Cart("raccoon-cart");

        raccoonCart.addRealItem(book);
        raccoonCart.addVirtualItem(flash);
        double expectedTotal = raccoonCart.getTotalPrice();
        raccoonCart.deleteVirtualItem(flash);
        double actualTotal = raccoonCart.getTotalPrice();

        assertNotEquals(expectedTotal, actualTotal, "Total is counted incorrectly");
    }

    @Test(description = "Testing that total price in the cart is counted correctly for different VirtualItems", dataProvider = "itemsAndTotalProvider")
    public void addItemsTests(VirtualItem item, double total) {
        Cart raccoonCart = new Cart("raccoon-cart");
        raccoonCart.addVirtualItem(item);
        assertEquals(total, raccoonCart.getTotalPrice(), "Total is counted incorrectly");
    }

    @DataProvider(name = "itemsAndTotalProvider")
    public static Object[][] itemsAndTotalProvider() {
        VirtualItem flash = new VirtualItem();
        flash.setName("Linux");
        flash.setPrice(15);
        flash.setSizeOnDisk(25);

        return new Object[][]{{flash, 18}, {null, 0}};
    }
}
