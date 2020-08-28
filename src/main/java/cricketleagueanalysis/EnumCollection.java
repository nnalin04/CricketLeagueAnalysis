package cricketleagueanalysis;

import java.util.Comparator;

public class EnumCollection {

    static Comparator<FactSheetDAO> battingAvgComparator = Comparator.comparing(leagueFact -> leagueFact.battingAvg);
    static Comparator<FactSheetDAO> strikeRateComparator = Comparator.comparing
            (leagueFact -> leagueFact.battingStrikeRate);
    static Comparator<FactSheetDAO> fourAndSixComparator = Comparator.comparing
            (leagueFact -> leagueFact.fours * 4 + leagueFact.sixes * 6);
    static Comparator<FactSheetDAO> runComparator = Comparator.comparing(leagueFact -> leagueFact.runs);
    static Comparator<FactSheetDAO> bowlingAvgComparator = Comparator.comparing(leagueFact -> leagueFact.bowlingAvg);
    static Comparator<FactSheetDAO> bowlerStrikeRateComparator = Comparator.comparing
            (leagueFact -> leagueFact.bowlerStrikeRate);
    static Comparator<FactSheetDAO> ecoRateComparator = Comparator.comparing(leagueFact -> leagueFact.ecoRate);
    static Comparator<FactSheetDAO> w4AndW5Comparator = Comparator.comparing
            (leagueFact -> leagueFact.fourWicket + leagueFact.fourWicket);
    static Comparator<FactSheetDAO> wicketComparator = Comparator.comparing(leagueFact -> leagueFact.wicket);
    static Comparator<FactSheetDAO> hundredComparator = Comparator.comparing(leagueFact -> leagueFact.hundreds);
    static Comparator<FactSheetDAO> hundredAnd50sComparator = Comparator.comparing
            (leagueFact -> leagueFact.hundreds + leagueFact.fifty == 0);

    public enum Cricketer {
        BATSMEN, BOWLER
    }
}
