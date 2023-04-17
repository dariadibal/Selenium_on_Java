package shop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RealItemTest {

    @Test
    void realItemWeightPropertyCheck(){
        int weightAmount = 2000;
        RealItem weight = new RealItem();
        weight.setWeight(weightAmount);
        assertEquals(weightAmount, weight.getWeight());
    }
}
