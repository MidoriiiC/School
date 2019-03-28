import javax.swing.JFrame;

public class Partie{

    private Partie(){}
    /*faire un système qui ne permet pas de lancer plusieurs parties 
      en même temps*/
    private static Partie INSTANCE = new Partie();
    private EcranAccueil acc;
    private EcranJeu ej;
    private ControleurSouris cs;
    private Controleur controleur;
    private Save sauv;
    private String nom;
    private String chap;
    public static Partie getInstance(){
	return INSTANCE;
    }

    public void choice(){
	ControleurSouris cs= new ControleurSouris(this);
	EcranAccueil acc= new EcranAccueil(cs,this);
	Save f= new Save(this,acc);
	this.acc=acc;
	this.cs=cs;
	this.sauv=f;
	cs.setEcran(acc);
	cs.setSave(f);

	/** plus tard?**/
	/*if (v==5) this.createServer();
	  if (v==6) this.joinServer();*/
    }

    /* va modifier l'écran pour choisir perso et son nom */
    public void fermerFenetre(){
	if(this.acc!=null){
	    this.acc.dispose();
	    this.controleur=new Controleur(this,this.sauv);
	    this.ej= new EcranJeu(this.nom,this.chap,this.controleur,this);
	    this.controleur.setEcran(this.ej);
	}//else(cas de la fenetre de jeu)
    }
    
    
    public void initPartie(String nameJ){ //pour création
	//System.out.println("personnage= "+nameJ);
	this.nom=nameJ;
	this.chap="intro";
	/*JFrame a=new JFrame("hello");
	a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a.setSize(700, 500);
	a.setLocationRelativeTo(null);
	*/
	//this.acc.close();
    }
    public void initPartie(String n,String e){  // pour continuer
	this.nom=n;
	this.chap=e;
    }
    public char[][] getFileClasse(String salle){
	return this.sauv.getFileClasse(salle);
    }
}
