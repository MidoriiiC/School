import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
/**
 * Cette classe permet gérer le joueur principal de la partie.
 *
 * @version 20-07-2018
 * @author Mathilde Charrière
 */

public class Joueur{

    public String nom;
    private int style; /* représente sportif, délégué, populaire, ...*/
    public ImageIcon front;
    public ImageIcon back;
    public ImageIcon left;
    public ImageIcon right;
    public ImageIcon leftDo;
    public ImageIcon rightDo;
    public String action;
    public int x;
    public int y;
    public String salleP;
    /**
     * Cette fonction initie un(e) &eacute;l&egrav;ve, o&ugrav; la variable
     n est le nom. Les images correspondantes au prénom sont chargées, et 
     l'action spéciale du personnage est attribuée.
    **/
    
    public Joueur(String n){
	nom=n;
	try{
	    if(n.equals("Baptiste")){  //pos ok
		salleP="Salle1";
		x=14;
		y=3;
		action="fouiller";
		front=new ImageIcon(ImageIO.read(new File("../Images/MainBoy/Boy1.png")));
		back=new ImageIcon(ImageIO.read(new File("../Images/MainBoy/BoyBack1.png")));
		left=new ImageIcon(ImageIO.read(new File("../Images/MainBoy/BoyLeft1.png")));
		right=new ImageIcon(ImageIO.read(new File("../Images/MainBoy/BoyRight1.png")));
		leftDo=new ImageIcon(ImageIO.read(new File("../Images/MainBoy/BoyLeftSearch1.png")));
		rightDo=new ImageIcon(ImageIO.read(new File("../Images/MainBoy/BoyRightSearch1.png")));
	    }
	    if(n.equals("Olivia")){  //pos ok
		x=4;
		y=5;
		salleP="Salle4";
		action="papoter";
		front=new ImageIcon(ImageIO.read(new File("../Images/MainGirl/Girl2.png")));
		back=new ImageIcon(ImageIO.read(new File("../Images/MainGirl/GirlBack2.png")));
		left=new ImageIcon(ImageIO.read(new File("../Images/MainGirl/GirlLeft2.png")));
		right=new ImageIcon(ImageIO.read(new File("../Images/MainGirl/GirlRight2.png")));
	    }
	    if(n.equals("Mathéo")){  //pos ok
		x=1;
		y=5;
		salleP="Salle2";
	       
		action="papoter";
		front=new ImageIcon(ImageIO.read(new File("../Images/MainBoy/Boy2.png")));
		back=new ImageIcon(ImageIO.read(new File("../Images/MainBoy/BoyBack2.png")));
		left=new ImageIcon(ImageIO.read(new File("../Images/MainBoy/BoyLeft2.png")));
		right=new ImageIcon(ImageIO.read(new File("../Images/MainBoy/BoyRight2.png")));
	    }
	    if(n.equals("Inès")){
		x=7;
		y=6;
		salleP="Salle2";
		action="distribuer";
		front=new ImageIcon(ImageIO.read(new File("../Images/MainGirl/Girl3.png")));
		back=new ImageIcon(ImageIO.read(new File("../Images/MainGirl/GirlBack3.png")));
		left=new ImageIcon(ImageIO.read(new File("../Images/MainGirl/GirlLeft3.png")));
		right=new ImageIcon(ImageIO.read(new File("../Images/MainGirl/GirlRight3.png")));
		leftDo=new ImageIcon(ImageIO.read(new File("../Images/MainGirl/GirlLeftSearch3.png")));
		rightDo=new ImageIcon(ImageIO.read(new File("../Images/MainGirl/GirlRightSearch3.png")));
	    }
	    if(n.equals("Myriam")){  //pos ok
		salleP="Salle3";
		x=14;
		y=3;
		action="fouiller";
		front=new ImageIcon(ImageIO.read(new File("../Images/MainGirl/Girl1.png")));
		back=new ImageIcon(ImageIO.read(new File("../Images/MainGirl/GirlBack1.png")));
		left=new ImageIcon(ImageIO.read(new File("../Images/MainGirl/GirlLeft1.png")));
		right=new ImageIcon(ImageIO.read(new File("../Images/MainGirl/GirlRight1.png")));
		leftDo=new ImageIcon(ImageIO.read(new File("../Images/MainGirl/GirlLeftSearch1.png")));
		rightDo=new ImageIcon(ImageIO.read(new File("../Images/MainGirl/GirlRightSearch1.png")));
	    }
	    if(n.equals("Thomas")){  //pos ok
		salleP="Salle1";
		x=8;
		y=6;
		action="distribuer";
		front=new ImageIcon(ImageIO.read(new File("../Images/MainBoy/Boy3.png")));
		back=new ImageIcon(ImageIO.read(new File("../Images/MainBoy/BoyBack3.png")));
		left=new ImageIcon(ImageIO.read(new File("../Images/MainBoy/BoyLeft3.png")));
		right=new ImageIcon(ImageIO.read(new File("../Images/MainBoy/BoyRight3.png")));
		leftDo=new ImageIcon(ImageIO.read(new File("../Images/MainBoy/BoyLeftSearch3.png")));
		rightDo=new ImageIcon(ImageIO.read(new File("../Images/MainBoy/BoyRightSearch3.png")));
	    }

	}catch (IOException e){
	    e.printStackTrace();
	};
    }
    /**
     * Cette fonction permet de récupérer la valeur nom.
     *
     *@return renvoie le String correspondant au nom de l'&eacute;l&egrav;ve.
     
    
     public String getName(){
     return this.nom;
     }
     public void setX(int val){ x=val;}
     public void setY(int val){ x=val;}**/
}
