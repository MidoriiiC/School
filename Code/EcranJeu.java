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

public class EcranJeu extends JFrame{
    private String nom;
    private String chap;
    
    private Joueur self;
    public Eleve girlh;
    public Eleve girll;
    public Eleve girla;
    private char dir;
    private Controleur ctlr;
    private final String salle1="Salle1";
    private final String salle2="Salle2";
    private final String salle3="Salle3";
    private final String salle4="Salle4";
    private final String couloir1="Couloir1";
    private final String appartMyriam="AppartMyriam";
    private String salleP;
    private String salleActuelle;
    private Partie partie;
    private char[][] grille1;
    private char[][] grille2;
    private char[][] grille3;
    private char[][] grille4;
    private char[][] grilleC1;
    private char[][] grilleAM;
    public FondSalle psalle1=new FondSalle(salle1);
    public FondSalle psalle2=new FondSalle(salle2);
    public FondSalle psalle3=new FondSalle(salle3);
    public FondSalle psalle4=new FondSalle(salle4);
    public FondSalle pcoul1=new FondSalle(couloir1);
    public FondSalle pappartMyriam=new FondSalle(appartMyriam);
    public ImageIcon vide;
    public ImageIcon mur1;
    public ImageIcon mur2;
    
    public ImageIcon sortie1;
    public ImageIcon sortie2;
    public ImageIcon sortie3;
    public ImageIcon sortie4;
    public ImageIcon sortie5;
    public ImageIcon sortie6;
    public ImageIcon sortieC1;
    public ImageIcon sortieEcole;
    
    public ImageIcon mur3;
    public ImageIcon mur4;
    public ImageIcon murC1;
    public ImageIcon sol;
    public ImageIcon bureau;
    public ImageIcon bDM;
    public ImageIcon bDF;
    public ImageIcon bP;
    public ImageIcon bR;
    public ImageIcon bureauP;
    public ImageIcon bDMP;
    public ImageIcon bDFP;
    public ImageIcon bPP;
    public ImageIcon bRP;
    
    JPanel cards;
    public JLabel dialogue1;
    public JLabel dialogue2;
    public JLabel dialogue3;
    public JLabel dialogue4;
    public JLabel dialogueC1;
    public JLabel dialogueAM;

    public JLabel dialogueIcon1;
    public JLabel dialogueIcon2;
    public JLabel dialogueIcon3;
    public JLabel dialogueIcon4;
    public JLabel dialogueIconC1;
    public JLabel dialogueIconAM;
    String mission;

    
    public EcranJeu(String n, String ch, Controleur ct, Partie p){
	this.nom=n;
	this.chap=ch;
	this.ctlr=ct;
	this.addKeyListener(this.ctlr);
	//System.out.println(this.isFocusable());
	this.partie=p;
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 637);
	this.setLocationRelativeTo(null);
	this.setTitle("Bruits de Couloirs");
	cards=new JPanel();
	cards.setLayout(new CardLayout());
	
	this.salleActuelle=this.salleP;
	
	this.grille1=this.partie.getFileClasse(this.salle1);
	this.grille2=this.partie.getFileClasse(this.salle2);
	this.grille3=this.partie.getFileClasse(this.salle3);
	this.grille4=this.partie.getFileClasse(this.salle4);
	this.grilleC1=this.partie.getFileClasse(this.couloir1);
	this.grilleAM=this.partie.getFileClasse(this.appartMyriam);
	girlh=new Eleve("Héloïse");
	girll=new Eleve("Lili");
	girla=new Eleve("Alexa");
	
	this.self=new Joueur(this.nom);
	if (this.nom.equals("Thomas")||this.nom.equals("Baptiste")) {
	    this.salleP=this.salleActuelle="Salle1";
	    this.grille1[this.self.x][this.self.y]='J';
	    if (this.nom.equals("Thomas")) mission="distribuer les cours à tous les élèves.";
	    if (this.nom.equals("Baptiste")) mission="trouver une revue douteuse dans le sac du délégué.";
	}
	if (this.nom.equals("Mathéo")) {
	    this.salleP=this.salleActuelle="Salle2";
	    mission="comprendre pourquoi les élèves évite la déléguée.";
	    this.grille2[this.self.x][this.self.y]='J';
	}
	if (this.nom.equals("Myriam")) {
	    this.salleP=this.salleActuelle="Salle3";
	    this.grille3[this.self.x][this.self.y]='J';
	    //this.salleP=this.salleActuelle="AppartMyriam";
	    //this.grilleAM[this.self.x][this.self.y]='J';
	    mission="trouver un devoir à recopier en s-4.";
	}
	if (this.nom.equals("Olivia")) {
	    this.salleP=this.salleActuelle="Salle4";
	    this.grille4[this.self.x][this.self.y]='J';
	    mission="trouver un témoin pour savoir s'il y a un nouveau couple.";
	}
	if (this.nom.equals("Inès")) {
	    this.salleP=this.salleActuelle="Salle2";
	    this.grille2[this.self.x][this.self.y]='J';
	    mission="distribuer les feuilles de sondages pour le prochain festival.";
	}
	
