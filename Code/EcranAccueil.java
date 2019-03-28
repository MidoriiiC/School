import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;


/**
 * Cette classe représente les écrans affichés avant de jouer.
 *
 * @version 20-07-2018
 * @author Mathilde Charrière
 */

public class EcranAccueil extends JFrame{
    /*nécéssaire pour choisir une partie*/
    private String[] tabParties= new String[6];
    final static String nomJeu="nomJeu";
    final static String menu="menu";
    final static String creaPartie="creaPartie";
    final static String choixPartie="choixPartie";
    final static String chargement="chargement";
    final static String commandes="commandes";
    final static String suppression="suppression";
    private Partie partie;
    ControleurSouris co;
    GridBagConstraints c= new GridBagConstraints();
    JLabel nomGame=new JLabel("School Project"); // pour nomJeu   qui deviendra: bruits de couloir
    JLabel nomGame2=new JLabel("School Project");
    JProgressBar barre;
    private Thread t;
    JPanel cards;
    PanelFond pinit=new PanelFond();
    PanelFond pmenu=new PanelFond();
    PanelFond pcrea=new PanelFond();
    PanelFond pchoix=new PanelFond();
    PanelFond pcharge=new PanelFond();
    PanelFond poption=new PanelFond();
    PanelFond psupp=new PanelFond();

    
    JLabel partie1;  //pour choixPartie
    JLabel partie2;
    JLabel partie3;
    JLabel partie4;
    JLabel partie5;
    JLabel partie6;

    JLabel part1;  // pour suppression
    JLabel part2;
    JLabel part3;
    JLabel part4;
    JLabel part5;
    JLabel part6;

    
    JLabel choix=new JLabel("Choisissez votre personnage:"); // pour creaPartie
    JLabel role1=new JLabel("Les voyoux");
    JLabel role2=new JLabel("Les populaires");
    JLabel role3=new JLabel("Les délégués");
    Bouton nomDF=new Bouton("Inès");
    Bouton nomPF=new Bouton("Olivia");
    Bouton nomRF=new Bouton("Myriam");
    Bouton nomDM=new Bouton("Thomas");
    Bouton nomPM=new Bouton("Mathéo");
    Bouton nomRM=new Bouton("Baptiste");
    ImageIcon imageRF;
    ImageIcon imagePF;
    ImageIcon imageDF;
    ImageIcon imageRM;
    ImageIcon imagePM;
    ImageIcon imageDM;
    ImageIcon noImage;
    
    JLabel continu=new JLabel("Histoire à continuer:");
    JLabel supprim=new JLabel("Histoire à supprimer:");

    //  -- nécéssaire du chargement --
    JProgressBar charge; //pour le chargement
    
