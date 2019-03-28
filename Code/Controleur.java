import javax.swing.*;
import java.awt.event.*;


public class Controleur  implements  KeyListener{ //et touches clavier??
    private EcranJeu ej;
    private Save save;
    private String lastAction;
    private Partie partie;
    private Joueur j;
    private char dir;
    private String sA;
    private char[][] tabAct;
    private String chap;
    private int compteur;
    public Controleur(Partie p, Save s){
	this.partie=p;
	this.save=s;
	this.dir='B';
    }
    public void setEcran(EcranJeu a){
	this.ej=a;
	this.j=a.getJoueur();
	this.chap=a.getChap();
	this.compteur=0;
	if(this.chap.equals("intro")){
	    if(this.j.action.equals("distribuer")){
		this.compteur=32;
		if(this.j.nom.equals("Thomas")) this.compteur=128;
	    }
	}
	this.tabAct=a.getGrilleActuelle();
	this.sA=a.getSalleActuelle();
	
    }
    public void keyTyped(KeyEvent e) {
	//System.out.println("KEY TYPED: "+e);
    }

    /** Handle the key-pressed event from the text field. 

	ne pas oublier de mettre à jour les grilles et enlever J de 
	l'ancienne après un passage sur 'E' */
    public void keyPressed(KeyEvent e) {

	
	if(e.getKeyCode()==KeyEvent.VK_UP){
	    this.dir='H';    //Monte
	    if(this.tabAct[this.j.x][this.j.y-1]=='E'){         //que dans le couloir, pour les salles impaires
		if(this.j.x==1&&this.j.y==5){
		    /*System.out.println(this.j.x+" pour 1 attendu et "+this.j.y+" pour 5");*/
		    //this.tabAct[this.j.x][this.j.y]='S';
		    this.tabAct=this.ej.getGrille1();
		    this.tabAct[1][7]='J';
		    this.j.x=1;
		    this.j.y=7;
		    this.dir='D';
		    this.ej.updatePosJ(1,7);
		    this.ej.setGrille1(this.tabAct);
		    this.ej.setSalleActuelle("Salle1");
		    //System.out.println(this.j.x+" pour 1 attendu et "+this.j.y+" pour 7");
		    this.ej.updateGrille(this.ej.getSalleActuelle(),this.tabAct,'D');
		    this.sA=this.ej.getSalleActuelle();
		    return;
		}
		if(this.j.x==7&&this.j.y==5){
		    //System.out.println("haut Entrée vers salle 3");
		    //this.tabAct[this.j.x][this.j.y]='S';
		    this.tabAct=this.ej.getGrille3();
		    this.tabAct[1][7]='J';
		    this.j.x=1;
		    this.j.y=7;
		    this.dir='D';
		    this.ej.updatePosJ(1,7);
		    this.ej.setGrille3(this.tabAct);
		    this.ej.setSalleActuelle("Salle3");
		    this.ej.updateGrille(this.ej.getSalleActuelle(),this.tabAct,'D');
		    this.sA=this.ej.getSalleActuelle();
		    return;
		}
		if(this.j.x==13&&this.j.y==5){
		    System.out.println("Entrée vers salle 5 actuellement bloquée");
		    return;
		}
	    }
	    if(this.tabAct[this.j.x][this.j.y-1]=='S'){
		//System.out.println("haut");
		this.tabAct[this.j.x][this.j.y-1]='J';
		this.tabAct[this.j.x][this.j.y]='S';
		this.j.y--;
	        this.ej.updateGrille(this.ej.getSalleActuelle(),this.tabAct,this.dir);
		return;
	    }
	    if(this.tabAct[this.j.x][this.j.y-1]!='E'&&this.tabAct[this.j.x][this.j.y-1]!='S'){
		this.ej.updateGrille(this.ej.getSalleActuelle(),this.tabAct,this.dir);
		//System.out.println("Bloqué H"); //bruit?+ changer ecran
	    }
	}







	
	if(e.getKeyCode()==KeyEvent.VK_RIGHT){
	    this.dir='D';   //droite
	    if(this.tabAct[this.j.x+1][this.j.y]=='E'){
		if(this.j.x==14&&this.j.y==7&&this.sA.equals("Salle4")){
		    //System.out.println("ok 4");
		    this.tabAct=this.ej.getGrilleC1();
		    this.tabAct[7][7]='J';
		    this.j.x=7;
		    this.j.y=7;
		    this.dir='H';
		    this.ej.updatePosJ(7,7);
		    this.ej.setGrilleC1(this.tabAct);
		    this.ej.setSalleActuelle("Couloir1");
		    this.ej.updateGrille(this.ej.getSalleActuelle(),this.tabAct,'H');
		    this.sA=this.ej.getSalleActuelle();
		    return;
		}
		if(this.j.x==14&&this.j.y==7&&this.sA.equals("Salle2")){
		    //System.out.println("ok 2");
		    this.tabAct=this.ej.getGrilleC1();
		    this.tabAct[1][7]='J';
		    this.j.x=1;
		    this.j.y=7;
		    this.dir='H';
		    this.ej.updatePosJ(1,7);
		    this.ej.setGrilleC1(this.tabAct);
		    this.ej.setSalleActuelle("Couloir1");
		    this.ej.updateGrille(this.ej.getSalleActuelle(),this.tabAct,'H');
		    this.sA=this.ej.getSalleActuelle();
		    return;
		}

	    }
	    if(this.tabAct[this.j.x+1][this.j.y]=='S'){
		//System.out.println("droite");
		this.tabAct[this.j.x+1][this.j.y]='J';
		this.tabAct[this.j.x][this.j.y]='S';
		this.j.x++;
		this.ej.updateGrille(this.ej.getSalleActuelle(),this.tabAct,this.dir);
		return;
	    }
	    //System.out.println("droite Entrée");
	    if(this.tabAct[this.j.x+1][this.j.y]!='E'&&this.tabAct[this.j.x+1][this.j.y]!='S')
		this.ej.updateGrille(this.ej.getSalleActuelle(),this.tabAct,this.dir);
	    //System.out.println("Bloqué D");
	}




	
	if(e.getKeyCode()==KeyEvent.VK_LEFT){
	    this.dir='G';    //gauche
	    if(this.tabAct[this.j.x-1][this.j.y]=='E'){
		if(this.j.x==1&&this.j.y==7&&this.sA.equals("Salle1")){
		    //System.out.println("ok 1");
		    this.tabAct=this.ej.getGrilleC1();
		    this.tabAct[1][5]='J';
		    this.j.x=1;
		    this.j.y=5;
		    this.dir='B';
		    this.ej.updatePosJ(1,5);
		    this.ej.setGrilleC1(this.tabAct);
		    this.ej.setSalleActuelle("Couloir1");
		    this.ej.updateGrille(this.ej.getSalleActuelle(),this.tabAct,'B');
		    this.sA=this.ej.getSalleActuelle();
		    return;
		}
		if(this.j.x==1&&this.j.y==7&&this.sA.equals("Salle3")){
		    //System.out.println("ok 3");
		    this.tabAct=this.ej.getGrilleC1();
		    this.tabAct[7][5]='J';
		    this.j.x=7;
		    this.j.y=7;
		    this.dir='B';
		    this.ej.updatePosJ(7,5);
		    this.ej.setGrilleC1(this.tabAct);
		    this.ej.setSalleActuelle("Couloir1");
		    this.ej.updateGrille(this.ej.getSalleActuelle(),this.tabAct,'B');
		    this.sA=this.ej.getSalleActuelle();
		    return;
		}

	    }

	    
	    //System.out.println("gauche Entrée");
	    if(this.tabAct[this.j.x-1][this.j.y]=='S'){
		//System.out.println("gauche");
		this.tabAct[this.j.x-1][this.j.y]='J';
		this.tabAct[this.j.x][this.j.y]='S';
		this.j.x--;
		this.ej.updateGrille(this.ej.getSalleActuelle(),this.tabAct,this.dir);
		return;
	    }
	    if(this.tabAct[this.j.x-1][this.j.y]!='E'&&this.tabAct[this.j.x-1][this.j.y]!='S')
		this.ej.updateGrille(this.ej.getSalleActuelle(),this.tabAct,this.dir);
	    //System.out.println("Bloqué G");
	}









	
	if(e.getKeyCode()==KeyEvent.VK_DOWN){
	    this.dir='B';   //bas
	    
	    if(this.tabAct[this.j.x][this.j.y+1]=='E'){
		//System.out.println("bas Entrée");
		if(this.j.x==1&&this.j.y==7){
		    //System.out.println("haut Entrée vers salle 2");
			
		    //System.out.println("haut Entrée vers salle 3");
		    //this.tabAct[this.j.x][this.j.y]='S';
		    this.tabAct=this.ej.getGrille2();
		    this.tabAct[14][7]='J';
		    this.j.x=14;
		    this.j.y=7;
		    this.dir='G';
		    this.ej.updatePosJ(14,7);
		    this.ej.setGrille2(this.tabAct);
		    this.ej.setSalleActuelle("Salle2");
		    this.ej.updateGrille(this.ej.getSalleActuelle(),this.tabAct,'G');
		    this.sA=this.ej.getSalleActuelle();
		    return;
		}
		if(this.j.x==7&&this.j.y==7){
		    //System.out.println("haut Entrée vers salle 4");
		    //this.tabAct[this.j.x][this.j.y]='S';
		    this.tabAct=this.ej.getGrille4();
		    this.tabAct[14][7]='J';
		    this.j.x=14;
		    this.j.y=7;
		    this.dir='G';
		    this.ej.updatePosJ(14,7);
		    this.ej.setGrille4(this.tabAct);
		    this.ej.setSalleActuelle("Salle4");
		    this.ej.updateGrille(this.ej.getSalleActuelle(),this.tabAct,'G');
		    this.sA=this.ej.getSalleActuelle();
		    return;
		}
		if(this.j.x==13&&this.j.y==7){
		    System.out.println("haut Entrée vers salle 6");
		}
	    }
	    if(this.tabAct[this.j.x][this.j.y+1]=='S'){
		//System.out.println("bas");
		this.tabAct[this.j.x][this.j.y+1]='J';
		this.tabAct[this.j.x][this.j.y]='S';
		this.j.y++;
		this.ej.updateGrille(this.ej.getSalleActuelle(),this.tabAct,this.dir);
		return;
	    }
	    if(this.tabAct[this.j.x][this.j.y+1]!='E'&&this.tabAct[this.j.x][this.j.y+1]!='S')
		this.ej.updateGrille(this.ej.getSalleActuelle(),this.tabAct,this.dir);
	    //System.out.println("Bloqué B par un "+this.tabAct[this.j.x][this.j.y+1]);
	}





	// si la touche a (action) est appuyée

	  
	if(e.getKeyCode()==KeyEvent.VK_A){
	    /*
	    if Dir et case dans la dir="i"(Alexa)+salle
	         changer dir de la fille 1
		 new texte
		 Texte "Salut. Comment Vas-tu?"
		 if perso=Olivia
		      Texte "Au rapport grande soeur! Je sais qu'il se passe des choses intéressantes dans la salle (Délégué+BadBoy), mais je ne sais pas quoi..."
		 If perso= Mathéo
		      Texte="Je n'en sais trop rien. Demande à d'autre personnes sur la déléguée."
		 If perso=Inès
		      Texte= "Salut..."
		      
		      

	     if Dir et case dans la dir="j"(Lili)+salle
	         changer dir de la fille 2
		 new texte
		 Texte "Salut. Tu pourrais m'aider pour des révisions s'il te plaît?"
		 if perso=Olivia
		      Texte "Au rapport Chef! Rien a signaler pour aujourd'hui."
		 If perso= Mathéo
		      Texte="Je la trouve trop calme et trop discrète. Je ne me souviens même pas de son visage..."
		 If perso=Inès
		      Texte= "Salut?"




	      if Dir et case dans la dir="k"(Héloïse)+salle
	         changer dir de la fille 3
		 new texte
		 Texte "Bonjour."
		 if perso=Olivia
		      Texte "Je ne cherche pas à collectionner les ragots. Ce n'est pas mon genre."
		 If perso= Mathéo
		      Texte="Ma soeur? Elle est parfaitement normale. Personne ne l'embête au moins?"
		 If perso=Inès
		      Texte= "Coucou. J'ai pensé à fermer la porte de la maison derrière moi ce matin."

	    */
	    if(this.dir=='H'&&isDesk(this.tabAct[this.j.x][this.j.y-1])&&this.j.action.equals("distribuer")){
		if(this.chap.equals("intro")){
		    if((this.j.nom.equals("Thomas"))||(this.sA.equals("Salle2"))){
			this.tabAct[this.j.x][this.j.y-1]++;
			String s=this.ej.getSalleActuelle();
			if(s.equals("Salle1")) this.ej.setGrille1(this.tabAct);
			if(s.equals("Salle2")) this.ej.setGrille2(this.tabAct);
			if(s.equals("Salle3")) this.ej.setGrille3(this.tabAct);
			if(s.equals("Salle4")) this.ej.setGrille4(this.tabAct);
			if(s.equals("Couloir1")) this.ej.setGrilleC1(this.tabAct);
			this.ej.updateGrille(s,this.tabAct,this.dir);
			this.compteur--;
		    }
		}
	    }
	    if(this.dir=='H'&&isDesk(this.tabAct[this.j.x][this.j.y-1])&&this.j.action.equals("fouiller")){
		if(this.chap.equals("intro")){
		    if(this.j.nom.equals("Myriam")&&this.sA.equals("Salle4")){
			if(this.tabAct[this.j.x][this.j.y-1]=='e'){
			    this.ej.redrawTxt("Trouvé! Je vais pouvoir rendre quelque chose.","Salle4");
			}
		    }
		}
	    }
	    if(this.dir=='D'&&isDesk(this.tabAct[this.j.x+1][this.j.y])&&this.j.action.equals("distribuer")){
		if(this.chap.equals("intro")){
		    if((this.j.nom.equals("Thomas"))||(this.sA.equals("Salle2"))){
		    this.tabAct[this.j.x+1][this.j.y]++;
		    String s=this.ej.getSalleActuelle();
		    if(s.equals("Salle1")) this.ej.setGrille1(this.tabAct);
		    if(s.equals("Salle2")) this.ej.setGrille2(this.tabAct);
		    if(s.equals("Salle3")) this.ej.setGrille3(this.tabAct);
		    if(s.equals("Salle4")) this.ej.setGrille4(this.tabAct);
		    if(s.equals("Couloir1")) this.ej.setGrilleC1(this.tabAct);
		    this.ej.updateGrille(s,this.tabAct,this.dir);
		    this.compteur--;
		    }
		}
	    }
	    if(this.dir=='D'&&isDesk(this.tabAct[this.j.x+1][this.j.y])&&this.j.action.equals("fouiller")){
		if(this.chap.equals("intro")){
		    if(this.j.nom.equals("Myriam")&&this.sA.equals("Salle4")){
			if(this.tabAct[this.j.x+1][this.j.y]=='e'){
			    this.ej.redrawTxt("Trouvé! Je vais pouvoir rendre quelque chose.","Salle4");

			}
		    }
		}
	    }
	    if(this.dir=='G'&&isDesk(this.tabAct[this.j.x-1][this.j.y])&&this.j.action.equals("distribuer")){
		if(this.chap.equals("intro")){
		    if((this.j.nom.equals("Thomas"))||(this.sA.equals("Salle2"))){
		    this.tabAct[this.j.x-1][this.j.y]++;
		    String s=this.ej.getSalleActuelle();
		    if(s.equals("Salle1")) this.ej.setGrille1(this.tabAct);
		    if(s.equals("Salle2")) this.ej.setGrille2(this.tabAct);
		    if(s.equals("Salle3")) this.ej.setGrille3(this.tabAct);
		    if(s.equals("Salle4")) this.ej.setGrille4(this.tabAct);
		    if(s.equals("Couloir1")) this.ej.setGrilleC1(this.tabAct);
		    this.ej.updateGrille(s,this.tabAct,this.dir);
		    this.compteur--;
		    if(sA.equals("Salle3")&&this.tabAct[this.j.x-1][this.j.y]=='h')
			this.ej.redrawTxt("<HTML>...<br>Je devrais trouver un moment.</HTML>","Salle3");
		    }
		}
	    }
	    if(this.dir=='G'&&isDesk(this.tabAct[this.j.x-1][this.j.y])&&this.j.action.equals("fouiller")){
		if(this.chap.equals("intro")){
		    if(this.j.nom.equals("Myriam")&&this.sA.equals("Salle4")){
			if(this.tabAct[this.j.x-1][this.j.y]=='e'){
			    this.ej.redrawTxt("Trouvé! Je vais pouvoir rendre quelque chose.","Salle4");
			}
		    }
		}
	    }
	}
	if(this.compteur==0&&this.j.action.equals("distribuer")){
	    this.ej.redrawTxt("J'ai fini cette tâche.",sA);
	}
	if(e.getKeyCode()==KeyEvent.VK_S) System.exit(0);
	//System.out.println(this.j.x+" pour x et "+this.j.y+" pour y");
	//System.out.print(this.dir);
	//faura un ecran de chargement et revenir sur l'accueil.
	// aussi penser a mettre du txt dans les fichiers
    }

    /** Handle the key-released event from the text field. */
    public void keyReleased(KeyEvent e) {
	//   System.out.println("KEY RELEASED: "+e);
    }
    public char getDirection(){
	return this.dir; 
    }

    public boolean isDesk(char a){
	if(a=='t'||a=='a'||a=='c'||a=='e'||a=='g') return true;
	return false;
    }
    public boolean isPeople(char a){
	if(a=='i'||a=='j'||a=='k'||a=='l'||a=='m') return true;// n o p et autres pr les autres persos principaux
	return false;
    }
}
