package org.example;


public class Uno extends Game{
    private final QueueController queueController = QueueController.getInstance();
    private final MatchController matchController = MatchController.getInstance();
    private final EffectController effectController = EffectController.getInstance();
    private final GameInitializer gameInitializer = new GameInitializer();
    private final UiController uiController = new UiController();

    public void playTurn(Player currentPlayer){
        uiController.displayPlayerHand(currentPlayer);
        Card card = matchController.chooseCard(currentPlayer.getHand());

        if(card != null){
            effectController.applyEffect(card);
        }else{
            currentPlayer.getHand().add(matchController.drawCard());
        }
    }
    @Override
    public void play() {
        gameInitializer.initializeGame();

        while (true){
            Player currentPlayer = queueController.getCurrentPlayer();

            uiController.displayMessage("---> " + currentPlayer.toString() + " please choose a card to play. <---");
            uiController.displayMessage("---> Current card color " + matchController.getCurrentColor() + " <---");

            playTurn(currentPlayer);

            if(currentPlayer.getHand().isEmpty()){
                uiController.displayMessage("---> " + currentPlayer + " HAS WON THE MATCH !!!! <---");
                break;
            }
            queueController.move();
            uiController.displayMessage("------------------------------------------");
        }
    }
}
