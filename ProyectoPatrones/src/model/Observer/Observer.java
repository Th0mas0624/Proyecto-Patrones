package model.Observer;

import model.Decorator.Player;

public interface Observer {
    void updatePlayer(Player playerModel);
    void updatePlayerHealth(float health);
    
}
