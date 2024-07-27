package org.backend.session.ll3.machinecoding.tictactoe.factory;

import org.backend.session.ll3.machinecoding.tictactoe.models.BotDifficultLevel;
import org.backend.session.ll3.machinecoding.tictactoe.startergies.botstategies.BotPlayingStrategy;
import org.backend.session.ll3.machinecoding.tictactoe.startergies.botstategies.EasyBotPlayingStrategy;
import org.backend.session.ll3.machinecoding.tictactoe.startergies.botstategies.HardBotPlayingStategy;
import org.backend.session.ll3.machinecoding.tictactoe.startergies.botstategies.MediumBotPlayingStategy;

public class BotPlayingFactory {

    public static BotPlayingStrategy getBotPlayingStrategy(BotDifficultLevel botDifficultLevel){
        return switch (botDifficultLevel){
            case EASY -> new EasyBotPlayingStrategy();
            case MEDIUM -> new MediumBotPlayingStategy();
            default -> new HardBotPlayingStategy();
        };
    }
}
