package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.AbstractFactory.AbstractCharacter;
import model.AbstractFactory.Character.Girl;
import model.AbstractFactory.Character.Man;
import model.entitys.Player;
import view.GameFrame;
import view.GameGame;
import view.GamePanel;

public class ButtonsController implements ActionListener{
    
    private GameFrame w;
    private GamePanel g;
    private Player player;
    private AbstractCharacter a;
    @Override
    public void actionPerformed(ActionEvent e) {

        JButton buttons = (JButton) e.getSource();
        if(buttons.getText().equals("1")){
            a = new Man();
        }else if(buttons.getText().equals("2")){
            a = new Girl();
        }

        player = Player.getInstance(100, 100);
        player.setC(a);
        g = new GamePanel(player);
        this.w.dispose();
        GameGame game= new GameGame(g);
        /*Container contentPane = this.w.getContentPane();
        contentPane.removeAll();
        contentPane.add(g);
        contentPane.revalidate();
        contentPane.repaint();*/
        
    }

    public void setWindow(GameFrame w){
        this.w = w;
    }
}

