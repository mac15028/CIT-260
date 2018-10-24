package control;

import model.CropData;
import org.junit.Test;
import static org.junit.Assert.*;

public class CropControlTest {
    /**
     * Test of sellLand method, of class CropControl.
     * Test Case 1
     */
    @Test
    public void testSellLandCase1() {
        System.out.println("sellLand - Test Case 1");
        CropData cropData = new CropData();
        cropData.setAcresOwned(2800);
        
        int landPrice = 20;
        int acresToSell = 10;
        int expResult = 2790;
        int result = CropControl.sellLand(landPrice, acresToSell, cropData);
        assertEquals(expResult, result);
    }

    /**
     * Test of buyLand method, of class CropControl.
     * Test Case 1
     */
    @Test
    public void testBuyLandCase1() {
        System.out.println("buyLand - Test Case 1");
        CropData cropData = new CropData();
        cropData.setAcresOwned(100);
        cropData.setWheatInStore(500);
        
        int landPrice = 10;
        int acresToBuy = 10;
        int population = 11;
        int expResult = 110;
        int result = CropControl.buyLand(landPrice, acresToBuy, population, cropData);
        assertEquals(expResult, result);
    }
    
     /**
     * Test of buyLand method, of class CropControl.
     * Test Case 2
     */
    @Test
    public void testBuyLandCase2() {
        System.out.println("buyLand - Test Case 2");
        CropData cropData = new CropData();
        cropData.setAcresOwned(100);
        cropData.setWheatInStore(500);
        
        int landPrice = 10;
        int acresToBuy = -25;
        int population = 11;
        int expResult = -1;
        int result = CropControl.buyLand(landPrice, acresToBuy, population, cropData);
        assertEquals(expResult, result);
    }
    
     /**
     * Test of buyLand method, of class CropControl.
     * Test Case 3
     */
    @Test
    public void testBuyLandCase3() {
        System.out.println("buyLand - Test Case 3");
        CropData cropData = new CropData();
        cropData.setAcresOwned(100);
        cropData.setWheatInStore(800);
        
        int landPrice = 50;
        int acresToBuy = 50;
        int population = 2;
        int expResult = -1;
        int result = CropControl.buyLand(landPrice, acresToBuy, population, cropData);
        assertEquals(expResult, result);
    }
    
     /**
     * Test of buyLand method, of class CropControl.
     * Test Case 4
     */
    @Test
    public void testBuyLandCase4() {
        System.out.println("buyLand - Test Case 4");
        CropData cropData = new CropData();
        cropData.setAcresOwned(100);
        cropData.setWheatInStore(500);
        
        int landPrice = 20;
        int acresToBuy = 0;
        int population = 10;
        int expResult = 100;
        int result = CropControl.buyLand(landPrice, acresToBuy, population, cropData);
        assertEquals(expResult, result);
    }
    
     /**
     * Test of buyLand method, of class CropControl.
     * Test Case 5
     */
    @Test
    public void testBuyLandCase5() {
        System.out.println("buyLand - Test Case 5");
        CropData cropData = new CropData();
        cropData.setAcresOwned(100);
        cropData.setWheatInStore(500);
        
        int landPrice = 10;
        int acresToBuy = 50;
        int population = 15;
        int expResult = 150;
        int result = CropControl.buyLand(landPrice, acresToBuy, population, cropData);
        assertEquals(expResult, result);
    }
    
}
