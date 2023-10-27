package model.Observer;

import model.entitys.Player;

public interface Observer {
    void updatePlayer(Player playerModel);
    void updatePlayerHealth(float health);
    
}
