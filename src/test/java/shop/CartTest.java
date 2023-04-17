package shop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

class CartTest {
    RealItem book;
    VirtualItem flash;

    @BeforeEach
    void setupData(){
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
    void realItemAndVirtualItemTotalPriceCheck(){
       double expectedTotal = 0;
       double TAX = 0.2;

       Cart raccoonCart = new Cart("raccoon-cart");

       raccoonCart.addRealItem(book);
       raccoonCart.addVirtualItem(flash);
       expectedTotal += book.getPrice() + book.getPrice()*TAX;
       expectedTotal += flash.getPrice() + flash.getPrice()*TAX;
       assertEquals(expectedTotal,raccoonCart.getTotalPrice());
   }

   @Test
   void deleteItemCheck(){
        Cart raccoonCart = new Cart("raccoon-cart");

        raccoonCart.addRealItem(book);
        raccoonCart.addVirtualItem(flash);
        double expectedTotal = raccoonCart.getTotalPrice();
        raccoonCart.deleteVirtualItem(flash);
        double actualTotal =  raccoonCart.getTotalPrice();

        assertNotEquals(expectedTotal,actualTotal);
    }

    @ParameterizedTest
    @MethodSource("itemsAndTotalProvider")
    void addItemsTests(VirtualItem item, double total){
        Cart raccoonCart = new Cart("raccoon-cart");
        raccoonCart.addVirtualItem(item);
        assertEquals(total, raccoonCart.getTotalPrice());
    }

    static Stream<Arguments> itemsAndTotalProvider() {
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
