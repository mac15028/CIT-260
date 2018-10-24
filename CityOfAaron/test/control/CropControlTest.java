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
     * Test of sellLand method, of class CropControl.
     * Test Case 2
     */
    @Test
    public void testSellLandCase2() {
        System.out.println("sellLand - Test Case 2");
        CropData cropData = new CropData();
        cropData.setAcresOwned(2800);
        
        int landPrice = 20;
        int acresToSell = -5;
        int expResult = -1;
        int result = CropControl.sellLand(landPrice, acresToSell, cropData);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of sellLand method, of class CropControl.
     * Test Case 3
     */
    @Test
    public void testSellLandCase3() {
        System.out.println("sellLand - Test Case 3");
        CropData cropData = new CropData();
        cropData.setAcresOwned(2800);
        
        int landPrice = 20;
        int acresToSell = 3000;
        int expResult = -1;
        int result = CropControl.sellLand(landPrice, acresToSell, cropData);
        assertEquals(expResult, result);
    }

    /**
     * Test of sellLand method, of class CropControl.
     * Test Case 4
     */
    @Test
    public void testSellLandCase4() {
        System.out.println("sellLand - Test Case 4");
        CropData cropData = new CropData();
        cropData.setAcresOwned(2000);
        
        int landPrice = 10;
        int acresToSell = 2000;
        int expResult = 0;
        int result = CropControl.sellLand(landPrice, acresToSell, cropData);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of sellLand method, of class CropControl.
     * Test Case 5
     */
    @Test
    public void testSellLandCase5() {
        System.out.println("sellLand - Test Case 5");
        CropData cropData = new CropData();
        cropData.setAcresOwned(2000);
        
        int landPrice = 10;
        int acresToSell = 0;
        int expResult = 2000;
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
        cropData.setPopulation(11);
        
        int landPrice = 10;
        int acresToBuy = 10;
        int expResult = 110;
        int result = CropControl.buyLand(landPrice, acresToBuy, cropData);
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
        cropData.setPopulation(11);
        
        int landPrice = 10;
        int acresToBuy = -25;
        int expResult = -1;
        int result = CropControl.buyLand(landPrice, acresToBuy, cropData);
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
        cropData.setPopulation(2);
        
        int landPrice = 50;
        int acresToBuy = 50;
        int expResult = -1;
        int result = CropControl.buyLand(landPrice, acresToBuy, cropData);
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
        cropData.setPopulation(10);
        
        int landPrice = 20;
        int acresToBuy = 0;
        int expResult = 100;
        int result = CropControl.buyLand(landPrice, acresToBuy, cropData);
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
        cropData.setPopulation(15);
        
        int landPrice = 10;
        int acresToBuy = 50;
        int expResult = 150;
        int result = CropControl.buyLand(landPrice, acresToBuy, cropData);
        assertEquals(expResult, result);
    }
    
     /**
     * Test of feedPeople method, of class CropControl.
     * Test Case 1
     */
    @Test
    public void testfeedPeopleCase1() {
        System.out.println("feedPeople - Test Case 1");
        CropData cropData = new CropData();
        cropData.setWheatInStore(500);
        
        int wheatForPeople = 10;
        int expResult = 10;
        int result = CropControl.feedPeople(wheatForPeople, cropData);
        assertEquals(expResult, result);
    }
        
     /**
     * Test of feedPeople method, of class CropControl.
     * Test Case 2
     */
    @Test
    public void testfeedPeopleCase2() {
        System.out.println("feedPeople - Test Case 2");
        CropData cropData = new CropData();
        cropData.setWheatInStore(500);
        
        int wheatForPeople = -10;
        int expResult = -1;
        int result = CropControl.feedPeople(wheatForPeople, cropData);
        assertEquals(expResult, result);
    }
        
     /**
     * Test of feedPeople method, of class CropControl.
     * Test Case 3
     */
    @Test
    public void testfeedPeopleCase3() {
        System.out.println("feedPeople - Test Case 3");
        CropData cropData = new CropData();
        cropData.setWheatInStore(500);
        
        int wheatForPeople = 1000;
        int expResult = -1;
        int result = CropControl.feedPeople(wheatForPeople, cropData);
        assertEquals(expResult, result);
    }
        
     /**
     * Test of feedPeople method, of class CropControl.
     * Test Case 4
     */
    @Test
    public void testfeedPeopleCase4() {
        System.out.println("feedPeople - Test Case 4");
        CropData cropData = new CropData();
        cropData.setWheatInStore(500);
        
        int wheatForPeople = 0;
        int expResult = 0;
        int result = CropControl.feedPeople(wheatForPeople, cropData);
        assertEquals(expResult, result);
    }
        
     /**
     * Test of feedPeople method, of class CropControl.
     * Test Case 5
     */
    @Test
    public void testfeedPeopleCase5() {
        System.out.println("feedPeople - Test Case 5");
        CropData cropData = new CropData();
        cropData.setWheatInStore(500);
        
        int wheatForPeople = 500;
        int expResult = 500;
        int result = CropControl.feedPeople(wheatForPeople, cropData);
        assertEquals(expResult, result);
    }
        
     /**
     * Test of plantCrops method, of class CropControl.
     * Test Case 1
     */
    @Test
    public void testplantCropsCase1() {
        System.out.println("plantCrops - Test Case 1");
        CropData cropData = new CropData();
        cropData.setAcresOwned(10);
        cropData.setWheatInStore(100);
        
        int acresPlanted = 1;
        int expResult = 1;
        int result = CropControl.plantCrops(acresPlanted, cropData);
        assertEquals(expResult, result);
    }
            
     /**
     * Test of plantCrops method, of class CropControl.
     * Test Case 2
     */
    @Test
    public void testplantCropsCase2() {
        System.out.println("plantCrops - Test Case 2");
        CropData cropData = new CropData();
        cropData.setAcresOwned(10);
        cropData.setWheatInStore(100);
        
        int acresPlanted = -10;
        int expResult = -1;
        int result = CropControl.plantCrops(acresPlanted, cropData);
        assertEquals(expResult, result);
    }
            
     /**
     * Test of plantCrops method, of class CropControl.
     * Test Case 3
     */
    @Test
    public void testplantCropsCase3() {
        System.out.println("plantCrops - Test Case 3");
        CropData cropData = new CropData();
        cropData.setAcresOwned(1);
        cropData.setWheatInStore(5);
        
        int acresPlanted = 10;
        int expResult = -1;
        int result = CropControl.plantCrops(acresPlanted, cropData);
        assertEquals(expResult, result);
    }
            
     /**
     * Test of plantCrops method, of class CropControl.
     * Test Case 4
     */
    @Test
    public void testplantCropsCase4() {
        System.out.println("plantCrops - Test Case 4");
        CropData cropData = new CropData();
        cropData.setAcresOwned(10);
        cropData.setWheatInStore(100);
        
        int acresPlanted = 0;
        int expResult = 0;
        int result = CropControl.plantCrops(acresPlanted, cropData);
        assertEquals(expResult, result);
    }
            
     /**
     * Test of plantCrops method, of class CropControl.
     * Test Case 5
     */
    @Test
    public void testplantCropsCase5() {
        System.out.println("plantCrops - Test Case 5");
        CropData cropData = new CropData();
        cropData.setAcresOwned(10);
        cropData.setWheatInStore(100);
        
        int acresPlanted = 10;
        int expResult = 10;
        int result = CropControl.plantCrops(acresPlanted, cropData);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of setOffering method, of class CropControl.
     * Test Case 1
     */
    @Test
    public void testsetOfferingCase1() {
        System.out.println("plantCrops - Test Case 1");
        
        int offering = 10;
        int expResult = 10;
        int result = CropControl.setOffering(offering);
        assertEquals(expResult, result);
    }
        
    /**
     * Test of setOffering method, of class CropControl.
     * Test Case 2
     */
    @Test
    public void testsetOfferingCase2() {
        System.out.println("plantCrops - Test Case 2");
        
        int offering = -10;
        int expResult = -1;
        int result = CropControl.setOffering(offering);
        assertEquals(expResult, result);
    }
        
    /**
     * Test of setOffering method, of class CropControl.
     * Test Case 3
     */
    @Test
    public void testsetOfferingCase3() {
        System.out.println("plantCrops - Test Case 3");
        
        int offering = 110;
        int expResult = -1;
        int result = CropControl.setOffering(offering);
        assertEquals(expResult, result);
    }
        
    /**
     * Test of setOffering method, of class CropControl.
     * Test Case 4
     */
    @Test
    public void testsetOfferingCase4() {
        System.out.println("plantCrops - Test Case 4");
        
        int offering = 0;
        int expResult = 0;
        int result = CropControl.setOffering(offering);
        assertEquals(expResult, result);
    }
        
    /**
     * Test of setOffering method, of class CropControl.
     * Test Case 5
     */
    @Test
    public void testsetOfferingCase5() {
        System.out.println("plantCrops - Test Case 5");
        
        int offering = 100;
        int expResult = 100;
        int result = CropControl.setOffering(offering);
        assertEquals(expResult, result);
    }
}