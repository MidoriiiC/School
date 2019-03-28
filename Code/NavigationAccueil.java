import javax.swing.*;

public class NavigationAccueil extends JButton{

    private String name;

    public NavigationAccueil(String nom){

	this.name=nom;
	this.setActionCommand(nom);
	//this.setBorder(BorderFactory.createEmptyBorder());
	this.setText(nom);
	this.setContentAreaFilled(false);

    }
    public String getName(){
	return this.name;
    }
}
