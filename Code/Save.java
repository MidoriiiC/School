/* ce fichier sert à retenir les modifications à apporter au fichier
   de sauvegarde de la partie. Il contient:

   - nom du joueur
   - chapitre en cours ( de 0 pour l intro à ?)
   - étape du chapitre en cours 


*/
import java.io.*;

public class Save{

    private Partie p;
    private EcranAccueil acc;
    private String[] tabParties= new String[6];
    public Save(Partie game, EcranAccueil a){
	this.p=game;
	this.acc=a;
	File repertoire = new File("./Sauvegarde/");
	tabParties=repertoire.list();
    }
    public Boolean isAlreadyTaken(String[] t, String nom){
	String test;
	for(int i=0;i<this.tabParties.length&&this.tabParties[i]!=null;i++){
	    test=this.tabParties[i].substring(5,this.tabParties[i].length()-4);
	    if(test.equals(nom)){
		return true;
	    }
	}
	return false;
    }

    /*va modifier l'écran pour sélectionner partie à continuer*/
    public boolean creerPartie(String nom){
	//System.out.println("création fichier");
	File f=new File("./Sauvegarde/intro"+nom+".txt");
	try{
	    if(this.isAlreadyTaken(this.tabParties, nom)) {  //changer le controle pour éviter un doubloon de perso, ceci est efficasse que pour les intros
                //System.out.println("Le fichier existe"); //devoir troller!!  
            } else {
                //System.out.println("Le fichier n'existe pas");
                if(f.createNewFile()) {
                    //System.out.println("Création du fichier OK");
		    return true;
                } else {
                    //System.out.println("Création du fichier KO");
                }              
            }
        }catch(Exception r){
	    r.printStackTrace();
	}
	return false;
	
    }
    /** les fichiers devront être traités dans une autre classe!!**/
    public void deletePartie(String n, String e){
	String fichier="./Sauvegarde/"+e+n+".txt";
	File f=new File(fichier);
	try{
	    if(f.exists()) {
                //System.out.println("Le fichier existe");
		this.deleteCase(e+n+".txt");
                if(f.delete()) {
		    
                    //System.out.println("Suppression du fichier OK");
                }// else 
		//System.out.println("Suppression du fichier KO");
            } else {
                //System.out.println("Le fichier n'existe pas");
                if(f.createNewFile()) ; //System.out.println("Création du fichier OK");
		//else System.out.println("Création du fichier KO");           
	    }
        }catch(Exception r){
	    //System.out.println("un pb à eu lieu");
	    r.printStackTrace();
	}
	this.acc.updateDonneesEcranAccueil(this.tabParties);
	this.acc.setEcranSuppPartie();
    }
    public void deleteCase(String fichier){
	int g=this.tabParties.length;
	//for(int a=0;a<tabParties.length;a++) //System.out.print(" > "+tabParties[a]);
	//System.out.println(g);
	int pos=-1;
	int i;
	for(i=0; i<g;i++)
	    if(fichier.equals(this.tabParties[i])) pos=i;
	if(i!=pos)
	    for(int j=pos;j<g-1;j++)
		this.tabParties[j]=this.tabParties[j+1];
	this.tabParties[g-1]="";
	String[] tab=new String[6];
	for(int a=0;a<tabParties.length-1;a++) tab[a]=this.tabParties[a];//System.out.print(" > "+tabParties[a]);
	this.tabParties=tab;
	//System.out.println(tabParties[5]);
	//System.out.println(g+" puis "+this.tabParties.length);
	int size=0;
	while(this.tabParties[size]!=null) size++;
	//System.out.println(size);
	//remettre à jour l'écran choix et l'écran supp  + mettre à jour le tabParties de la fenêtre avant!  
    }

    public char[][] getFileClasse(String salle){
	char[][] grille=new char[22][12];
	File f=new File("./Visuel/"+salle);
	int videur;
	try{
	    if(!f.exists()) {
                //System.out.println("Le fichier n'existe pas, voir pb");
            } else {
		/** - - - - - - - - - - - - - - **/
		try{
		    FileReader flux = new FileReader(f);
		    for(int ligne=0;ligne<10;ligne++){
			for(int col=0;col<16;col++){
			    grille[col][ligne]=((char)flux.read());
			}
			videur=flux.read();
		    }
		}catch(FileNotFoundException rn){
		    //System.err.println("Erreur a l'ouverture");
		}catch(IOException io){
		    io.printStackTrace();
		}
	    
		return grille;
		/** - - - - - - - - - - - - - - **/
	    }
	}catch(Exception r){
	    r.printStackTrace();
	}
	return grille;
    }
}
