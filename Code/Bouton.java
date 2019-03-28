import javax.swing.*;

public class Bouton extends JButton{

    private String name;

    public Bouton(String nom){

	this.name=nom;
	this.setActionCommand(nom);
	this.setBorder(BorderFactory.createEmptyBorder());
	this.setText(nom);
	this.setContentAreaFilled(false);

    }
    public String getName(){
	return this.name;
    }
}
