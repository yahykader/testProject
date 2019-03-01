import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.util.*;
import java.io.*;
import java.lang.Thread;
import java.applet.*;





public class interfaceP extends JFrame implements ActionListener,Runnable
{
	parking p=new parking();;
	JPanel p2=new JPanel();
	JButton Entrer=new JButton("Entrer");
    JButton Sortir=new JButton("Sortir");
	boolean test=false;
	 String col,vit;
	 int prix;
	TextField       nbreVoiture;
   ButtonGroup  gniveau1 = new  ButtonGroup();
   ButtonGroup  gniveau2 = new  ButtonGroup();
  
   Choice c2=new Choice();
   Choice c=new Choice();
   
   String sms;    
   JRadioButton  niveau3 = new JRadioButton ("Gauche");
         
        JRadioButton   niveau4 = new JRadioButton ("Droite");
        

 JRadioButton   niveau1 = new JRadioButton ("HAUT");
        
        JRadioButton   niveau2 = new JRadioButton ("BAS");
      
	Thread simul=null;
	public interfaceP ()
	{
		
		super("Simulation de la gestion d'un parking");
		
		
		JPanel panneau2=new JPanel(); panneau2.setBackground(Color.pink);        
		panneau2.setLayout(new GridLayout(3,10));         
   	JPanel panneau1=new JPanel(); panneau1.setBackground(Color.pink);        
		panneau1.setLayout(new GridLayout(2,3));         
    JLabel titre2=new JLabel(" * CHOIX DU BLOC *");
              titre2.setForeground(Color.blue); panneau2.add(titre2);
              
              for(int i=1;i<p.a;i++)
	          c.addItem(""+i);
	       
     
       niveau1.setForeground(Color.white); 
       niveau2.setForeground(Color.white);
       gniveau1.add(niveau1);
       gniveau1.add(niveau2);
       niveau1.setSelected(true); 
       panneau2.add(niveau1);
       panneau2.add(niveau2);
       panneau2.add(c);
       
  
  
  
    JLabel titre3=new JLabel(" * CHOIX DU GARAGE *");
              titre3.setForeground(Color.blue); panneau2.add(titre3);
              
                for(int i=1;i<p.c;i++)
	          c2.addItem(""+i);
  
     
               niveau3.setForeground(Color.white); 
                niveau4.setForeground(Color.white);
      
      gniveau2.add(niveau3);
      gniveau2.add(niveau4);
       niveau3.setSelected(true); 
       panneau2.add(niveau3);
       panneau2.add(niveau4);
        panneau2.add(c2);
  
       Sortir.addActionListener(this);
       Entrer.addActionListener(this);
             
  
    JLabel titre2_1=new JLabel("Nombre de Voiture");
        titre2_1.setForeground(Color.black);
        panneau2.add(Entrer);
        panneau2.add(Sortir);
        panneau2.add(titre2_1);
    nbreVoiture=new TextField("000");
         nbreVoiture.setForeground(Color.white);
         nbreVoiture.setBackground(Color.black);
           panneau2.add(nbreVoiture);
         nbreVoiture.setEditable(false);nbreVoiture.setForeground(Color.white);
         
         //panneau2.add(panneau1);
  		//getContentPane().setLayout(new GridLayout(2,2));
		getContentPane().add(panneau2,BorderLayout.SOUTH);
	//	getContentPane().add(panneau1,BorderLayout.SOUTH);
        //getContentPane().add(p,BorderLayout.NORTH);
             setResizable(true);
       getContentPane().add(p); 
        
	       setBounds(0,0,900,690); 
		setVisible(true); 
		
			
    		 }
	
 
  
