
import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import java.awt.Point;
import java.util.ArrayList;


public class Snake {
    
  List<Point> snakePoints;
    int xDir,yDir;
    boolean  isMoving,elongate;
     final int STARTSIZE=20, STARTX=150, STARTY=150;
    
    
    
    public Snake(){
        
        snakePoints = new ArrayList<Point>();
        xDir = 0;
        yDir = 0;
        isMoving =false;
        elongate = false;
        snakePoints.add(new Point(STARTX,STARTY));
        for(int i=1;i<STARTSIZE;i++){
        snakePoints.add(new Point(STARTX-i*4,STARTY));
    }
    }
    public void draw(Graphics g){
        g.setColor(Color.white);
        for(Point p : snakePoints){
            g.fillRect((int)p.getX(),(int) p.getY(), 4, 4);
        }
        
    }
    public void move(){
        if(isMoving){
        Point  temp=snakePoints.get(0);
        Point last =snakePoints.get(snakePoints.size()-1);
        
        Point  newStart = new Point( (int)temp.getX() + xDir * 4,(int) temp.getY()+ yDir * 4);
        
       
        
        
        for(int i=snakePoints.size()-1;i>=1;i--){
    snakePoints.set(i,snakePoints.get(i-1 ));
       }
       
       snakePoints.set(0,newStart);
       if(elongate){
            snakePoints.add(last);
            elongate =false;
       }
    }
    }
    public boolean snakeCollision(){
      int x=this.getX();
      int y=this.getY();
      for(int i=1;i<snakePoints.size();i++){
          if(snakePoints.get(i).getX() == x && snakePoints.get(i).getY()==y)
              return true;
      }
      return false;
    }
    public boolean isMoving(){
        return isMoving;
    }
    public void setIsMoving(boolean b){
        isMoving=b;
    }
    
    
    
    public int getXDir(){
        return (int) xDir;
    }
    public int getYDir(){
        return(int) yDir;
    }
    public void setXDir(int x){
        xDir=x;
    }
    public void setYDir(int y){
        yDir=y;
    }
    
    //head of the Snake
    public int getX(){
        return (int) snakePoints.get(0).getX();
    }
    public int getY(){
        return (int) snakePoints.get(0).getY();
    }

    public void setElongate(boolean b){
        elongate =b;
        
    }
    
//    void draw(Graphics gfx) {
//       
//    }
    
}
