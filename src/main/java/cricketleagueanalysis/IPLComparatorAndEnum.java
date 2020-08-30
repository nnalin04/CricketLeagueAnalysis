package cricketleagueanalysis;

import java.util.Comparator;

public class IPLComparatorAndEnum {

    public enum Cricketer {
        BATSMEN, BOWLER
    }

    public enum Compare {
        BATTING_AVG, BATTING_STRIKE_RATE, FOUR_SIX, RUN, BOWLING_AVG, BOWLING_STRIKE_RATE, ECONOMY, W4ANDW5, WICKET,
        HUNDREDS, HUNDRED_FIFTY;
    }

    static Comparator<FactSheetDAO> comparator = null;

    public static Comparator<FactSheetDAO> getComparator(Compare compare){
        switch(compare) {
            case BATTING_AVG:
                comparator = Comparator.comparing(leagueFact -> leagueFact.battingAvg);
                return comparator;
            case BATTING_STRIKE_RATE:
                comparator = Comparator.comparing(leagueFact -> leagueFact.battingStrikeRate);
                return comparator;
            case FOUR_SIX:
                comparator = Comparator.comparing(leagueFact -> leagueFact.fours * 4 + leagueFact.sixes * 6);
                return comparator;
            case RUN:
                comparator = Comparator.comparing(leagueFact -> leagueFact.runs);
                return comparator;
            case BOWLING_AVG:
                comparator = Comparator.comparing(leagueFact -> leagueFact.bowlingAvg);
                return comparator;
            case BOWLING_STRIKE_RATE:
                comparator = Comparator.comparing(leagueFact -> leagueFact.bowlerStrikeRate);
                return comparator;
            case ECONOMY:
                comparator = Comparator.comparing(leagueFact -> leagueFact.ecoRate);
                return comparator;
            case W4ANDW5:
                comparator = Comparator.comparing(leagueFact -> leagueFact.fourWicket + leagueFact.fourWicket);
                return comparator;
            case WICKET:
                comparator = Comparator.comparing(leagueFact -> leagueFact.wicket);
                return comparator;
            case HUNDREDS:
                comparator = Comparator.comparing(leagueFact -> leagueFact.hundreds);
                return comparator;
            case HUNDRED_FIFTY:
                comparator = Comparator.comparing(leagueFact -> leagueFact.hundreds + leagueFact.fifty == 0);
                return comparator;
            default:
                System.out.println("Invalid Input");
        }
        return null;
    }

}
