package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.AbstractFactory.AbstractCharacter;
import model.AbstractFactory.Character.Girl;
import model.AbstractFactory.Character.Man;
import model.entitys.Player;
import view.GameFrame;
import view.GamePanel;

public class ButtonsController implements ActionListener{
    
    private GameFrame gameFrame;
    private Player player;
    private AbstractCharacter abtractCharacter;

    public ButtonsController(GameFrame gameFrame){
        this.gameFrame = gameFrame;
        this.player = Player.getInstance(100, 100);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        JButton buttons = (JButton) e.getSource();
        if(buttons.getText().equals("Player 1")){
            abtractCharacter = new Man();
        }else if(buttons.getText().equals("Player 2")){
            abtractCharacter = new Girl();
        }

        player.setC(abtractCharacter);
        this.gameFrame.switchToGame();
        
        
    }
}

