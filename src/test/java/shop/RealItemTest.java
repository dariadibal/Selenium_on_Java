package shop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RealItemTest {

    @Test
    @DisplayName("Testing that WeightProperty can be set")
    public void realItemWeightPropertyCheck(){
        int weightAmount = 2000;
        RealItem weight = new RealItem();
        weight.setWeight(weightAmount);
        assertEquals(weightAmount, weight.getWeight(),"Weight is set incorrectly");
    }
}
