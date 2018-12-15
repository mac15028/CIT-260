/*
 * The CropControl class - part of the control layer
 * class contains all of the calculation methods for managing the crops
 * Author: Taylor Mackintosh
 * Date last modified: Oct 2018
 */
package control;

import exceptions.CropException;
import model.CropData;
import java.util.Random;

public class CropControl {
    // constants
    private static final int ACRES_PER_BUSHEL = 2;
    private static final int PEOPLE_PER_ACRE = 10;
    private static final int BUSHELS_PER_PERSON = 20;
    private static int YIELD_BASE;
    private static int YIELD_RANGE;
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
     * @throws exceptions.CropException
     * Pre-conditions: acres to buy must be positive,
     * the number of people must be at least 1 per 10 acres
     * and there must be enough bushels available to make the purchase
     */
    public static void buyLand(int landPrice, int acresToBuy, CropData cropData) throws CropException
    {
        //if acresToBuy < 0, throw exception
        if (acresToBuy < 0)
            throw new CropException("A negative value was input");
        
        //if wheatInStore < (acresToBuy * landPrice), throw exception
        int wheatInStore = cropData.getWheatInStore();
        if (wheatInStore < (acresToBuy * landPrice))
            throw new CropException("There is insufficient wheat to buy this much land");
        
        //if population < (acresOwned + acresToBuy) * PEOPLE_PER_ACRE, throw exception
        int acresOwned = cropData.getAcresOwned();
        int population = cropData.getPopulation();
        if (acresToBuy > (population / PEOPLE_PER_ACRE))
            throw new CropException("There is insufficient population to work this much land");
        
        //acresOwned = acresOwned + acresToBuy
        acresOwned += acresToBuy;
        cropData.setAcresOwned(acresOwned);
        
        //wheatInStore = wheatInStore - (acresToBuy * landPrice)
        wheatInStore -= (acresToBuy * landPrice);
        cropData.setWheatInStore(wheatInStore);
    }
    
    /**
     * The sellLand method
     * Purpose: To sell land
     * @param landPrice
     * @param acresToSell
     * @param cropData
     * @throws exceptions.CropException
     * Pre-conditions: acres to sell must be positive and <= acresOwned
     */
    public static void sellLand(int landPrice, int acresToSell, CropData cropData) throws CropException
    {
        //if acresToSell < 0, throw exception
        if (acresToSell < 0)
           throw new CropException("A negative value was input");
        
        //if acresToSell > acresOwned, throw exception
        int acresOwned = cropData.getAcresOwned();
        if (acresToSell > acresOwned)
            throw new CropException("You cannot sell more land than you own");
        
        //acresOwned = acresOwned - acresToSell
        acresOwned -= acresToSell;
        cropData.setAcresOwned(acresOwned);
        
        //wheatInStore = wheatInStore + acresToSell * landPrice
        int wheatInStore = cropData.getWheatInStore();
        wheatInStore += (acresToSell * landPrice);
        cropData.setWheatInStore(wheatInStore);
    }
        
    /**
     * The feedPeople method
     * Purpose: to set aside wheat for the people
     * @param wheatForPeople
     * @param cropData
     * @throws exceptions.CropException
     * Pre-conditions: number set aside must be positive
     * and there must be enough wheat in storage
     */
    public static void feedPeople(int wheatForPeople, CropData cropData) throws CropException
    {
        int wheatInStore = cropData.getWheatInStore();
        
        //if wheatForPeople < 0, throw exception
        if (wheatForPeople < 0)
            throw new CropException("A negative value was input");
        
        //if wheatForPeople > wheatInStore, throw exception
        if (wheatForPeople > wheatInStore)
            throw new CropException("There is insufficient wheat to set aside this amount");
        
        //wheatInStore = wheatInStore - wheatForPeople
        wheatInStore -= wheatForPeople;
        cropData.setWheatInStore(wheatInStore);
        cropData.setWheatForPeople(wheatForPeople);
    }
    
    /**
     * The plantCrops method
     * Purpose: to plant wheat
     * @param acresPlanted
     * @param cropData
     * @throws exceptions.CropException
     * Pre-conditions: acres planted must be positive,
     * enough land must be available,
     * and there must be enough wheat available
     */
    public static void plantCrops(int acresPlanted, CropData cropData) throws CropException
    {
        //if acresPlanted < 0, throw exception
        if (acresPlanted < 0)
            throw new CropException("A negative value was input");
        
        //if acresPlanted > acresOwned, throw exception
        int acresOwned = cropData.getAcresOwned();
        if (acresPlanted > acresOwned)
            throw new CropException("There is insufficient land to plant this many acres");
        
        //if wheatInStore < (acresPlanted * ACRES_PER_BUSHEL), throw exception
        int wheatInStore = cropData.getWheatInStore();
        if (wheatInStore < (acresPlanted * ACRES_PER_BUSHEL))
            throw new CropException("There is insufficient wheat to plant this many acres");
        
        //wheatInStore = wheatInStore - (acresPlanted * ACRES_PER_BUSHEL)
        wheatInStore -= (acresPlanted * ACRES_PER_BUSHEL);
        cropData.setWheatInStore(wheatInStore);
        cropData.setAcresPlanted(acresPlanted);
    }
    
