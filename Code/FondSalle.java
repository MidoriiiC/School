import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;



public class FondSalle extends JPanel{

    private BufferedImage image;
    public FondSalle(String fichier) {
	try{
	image = ImageIO.read(new File("../Images/Fonds/"+fichier+".png"));
	//System.out.println(fichier);
	}catch(IOException e){
	    System.out.println("fichier non trouvé");
	}
    }
    protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	g.drawImage(image, 0, 0, null);
    }
}