  /*	public void init()
 {
 simul=new Thread(this);
 simul.start();
		
  
		
}
 
 public void start()
 {if (simul==null)
  {   simul.start();
      simul.run();
  }
 }*/
  public void run()
 {
     
  while(true)
	{	
  
  	
  	try{
  	(Thread.currentThread()).sleep(500);	//simul.sleep(1000);
  
  }catch(InterruptedException e){}
 p.repaint();
}

	
  }
  
  
  
  
	
 
 public void actionPerformed(ActionEvent e)
   {
         int blc,grg;
         
         blc=Integer.parseInt(String.valueOf(c.getSelectedItem()))-1;
         grg=Integer.parseInt(String.valueOf(c2.getSelectedItem()))-1;
         String[] options = {"ok","annuler"};

JLabel     taillelabel=new JLabel("Choix");
//JToolBar men=new JToolBar("taille de la matrice");
JComboBox tailleMat= new 	JComboBox();

tailleMat.addItem("0");
tailleMat.addItem("1");
tailleMat.addItem("2");

JPanel panel1=new JPanel();

panel1.add(taillelabel);
panel1.add(tailleMat);


    if (e.getSource() == Entrer)//entrer la voiture
    
    {
    	test=false;
    	

    	//--------------------------------
    	if (niveau1.isSelected()) 
     {
      
      if (niveau4.isSelected()) 
     {
     
      if (p.bloch[blc].occdroite[grg]!=0) test=true;
     }
      else if (niveau3.isSelected()) 
     {
     
      if (p.bloch[blc].occgauche[grg]!=0) test=true;
     }
      
     System.out.println("haut"+p.bloch[blc].occdroite[grg] +" "+ p.bloch[blc].occgauche[grg]); 
      }
    	
    	//-----------------------------
    else if (niveau2.isSelected()) 
     {
      
      if (niveau4.isSelected()) 
     {
     
      if (p.blocb[blc].occdroite[grg]!=0) test=true;
     }
     else if (niveau3.isSelected()) 
     {
     
      if (p.blocb[blc].occgauche[grg]!=0) test=true;
     }
      
      
      }
    	
    	
    
       if (test==false) 
     {
     	 
     	 if(JOptionPane.showOptionDialog(this,panel1,"Entrer la couleur",
		   JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                   null, options,options[0])==0)
    col=(String.valueOf(tailleMat.getSelectedItem()));
    
       vit=JOptionPane.showInputDialog(null,"Entrer la vitesse","Saisie de la vitesse",JOptionPane.INFORMATION_MESSAGE);
 
       p.nbrvoiture=p.nbrvoiture+1;
         p.voitures[p.nbrvoiture-1]=new voiture(9,p.y2-65,0,Integer.parseInt(String.valueOf(vit)),Integer.parseInt(String.valueOf(col)));
      //p.voitures[p.nbrvoiture-1].positionx=5;
      //p.voitures[p.nbrvoiture-1].positionx=p.y2-5;
     p.voitures[p.nbrvoiture-1].indetat=0;
     p.voitures[p.nbrvoiture-1].tabetats[0]=1;
     p.voitures[p.nbrvoiture-1].tabetats[1]=3;
     p.voitures[p.nbrvoiture-1].indetat=0;	
     p.voitures[p.nbrvoiture-1].tabmax[0]=p.y2/2;
     
     if (niveau1.isSelected()) 
     {
     p.voitures[p.nbrvoiture-1].tabetats[2]=1;	
     p.voitures[p.nbrvoiture-1].tabmax[1]=p.bloch[blc].entrer;
     
     if (niveau4.isSelected())  
     {
     p.voitures[p.nbrvoiture-1].tabetats[3]=3;	
     p.voitures[p.nbrvoiture-1].tabmax[2]=p.bloch[blc].ligdroite[grg];
     p.voitures[p.nbrvoiture-1].tabmax[3]=p.bloch[blc].coldroite[grg]-60;
     System.out.println("haut"+blc+" grg"+grg+" " +p.bloch[blc].occdroite[grg] +" "+ p.bloch[blc].occgauche[grg]);      
     p.bloch[blc].occdroite[grg]=p.nbrvoiture;
     System.out.println("haut"+blc+" grg"+grg+" " +p.bloch[blc].occdroite[grg] +" "+ p.bloch[blc].occgauche[grg]);      
     }	
     
     else if (niveau3.isSelected()) 
     {
     p.voitures[p.nbrvoiture-1].tabetats[3]=4;	
     p.voitures[p.nbrvoiture-1].tabmax[2]=p.bloch[blc].liggauche[grg];
     p.voitures[p.nbrvoiture-1].tabmax[3]=p.bloch[blc].colgauche[grg];
     System.out.println("haut"+blc+" grg"+grg+" " +p.bloch[blc].occdroite[grg] +" "+ p.bloch[blc].occgauche[grg]);      
     p.bloch[blc].occgauche[grg]=p.nbrvoiture;
     System.out.println("haut"+blc+" grg"+grg+" " +p.bloch[blc].occdroite[grg] +" "+ p.bloch[blc].occgauche[grg]);      
     }
     
              
     }
     else if (niveau2.isSelected())
     {
     p.voitures[p.nbrvoiture-1].tabetats[2]=2;	
     p.voitures[p.nbrvoiture-1].tabmax[1]=p.blocb[blc].entrer;
     
     
     if (niveau4.isSelected())  
     {
     p.voitures[p.nbrvoiture-1].tabetats[3]=3;	
     p.voitures[p.nbrvoiture-1].tabmax[2]=p.blocb[blc].ligdroite[grg]-20;
     p.voitures[p.nbrvoiture-1].tabmax[3]=p.blocb[blc].coldroite[grg]-60;
     p.blocb[blc].occdroite[grg]=p.nbrvoiture;
     }	
     
     else if (niveau3.isSelected()) 
     {
     p.voitures[p.nbrvoiture-1].tabetats[3]=4;	
     p.voitures[p.nbrvoiture-1].tabmax[2]=p.blocb[blc].liggauche[grg]-20;
     p.voitures[p.nbrvoiture-1].tabmax[3]=p.blocb[blc].colgauche[grg];
     p.blocb[blc].occgauche[grg]=p.nbrvoiture;     
     }
     
     }
     p.voitures[p.nbrvoiture-1].tabetats[4]=7;
     p.voitures[p.nbrvoiture-1].tabmax[4]=0;
         
   nbreVoiture.setText(String.valueOf(p.nbrvoiture));  	
     
     
       } else JOptionPane.showMessageDialog(new JFrame(),"<HTML><BODY>Auteur : NUELO<BR><I>Ce garage est occupé</I></BODY></HTML>");
     }  
     
     
     //sortir la voiture
    if (e.getSource()==Sortir)
    {
    	
    test=false;	
    
  
      
    	//--------------------------------
    	if (niveau1.isSelected()) 
     {
      
      if (niveau4.isSelected()) 
     {
     
      if (p.bloch[blc].occdroite[grg]==0) test=true;
     }
      else if (niveau3.isSelected()) 
     {
     
      if (p.bloch[blc].occgauche[grg]==0) test=true;
     }
      
      System.out.println(""+p.bloch[blc].occdroite[grg] +" "+ p.bloch[blc].occgauche[grg]); 
      }
    	
    	//-----------------------------
    else if (niveau2.isSelected()) 
     {
      
      if (niveau4.isSelected()) 
     {
     
      if (p.blocb[blc].occdroite[grg]==0) test=true;
     }
     else if (niveau3.isSelected()) 
     {
     
      if (p.blocb[blc].occgauche[grg]==0) test=true;
     }
      
      
      }
    	
    	
    
       if (test==false) 
     {
      
           
      
      prix=Integer.parseInt(String.valueOf(JOptionPane.showInputDialog(null,"Entrer le montant par seconde","Saisie du montant",JOptionPane.INFORMATION_MESSAGE)));   
    
     if (niveau1.isSelected()) 
     {
        
        
    
        
     if (niveau4.isSelected())  
     {
     	
     p.voitures[p.bloch[blc].occdroite[grg]-1].indetat=0;	
         p.voitures[p.bloch[blc].occdroite[grg]-1].tabmax[2]=p.x2-10;
      p.voitures[p.bloch[blc].occdroite[grg]-1].tabmax[3]=p.y1;
   
      p.voitures[p.bloch[blc].occdroite[grg]-1].tabetats[2]=3;
      p.voitures[p.bloch[blc].occdroite[grg]-1].tabetats[3]=1;
	
     	
     p.voitures[p.bloch[blc].occdroite[grg]-1].tabetats[0]=5;
     p.voitures[p.bloch[blc].occdroite[grg]-1].tabetats[1]=2;
      
     p.voitures[p.bloch[blc].occdroite[grg]-1].tabmax[0]=p.bloch[blc].entrer;
     p.voitures[p.bloch[blc].occdroite[grg]-1].tabmax[1]=p.y2/2;
     sms="<HTML><BODY>Auteur : NUELO<BR><I>Cette voiture a mis "+String.valueOf(p.voitures[p.bloch[blc].occdroite[grg]-1].temps/2)+"s et va payer "+String.valueOf(p.voitures[p.bloch[blc].occdroite[grg]-1].temps*prix/2)+"Fcfa </I></BODY></HTML>";
    
    JOptionPane.showMessageDialog(new JFrame(),sms+' '+p.bloch[blc].entrer);
     	
     p.bloch[blc].occdroite[grg]=0;
     }	
     
     else if (niveau3.isSelected()) 
     {
     	
     p.voitures[p.bloch[blc].occgauche[grg]-1].indetat=0;	
         p.voitures[p.bloch[blc].occgauche[grg]-1].tabmax[2]=p.x2-10;
      p.voitures[p.bloch[blc].occgauche[grg]-1].tabmax[3]=p.y1;
   
      p.voitures[p.bloch[blc].occgauche[grg]-1].tabetats[2]=3;
      p.voitures[p.bloch[blc].occgauche[grg]-1].tabetats[3]=1;
	
     	
     	
     p.voitures[p.bloch[blc].occgauche[grg]-1].tabetats[0]=6;
     p.voitures[p.bloch[blc].occgauche[grg]-1].tabetats[1]=2;
      
     p.voitures[p.bloch[blc].occgauche[grg]-1].tabmax[0]=p.bloch[blc].entrer-20;
     p.voitures[p.bloch[blc].occgauche[grg]-1].tabmax[1]=p.y2/2;
     
     JOptionPane.showMessageDialog(new JFrame(),"<HTML><BODY>Auteur : NUELO<BR><I>Cette voiture a mis "+String.valueOf(p.voitures[p.bloch[blc].occgauche[grg]-1].temps/2)+"s et va payer "+String.valueOf(p.voitures[p.bloch[blc].occgauche[grg]-1].temps*prix/2)+"Fcfa</I></BODY></HTML>");
     
      p.bloch[blc].occgauche[grg]=0;
          
     }
     
              
     }
     else if (niveau2.isSelected())
     {
     
     
     if (niveau4.isSelected())  
     {
    
     p.voitures[p.blocb[blc].occdroite[grg]-1].indetat=0;	
         p.voitures[p.blocb[blc].occdroite[grg]-1].tabmax[2]=p.x2-10;
      p.voitures[p.blocb[blc].occdroite[grg]-1].tabmax[3]=p.y1;
   
      p.voitures[p.blocb[blc].occdroite[grg]-1].tabetats[2]=3;
      p.voitures[p.blocb[blc].occdroite[grg]-1].tabetats[3]=1;
	
     	
     p.voitures[p.blocb[blc].occdroite[grg]-1].tabetats[0]=5;
     p.voitures[p.blocb[blc].occdroite[grg]-1].tabetats[1]=1;
      
     p.voitures[p.blocb[blc].occdroite[grg]-1].tabmax[0]=p.blocb[blc].entrer+20;
     p.voitures[p.blocb[blc].occdroite[grg]-1].tabmax[1]=p.y2/2;
    JOptionPane.showMessageDialog(new JFrame()," <HTML><BODY>Auteur : NUELO<BR><I>Cette voiture a mis "+String.valueOf(p.voitures[p.blocb[blc].occdroite[grg]-1].temps/2)+"s et va payer "+String.valueOf(p.voitures[p.blocb[blc].occdroite[grg]-1].temps*prix/2)+"Fcfa</I></BODY></HTML>");
    
    
    
        p.blocb[blc].occdroite[grg]=0;
     }	
     
     else if (niveau3.isSelected()) 
     {
    
     p.voitures[p.blocb[blc].occgauche[grg]-1].indetat=0;	
         p.voitures[p.blocb[blc].occgauche[grg]-1].tabmax[2]=p.x2-10;
      p.voitures[p.blocb[blc].occgauche[grg]-1].tabmax[3]=p.y1;
   
      p.voitures[p.blocb[blc].occgauche[grg]-1].tabetats[2]=3;
      p.voitures[p.blocb[blc].occgauche[grg]-1].tabetats[3]=1;
	
     	
     	
     p.voitures[p.blocb[blc].occgauche[grg]-1].tabetats[0]=6;
     p.voitures[p.blocb[blc].occgauche[grg]-1].tabetats[1]=1;
      
     p.voitures[p.blocb[blc].occgauche[grg]-1].tabmax[0]=p.blocb[blc].entrer-20;
     p.voitures[p.blocb[blc].occgauche[grg]-1].tabmax[1]=p.y2/2;
    
     JOptionPane.showMessageDialog(new JFrame(),"<HTML><BODY>Auteur : NUELO<BR><I>Cette voiture a mis "+String.valueOf(p.voitures[p.blocb[blc].occgauche[grg]-1].temps/2)+"s et va payer "+String.valueOf(p.voitures[p.blocb[blc].occgauche[grg]-1].temps*prix/2)+"Fcfa</I></BODY></HTML>");
    
     p.blocb[blc].occgauche[grg]=0;     
     }
     
     }
     //p.voitures[p.nbrvoiture-1].tabetats[4]=7;
     //p.voitures[p.nbrvoiture-1].tabmax[4]=0;
     p.nbrvoiture=p.nbrvoiture-1;    
   nbreVoiture.setText(String.valueOf(p.nbrvoiture));  	
     
     
       } else JOptionPane.showMessageDialog(new JFrame(),"<HTML><BODY>Auteur : NUELO<BR><I>Ce garage est vide</I></BODY></HTML>");
   
    
    }
  }
  
 
 
 static public void main (String arg[])
    {
    	
    	 
   
	 interfaceP v=new interfaceP();
	 Thread t= new Thread(v);

	 t.start();
	 
	 	 
    }
  }