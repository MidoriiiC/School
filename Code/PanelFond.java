import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;



public class PanelFond extends JPanel{

    private BufferedImage image;
    public PanelFond() {
	try{
	image = ImageIO.read(new File("../Images/ecransMenu/Menu.png"));
	}catch(IOException e){}
    }
    protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	g.drawImage(image, 0, 0, null);
    }
}




   
