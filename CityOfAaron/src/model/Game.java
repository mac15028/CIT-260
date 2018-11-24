package model;

import java.io.Serializable;
import java.util.Objects;

public class Game implements Serializable {
    
    // class instance variables
    private Player thePlayer;
    private CropData cropData;
    private Map theMap;

    public Game() {
    }
    
    public Player getPlayer() {
        return thePlayer;
    }

    public void setPlayer(Player thePlayer) {
        this.thePlayer = thePlayer;
    }
    
    public CropData getCropData() {
        return cropData;
    }

    public void setCropData(CropData cropData) {
        this.cropData = cropData;
    }

    public Map getMap() {
        return this.theMap;
    }
    
    public void setMap(Map map) {
        this.theMap = map;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.thePlayer);
        return hash;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Game other = (Game) obj;
        if (!Objects.equals(this.thePlayer, other.thePlayer)) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "Game{" + "thePlayer=" + thePlayer + '}';
    }

}