	try{
	    Image myPic = ImageIO.read(new File("../Images/Meubles/vide.png"));
	    vide = new ImageIcon(myPic);
	    Image myPm1 = ImageIO.read(new File("../Images/Meubles/mur1.png"));
	    mur1 = new ImageIcon(myPm1);
	    Image myPm2 = ImageIO.read(new File("../Images/Meubles/mur2.png"));
	    mur2 = new ImageIcon(myPm2);
	    Image myPm3 = ImageIO.read(new File("../Images/Meubles/mur3.png"));
	    mur3 = new ImageIcon(myPm3);
	    Image myPm4 = ImageIO.read(new File("../Images/Meubles/mur4.png"));
	    mur4 = new ImageIcon(myPm4);
	    Image myPmC1 = ImageIO.read(new File("../Images/Meubles/couloir1.png"));
	    murC1 = new ImageIcon(myPmC1);
	    Image myPicb = ImageIO.read(new File("../Images/Meubles/sol.png"));
	    sol = new ImageIcon(myPicb);

	    Image myPicc = ImageIO.read(new File("../Images/Meubles/Desk.png"));
	    bureau = new ImageIcon(myPicc);
	    Image myPicd = ImageIO.read(new File("../Images/Meubles/DeskRespB.png"));
	    bDM = new ImageIcon(myPicd);
	    Image myPicBDF = ImageIO.read(new File("../Images/Meubles/DeskRespG.png"));
	    bDF = new ImageIcon(myPicBDF);
	    Image myPicBP = ImageIO.read(new File("../Images/Meubles/DeskPopular.png"));
	    bP = new ImageIcon(myPicBP);
	    Image myPice = ImageIO.read(new File("../Images/Meubles/DeskFight.png"));
	    bR = new ImageIcon(myPice);

	    
	    myPicc = ImageIO.read(new File("../Images/Meubles/DeskPaper.png"));
	    bureauP = new ImageIcon(myPicc);
	    myPicd = ImageIO.read(new File("../Images/Meubles/DeskRespBPaper.png"));
	    bDMP = new ImageIcon(myPicd);
	    myPicBDF = ImageIO.read(new File("../Images/Meubles/DeskRespGPaper.png"));
	    bDFP = new ImageIcon(myPicBDF);
	    myPicBP = ImageIO.read(new File("../Images/Meubles/DeskPopularPaper.png"));
	    bPP = new ImageIcon(myPicBP);
	    myPice = ImageIO.read(new File("../Images/Meubles/DeskFightPaper.png"));
	    bRP = new ImageIcon(myPice);



	    Image myPicS1 = ImageIO.read(new File("../Images/Meubles/eS1.png"));
	    sortie1= new ImageIcon(myPicS1);
	    Image myPicS2 = ImageIO.read(new File("../Images/Meubles/eS2.png"));
	    sortie2= new ImageIcon(myPicS2);
	    Image myPicS3 = ImageIO.read(new File("../Images/Meubles/eS3.png"));
	    sortie3= new ImageIcon(myPicS3);
	    Image myPicS4 = ImageIO.read(new File("../Images/Meubles/eS4.png"));
	    sortie4= new ImageIcon(myPicS4);
    	    Image myPicS5 = ImageIO.read(new File("../Images/Meubles/eS5.png"));
	    sortie5= new ImageIcon(myPicS5);
	    Image myPicS6 = ImageIO.read(new File("../Images/Meubles/eS6.png"));
	    sortie6= new ImageIcon(myPicS6);
	    Image myPicC1 = ImageIO.read(new File("../Images/Meubles/eC1.png"));
	    sortieC1= new ImageIcon(myPicC1);
	}catch (IOException e){
	    e.printStackTrace();
	};

