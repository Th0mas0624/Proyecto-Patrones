package view;

import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

public class GameFrame extends JFrame {
    private GameMenu menuPanel;
    private GamePanel gamePanel;
	
    public GameFrame(GamePanel gamePanel) {
        this.menuPanel = new GameMenu(this);
        this.gamePanel = gamePanel;


        
    	// Configura la ventana del juego
        this.setTitle("Mi Juego");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    

        // Agrega el menú al frame por defecto
        this.add(menuPanel);
        // Agregar panel
        //this.add(gamePanel);
        
        // Deshabilita la posibilidad de redimensionar
        this.setResizable(false);



        
        // Acomodarse al contenido de Jframe 
		this.pack();
		
        // Agrega más configuraciones si es necesario
        this.setVisible(true);
       
    }

    public GameMenu getMenuPanel() {
        return menuPanel;
    }

    public void switchToGame() {
        this.remove(menuPanel);
        this.add(gamePanel);
        gamePanel.requestFocus();
        this.revalidate();
        this.repaint();
    }
  
}
