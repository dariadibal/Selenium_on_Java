package shop;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class VirtualItemTest {
    private static final String EXPECTED_MSG = "Class: class shop.VirtualItem; Name: USB; Price: 15.0; Size on disk: 30000.0";

    @Test(groups = {"happy"}, description = "Testing that ToString method formats the output correctly")
    public void virtualItemToStringCheck() {
        VirtualItem usb = new VirtualItem();
        usb.setName("USB");
        usb.setPrice(15);
        usb.setSizeOnDisk(30000);
        assertEquals(EXPECTED_MSG, usb.toString(), "ToString method is formatted incorrectly in the output");
    }
}