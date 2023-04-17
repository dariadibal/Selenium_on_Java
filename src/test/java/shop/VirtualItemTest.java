package shop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VirtualItemTest {
    String expectedMsg = "Class: class shop.VirtualItem; Name: USB; Price: 15.0; Size on disk: 30000.0";

    @Test
    void virtualItemToStringCheck(){
        VirtualItem usb = new VirtualItem();
        usb.setName("USB");
        usb.setPrice(15);
        usb.setSizeOnDisk(30000);
        assertEquals(expectedMsg, usb.toString());
    }
}