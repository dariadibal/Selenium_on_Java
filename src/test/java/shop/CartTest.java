package shop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

public class CartTest {
    private RealItem book;
    private VirtualItem flash;
    private static final double TAX = 0.2;

    @BeforeEach
    public void setupData(){
        book = new RealItem();
        book.setName("Harry Potter");
        book.setPrice(150);
        book.setWeight(200);

        flash = new VirtualItem();
        flash.setName("Linux");
        flash.setPrice(15);
        flash.setSizeOnDisk(25);
    }

    @Test
    @DisplayName("Testing that total price in the cart is counted correctly when item is added")
    public void realItemAndVirtualItemTotalPriceCheck(){
       double expectedTotal = 0;

       Cart raccoonCart = new Cart("raccoon-cart");

       raccoonCart.addRealItem(book);
       raccoonCart.addVirtualItem(flash);
       expectedTotal += book.getPrice() + book.getPrice()*TAX;
       expectedTotal += flash.getPrice() + flash.getPrice()*TAX;
       assertEquals(expectedTotal,raccoonCart.getTotalPrice(), "Total is counted incorrectly");
   }

   @Test
   @DisplayName("Testing that total price in the cart is counted correctly when item is deleted")
   public void deleteItemCheck(){
        Cart raccoonCart = new Cart("raccoon-cart");

        raccoonCart.addRealItem(book);
        raccoonCart.addVirtualItem(flash);
        double expectedTotal = raccoonCart.getTotalPrice();
        raccoonCart.deleteVirtualItem(flash);
        double actualTotal =  raccoonCart.getTotalPrice();

        assertNotEquals(expectedTotal,actualTotal,"Total is counted incorrectly");
    }

    @ParameterizedTest
    @DisplayName("Testing that total price in the cart is counted correctly for different VirtualItems")
    @MethodSource("itemsAndTotalProvider")
    public void addItemsTests(VirtualItem item, double total){
        Cart raccoonCart = new Cart("raccoon-cart");
        raccoonCart.addVirtualItem(item);
        assertEquals(total, raccoonCart.getTotalPrice(),"Total is counted incorrectly");
    }

    private static Stream<Arguments> itemsAndTotalProvider() {
        VirtualItem flash = new VirtualItem();
        flash.setName("Linux");
        flash.setPrice(15);
        flash.setSizeOnDisk(25);

        return Stream.of(
                arguments(flash, 18),
                arguments(null, 0)
        );
    }
}
