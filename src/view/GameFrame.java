package view;

import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

public class GameFrame extends JFrame {
	
    public GameFrame(GamePanel gamePanel) {
    	// Configura la ventana del juego
        this.setTitle("Mi Juego");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Agregar panel
        this.add(gamePanel);
        
        // Deshabilita la posibilidad de redimensionar
        this.setResizable(false);
        
        // Acomodarse al contenido de Jframe 
		this.pack();
		
        // Agrega más configuraciones si es necesario
        this.setVisible(true);
       
    }
  
}
