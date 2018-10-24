/*
 * The CropControl class - part of the control layer
 * class contains all of the calculation methods for managing the crops
 * Author: Taylor Mackintosh
 * Date last modified: Oct 2018
 */
package control;

import model.CropData;
import java.util.Random;

public class CropControl {
    // constants
    private static final int ACRES_PER_BUSHEL = 2;
    private static final int PEOPLE_PER_ACRE = 1/10;
    private static final int LAND_BASE = 17;
    private static final int LAND_RANGE = 10;

    // random number generator
    private static Random random = new Random();
    
    /**
     * The buyLand method
     * Purpose: to buy land
     * @param landPrice
     * @param acresToBuy
     * @param cropData
     * @return the number of acres owned after the purchase
     * Pre-conditions: acres to buy must be positive,
     * the number of people must be at least 1 per 10 acres
     * and there must be enough bushels available to make the purchase
     */
    public static int buyLand(int landPrice, int acresToBuy, CropData cropData)
    {
        //if acresToBuy < 0, return -1
        if (acresToBuy < 0)
            return -1;
        
        //if wheatInStore < (acresToBuy * landPrice), return -1
        int wheatInStore = cropData.getWheatInStore();
        if (wheatInStore < (acresToBuy * landPrice))
            return -1;
        
        //if population < (acresOwned + acresToBuy) * PEOPLE_PER_ACRE, return -1
        int acresOwned = cropData.getAcresOwned();
        int population = cropData.getPopulation();
        if (population < (acresOwned + acresToBuy) * PEOPLE_PER_ACRE)
            return -1;
        
        //acresOwned = acresOwned + acresToBuy
        acresOwned += acresToBuy;
        cropData.setAcresOwned(acresOwned);
        
        //wheatInStore = wheatInStore - (acresToBuy * landPrice)
        wheatInStore -= (acresToBuy * landPrice);
        cropData.setWheatInStore(wheatInStore);
        
        //return acresOwned
        return acresOwned;
    }
    
    /**
     * The sellLand method
     * Purpose: To sell land
     * @param landPrice
     * @param acresToSell
     * @param cropData
     * @return the number of acres owned after the sale
     * Pre-conditions: acres to sell must be positive and <= acresOwned
     */
    public static int sellLand(int landPrice, int acresToSell, CropData cropData)
    {
        //if acresToSell < 0, return -1
        if (acresToSell < 0)
            return -1;
        
        //if acresToSell > acresOwned, return -1
        int acresOwned = cropData.getAcresOwned();
        if (acresToSell > acresOwned)
            return -1;
        
        //acresOwned = acresOwned - acresToSell
        acresOwned -= acresToSell;
        cropData.setAcresOwned(acresOwned);
        
        //wheatInStore = wheatInStore + acresToSell * landPrice
        int wheatInStore = cropData.getWheatInStore();
        wheatInStore += (acresToSell * landPrice);
        cropData.setWheatInStore(wheatInStore);
        
        //return acresOwned
        return acresOwned;
    }
        
    /**
     * The feedPeople method
     * Purpose: to set aside wheat for the people
     * @param wheatForPeople
     * @param cropData
     * @return  the number of bushels set aside
     * Pre-conditions: number set aside must be positive
     * and there must be enough wheat in storage
     */
    public static int feedPeople(int wheatForPeople, CropData cropData)
    {
        //if wheatForPeople < 0, return -1
        if (wheatForPeople < 0)
            return -1;
        
        //if wheatForPeople > wheatInStore, return -1
        int wheatInStore = cropData.getWheatInStore();
        if (wheatForPeople > wheatInStore)
            return -1;
        
        //wheatInStore = wheatInStore - wheatForPeople
        wheatInStore -= wheatForPeople;
        cropData.setWheatInStore(wheatInStore);
        
        //return wheatForPeople
        return wheatForPeople;
    }
    
    /**
     * The plantCrops method
     * Purpose: to plant wheat
     * @param acresPlanted
     * @param cropData
     * @return the number of acres planted
     * Pre-conditions: acres planted must be positive,
     * enough land must be available,
     * and there must be enough wheat available
     */
    public static int plantCrops(int acresPlanted, CropData cropData)
    {
        //if acresPlanted < 0, return -1
        if (acresPlanted < 0)
            return -1;
        
        //if acresPlanted > acresOwned, return -1
        int acresOwned = cropData.getAcresOwned();
        if (acresPlanted > acresOwned)
            return -1;
        
        //if wheatInStore < (acresPlanted * ACRES_PER_BUSHEL), return -1
        int wheatInStore = cropData.getWheatInStore();
        if (wheatInStore < (acresPlanted * ACRES_PER_BUSHEL))
                return -1;
        //wheatInStore = wheatInStore - (acresPlanted * ACRES_PER_BUSHEL)
        wheatInStore -= (acresPlanted * ACRES_PER_BUSHEL);
        
        //return acresPlanted
        return acresPlanted;
    }
    
    /**
     * The setOffering method
     * Purpose: to set offering percentage
     * @param offering
     * @return offering percentage
     * Pre-conditions: offering must be positive
     * and less than or equal to 100 percent
     */
    public static int setOffering(int offering)
    {
        //if offering < 0, return -1
        if (offering < 0)
            return -1;
        
        //if offering > 100, return -1
        if (offering > 100)
            return -1;
        
        //return offering
        return offering;
    }
    
    /**
     * calcLandCost() method
     * Purpose: Calculate a random land cost between 17 and 26 bushels/acre
     * Parameters: none
     * @return the land cost
     */
    public static int calcLandCost(){
        int landCost = random.nextInt(LAND_RANGE) + LAND_BASE;
        return landCost;
    }
}