	/* - - - - - - - - - salle 1 - - - - - - - - - - - */

	
	GridBagConstraints c1= new GridBagConstraints();
	psalle1.setLayout(new GridBagLayout());
	c1.gridx=0;
	c1.gridy=0; /* - - - - - - - - - - - - - - - -l1- - - -*/
	c1.gridwidth=1;  //colonnes
	c1.gridheight=1;  // lignes
	c1.fill=GridBagConstraints.BOTH;
	c1.ipady = c1.anchor = GridBagConstraints.CENTER;
	c1.insets=new Insets(0,0,0,0);
	c1.weightx=1.0f;
	c1.weighty=1.0f;
	c1.fill=GridBagConstraints.BOTH;

	/*for(int j=0; j<10; j++){
	    for(int i=0; i<16; i++)
		System.out.print(this.grille1[i][j]);
	    System.out.println(" ");
	    }*/
	for(int j=0; j<10; j++){
	    for(int i=0; i<16; i++){
		c1.gridx=i;
		c1.gridy=j;
		//System.out.print(this.grille1[i][j]);
		if(this.grille1[i][j]=='%') psalle1.add(new JLabel(vide),c1);
		if(this.grille1[i][j]=='M') psalle1.add(new Jabel(),c1);
		if(this.grille1[i][j]=='S') psalle1.add(new Jabel(),c1);
		if(this.grille1[i][j]=='E') psalle1.add(new Jabel(),c1);
		
		if(this.grille1[i][j]=='t') psalle1.add(new JLabel(bureau),c1);
		if(this.grille1[i][j]=='c') psalle1.add(new JLabel(bDM),c1);
		if(this.grille1[i][j]=='g') psalle1.add(new JLabel(bR),c1);
		if(this.grille1[i][j]=='J') {
		    psalle1.add(new JLabel(this.self.front),c1);
		}
	    }
	    //System.out.println(" ");
	}
	c1.gridx=0;      //il faudrait revoir les commandes pour qu'il 
	c1.gridy=10;      // tout l'espace restant
	c1.gridwidth=16;  // lignes
	c1.weightx=0.0f;
	c1.weighty=0.0f;
	c1.fill=GridBagConstraints.CENTER;
	if(this.chap.equals("intro")){
	    dialogue1= new JLabel("Mission: "+mission);
	    if(this.nom.equals("Thomas"))
		dialogue1= new JLabel("<HTML>Bon... Je suis chargé de distribuer le cours du professeur malade dans toutes les classes.<br>Je vais simplement poser les feuilles sur toutes les tables.<br>C'est parti.</HTML>");
	    if(this.nom.equals("Baptiste"))
		dialogue1= new JLabel("<HTML>Je me demande si quelqu'un apporte une revue cochonne en cours.<br>Je vais regarder discrètos dans le sac de l'intello.</HTML>");
	}
	if(this.chap.equals("chap3"))
	    dialogue1= new JLabel("zone de texte salle 1, le personnage est "+this.nom+" et le chap 3 n'est pas encore imaginé");
	dialogue1.setMinimumSize(new Dimension(800,99));
	psalle1.add(dialogue1,c1);
	cards.add(salle1,psalle1);
	/* - - - - - - - - - salle 2 - - - - - - - - - - - */
	

	GridBagConstraints c2= new GridBagConstraints();
	psalle2.setLayout(new GridBagLayout());
	
	c2.gridx=0;
	c2.gridy=0; /* - - - - - - - - - - - - - - - -l1- - - -*/
	c2.gridwidth=1;  //colonnes
	c2.gridheight=1;  // lignes
	c2.fill=GridBagConstraints.BOTH;
	c2.ipady = c2.anchor = GridBagConstraints.CENTER;
	c2.insets=new Insets(0,0,0,0);
	c2.weightx=1.0f;
	c2.weighty=1.0f;
	
