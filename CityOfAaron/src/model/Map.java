package model;

import java.io.Serializable;

public class Map implements Serializable {
    private int rowCount;           // stores the number of rows
    private int colCount;           // stores the number of columns
    private Location[][] locations; // a reference to a 2-dimensional array
    
    /**
     * default Map constructor
     * Purpose: Set data members to default values
     */
    public Map() {};
    
    /**
     * parameterized Map constructor
     * Purpose: Sets row and column values
     *   and creates an array of Location objects
     * @param _rows
     * @param _cols
     */
    public Map(int _rows, int _cols){
        this.rowCount = _rows;
        this.colCount = _cols;
        
        // create the array of location objects
        this.locations = new Location[_rows][_cols];
    }

    public int getRowCount() {
        return rowCount;
    }

    public int getColCount() {
        return colCount;
    }
    
    /** 
     * The getLocation method
     * Purpose: returns the location object at the given row and column
     * @param row
     * @param col
     * @return a Location object
     */
    public Location getLocation(int row, int col) {
        return this.locations[row][col];
    }
    
    /**
     * The setLocation method
     * Purpose: stores a location object at the row and column
     * @param row
     * @param col
     * @param _location
     */
    public void setLocation(int row, int col, Location _location){
        this.locations[row][col] = _location;
    }
}
