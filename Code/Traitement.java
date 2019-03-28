
import javax.swing.JProgressBar;
    
class Traitement implements Runnable{
    private JProgressBar barre;
    private Thread t;
    private Partie partie;

    public Traitement(JProgressBar b, Thread th, Partie p){
	this.barre=b;
	this.t=th;
	this.partie=p;
    }
    public void run(){
	for(int val = 0; val <= 300; val=val+10){
	    barre.setValue(val);
	    try {
		t.sleep(200);
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	}
	//System.out.println("fin de temps");
	this.partie.fermerFenetre();
    }   
}
