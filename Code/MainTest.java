public class MainTest{

    private EcranJeu ej;
    private Controleur controleur;
    static Partie p=Partie.getInstance();
    
    public static void main(String[] args){
	
	if(args.length<1){
	    System.out.println("écrire: java MainTest Prénom");
	    System.exit(0);
	}
	System.out.println(args[0]);
	//faire un controle sur les prénoms pour éviter les gros pbs
        p.initPartie(args[0],"intro");

	Save sauv=new Save(p,
			   new EcranAccueil(
					    new ControleurSouris(p),p));
	Controleur c=new Controleur(p,sauv);
	EcranJeu ej= new EcranJeu(args[0],"intro",c,p);
	c.setEcran(ej);

	//Acc.dispose();
	//puis afficher ecranJeu

	


	
	//Partie p=Partie.getInstance();
	//p.choice();
    }

}
