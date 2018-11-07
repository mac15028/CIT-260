package model;

import java.io.Serializable;
import java.util.Objects;

public class Game implements Serializable {
    
    // class instance variables
    private Player Player;
    private CropData cropData;

    public Game() {
    }
    
    public Player getPlayer() {
        return Player;
    }

    public void setPlayer(Player thePlayer) {
        this.Player = Player;
    }
    
    public CropData getCropData() {
        return cropData;
    }

    public void setCropData(CropData cropData) {
        this.cropData = cropData;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.Player);
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
        if (!Objects.equals(this.Player, other.Player)) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "Game{" + "thePlayer=" + Player + '}';
    }

}