    public EcranAccueil(ControleurSouris cont,Partie p) {
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(450, 270);
	this.setLocationRelativeTo(null);
	this.setTitle("Menu");
	this.co=cont;
	this.partie=p;
	
	File repertoire = new File("./Sauvegarde/");
	tabParties=repertoire.list();

	try{
	    Image myPic = ImageIO.read(new File("../Images/MainGirl/Girl1.png"));
	    imageRF = new ImageIcon(myPic);
	    Image myPica = ImageIO.read(new File("../Images/MainGirl/Girl2.png"));
	    imagePF = new ImageIcon(myPica);
	    Image myPicb = ImageIO.read(new File("../Images/MainGirl/Girl3.png"));
	    imageDF = new ImageIcon(myPicb);

	    Image myPicc = ImageIO.read(new File("../Images/MainBoy/Boy1.png"));
	    imageRM = new ImageIcon(myPicc);
	    Image myPicd = ImageIO.read(new File("../Images/MainBoy/Boy2.png"));
	    imagePM = new ImageIcon(myPicd);
	    Image myPice = ImageIO.read(new File("../Images/MainBoy/Boy3.png"));
	    imageDM = new ImageIcon(myPice);

	    Image myPicf = ImageIO.read(new File("../Images/ecransMenu/SauvegardeVide.png"));
	    noImage = new ImageIcon(myPicf);
	
	    JLabel rfcrea= new JLabel(imageRF);
	    JLabel pfcrea= new JLabel(imagePF);
	    JLabel dfcrea= new JLabel(imageDF);

	    JLabel rmcrea= new JLabel(imageRM);
	    JLabel pmcrea= new JLabel(imagePM);
	    JLabel dmcrea= new JLabel(imageDM);

	    JLabel titreCommandes= new JLabel("Commandes");
	    JLabel contenuOption=new JLabel("<html><br>Ce jeu fonctionne avec le clavier<br>Les déplacements se font avec les flèches directionelles<br>et les intéractions avec a. Sauvegardez et quittez avec s.<br><br>Si un problème a lieu, contactez <br>la super développeuse ^^`<br><br><br>Ce jeu a été créé par Mathilde Charrière.<br> Pour plus d'informations:<br>site git<br><a href=\"http://dwarves.iut-fbleau.fr/~charrier/travaux.html\">http://dwarves.iut-fbleau.fr/~charrier/travaux.html</a></html>");
	
	    
	    /**	    **/
	    NavigationAccueil retourCrea=new NavigationAccueil("retour");
	    NavigationAccueil retourChoix=new NavigationAccueil("retour");
	    NavigationAccueil retourSupp=new NavigationAccueil("retour");
	    NavigationAccueil retourOption=new NavigationAccueil("retour");

	    NavigationAccueil validerCrea=new NavigationAccueil("commencer");
	    NavigationAccueil validerChoix=new NavigationAccueil("continuer");
	    NavigationAccueil validerSupp=new NavigationAccueil("supprimer");
	    NavigationAccueil quitter=new NavigationAccueil("quitter");

	    Bouton versCrea = new Bouton("Nouvelle partie");
	    NavigationAccueil versCommandes=new NavigationAccueil("?");
	    Bouton versChoix=new Bouton("Continuer");
	    Bouton versSupp=new Bouton("Supprimer");

    
	    retourCrea.addActionListener(co);     // on associe les boutons au controleur
	    retourChoix.addActionListener(co);
	    retourSupp.addActionListener(co);
	    retourOption.addActionListener(co);
	    quitter.addActionListener(co);
	    
	    nomDF.addActionListener(co);
	    nomPF.addActionListener(co);
	    nomRF.addActionListener(co);
	    nomDM.addActionListener(co);
	    nomPM.addActionListener(co);
	    nomRM.addActionListener(co);
	    
	    validerCrea.addActionListener(co);
	    validerChoix.addActionListener(co);
	    validerSupp.addActionListener(co);

	    versCrea.addActionListener(co);
	    versCommandes.addActionListener(co);
	    versChoix.addActionListener(co);
	    versSupp.addActionListener(co);
	    
	    //    -- ici les positions des items --
	
	    cards=new JPanel();
	    cards.setLayout(new CardLayout());
	    
	    pinit.setLayout(new GridBagLayout());
	    pmenu.setLayout(new GridBagLayout());
	    pcrea.setLayout(new GridBagLayout());
	    pchoix.setLayout(new GridBagLayout());
	    pcharge.setLayout(new GridBagLayout());
	    poption.setLayout(new GridBagLayout());
	    psupp.setLayout(new GridBagLayout());

	    barre= new JProgressBar();
	    barre.setMinimum(0);
	    barre.setMaximum(100);
	    barre.setStringPainted(true);
	    t=new Thread(new Traitement(barre, t, this.partie));
	    c.gridx=0;
	    c.gridy=0; /* - - - - - - - - - - - - - - - -l1- - - -*/
	    c.gridwidth=1;  //colonnes
	    c.gridheight=1;  // lignes
	    c.fill=GridBagConstraints.BOTH;
	    c.ipady = c.anchor = GridBagConstraints.LINE_END;
	    c.insets=new Insets(0,0,0,0);
	    c.weightx=1.0f;
	    c.weighty=1.0f;
	    pmenu.add(nomGame,c);
	    c.fill=GridBagConstraints.NONE;
	     c.ipady = c.anchor = GridBagConstraints.CENTER;
	    pcharge.add(barre,c);
	     c.ipady = c.anchor = GridBagConstraints.LINE_END;
	    c.fill=GridBagConstraints.BOTH;
	    
	    c.ipady = c.anchor = GridBagConstraints.LINE_START;
	    c.gridx=10;
	    c.gridwidth=2;
	    pmenu.add(quitter,c);
	    c.gridx=0;
	    c.gridwidth=5;
	    pcrea.add(choix,c);
	    pchoix.add(continu,c);
	    psupp.add(supprim,c);
	    poption.add(titreCommandes,c);

	    c.gridwidth=2;
	    c.gridx=5;
	    /* insertion des boutons retour*/
	    pcrea.add(retourCrea,c);
	    pchoix.add(retourChoix,c);
	    psupp.add(retourSupp,c);
	    poption.add(retourOption,c);

	    c.gridx=0;
	    c.gridwidth=2;
	    c.gridy=1; /*- - - - - - - - - - - - - - - -l2 - - -*/


	    c.gridy=2; /* - - - - - - - - - - - - - - - l3- - - */
	    c.fill=GridBagConstraints.CENTER;
	    c.ipady = c.anchor = GridBagConstraints.CENTER;
	    c.gridx=1;
	    c.gridwidth=6;
	    c.gridheight=4;
	    poption.add(contenuOption,c);
	    c.gridwidth=2;
	    c.gridheight=1;

	    pinit.add(nomGame2,c);
	    
	    pcrea.add(role1,c);
	    c.gridx=3;
	    pcrea.add(role2,c);
	    c.gridx=5;
	    pcrea.add(role3,c);

	    pmenu.add(versCrea,c);

	    c.gridx=1;
	    c.gridy=3; /*- - - - - - - - - - - - - - - -l4- - -*/
	    c.gridwidth=1;
	    c.ipady = c.anchor = GridBagConstraints.CENTER;
	    pcrea.add(rfcrea,c);
	    if(tabParties.length>0&&tabParties[0]!=null){
		String nomfichier0=tabParties[0];
		String nomJoueur0=nomfichier0.substring(5,nomfichier0.length()-4);
		pchoix.add(new JLabel(this.getImgChoixSupp(nomJoueur0)),c);
		psupp.add(new JLabel(this.getImgChoixSupp(nomJoueur0)),c);
	    }
	    else{
		pchoix.add(new JLabel("Pas de sauvegardes"),c);
		psupp.add(new JLabel("Pas de sauvegardes"),c);
	    }
	    c.gridx=2;
	    pcrea.add(rmcrea,c);
	    if(tabParties.length>1&&tabParties[1]!=null){
		String nomfichier1=tabParties[1];
		String nomJoueur1=nomfichier1.substring(5,nomfichier1.length()-4);
	        pchoix.add(new JLabel(this.getImgChoixSupp(nomJoueur1)),c);
		psupp.add(new JLabel(this.getImgChoixSupp(nomJoueur1)),c);
	    }else if(tabParties.length>0&&tabParties[0]!=null){
		pchoix.add(new JLabel(noImage),c);
		psupp.add(new JLabel(noImage),c);
	    }

	    c.gridx=3;
	    pcrea.add(pfcrea,c);
	    if(tabParties.length>2&&tabParties[2]!=null){
		String nomfichier2=tabParties[2];
		String nomJoueur2=nomfichier2.substring(5,nomfichier2.length()-4);
	        pchoix.add(new JLabel(this.getImgChoixSupp(nomJoueur2)),c);
		psupp.add(new JLabel(this.getImgChoixSupp(nomJoueur2)),c);
	    }else if(tabParties.length>0&&tabParties[0]!=null){
		pchoix.add(new JLabel(noImage),c);
		psupp.add(new JLabel(noImage),c);
	    }
	    c.gridx=4;
	    pcrea.add(pmcrea,c);
	    if(tabParties.length>3&&tabParties[3]!=null){
		String nomfichier3=tabParties[3];
		String nomJoueur3=nomfichier3.substring(5,nomfichier3.length()-4);
	        pchoix.add(new JLabel(this.getImgChoixSupp(nomJoueur3)),c);
		psupp.add(new JLabel(this.getImgChoixSupp(nomJoueur3)),c);
	    }else if(tabParties.length>0&&tabParties[0]!=null){
		pchoix.add(new JLabel(noImage),c);
		psupp.add(new JLabel(noImage),c);
	    }

	    c.gridx=5;
	    pcrea.add(dfcrea,c);
	    if(tabParties.length>4&&tabParties[4]!=null){
		String nomfichier4=tabParties[4];
		String nomJoueur4=nomfichier4.substring(5,nomfichier4.length()-4);
	        pchoix.add(new JLabel(this.getImgChoixSupp(nomJoueur4)),c);
		psupp.add(new JLabel(this.getImgChoixSupp(nomJoueur4)),c);
	    }else if(tabParties.length>0&&tabParties[0]!=null){
		pchoix.add(new JLabel(noImage),c);
		psupp.add(new JLabel(noImage),c);
	    }
	    c.gridwidth=2;
	    pmenu.add(versChoix,c);
	    c.gridwidth=1;
	    
	    c.gridx=6;
	    pcrea.add(dmcrea,c);
	    if(tabParties.length>5&&tabParties[5]!=null){
		String nomfichier5=tabParties[5];
		String nomJoueur5=nomfichier5.substring(5,nomfichier5.length()-4);
	        pchoix.add(new JLabel(this.getImgChoixSupp(nomJoueur5)),c);
		psupp.add(new JLabel(this.getImgChoixSupp(nomJoueur5)),c);
	    }else if(tabParties.length>0&&tabParties[0]!=null){
		pchoix.add(new JLabel(noImage),c);
		psupp.add(new JLabel(noImage),c);
	    }

	    c.gridx=1;
	    c.gridy=4; /*- - - - - - - - - - - - - - - -l5- - -*/
	    c.gridwidth=1;
	    pcrea.add(nomRF,c);
	    if(tabParties.length>0&&tabParties[0]!=null){
		String nomfichier0=tabParties[0];
		String nomJoueur0="<HTML>"+nomfichier0.substring(0,5)+"<br>"+nomfichier0.substring(5,nomfichier0.length()-4)+"</HTML>";
		Bouton a=new Bouton(nomJoueur0);
		Bouton b=new Bouton(nomJoueur0);
		a.addActionListener(co);
		b.addActionListener(co);
		pchoix.add(a,c);
		psupp.add(b,c);
	    }
	    c.gridx=2;
	    pcrea.add(nomRM,c);
	    if(tabParties.length>1&&tabParties[1]!=null){
		String nomfichier1=tabParties[1];
		String nomJoueur1="<HTML>"+nomfichier1.substring(0,5)+"<br>"+nomfichier1.substring(5,nomfichier1.length()-4)+"</HTML>";
		Bouton a=new Bouton(nomJoueur1);
		Bouton b=new Bouton(nomJoueur1);
		a.addActionListener(co);
		b.addActionListener(co);
		pchoix.add(a,c);
		psupp.add(b,c);
	    }else if(tabParties.length>0&&tabParties[0]!=null){
		pchoix.add(new JLabel("Vide"),c);
		psupp.add(new JLabel("Vide"),c);
	    }
	    c.gridx=3;
	    pcrea.add(nomPF,c);
	    if(tabParties.length>2&&tabParties[2]!=null){
		String nomfichier2=tabParties[2];
		String nomJoueur2="<HTML>"+nomfichier2.substring(0,5)+"<br>"+nomfichier2.substring(5,nomfichier2.length()-4)+"</HTML>";
	        Bouton a=new Bouton(nomJoueur2);
		Bouton b=new Bouton(nomJoueur2);
		a.addActionListener(co);
		b.addActionListener(co);
		pchoix.add(a,c);
		psupp.add(b,c);
	    }else if(tabParties.length>0&&tabParties[0]!=null){
		pchoix.add(new JLabel("Vide"),c);
		psupp.add(new JLabel("Vide"),c);
	    }
	    c.gridx=4;
	    pcrea.add(nomPM,c);
	    if(tabParties.length>3&&tabParties[3]!=null){
		String nomfichier3=tabParties[3];
		String nomJoueur3="<HTML>"+nomfichier3.substring(0,5)+"<br>"+nomfichier3.substring(5,nomfichier3.length()-4)+"</HTML>";
	        Bouton a=new Bouton(nomJoueur3);
		Bouton b=new Bouton(nomJoueur3);
		a.addActionListener(co);
		b.addActionListener(co);
		pchoix.add(a,c);
		psupp.add(b,c);
	    }else if(tabParties.length>0&&tabParties[0]!=null){
		pchoix.add(new JLabel("Vide"),c);
		psupp.add(new JLabel("Vide"),c);
	    }

	    c.gridx=5;
	    pcrea.add(nomDF,c);
	    if(tabParties.length>4&&tabParties[4]!=null){
		String nomfichier4=tabParties[4];
		String nomJoueur4="<HTML>"+nomfichier4.substring(0,5)+"<br>"+nomfichier4.substring(5,nomfichier4.length()-4)+"</HTML>";
	        Bouton a=new Bouton(nomJoueur4);
		Bouton b=new Bouton(nomJoueur4);
		a.addActionListener(co);
		b.addActionListener(co);
		pchoix.add(a,c);
		psupp.add(b,c);
	    }else if(tabParties.length>0&&tabParties[0]!=null){
		pchoix.add(new JLabel("Vide"),c);
		psupp.add(new JLabel("Vide"),c);
	    }

	    c.gridwidth=2;
	    pmenu.add(versSupp,c);
	    c.gridwidth=1;
	    
	    c.gridx=6;
	    pcrea.add(nomDM,c);
	    if(tabParties.length>5&&tabParties[5]!=null){
		String nomfichier5=tabParties[5];
		String nomJoueur5="<HTML>"+nomfichier5.substring(0,5)+"<br>"+nomfichier5.substring(5,nomfichier5.length()-4)+"</HTML>";
	        Bouton a=new Bouton(nomJoueur5);
		Bouton b=new Bouton(nomJoueur5);
		a.addActionListener(co);
		b.addActionListener(co);
		pchoix.add(a,c);
		psupp.add(b,c);
	    }else if(tabParties.length>0&&tabParties[0]!=null){
		pchoix.add(new JLabel("Vide"),c);
		psupp.add(new JLabel("Vide"),c);
	    }
	    c.gridx=1;
	    c.gridy=5; /*- - - - - - - - - - - - - - - -l6- - -*/
	    c.ipady = c.anchor = GridBagConstraints.CENTER;

	    c.fill=GridBagConstraints.BOTH;
	    c.gridwidth=2;
	    c.gridx=5;
	    pcrea.add(validerCrea,c);
	    pchoix.add(validerChoix,c);
	    psupp.add(validerSupp,c);
	    c.gridx=10;
	    c.gridwidth=2;
	    c.fill=GridBagConstraints.NONE;
	    pmenu.add(versCommandes,c);
	



	    cards.add(nomJeu,pinit);
	    cards.add(creaPartie, pcrea);
	    cards.add(menu,pmenu);
	    cards.add(commandes,poption);
	    cards.add(choixPartie,pchoix);
	    cards.add(suppression,psupp);
	    cards.add(chargement,pcharge);
	    this.add(cards);
	    
	    
	    Font font = new Font("Verdana",Font.BOLD,16);
	    nomGame.setFont(font);
	    font = new Font("Verdana",Font.BOLD,20);
	    nomGame2.setFont(font);
	
	    this.setVisible(true);
	    try{
		Thread.sleep(2000);
		//this.revalidate();
	    }catch(InterruptedException q){
	    }
	    this.setEcranMenuAccueil();
	}catch (IOException e){
	    e.printStackTrace();
	};
    }
    public void updateDonneesEcranAccueil(String[] tab){
	this.tabParties=tab;
	PanelFond pchoix=new PanelFond();
	PanelFond psupp=new PanelFond();
	NavigationAccueil retourChoix=new NavigationAccueil("retour");
	NavigationAccueil retourSupp=new NavigationAccueil("retour");
	c=new GridBagConstraints();
	pchoix.setLayout(new GridBagLayout());
	psupp.setLayout(new GridBagLayout());

	NavigationAccueil validerChoix=new NavigationAccueil("continuer");
	NavigationAccueil validerSupp=new NavigationAccueil("supprimer");
	retourChoix.addActionListener(co);
	retourSupp.addActionListener(co);
	validerChoix.addActionListener(co);
	validerSupp.addActionListener(co);
	c.gridx=0;
	c.gridy=0; /* - - - - - - - - - - - - - - - -l1- - - -*/
	//c.gridwidth=1;  //colonnes
	c.gridheight=1;  // lignes
	c.fill=GridBagConstraints.BOTH;
	c.insets=new Insets(0,0,0,0);
	c.weightx=1.0f;
	c.weighty=1.0f;
	    
	c.ipady = c.anchor = GridBagConstraints.LINE_START;
	c.gridwidth=5;
	pchoix.add(continu,c);
	psupp.add(supprim,c);

	c.gridwidth=2;
	c.gridx=5;
	/* insertion des boutons retour*/
	pchoix.add(retourChoix,c);
	psupp.add(retourSupp,c);

	c.gridx=1;
	c.gridy=3; /*- - - - - - - - - - - - - - - -l4- - -*/
	c.gridwidth=1;
	c.ipady = c.anchor = GridBagConstraints.CENTER;
	if(tabParties.length>0&&tabParties[0]!=null){
	    String nomfichier0=tabParties[0];
	    String nomJoueur0=nomfichier0.substring(5,nomfichier0.length()-4);
	    pchoix.add(new JLabel(this.getImgChoixSupp(nomJoueur0)),c);
	    psupp.add(new JLabel(this.getImgChoixSupp(nomJoueur0)),c);
	}else{
	    pchoix.add(new JLabel("Pas de sauvegardes"),c);
	    psupp.add(new JLabel("Pas de sauvegardes"),c);
	}
	c.gridx=2;
	if(tabParties.length>1&&tabParties[1]!=null){
	    String nomfichier1=tabParties[1];
	    String nomJoueur1=nomfichier1.substring(5,nomfichier1.length()-4);
	    pchoix.add(new JLabel(this.getImgChoixSupp(nomJoueur1)),c);
	    psupp.add(new JLabel(this.getImgChoixSupp(nomJoueur1)),c);
	}else if(tabParties[0]!=null){
	    pchoix.add(new JLabel(noImage),c);
	    psupp.add(new JLabel(noImage),c);
	}

	c.gridx=3;
	if(tabParties.length>2&&tabParties[2]!=null){
	    String nomfichier2=tabParties[2];
	    String nomJoueur2=nomfichier2.substring(5,nomfichier2.length()-4);
	    pchoix.add(new JLabel(this.getImgChoixSupp(nomJoueur2)),c);
	    psupp.add(new JLabel(this.getImgChoixSupp(nomJoueur2)),c);
	}else if(tabParties[0]!=null){
	    pchoix.add(new JLabel(noImage),c);
	    psupp.add(new JLabel(noImage),c);
	}
	c.gridx=4;
	if(tabParties.length>3&&tabParties[3]!=null){
	    String nomfichier3=tabParties[3];
	    String nomJoueur3=nomfichier3.substring(5,nomfichier3.length()-4);
	    pchoix.add(new JLabel(this.getImgChoixSupp(nomJoueur3)),c);
	    psupp.add(new JLabel(this.getImgChoixSupp(nomJoueur3)),c);
	}else if(tabParties[0]!=null){
	    pchoix.add(new JLabel(noImage),c);
	    psupp.add(new JLabel(noImage),c);
	}

	c.gridx=5;
	if(tabParties.length>4&&tabParties[4]!=null){
	    String nomfichier4=tabParties[4];
	    String nomJoueur4=nomfichier4.substring(5,nomfichier4.length()-4);
	    pchoix.add(new JLabel(this.getImgChoixSupp(nomJoueur4)),c);
	    psupp.add(new JLabel(this.getImgChoixSupp(nomJoueur4)),c);
	}else if(tabParties[0]!=null){
	    pchoix.add(new JLabel(noImage),c);
	    psupp.add(new JLabel(noImage),c);
	}
	c.gridwidth=1;
	    
	c.gridx=6;
	if(tabParties.length>5&&tabParties[5]!=null){
	    String nomfichier5=tabParties[5];
	    String nomJoueur5=nomfichier5.substring(5,nomfichier5.length()-4);
	    pchoix.add(new JLabel(this.getImgChoixSupp(nomJoueur5)),c);
	    psupp.add(new JLabel(this.getImgChoixSupp(nomJoueur5)),c);
	}else if(tabParties[0]!=null){
	    pchoix.add(new JLabel(noImage),c);
	    psupp.add(new JLabel(noImage),c);
	}
	c.gridx=1;
	c.gridy=4; /*- - - - - - - - - - - - - - - -l5- - -*/
	c.gridwidth=1;
	if(tabParties.length>0&&tabParties[0]!=null){
	    String nomfichier0=tabParties[0];
	    String nomJoueur0="<HTML>"+nomfichier0.substring(0,5)+"<br>"+nomfichier0.substring(5,nomfichier0.length()-4)+"</HTML>";
	    Bouton a=new Bouton(nomJoueur0);
	    Bouton b=new Bouton(nomJoueur0);
	    a.addActionListener(co);
	    b.addActionListener(co);
	    pchoix.add(a,c);
	    psupp.add(b,c);
	}
	c.gridx=2;
	if(tabParties.length>1&&tabParties[1]!=null){
	    String nomfichier1=tabParties[1];
	    String nomJoueur1="<HTML>"+nomfichier1.substring(0,5)+"<br>"+nomfichier1.substring(5,nomfichier1.length()-4)+"</HTML>";
	    Bouton a=new Bouton(nomJoueur1);
	    Bouton b=new Bouton(nomJoueur1);
	    a.addActionListener(co);
	    b.addActionListener(co);
	    pchoix.add(a,c);
	    psupp.add(b,c);
	}else if(tabParties.length>0&&tabParties[0]!=null){
	    pchoix.add(new JLabel("Vide"),c);
	    psupp.add(new JLabel("Vide"),c);
	}
	c.gridx=3;
	if(tabParties.length>2&&tabParties[2]!=null){
	    String nomfichier2=tabParties[2];
	    String nomJoueur2="<HTML>"+nomfichier2.substring(0,5)+"<br>"+nomfichier2.substring(5,nomfichier2.length()-4)+"</HTML>";
	    Bouton a=new Bouton(nomJoueur2);
	    Bouton b=new Bouton(nomJoueur2);
	    a.addActionListener(co);
	    b.addActionListener(co);
	    pchoix.add(a,c);
	    psupp.add(b,c);
	}else if(tabParties.length>0&&tabParties[0]!=null){
	    pchoix.add(new JLabel("Vide"),c);
	    psupp.add(new JLabel("Vide"),c);
	}
	c.gridx=4;
	if(tabParties.length>3&&tabParties[3]!=null){
	    String nomfichier3=tabParties[3];
	    String nomJoueur3="<HTML>"+nomfichier3.substring(0,5)+"<br>"+nomfichier3.substring(5,nomfichier3.length()-4)+"</HTML>";
	    Bouton a=new Bouton(nomJoueur3);
	    Bouton b=new Bouton(nomJoueur3);
	    a.addActionListener(co);
	    b.addActionListener(co);
	    pchoix.add(a,c);
	    psupp.add(b,c);
	}else if(tabParties.length>0&&tabParties[0]!=null){
	    pchoix.add(new JLabel("Vide"),c);
	    psupp.add(new JLabel("Vide"),c);
	}

	c.gridx=5;
	if(tabParties.length>4&&tabParties[4]!=null){
	    String nomfichier4=tabParties[4];
	    String nomJoueur4="<HTML>"+nomfichier4.substring(0,5)+"<br>"+nomfichier4.substring(5,nomfichier4.length()-4)+"</HTML>";
	    Bouton a=new Bouton(nomJoueur4);
	    Bouton b=new Bouton(nomJoueur4);
	    a.addActionListener(co);
	    b.addActionListener(co);
	    pchoix.add(a,c);
	    psupp.add(b,c);
	}else if(tabParties.length>0&&tabParties[0]!=null){
	    pchoix.add(new JLabel("Vide"),c);
	    psupp.add(new JLabel("Vide"),c);
	}
	c.gridwidth=1;
	    
	c.gridx=6;
	if(tabParties.length>5&&tabParties[5]!=null){
	    String nomfichier5=tabParties[5];
	    String nomJoueur5="<HTML>"+nomfichier5.substring(0,5)+"<br>"+nomfichier5.substring(5,nomfichier5.length()-4)+"</HTML>";
	    Bouton a=new Bouton(nomJoueur5);
	    Bouton b=new Bouton(nomJoueur5);
	    a.addActionListener(co);
	    b.addActionListener(co);
	    pchoix.add(a,c);
	    psupp.add(b,c);
	}else if(tabParties.length>0&&tabParties[0]!=null){
	    pchoix.add(new JLabel("Vide"),c);
	    psupp.add(new JLabel("Vide"),c);
	}
	c.gridx=1;
	c.gridy=5; /*- - - - - - - - - - - - - - - -l6- - -*/
	c.ipady = c.anchor = GridBagConstraints.CENTER;

	c.fill=GridBagConstraints.BOTH;
	c.gridwidth=2;
	c.gridx=5;
	pchoix.add(validerChoix,c);
	psupp.add(validerSupp,c);
	

	cards.add(choixPartie,pchoix);
	cards.add(suppression,psupp);
    }

    public ImageIcon getImgChoixSupp(String nomJoueur){
	
	if(nomJoueur.equals("Olivia")) return(imagePF);
	if(nomJoueur.equals("Inès")) return(imageDF);
	if(nomJoueur.equals("Myriam")) return(imageRF);
	if(nomJoueur.equals("Baptiste")) return(imageRM);
	if(nomJoueur.equals("Mathéo")) return(imagePM);
	if(nomJoueur.equals("Thomas")) return(imageDM);
        return(noImage);
    }

    public void setEcranMenuAccueil(){
	((CardLayout) cards.getLayout()).show(cards,menu);
    }

    public void setEcranCreationPartie(){
	((CardLayout) cards.getLayout()).show(cards,creaPartie);
    }
    public void setEcranChoixPartie(){
	((CardLayout) cards.getLayout()).show(cards,choixPartie);
    }
    public void setEcranCommandePartie(){
	((CardLayout) cards.getLayout()).show(cards,commandes);
    }
    public void setEcranSuppPartie(){
	((CardLayout) cards.getLayout()).show(cards,suppression);
    }
    public void setEcranChargeLancement(){
	((CardLayout) cards.getLayout()).show(cards,chargement);
	t.start();
    }
}

