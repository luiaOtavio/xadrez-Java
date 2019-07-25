
package BordGame;

/**
 *
 * @author luizc
 */
public class Position {
    private int row;
    private int colomn;
    
    public Position(int row, int colomn){
        this.row = row;
        this.colomn = colomn;
    }
    public int getRow(){
        return row;
    }
    public void setRow(int row){
        this.row = row;
    }
    public int getColumn(){
        return colomn;
    }
    public void setColumn(int colomn){
        this.colomn = colomn;
    }
    @Override
    public String toString(){
        return row+", "+colomn;
    }
}
