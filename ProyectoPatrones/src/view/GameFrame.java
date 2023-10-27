package view;

import javax.swing.JFrame;

import java.awt.Dimension;


public class GameFrame extends JFrame {
	
    public GameFrame(SelectPlayer gamePanel) {
    	// Configura la ventana del juego
        this.setTitle("Mi Juego");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //etFrameSize();

        
        
        // Centra la ventana en la pantalla
        this.setLocationRelativeTo(null);
        
        // Agregar panel
        this.setContentPane(gamePanel);    
        // Deshabilita la posibilidad de redimensionar
        this.setResizable(false);
        
        
		this.pack();
		
        // Evita la maximización
        //this.setExtendedState(JFrame.NORMAL);
        
        
        // Agrega más configuraciones si es necesario
        this.setVisible(true);
       
    }
    private void setFrameSize() {
		Dimension size = new Dimension(1200, 700);
		this.setSize(size);
	}
}
