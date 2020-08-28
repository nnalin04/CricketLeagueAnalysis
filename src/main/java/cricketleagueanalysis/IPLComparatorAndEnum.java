package cricketleagueanalysis;

import java.util.Comparator;

public class IPLComparatorAndEnum {

    public enum Cricketer {
        BATSMEN, BOWLER
    }

    static Comparator<FactSheetDAO> getBattingAvg = Comparator.comparing(leagueFact -> leagueFact.battingAvg);
    static Comparator<FactSheetDAO> getStrikeRate = Comparator.comparing
            (leagueFact -> leagueFact.battingStrikeRate);
    static Comparator<FactSheetDAO> get4And6 = Comparator.comparing
            (leagueFact -> leagueFact.fours * 4 + leagueFact.sixes * 6);
    static Comparator<FactSheetDAO> getRun = Comparator.comparing(leagueFact -> leagueFact.runs);
    static Comparator<FactSheetDAO> getBowlingAvg = Comparator.comparing(leagueFact -> leagueFact.bowlingAvg);
    static Comparator<FactSheetDAO> getBowlerStrikeRate = Comparator.comparing
            (leagueFact -> leagueFact.bowlerStrikeRate);
    static Comparator<FactSheetDAO> getEcoRate = Comparator.comparing(leagueFact -> leagueFact.ecoRate);
    static Comparator<FactSheetDAO> getW4AndW5 = Comparator.comparing
            (leagueFact -> leagueFact.fourWicket + leagueFact.fourWicket);
    static Comparator<FactSheetDAO> getWickets = Comparator.comparing(leagueFact -> leagueFact.wicket);
    static Comparator<FactSheetDAO> getHundred = Comparator.comparing(leagueFact -> leagueFact.hundreds);
    static Comparator<FactSheetDAO> get100sAnd50s = Comparator.comparing
            (leagueFact -> leagueFact.hundreds + leagueFact.fifty == 0);

}