	for(int j=0; j<10; j++){
	    for(int i=0; i<16; i++){
		c2.gridx=i;
		c2.gridy=j;
		if(this.grille2[i][j]=='%') psalle2.add(new JLabel(vide),c2);
		if(this.grille2[i][j]=='M') psalle2.add(new Jabel(),c2);
		if(this.grille2[i][j]=='S') psalle2.add(new Jabel(),c2);
		if(this.grille2[i][j]=='E') psalle2.add(new Jabel(),c2);
		
		if(this.grille2[i][j]=='t') psalle2.add(new JLabel(bureau),c2);
		if(this.grille2[i][j]=='a') psalle2.add(new JLabel(bDF),c2);
		if(this.grille2[i][j]=='e') psalle2.add(new JLabel(bP),c2);
		if(this.grille2[i][j]=='J') {
		    psalle2.add(new JLabel(this.self.front),c2);
		}
	    }
	}
	c2.gridx=0;      //il faudrait revoir les commandes pour qu'il 
	c2.gridy=10;      // tout l'espace restant
	c2.gridwidth=16;  // lignes
	c2.weightx=0.0f;
	c2.weighty=0.0f;
	c2.fill=GridBagConstraints.VERTICAL;
        if(this.chap.equals("intro")){
	    dialogue2=new JLabel("Mission: "+mission);
	    if(this.nom.equals("Mathéo"))
		dialogue2= new JLabel("<HTML>La déléguée n'est pas dans la salle, je vais pouvoir demander aux autres pourquoi ils l'évitent.<br> Elle n'est pourtant pas méchante...</HTML>");
	    if(this.nom.equals("Inès"))
		dialogue2= new JLabel("<HTML>En tant que déléguée, je doit présenter un projet pour le prochain festival.<br> Comme les gens préfèrent m'éviter, je vais passer par le papier.</HTML>");
	}
	if(this.chap.equals("chap3"))
	    dialogue2= new JLabel("zone de texte salle 2, le personnage est "+this.nom+" et le chap 3 n'est pas encore imaginé");
	dialogue2.setMinimumSize(new Dimension(800,99));
	psalle2.add(dialogue2,c2);
	cards.add(salle2,psalle2);
	/* - - - - - - - - - salle 3 - - - - - - - - - - - */
	
	GridBagConstraints c3= new GridBagConstraints();
	psalle3.setLayout(new GridBagLayout());
	
	c3.gridx=0;
	c3.gridy=0; /* - - - - - - - - - - - - - - - -l1- - - -*/
	c3.gridwidth=1;  //colonnes
	c3.gridheight=1;  // lignes
	c3.fill=GridBagConstraints.BOTH;
	c3.ipady = c3.anchor = GridBagConstraints.CENTER;
	c3.insets=new Insets(0,0,0,0);
	c3.weightx=1.0f;
	c3.weighty=1.0f;
	
	for(int j=0; j<10; j++){
	    for(int i=0; i<16; i++){
		c3.gridx=i;
		c3.gridy=j;
		if(this.grille3[i][j]=='%') psalle3.add(new JLabel(vide),c3);
		if(this.grille3[i][j]=='M') psalle3.add(new Jabel(),c3);
		if(this.grille3[i][j]=='S') psalle3.add(new Jabel(),c3);
		if(this.grille3[i][j]=='E') psalle3.add(new Jabel(),c3);
		
		if(this.grille3[i][j]=='t') psalle3.add(new JLabel(bureau),c3);
		if(this.grille3[i][j]=='g') psalle3.add(new JLabel(bR),c3);
		if(this.grille3[i][j]=='J') {
		    psalle3.add(new JLabel(this.self.front),c3);
		}
		if(this.grille3[i][j]=='i') psalle3.add(new JLabel(girla.front),c3);
	    }
	}
	c3.gridx=0;      //il faudrait revoir les commandes pour qu'il 
	c3.gridy=10;      // tout l'espace restant
	c3.gridwidth=16;  // lignes
	c3.weightx=0.0f;
	c3.weighty=0.0f;
	c3.fill=GridBagConstraints.VERTICAL;
        if(this.chap.equals("intro")){
	    dialogue3= new JLabel("Mission: "+mission);
	    if(this.nom.equals("Myriam"))
		dialogue3= new JLabel("<HTML>Argh, j'ai encore dormis pendant le cours au lieu de faire le devoir à rendre cet après-midi!<br>Je vais devoir fouiller dans les affaires des autres.<br>C'est chiant mais c'est mon seul espoir maintenant...<br>La nana populaire de la s-4 laisse souvent en traîner d'ailleurs.</HTML>");
	}
	if(this.chap.equals("chap3"))
	    dialogue3= new JLabel("zone de texte salle 3, le personnage est "+this.nom+" et le chap 3 n'est pas encore imaginé");
	dialogue3.setMinimumSize(new Dimension(800,99));
	psalle3.add(dialogue3,c3);
	cards.add(salle3,psalle3);
	/* - - - - - - - - - salle 4 - - - - - - - - - - - */

	GridBagConstraints c4= new GridBagConstraints();
	psalle4.setLayout(new GridBagLayout());

