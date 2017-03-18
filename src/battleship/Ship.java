 /*
Alex Stevens
3/14/2017
MidTerm
Csis 123B-3183
0495503
 */
package battleship;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author gstev
 */
public class Ship
{
	private String shipName;
	private int[] shipPieces; 
	char Direction;
	
        protected Image[] shipImageV;
        protected Image[] shipImageH;
        
        
       protected Image[] hitShipH;
       protected Image[] hitShipV;
       
       protected int[] DestroyV;
       protected int[] DestroyH;
       
       private Label[] completeShip; 
        
	Ship(String name,int[]V,int[]H,int[]DV,int[]DH)
	{
            this.shipName = name;
            
             this.hitShipH = new Image[H.length];
          this.hitShipV = new Image[V.length];
            
            this.completeShip = new Label[V.length];
            this.shipImageV = new Image[V.length];
            this.shipImageH = new Image[H.length];
            
             this.DestroyH = new int[DH.length];
        this.DestroyV = new int[DV.length];
        this.Assembler(DV,DH);
        
            
            this.pieceBuilder(V,H);
            this.DestroBuild(DestroyV, DestroyH);
             this.shipBuilder(hitShipV, hitShipH);
             
                
            }
            
            /*
		this.Direction = Direction;
		this.shipName = name;
		shipPieces = new int[pieces.length];
		for(int i = 0; i < pieces.length; i++)
			shipPieces[i] = pieces[i];
		*/

    private void pieceBuilder(int[] V, int[] H) {
        
        if(Direction=='H'){
        for(int i=0;i<H.length;i++){
            
            completeShip[i]=new Label();
            shipImageH[i] = new Image("file:Images\\batt" + (H[i]+1) + ".gif");
            
            
        }
    }
        else if(Direction=='V'){
           for(int i=0;i<V.length;i++){
        completeShip[i] = new Label();
       shipImageV[i] = new Image("file:Images\\batt" + (V[i]+1) + ".gif");

           } 
        }
    }
    
    private void shipBuilder(Image[] V,Image[]H){
        if(Direction=='H'){
            for(int a=0;a<H.length;a++){
                
                completeShip[a].setGraphic(new ImageView(shipImageH[a]));
            }
            
        }
        
        else if(Direction=='V'){
            
              for(int a=0;a<V.length;a++){
                
                completeShip[a].setGraphic(new ImageView(shipImageV[a]));
            } 
        }
        
        
    }
    
    private void DestroBuild(int[] V,int[] H){
        
        for(int i=0;i<V.length;i++){
            
            hitShipV[i] = new Image("file:Images\\batt" + V[i]+ ".gif");
            hitShipH[i] = new Image("file:Images\\batt" + H[i] + ".gif");
        }
        
        
    }
    public void Assembler(int[] V,int[]H){
        
       
        
        for(int i=0;i<V.length;i++){
       DestroyV[i]= V[i];
       DestroyH[i]=H[i];
            
            
        }
    }

	
	public String getName()
	{
		return this.shipName;
	}
 /*
	public int[] getShipPieces()
	{
		return shipPieces;
	}
*/
	public int getDirection()
	{
		return this.Direction;
	}
	public int length()
	{
		return shipImageV.length;
	}


        public Image[] getDestV(){
            
            
            return this.hitShipV;
        }
        public Image[] getDestH(){
    
        return this.hitShipH;
       }
       
        
        public Label[] retShip(){
            
            return this.completeShip;
            
        }
        public Image[] shipPieces(){
         if(Direction=='H'){
             return this.shipImageH;
         }
         else{
             return this.shipImageV;
         }
           
        }
}




class Frigate extends Ship{
   
    static int[] frigateH = {0,1,4};
   static int[] frigateV = {5,6,9};
   
   static int[] frigHitH = {201,202,203};
   static int[] frigHitV ={204,205,206};
   
    public Frigate(char Direction) {
        super("Frigate",frigateV,frigateH,frigHitV,frigHitH);
        super.Direction=Direction;
        
    }
   
    
    
}
class MineSweep extends Ship{
    
   static int[] mineSweepH = {0,4};
   static int[] mineSweepV = {5,9};
   
   static int[] mSweepHitH = {201,203};
   static int[] mSweepHitV = {204,206};
    
    public MineSweep(char Direction) {
        super("MineSweep",mineSweepV,mineSweepH,mSweepHitV,mSweepHitH);
        super.Direction=Direction;
        
    }
    
    
    
}
class Cruiser extends Ship{
    
   static int[] cruiserH = {0,1,2,4};
   static int[] cruiserV = {5,6,7,9};
    
   static int[] cruiseHitH ={201,202,202,203};
   static int[] cruiseHitV ={204,205,205,206};
    
    public Cruiser(char Direction) {
        super("Cruiser",cruiserV,cruiserH,cruiseHitV,cruiseHitH);
        super.Direction = Direction;
      
    }
    
    
    
}

class BattShip extends Ship{
   static int[] battShipV ={5,6,7,8,9};
  static int[] battShipH ={0,1,2,3,4};
  
  static int[] bShipHitH ={201,202,202,202,203};
  static int[] bShipHitV = {204,205,205,205,206};
    
    public BattShip(char Direction) {
       super("BattleShip",battShipV,battShipH,bShipHitV,bShipHitH);
       super.Direction = Direction; 
      
    }
    
    
    
}