import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;


public class parking extends JPanel //implements ActionListener 
{
     JPanel panel1=new JPanel();
      JPanel panel2=new JPanel();
	 JTextField texte1=new JTextField("panel1");
	 JTextField texte2=new JTextField("panel2");
	 bloc bloch[];//tableau des blocs du haut
	 bloc blocb[];//tableau des blocs du bas
	 
	 int nbrvoiture=0;
		   // Graphics  Gmem;

		 
	 int entrer,sortie,blt;
	 static Image porteEntree[]=new Image[4], porteSortie[]=new Image[4],VoitureEntrer[]=new Image[4],VoitureMonter[]=new Image[4],VoitureSortir[]=new Image[4],VoitureDescendre[]=new Image[4];
	public int x1,x2,y1,y2,ecart,ecRoute,nbrvoituremax;
      voiture voitures[]; 
	  int a,b,c,d,e,f,te;
	  int largeur,esp,bar,ctbloc,ctgarage;   
	  private Toolkit tk;
	  
	   int width;
	int height    ;
        
	 
	 
	public parking()
	{
		
		//super("Simulation de la gestion d'un parking");
		/*getContentPane().setLayout(new GridLayout(10,2));
		panel1.add(texte1);
		panel2.add(texte2);
		getContentPane().add(panel1);
		getContentPane().add(panel2);*/
		
		
	 	//
	
   
	initglobal();		
		
			
		
		
	}
	
	

		
	public void initglobal()
  { 
  
    y1=0;
    x1=0;
    y2=500;
    x2=900;
    ecart=50;
	ecRoute=40;
	a=5;b=5;c=6;d=7;
	entrer=0;sortie=0; 
    te=0;
	
  
  
  tk=getToolkit();
	bloch=new bloc[a];
    blocb=new bloc[a];
    
        largeur=(x2-x1)/a;
        esp=(y2/2-ecRoute-y1)/d;
       
	
		for(int j=0;j<3;j++)
   {
   	
   	porteEntree[j] = tk.getImage("img/parkingentree"+j+".gif");
   	VoitureEntrer[j]=tk.getImage("img/voiturealler"+j+".gif"); 
    VoitureSortir[j]=tk.getImage("img/voitureretour"+j+".gif");
    VoitureDescendre[j]=tk.getImage("img/voituredescente"+j+".gif"); 
    VoitureMonter[j]=tk.getImage("img/voituremonter"+j+".gif"); 
    porteSortie[j] = tk.getImage("img/parkingsortie"+j+".gif");
  }
    
    ctbloc=0;//pour compter les blocs
        for (int i=ecart+10;i<x2-ecart;i=i+largeur) 
        {
              bloch[ctbloc]=new bloc(c);
              blocb[ctbloc]=new bloc(c);
            
            bloch[ctbloc].nmaxvoiture=2*(c-1);
            blocb[ctbloc].nmaxvoiture=2*(c-1);
            
            
            //on calcule le centre de l'entrer de chaque blocs
            bloch[ctbloc].entrer=i+largeur/2;
            blocb[ctbloc].entrer=i+largeur/2;
                       
            //on enregistre le nom de chaque blocs
            ctbloc++;
            bloch[ctbloc-1].nom="bloc H"+ctbloc;
            blocb[ctbloc-1].nom="bloc B"+ctbloc;
            	}
        blt=ctbloc;	
        nbrvoituremax=2*ctbloc*2*(c-1);
        voitures=new voiture[nbrvoituremax];
        ctbloc=0;
        ctgarage=0;//compte le nombre de garage d'un coté d'un bloc	
        bar=largeur/b;
        
        esp=(y2/2-ecRoute-y1)/d;
        //dessin de tous les garages du parking
        	 for (int i=ecart+10;i<x2-(ecart+largeur);i=i+largeur) 
        {
            ctgarage=0;
             for (int j=y1;j<y1+esp*c;j=j+esp) 
           {
            
 	          //enregistrement des coordonnées des garages des blocs du haut
 	        bloch[ctbloc].liggauche[ctgarage]=j+esp/2;
 	        bloch[ctbloc].colgauche[ctgarage]=i+5;
 	        bloch[ctbloc].ligdroite[ctgarage]=j+esp/2;
 	        bloch[ctbloc].coldroite[ctgarage]=i+largeur-15;
 	        /*if (j<y1+esp*c-esp)
            {
           
 	        Gmem.drawString("g"+(ctgarage+1),(bloch[ctbloc].colgauche[ctgarage]),(bloch[ctbloc].liggauche[ctgarage]));
            Gmem.drawString("d"+(ctgarage+1),(bloch[ctbloc].coldroite[ctgarage]),(bloch[ctbloc].ligdroite[ctgarage]));
            } */       
 	        ctgarage++;
                     
        	}
        	
        	ctgarage=0;
        	  for (int j=y2;j>y2-esp*c;j=j-esp) 
           {
            
 	        //enregistrement des coordonnées des garages des blocs du bas
            blocb[ctbloc].liggauche[ctgarage]=j-esp/2;
 	        blocb[ctbloc].colgauche[ctgarage]=i+5;
 	        blocb[ctbloc].ligdroite[ctgarage]=j-esp/2;
 	        blocb[ctbloc].coldroite[ctgarage]=i+largeur-15;
 	       /* if (ctgarage<c-1)
            {
           
 	        Gmem.drawString("g"+(ctgarage+1),(blocb[ctbloc].colgauche[ctgarage]),(blocb[ctbloc].liggauche[ctgarage]));
            Gmem.drawString("d"+(ctgarage+1),(blocb[ctbloc].coldroite[ctgarage]),(blocb[ctbloc].ligdroite[ctgarage]));
            }
 	        */
 	        ctgarage++;
            
                     
        	}
        	
              ctbloc++;       
        	}    	
    
   		    	    
        
  
   
  }
  
 
  
