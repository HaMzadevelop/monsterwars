package me.iHDeveloper.game;

public enum GameState {

    IN_LOBBY(true), FULL(true), IN_GAME(false), RESTARTING(false);

    private boolean canJoin;
        
    private GameState(boolean canJoin) {
        this.canJoin = canJoin;
    }
    
    public boolean canStart(){
        return canJoin;
    }
    
}
