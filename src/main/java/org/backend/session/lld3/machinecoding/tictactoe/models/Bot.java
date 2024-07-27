packagename org.backend.session.lld3.machinecoding.tictactoe.model;


public class Bot extends Player{
    private BotDifficultLevel botDifficultLevel;
    private BotPlayingStrategy botPlayingStrategy;

    public Bot(Symbol symbol, String name, PlayerType playerType, BotDifficultLevel botDifficultLevel
        ) {
        super(symbol, name, playerType);
        this.botDifficultLevel = botDifficultLevel;
        this.botPlayingStrategy = BotPlayingFactory.getBotPlayingStrategy(botDifficultLevel); //factory pattern

    }

    public BotPlayingStrategy getBotPlayingStrategy() {
        return botPlayingStrategy;
    }

    public void setBotPlayingStrategy(BotPlayingStrategy botPlayingStrategy) {
        this.botPlayingStrategy = botPlayingStrategy;
    }

    public BotDifficultLevel getBotDifficultLevel() {
        return botDifficultLevel;
    }

    public void setBotDifficultLevel(BotDifficultLevel botDifficultLevel) {
        this.botDifficultLevel = botDifficultLevel;
    }

    @Override
    public Move makeMove(Board board){

       return botPlayingStrategy.makeMove(board);
    }
}