  public void paint(Graphics Gmem){
    //super.paintComponents(Gmem);
         largeur=(x2-x1)/a;
        Gmem.setColor(Color.blue);
        Gmem.fillRect(x1,y1,x2,y2);
        Gmem.setColor(Color.black);
        Gmem.drawLine(ecart,y2/2-ecRoute,x2-ecart,y2/2-ecRoute);
        Gmem.drawLine(ecart,y2/2+ecRoute,x2-ecart,y2/2+ecRoute);
        Gmem.setColor(Color.green);  
        
              
        ctbloc=0;//pour compter les blocs
        for (int i=ecart+10;i<x2-ecart;i=i+largeur) 
        {
            
            Gmem.drawLine(i,x1,i,y2/2-ecRoute);
            Gmem.drawLine(i,y2/2+ecRoute,i,y2);
            ctbloc++;
            if (i<x2-ecart-largeur)
            {
            Gmem.drawString(bloch[ctbloc-1].nom,(bloch[ctbloc-1].entrer),(y2/2-ecRoute));
            Gmem.drawString(blocb[ctbloc-1].nom,(bloch[ctbloc-1].entrer),y2/2+ecRoute);
             }        
         
        	}
       

        bar=largeur/b;
       
        esp=(y2/2-ecRoute-y1)/d;
        //dessin de tous les garages du parking
        ctbloc=0;
        	 for (int i=ecart+10;i<x2-(ecart+largeur);i=i+largeur) 
        {
           	ctgarage=0;
           	
             for (int j=y1;j<y1+esp*c;j=j+esp) 
           {
            
 	        Gmem.drawLine(i,j,i+bar,j);
 	        Gmem.drawLine(i+largeur,j,i+largeur-bar,j);	
 	        
 	         
 	         if (j<y1+esp*c-esp)
            {
           
 	        Gmem.drawString("g"+(ctgarage+1),(bloch[ctbloc].colgauche[ctgarage]),(bloch[ctbloc].liggauche[ctgarage]));
            Gmem.drawString("d"+(ctgarage+1),(bloch[ctbloc].coldroite[ctgarage]),(bloch[ctbloc].ligdroite[ctgarage]));
            }        
 	        ctgarage++;
          
 	        
        	}
        	
        	ctgarage=0;
        	  for (int j=y2;j>y2-esp*c;j=j-esp) 
           {
            
 	        Gmem.drawLine(i,j,i+bar,j);
 	        Gmem.drawLine(i+largeur,j,i+largeur-bar,j);	   
 	        
             if (ctgarage<c-1)
            {
           
 	        Gmem.drawString("g"+(ctgarage+1),(blocb[ctbloc].colgauche[ctgarage]),(blocb[ctbloc].liggauche[ctgarage]));
            Gmem.drawString("d"+(ctgarage+1),(blocb[ctbloc].coldroite[ctgarage]),(blocb[ctbloc].ligdroite[ctgarage]));
            }
 	            
            ctgarage=ctgarage+1;         
        	}
        	
          ctbloc=ctbloc+1;
        	}
        	
        	
        /*Gmem.drawRect(60,0,180,130);
        Gmem.drawRect(200,0,300,130);
        Gmem.setColor(Color.green);
        Gmem.drawRect(301,0,480,130);
        Gmem.setColor(Color.green);
        Gmem.drawRect(481,0,600,130);*/
        
        
        //Gmem.fillRect(0,0,size().width,size().height);
        
 
 
	 
 
       
	 width = porteEntree[0].getWidth(null);
	height = porteEntree[0].getHeight(null); 
	
		
        
  Gmem.drawImage(porteEntree[0],ecart,y2/2-ecRoute,width,height+ecRoute,this);	
  
  
  
       
	width = porteSortie[sortie].getWidth(null);
	height = porteSortie[sortie].getHeight(null); 
   Gmem.drawImage(porteSortie[sortie],x2-ecart,y2/2-ecRoute,width,height+ecRoute,this);
   	
   
  
  
          	
        nbrvoituremax=2*ctbloc*2*(c-1);
        
        ctbloc=0;
        ctgarage=0;//compte le nombre de garage d'un coté d'un bloc	
        bar=largeur/b;
        
        esp=(y2/2-ecRoute-y1)/d;
        //dessin de tous les garages du parking
        	 for (int i=ecart+10;i<x2-(ecart+largeur);i=i+largeur) 
        {
            ctgarage=0;
             for (int j=y1;j<y1+esp*c;j=j+esp) 
           {
            
 	          //enregistrement des coordonnées des garages des blocs du haut
 	        bloch[ctbloc].liggauche[ctgarage]=j+esp/2;
 	        bloch[ctbloc].colgauche[ctgarage]=i+5;
 	        bloch[ctbloc].ligdroite[ctgarage]=j+esp/2;
 	        bloch[ctbloc].coldroite[ctgarage]=i+largeur-15;
 	        if (j<y1+esp*c-esp)
            {
           
 	        Gmem.drawString("g"+(ctgarage+1),(bloch[ctbloc].colgauche[ctgarage]),(bloch[ctbloc].liggauche[ctgarage]));
            Gmem.drawString("d"+(ctgarage+1),(bloch[ctbloc].coldroite[ctgarage]),(bloch[ctbloc].ligdroite[ctgarage]));
            }        
 	        ctgarage++;
                     
        	}
        	
        	ctgarage=0;
        	  for (int j=y2;j>y2-esp*c;j=j-esp) 
           {
            
 	        //enregistrement des coordonnées des garages des blocs du bas
            blocb[ctbloc].liggauche[ctgarage]=j-esp/2;
 	        blocb[ctbloc].colgauche[ctgarage]=i+5;
 	        blocb[ctbloc].ligdroite[ctgarage]=j-esp/2;
 	        blocb[ctbloc].coldroite[ctgarage]=i+largeur-15;
 	        if (ctgarage<c-1)
            {
           
 	        Gmem.drawString("g"+(ctgarage+1),(blocb[ctbloc].colgauche[ctgarage]),(blocb[ctbloc].liggauche[ctgarage]));
            Gmem.drawString("d"+(ctgarage+1),(blocb[ctbloc].coldroite[ctgarage]),(blocb[ctbloc].ligdroite[ctgarage]));
            }
 	        
 	        ctgarage++;
            
                     
        	}
        	
              ctbloc++;       
        	}
  	  for (int k=0;k<nbrvoiture;k++) 
           {
           
          if (voitures[k].indetat<5) 
          {
           switch(voitures[k].tabetats[voitures[k].indetat])
  	{
  	  case 1:     
	 width = VoitureMonter[voitures[k].color].getWidth(null);
	 height = VoitureMonter[voitures[k].color].getHeight(null); 
	 Gmem.drawImage(VoitureMonter[voitures[k].color],voitures[k].positionx,voitures[k].positiony,width,height+5,this);break;
  	
  	 case 2:  width = VoitureDescendre[voitures[k].color].getWidth(null);
	 height = VoitureDescendre[voitures[k].color].getHeight(null); 
 Gmem.drawImage(VoitureDescendre[voitures[k].color],voitures[k].positionx,voitures[k].positiony,width,height+5,this);break;
  	
  	  case 3:  width = VoitureEntrer[voitures[k].color].getWidth(null);
	 height = VoitureEntrer[voitures[k].color].getHeight(null); 
 Gmem.drawImage(VoitureEntrer[voitures[k].color],voitures[k].positionx,voitures[k].positiony,width,height+5,this);break;
  	  case 4:  width = VoitureSortir[voitures[k].color].getWidth(null);
	 height = VoitureSortir[voitures[k].color].getHeight(null); 
 Gmem.drawImage(VoitureSortir[voitures[k].color],voitures[k].positionx,voitures[k].positiony,width,height+5,this);break;
case 6:  width = VoitureSortir[voitures[k].color].getWidth(null);
	 height = VoitureSortir[voitures[k].color].getHeight(null); 
 Gmem.drawImage(VoitureSortir[voitures[k].color],voitures[k].positionx,voitures[k].positiony,width,height+5,this);break;
case 5:  width = VoitureEntrer[voitures[k].color].getWidth(null);
	 height = VoitureEntrer[voitures[k].color].getHeight(null); 
 Gmem.drawImage(VoitureEntrer[voitures[k].color],voitures[k].positionx,voitures[k].positiony,width,height+5,this);break;
      case 7: 
      if (voitures[k].tabetats[voitures[k].indetat-1]==4) 
      {        
       width = VoitureSortir[voitures[k].color].getWidth(null);
	   height = VoitureSortir[voitures[k].color].getHeight(null); 
       Gmem.drawImage(VoitureSortir[voitures[k].color],voitures[k].positionx,voitures[k].positiony,width,height+5,this);
       }
       else
       {
       	width = VoitureEntrer[voitures[k].color].getWidth(null);
	    height = VoitureEntrer[voitures[k].color].getHeight(null); 
        Gmem.drawImage(VoitureEntrer[voitures[k].color],voitures[k].positionx,voitures[k].positiony,width,height+5,this);
 
       	} break;    
      
     }   	
      
              
              
     voitures[k].deplacer(voitures[k].positionx,voitures[k].positiony,voitures[k].tabetats[voitures[k].indetat],voitures[k].tabmax[voitures[k].indetat]);            	     
        
         
         if ((voitures[k].tabetats[voitures[k].indetat])==3) 
     {
       if( (voitures[k].positionx<ecart+10))             	
       {
           entrer=2;  
	 width = porteEntree[2].getWidth(null);
	 height = porteEntree[2].getHeight(null); 
	
		
        
  Gmem.drawImage(porteEntree[2],ecart,y2/2-ecRoute,width,height+ecRoute,this);	
  
  
          }
          else {
          	  entrer=0; 
	 width = porteEntree[0].getWidth(null);
	 height = porteEntree[0].getHeight(null); 
	
		
        
  Gmem.drawImage(porteEntree[0],ecart,y2/2-ecRoute,width,height+ecRoute,this);	
  
  
          	
          	}
          	
          	if( (voitures[k].positionx<x2+50))             	
       {
           
           if((voitures[k].positionx>x2-150))
           {
           sortie=2;  
	 width = porteSortie[2].getWidth(null);
	 height = porteSortie[2].getHeight(null); 
	
		
        
  Gmem.drawImage(porteSortie[2],x2-ecart,y2/2-ecRoute,width,height+ecRoute,this);
  
           } 
           
          
          }
          
          	
          
        
          	
       }
       else {
          	  sortie=0; 
	 width = porteSortie[0].getWidth(null);
	 height = porteSortie[0].getHeight(null); 
 Gmem.drawImage(porteSortie[0],x2-ecart,y2/2-ecRoute,width,height+ecRoute,this); 
 
 entrer=0; 
	 width = porteEntree[0].getWidth(null);
	 height = porteEntree[0].getHeight(null); 
	
		
        
  Gmem.drawImage(porteEntree[0],ecart,y2/2-ecRoute,width,height+ecRoute,this);	
  
  
          	
          	}
       
      
    }

   }  
   
	//Gmem.drawImage(VoitureMonter[0],voitures[0].positionx,voitures[0].positiony,width,height+5,this);	
 }
    
    public void charger()
    {
    	
      
    }

   static public void main (String arg[])
    {
	 parking v=new parking();
	 
	 
	 	 
    }
  }