	c4.gridx=0;
	c4.gridy=0; /* - - - - - - - - - - - - - - - -l1- - - -*/
	c4.gridwidth=1;  //colonnes
	c4.gridheight=1;  // lignes
	c4.fill=GridBagConstraints.BOTH;
	c4.ipady = c4.anchor = GridBagConstraints.CENTER;
	c4.insets=new Insets(0,0,0,0);
	c4.weightx=1.0f;
	c4.weighty=1.0f;
	
	for(int j=0; j<10; j++){
	    for(int i=0; i<16; i++){
		c4.gridx=i;
		c4.gridy=j;
		if(this.grille4[i][j]=='%') psalle4.add(new JLabel(vide),c4);
		if(this.grille4[i][j]=='M') psalle4.add(new Jabel(),c4);
		if(this.grille4[i][j]=='S') psalle4.add(new Jabel(),c4);
		if(this.grille4[i][j]=='E') psalle4.add(new Jabel(),c4);
		
		if(this.grille4[i][j]=='t') psalle4.add(new JLabel(bureau),c4);
		if(this.grille4[i][j]=='a') psalle4.add(new JLabel(bDF),c4);
		if(this.grille4[i][j]=='e') psalle4.add(new JLabel(bP),c4);
		if(this.grille4[i][j]=='J') {
		    psalle4.add(new JLabel(this.self.front),c4);
		}
		if(this.grille4[i][j]=='j') psalle4.add(new JLabel(girll.front),c4);
	    }
	    
	}
	c4.gridx=0;      //il faudrait revoir les commandes pour qu'il 
	c4.gridy=10;      // tout l'espace restant
	c4.gridwidth=16;  // lignes
	c4.weightx=0.0f;
	c4.weighty=0.0f;
	c4.fill=GridBagConstraints.VERTICAL;
        if(this.chap.equals("intro")){
	    dialogue4= new JLabel("Mission: "+mission);
	    if(this.nom.equals("Olivia"))
		dialogue4= new JLabel("<HTML>Je veux savoir si un nouveau couple s'est formé.<br>Sus aux ragots!</HTML>");
	}
	if(this.chap.equals("chap3"))
	    dialogue4= new JLabel("zone de texte salle 4, le personnage est "+this.nom+" et le chap 3 n'est pas encore imaginé");
	dialogue4.setMinimumSize(new Dimension(800,99));
	psalle4.add(dialogue4,c4);
	cards.add(salle4,psalle4);
	/* - - - - - - - - - couloirs - - - - - - - - - - - */

	GridBagConstraints cc1= new GridBagConstraints();
	pcoul1.setLayout(new GridBagLayout());

	cc1.gridx=0;
	cc1.gridy=0; /* - - - - - - - - - - - - - - - -l1- - - -*/
	cc1.gridwidth=1;  //colonnes
	cc1.gridheight=1;  // lignes
	cc1.fill=GridBagConstraints.BOTH;
	cc1.ipady = cc1.anchor = GridBagConstraints.CENTER;
	cc1.insets=new Insets(0,0,0,0);
	cc1.weightx=1.0f;
	cc1.weighty=1.0f;
	
	for(int j=0; j<10; j++){
	    for(int i=0; i<16; i++){
		cc1.gridx=i;
		cc1.gridy=j;
		if(this.grilleC1[i][j]=='%') pcoul1.add(new JLabel(vide),cc1);
		if(this.grilleC1[i][j]=='M') pcoul1.add(new Jabel(),cc1);
		if(this.grilleC1[i][j]=='S') pcoul1.add(new Jabel(),cc1);
		if(this.grilleC1[i][j]=='E'){
		    if(i==4&&j==1) pcoul1.add(new Jabel(),cc1);
		    if(i==4&&j==7) pcoul1.add(new Jabel(),cc1);
		    if(i==4&&j==13) pcoul1.add(new Jabel(),cc1);
		    if(i==8&&j==1) pcoul1.add(new Jabel(),cc1);
		    if(i==8&&j==7) pcoul1.add(new Jabel(),cc1);
		    if(i==8&&j==13) pcoul1.add(new Jabel(),cc1); 
		}
		if(this.grilleC1[i][j]=='k'){
		    cc1.fill=GridBagConstraints.NONE;
		    pcoul1.add(new JLabel(girlh.front),cc1);
			cc1.fill=GridBagConstraints.NONE;
		}
		if(this.grilleC1[i][j]=='J') {
		    cc1.fill=GridBagConstraints.NONE;
		    pcoul1.add(new JLabel(this.self.front),cc1);
		    cc1.fill=GridBagConstraints.BOTH;
		     // lignes
		}

	    }
	}
	cc1.gridx=0;      //il faudrait revoir les commandes pour qu'il 
	cc1.gridy=10;      // tout l'espace restant
	cc1.gridwidth=16;  // lignes
	cc1.weightx=0.0f;
	cc1.weighty=0.0f;
	cc1.fill=GridBagConstraints.VERTICAL;
        if(this.chap.equals("intro"))
	    dialogueC1= new JLabel("Mission: "+mission);
	if(this.chap.equals("chap3"))
	    dialogueC1= new JLabel("zone de texte couloir 1, le personnage est "+this.nom+" et le chap 3 n'est pas encore imaginé");
	dialogueC1.setMinimumSize(new Dimension(800,99));
	pcoul1.add(dialogueC1,c1);
	cards.add(couloir1,pcoul1);

