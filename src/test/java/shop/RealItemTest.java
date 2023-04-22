package shop;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RealItemTest {

    @Test(description = "Testing that WeightProperty can be set")
    public void realItemWeightPropertyCheck() {
        int weightAmount = 2000;
        RealItem weight = new RealItem();
        weight.setWeight(weightAmount);
        assertEquals(weightAmount, weight.getWeight(), "Weight is set incorrectly");
    }
}
