package controller;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.AbstractFactory.AbstractCharacter;
import model.AbstractFactory.Character.Girl;
import model.AbstractFactory.Character.Man;
import model.Decorator.Player;
import view.GameFrame;
import view.GamePanel;

public class ButtonsCrontroller implements ActionListener{
    
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

        player = Player.getInstance(100, 100, a);
        g = new GamePanel(player);
        Container contentPane = this.w.getContentPane();
        contentPane.removeAll();
        contentPane.add(g);
        contentPane.revalidate();
        contentPane.repaint();
        
    }

    public void setWindow(GameFrame w){
        this.w = w;
    }
}