	/* - - - - - - - - - appart Myriam - - - - - - - - - - - 
	
	GridBagConstraints cAM= new GridBagConstraints();
	pappartMyriam.setLayout(new GridBagLayout());
	
	cAM.gridx=0;
	cAM.gridy=0; /* - - - - - - - - - - - - - - - -l1- - - -
	cAM.gridwidth=1;  //colonnes
	cAM.gridheight=1;  // lignes
	cAM.fill=GridBagConstraints.BOTH;
	cAM.ipady = c3.anchor = GridBagConstraints.CENTER;
	cAM.insets=new Insets(0,0,0,0);
	cAM.weightx=1.0f;
	cAM.weighty=1.0f;
	
	for(int j=0; j<10; j++){
	    for(int i=0; i<16; i++){
		cAM.gridx=i;
		cAM.gridy=j;
		if(this.grilleAM[i][j]=='%') pappartMyriam.add(new JLabel(vide),cAM);
		if(this.grilleAM[i][j]=='M') pappartMyriam.add(new Jabel(),cAM);
		if(this.grilleAM[i][j]=='S') pappartMyriam.add(new Jabel(),cAM);
		if(this.grilleAM[i][j]=='E') pappartMyriam.add(new Jabel(),cAM);

		if(this.grilleAM[i][j]=='J') {
		    pappartMyriam.add(new JLabel(this.self.front),cAM);
		}
		//if(this.grille3[i][j]=='i') psalle3.add(new JLabel(girla.front),c3);
	    }
	}
	cAM.gridx=0;      //il faudrait revoir les commandes pour qu'il 
	cAM.gridy=10;      // tout l'espace restant
	cAM.gridwidth=16;  // lignes
	cAM.weightx=0.0f;
	cAM.weighty=0.0f;
	cAM.fill=GridBagConstraints.VERTICAL;
        if(this.chap.equals("intro")){
	    dialogue3= new JLabel("Mission: "+mission);
	    if(this.nom.equals("Myriam"))
		dialogueAM= new JLabel("<HTML>Argh, j'ai encore dormis pendant le cours au lieu de faire le devoir à rendre cet après-midi!<br>Je vais devoir fouiller dans les affaires des autres.<br>C'est chiant mais c'est mon seul espoir maintenant...<br>La nana populaire de la s-4 laisse souvent en traîner d'ailleurs.</HTML>");
	}
	if(this.chap.equals("chap3"))
	    dialogueAM= new JLabel("zone de texte salle 3, le personnage est "+this.nom+" et le chap 3 n'est pas encore imaginé");
	dialogueAM.setMinimumSize(new Dimension(800,99));
	pappartMyriam.add(dialogueAM,cAM);
	cards.add(appartMyriam,pappartMyriam);




	/* affichage première salle*/
	this.add(cards);
	

	if(salleP.equals(salle1))
	    ((CardLayout) cards.getLayout()).show(cards,salle1);
	if(salleP.equals(salle2))
	    ((CardLayout) cards.getLayout()).show(cards,salle2);
	if(salleP.equals(salle3))
	    ((CardLayout) cards.getLayout()).show(cards,salle3);
	if(salleP.equals(salle4))
	    ((CardLayout) cards.getLayout()).show(cards,salle4);
	
	if(salleP.equals(couloir1))
	    ((CardLayout) cards.getLayout()).show(cards,couloir1);
	
	//if(salleP.equals(appartMyriam))
	   // ((CardLayout) cards.getLayout()).show(cards,appartMyriam);
	
