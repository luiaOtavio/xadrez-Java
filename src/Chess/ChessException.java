package Chess;

import BordGame.BoardGameException;

/**
 *
 * @author luizc
 */
public class ChessException extends BoardGameException{
    private static final long serialVersionUID = 1L;
    
    public ChessException(String msg){
        super(msg);
    }
}
