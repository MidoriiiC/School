import javax.swing.*;
import java.awt.event.*;


public class ControleurSouris  implements ActionListener, MouseListener {
    /**
     *Non utilis&eacute;e ici.
     **/
    private EcranAccueil fond;
    private Save s;
    private String lastAction;

    private Partie jeu;


    public ControleurSouris(Partie p){
	this.jeu=p;
    }
    public void setEcran(EcranAccueil a){
	this.fond=a;
    }

    public void setSave(Save save){
	this.s=save;
    }
    
    public void mouseClicked(MouseEvent e){}
    
    @Override
    public void mouseEntered(MouseEvent e){}
    @Override
    public void mouseExited(MouseEvent e){}
    /**
     *Non utilis&eacute;e ici.
     **/
    public void mousePressed(MouseEvent e){}
    /**
     *Non utilis&eacute;e ici.
     **/
    public void mouseReleased(MouseEvent e){}
    /**
     * Lorsqu'un bouton est cliqu&eacute;, actionPerformed s'active et appelle la fonction boutonPouser, et red&eacute;ssine la fen&ecirc;tre avec les nouvelles donn&eacute;es.
     *
     * @param e ActionEvent e.
     **/
    @Override
    public void actionPerformed(ActionEvent e){
	String txt=e.getActionCommand();
	//int valeur=Integer.parseInt(txt);
	//this.etat.boutonPouser(valeur);
	//System.out.println(txt);
	if(txt.equals("retour")){
	    this.lastAction=txt;
	    this.fond.setEcranMenuAccueil();
	}
	if(txt.equals("Nouvelle partie")){
	    this.lastAction=txt;
	    this.fond.setEcranCreationPartie();
	}
	if(txt.equals("?")){
	    this.lastAction=txt;
	    this.fond.setEcranCommandePartie();
	}
	if(txt.equals("Continuer")){
	    //System.out.println("Choix Partie");
	    this.lastAction=txt;
	    this.fond.setEcranChoixPartie();
	}
	if(txt.equals("continuer")){
	    if(!lastAction.equals("Continuer")&&(!lastAction.equals("continuer"))){
		String etat=lastAction.substring(6,11);
		String nom=lastAction.substring(15,lastAction.length()-7);
		this.jeu.initPartie(nom,etat);
		//System.out.println(etat);
		this.fond.setEcranChargeLancement();
	    }
	}
	if(txt.equals("Supprimer")){
	    //System.out.println("Ecran Supp");
	    this.lastAction=txt;
	    this.fond.setEcranSuppPartie();
	}
	if(txt.equals("supprimer")){
	    if(!lastAction.equals("Supprimer")&&(!lastAction.equals("supprimer"))){
		String etat=lastAction.substring(6,11);
		String nom=lastAction.substring(15,lastAction.length()-7);
		this.s.deletePartie(nom,etat);
	    }
	}
	if(txt.equals("commencer")){
	   if(!lastAction.equals("Nouvelle partie")&&!lastAction.equals("commencer")){
	       boolean k=this.s.creerPartie(lastAction);
	       if(k){
		   this.jeu.initPartie(lastAction);
		   this.fond.setEcranChargeLancement();
	       }
	       
	       //mettre écran chargement
	   }
	}
	if(txt.equals("quitter")){
		System.exit(0);
	    }
	if(txt!=""){
	    this.lastAction=txt;
	}
	
	    
		
	//this.fond.score.setText("Score:"+etat.donnerScore());
	//this.fond.repaint();
    }
}