    /**
     * The setOffering method
     * Purpose: to set offering percentage
     * @param offering
     * @param cropData
     * Pre-conditions: offering must be positive
     * and less than or equal to 100 percent
     * @throws exceptions.CropException
     */
    public static void setOffering(int offering, CropData cropData) throws CropException
    {
        //if offering < 0, return -1
        if (offering < 0)
            throw new CropException("A negative value was input");
        
        //if offering > 100, return -1
        if (offering > 100)
            throw new CropException("You cannot offer more than 100 percent");
        
        //return offering
        cropData.setOffering(offering);
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
    
    /**
     * harvestCrops() method
     * Purpose: Calculate the amount harvested based on the offering
     * @param cropData
     */
    public static void harvestCrops(CropData cropData){
        int offering = cropData.getOffering();
        // if offering > 12, random value between 2-5 per acre
        if (offering > 12) {
            YIELD_BASE = 2;
            YIELD_RANGE = 4;
        // else if offering between 8 and 12, random value between 2-4 per acre
        } else if (offering >= 8 && offering <= 12) {
            YIELD_BASE = 2;
            YIELD_RANGE = 3;
        // else, random value between 1-3 per acre
        } else {
            YIELD_BASE = 1;
            YIELD_RANGE = 3;
        }
        int acresPlanted = cropData.getAcresPlanted();
        int cropYield = random.nextInt(YIELD_RANGE) + YIELD_BASE;
        int harvest = cropYield * acresPlanted;
        cropData.setCropYield(cropYield);
        cropData.setHarvest(harvest);
    }
    
    /**
     * payOffering() method
     * Purpose: To use the results of setOffering() and harvestCrops()
     * to pay the offering
     * @param cropData
     */
    public static void payOffering(CropData cropData) {
        int harvest = cropData.getHarvest();
        double offering = cropData.getOffering() / 100.0;
        int offeringBushels = (int) (harvest * (offering));
        int harvestAfterOffering = harvest - offeringBushels;
        cropData.setOfferingBushels(offeringBushels);
        cropData.setHarvestAfterOffering(harvestAfterOffering);
    }
    
    /**
     * storeWheat method
     * Purpose: Store the wheat gained after harvest and offering
     * @param cropData 
     */
    public static void storeWheat(CropData cropData) {
        int harvestAfterOffering = cropData.getHarvestAfterOffering();
        int wheatInStore = cropData.getWheatInStore();
        wheatInStore = wheatInStore + harvestAfterOffering;
        cropData.setWheatInStore(wheatInStore);
    }
    
    /**
     * calcEatenByRats method
     * Purpose: Calculate the amount of wheat eaten by rats
     * @param cropData 
     */
    public static void calcEatenByRats(CropData cropData) {
    // generate random value between 1 and 100
    int chance = random.nextInt(100) + 1;
    
    // if value < 30, calculate wheat eaten by rats according to offering
    if (chance < 30) {
        int offering = cropData.getOffering();
        int eatenAmount;
        // if offering < 8, random value between 3% and 7%
        if (offering < 8) {
            eatenAmount = random.nextInt(4) + 3;
        // else if offering >= 8 and <= 12, random value between 6% and 10%
        } else if (offering >= 8 && offering <= 12) {
            eatenAmount = random.nextInt(4) + 6;
        // else if offering > 12, random value between 3% and 5%
        } else {
            eatenAmount = random.nextInt(3) + 3;
        }
        double eatenPercent = eatenAmount / 100.0;
        int wheatInStore = cropData.getWheatInStore();
        int eatenByRats = (int) (wheatInStore * eatenPercent);
        // subtract amount eaten from wheatInStore
        wheatInStore = wheatInStore - eatenByRats;
        cropData.setEatenByRats(eatenByRats);
        cropData.setWheatInStore(wheatInStore);
    }
    }
    
    /**
     * growPopulation method
     * Purpose: grow the population of the city
     * @param cropData 
     */
    public static void growPopulation(CropData cropData) {
        int population = cropData.getPopulation();
        // generate random number to grow population between 1% and 5%
        int popGrowth = random.nextInt(4) + 1;
        double popPercent = popGrowth / 100.0;
        int newPeople = (int) (population * popPercent);
        cropData.setNewPeople(newPeople);
        population = population + newPeople;
        cropData.setPopulation(population);
    }
    
    public static void calcStarved(CropData cropData) {
        int population = cropData.getPopulation();
        int wheatSetAside = cropData.getWheatForPeople();
        // amount of wheat set aside / 20 = people fed
        int peopleFed = wheatSetAside / BUSHELS_PER_PERSON;
        
        // if people fed < population, subtract from population
        if (peopleFed < population) {
            int numStarved = population - peopleFed;
            cropData.setNumStarved(numStarved);
            population = population - numStarved;
            cropData.setPopulation(population);
        }
    }
}