	this.setVisible(true);
    }
    public void updateGrille(String salle, char[][] tab, char direction){
	this.dir=direction;
	//System.out.println("salle = "+salle);
	if(salle.equals("Salle1")){
	    this.grille1=tab;
	    this.redraw(this.salle1, this.grille1, this.psalle1, dialogue1,null);  // voir ecranaccueil
	}
	if(salle.equals("Salle2")) {
	    this.grille2=tab;
	    this.redraw(this.salle2, this.grille2, this.psalle2, dialogue2,null);
	}
	if(salle.equals("Salle3")) {
	    this.grille3=tab;
	    this.redraw(this.salle3,this.grille3, this.psalle3, dialogue3,null);
	}
	if(salle.equals("Salle4")) {
	    this.grille4=tab;
	    this.redraw(this.salle4, this.grille4, this.psalle4, dialogue4,null);
	}
	if(salle.equals("Couloir1")) {
	    this.grilleC1=tab;
	    this.redraw(this.couloir1,this.grilleC1, this.pcoul1, dialogueC1,null);
	
	}
	/*if(salle.equals("AppartMyriam")) {
	    this.grilleAM=tab;
	    this.redraw(this.appartMyriam, this.grilleAM, this.pappartMyriam, dialogueAM,null);
	}*/
    }
    public Joueur getJoueur(){
	return this.self;
    }
    public String getSalleActuelle(){
	return this.salleActuelle;
    }
    public void setSalleActuelle(String s){
	this.salleActuelle=s;
    }

    public char[][] getGrilleActuelle(){
	if (salleActuelle.equals(this.salle1)) return this.grille1;
	if (salleActuelle.equals(this.salle2)) return this.grille2;
	if (salleActuelle.equals(this.salle3)) return this.grille3;
	if (salleActuelle.equals(this.salle4)) return this.grille4;
	if (salleActuelle.equals(this.couloir1)) return this.grilleC1;
	//if (salleActuelle.equals(this.appartMyriam)) return this.grilleAM;
	return null;
    }






    
    private void redraw(String salle, char[][] grille, FondSalle fs,JLabel d,JLabel diag){
	fs=new FondSalle(salle);
	GridBagConstraints cc1= new GridBagConstraints();
	fs.setLayout(new GridBagLayout());
	//System.out.println("Salle travaillée="+salle);
	cc1.gridx=0;
	cc1.gridy=0; /* - - - - - - - - - - - - - - - -l1- - - -*/
	cc1.gridwidth=1;  //colonnes
	cc1.gridheight=1;  // lignes
	cc1.fill=GridBagConstraints.BOTH;
	cc1.ipady = cc1.anchor = GridBagConstraints.CENTER;
	cc1.insets=new Insets(0,0,0,0);
	cc1.weightx=1.0f;
	cc1.weighty=1.0f;
	cc1.fill=GridBagConstraints.NONE;
	
	for(int j=0; j<10; j++){
	    for(int i=0; i<16; i++){
		cc1.gridx=i;
		cc1.gridy=j;
		if(grille[i][j]=='%') fs.add(new JLabel(vide),cc1);
		if(grille[i][j]=='M') fs.add(new Jabel(),cc1);
		if(grille[i][j]=='S') fs.add(new Jabel(),cc1);
		if(grille[i][j]=='E') fs.add(new Jabel(),cc1);
		if(grille[i][j]=='t') fs.add(new JLabel(bureau),cc1);
		if(grille[i][j]=='u') fs.add(new JLabel(bureauP),cc1);
		if(grille[i][j]=='a') fs.add(new JLabel(bDF),cc1);
		if(grille[i][j]=='b') fs.add(new JLabel(bDFP),cc1);
		if(grille[i][j]=='e') fs.add(new JLabel(bP),cc1);
		if(grille[i][j]=='f') fs.add(new JLabel(bPP),cc1);
		if(grille[i][j]=='c') fs.add(new JLabel(bDM),cc1);
		if(grille[i][j]=='d') fs.add(new JLabel(bDMP),cc1);
		if(grille[i][j]=='g') fs.add(new JLabel(bR),cc1);
		if(grille[i][j]=='h') fs.add(new JLabel(bRP),cc1);
        
		if(grille[i][j]=='J') {
		    char dir=this.ctlr.getDirection();
		    if(dir=='B') fs.add(new JLabel(this.self.front),cc1);
		    if(dir=='H') fs.add(new JLabel(this.self.back),cc1);
		    if(dir=='G') fs.add(new JLabel(this.self.left),cc1);
		    if(dir=='D') fs.add(new JLabel(this.self.right),cc1);
		    // lignes
		}
		if(grille[i][j]=='i') fs.add(new JLabel(girla.front),cc1);
		if(grille[i][j]=='j') fs.add(new JLabel(girll.front),cc1);
		if(grille[i][j]=='k'){  //faire des if comme pour j mais pour B draw back  ==> face a face
		    fs.add(new JLabel(this.girlh.front),cc1);
		}

	    }
	}
	cc1.gridx=0;      //il faudrait revoir les commandes pour qu'il 
	cc1.gridy=10;      // tout l'espace restant
	cc1.gridwidth=16;  // lignes
	cc1.weightx=0.0f;
	cc1.weighty=0.0f;
	cc1.fill=GridBagConstraints.VERTICAL;
	d.setText("zone de texte "+salle+" et le personnage est "+this.nom+".");
	if(diag==null)
	    d.setText("Mission: "+mission);
        if(diag!=null)
	    d=diag;
	//dialogue.setMinimumSize(new Dimension(800,99));
	fs.add(d,cc1);
	//cards.add(couloir1,pcoul1);
	


	if(salle.equals("Salle1")) cards.add(salle1,fs);
	if(salle.equals("Salle2")) cards.add(salle2,fs);
	if(salle.equals("Salle3")) cards.add(salle3,fs);
	if(salle.equals("Salle4")) cards.add(salle4,fs);
	if(salle.equals("Couloir1")) cards.add(couloir1,fs);
	if(salle.equals("AppartMyriam")) cards.add(appartMyriam,fs);

	if(salle.equals(salle1)) ((CardLayout) cards.getLayout()).show(cards,salle1);
	if(salle.equals(salle2)) ((CardLayout) cards.getLayout()).show(cards,salle2);
	if(salle.equals(salle3)) ((CardLayout) cards.getLayout()).show(cards,salle3);
	if(salle.equals(salle4)) ((CardLayout) cards.getLayout()).show(cards,salle4);
	if(salle.equals(couloir1)) ((CardLayout) cards.getLayout()).show(cards,couloir1);
	if(salle.equals(appartMyriam)) ((CardLayout) cards.getLayout()).show(cards,appartMyriam);
    }



    public char[][] getGrille1(){
	return this.grille1;
    }
    public char[][] getGrille2(){
	return this.grille2;
    }
    public char[][] getGrille3(){
	return this.grille3;
    }
    public char[][] getGrille4(){
	return this.grille4;
    }
    public char[][] getGrilleC1(){
	return this.grilleC1;
    }
    public char[][] getGrilleAM(){
	return this.grilleAM;
    }

    public void setGrille1(char[][] g){
	this.grille1=g;
    }
    public void setGrille2(char[][] g){
	this.grille2=g;
    }
    public void setGrille3(char[][] g){
	this.grille3=g;
    }

    public void setGrille4(char[][] g){
	this.grille4=g;
    }
    public void setGrilleC1(char[][] g){
	this.grilleC1=g;
    }
    public void setGrilleAM(char[][] g){
	this.grilleAM=g;
    }
    public void updatePosJ(int x, int y){
	this.self.x=x;
	this.self.y=y;
    }
    public String getChap(){
	return this.chap;
    }

    public void redrawTxt(String txt, String salle){
        JLabel texte=new JLabel(txt);
	texte.setMinimumSize(new Dimension(800,99));
	//System.out.println("salle = "+salle);
	if(salle.equals("Salle1")){
	    this.redraw(this.salle1, this.grille1, this.psalle1, dialogue1,texte);
	}
	if(salle.equals("Salle2")) {
	    this.redraw(this.salle2, this.grille2, this.psalle2, dialogue2,texte);
	}
	if(salle.equals("Salle3")) {
	    this.redraw(this.salle3,this.grille3, this.psalle3, dialogue3,texte);
	}
	if(salle.equals("Salle4")) {
	    this.redraw(this.salle4, this.grille4, this.psalle4, dialogue4,texte);
	    //System.out.println("Lancement texte");
	}
	if(salle.equals("Couloir1")) {
	    this.redraw(this.couloir1,this.grilleC1, this.pcoul1, dialogueC1,texte);
	
	}
	if(salle.equals("AppartMyriam")) {
	    this.redraw(this.appartMyriam,this.grilleAM, this.pappartMyriam, dialogueAM,texte);
	
	}
    }
}
