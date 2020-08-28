package cricketleagueanalysis;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CricketLeagueAnalyser {

    Map<String, FactSheetDAO>  factSheetMap;

    Comparator<FactSheetDAO> battingAvgComparator = Comparator.comparing(leagueFact -> leagueFact.battingAvg);
    Comparator<FactSheetDAO> strikeRateComparator = Comparator.comparing(leagueFact -> leagueFact.strikeRate);
    Comparator<FactSheetDAO> fourAndSixComparator = Comparator.comparing
            (leagueFact -> leagueFact.fours * 4 + leagueFact.sixes * 6);
    Comparator<FactSheetDAO> runComparator = Comparator.comparing(leagueFact -> leagueFact.runs);
    Comparator<FactSheetDAO> bowlingAvgComparator = Comparator.comparing(leagueFact -> leagueFact.bowlingAvg);
    Comparator<FactSheetDAO> bowlerStrikeRateComparator = Comparator.comparing(leagueFact -> leagueFact.strikeRate);
    Comparator<FactSheetDAO> ecoRateComparator = Comparator.comparing(leagueFact -> leagueFact.ecoRate);
    Comparator<FactSheetDAO> w4AndW5Comparator = Comparator.comparing
            (leagueFact -> leagueFact.fourWicket + leagueFact.fourWicket);
    Comparator<FactSheetDAO> wicketComparator = Comparator.comparing(leagueFact -> leagueFact.wicket);
    Comparator<FactSheetDAO> hundredComparator = Comparator.comparing(leagueFact -> leagueFact.hundreds);
    Comparator<FactSheetDAO> hundredAnd50sComparator = Comparator.comparing
            (leagueFact -> leagueFact.hundreds + leagueFact.fifty == 0);



    public void loadLeagueFactSheet(EnumCollection.Cricketer cricketer, String... csvFilePath) throws CricketLeagueAnalyserException {
        factSheetMap = new FactSheetLoader().leagueFactLoader(cricketer, csvFilePath);
    }

    public String getBattingAverageSortedFactSheet() throws CricketLeagueAnalyserException {
        List<FactSheetDAO> factSheetDAO = new ArrayList<>(factSheetMap.values());
        this.sort(factSheetDAO, battingAvgComparator);
        return new Gson().toJson(factSheetDAO);
    }

    public String getStrikingRatesSortedFactSheet() throws CricketLeagueAnalyserException {
        List<FactSheetDAO> factSheetDAO = new ArrayList<>(factSheetMap.values());
        this.sort(factSheetDAO, strikeRateComparator);
        return new Gson().toJson(factSheetDAO);
    }

    public String getMax4sAnd6sSortedFactSheet() throws CricketLeagueAnalyserException {
        List<FactSheetDAO> factSheetDAO = new ArrayList<>(factSheetMap.values());
        this.sort(factSheetDAO, fourAndSixComparator);
        return new Gson().toJson(factSheetDAO);
    }

    public String getMax4sAnd6sWithStrikeRatesSortedFactSheet() throws CricketLeagueAnalyserException {
        List<FactSheetDAO> factSheetDAO = new ArrayList<>(factSheetMap.values());
        this.sort(factSheetDAO, fourAndSixComparator.thenComparing(strikeRateComparator));
        return new Gson().toJson(factSheetDAO);
    }

    public String getBattingAverageWithStrikeRatesSortedFactSheet() throws CricketLeagueAnalyserException {
        List<FactSheetDAO> factSheetDAO = new ArrayList<>(factSheetMap.values());
        this.sort(factSheetDAO, strikeRateComparator.thenComparing(battingAvgComparator));
        return new Gson().toJson(factSheetDAO);
    }

    public String getBestRunsWithBattingAverageSortedFactSheet() throws CricketLeagueAnalyserException {
        List<FactSheetDAO> factSheetDAO = new ArrayList<>(factSheetMap.values());
        this.sort(factSheetDAO, battingAvgComparator.thenComparing(runComparator));
        return new Gson().toJson(factSheetDAO);
    }

    public String getBestBowlingAverageSortedFactSheet() throws CricketLeagueAnalyserException {
        List<FactSheetDAO> factSheetDAO = new ArrayList<>(factSheetMap.values());
        this.sort(factSheetDAO, bowlingAvgComparator);
        return new Gson().toJson(factSheetDAO);
    }

    public String getBestBowlerStrikeRateSortedFactSheet() throws CricketLeagueAnalyserException {
        List<FactSheetDAO> factSheetDAO = new ArrayList<>(factSheetMap.values());
        this.sort(factSheetDAO, bowlerStrikeRateComparator);
        return new Gson().toJson(factSheetDAO);
    }

    public String getBestEconomyRateSortedFactSheet() throws CricketLeagueAnalyserException {
        List<FactSheetDAO> factSheetDAO = new ArrayList<>(factSheetMap.values());
        this.sort(factSheetDAO, ecoRateComparator);
        return new Gson().toJson(factSheetDAO);
    }

    public String getBestStrikeRateWith4wAnd5wSortedFactSheet() throws CricketLeagueAnalyserException {
        List<FactSheetDAO> factSheetDAO = new ArrayList<>(factSheetMap.values());
        this.sort(factSheetDAO, w4AndW5Comparator.thenComparing(bowlerStrikeRateComparator));
        return new Gson().toJson(factSheetDAO);
    }

    public String getBestBowlingAverageWithStrikeRateSortedFactSheet() throws CricketLeagueAnalyserException {
        List<FactSheetDAO> factSheetDAO = new ArrayList<>(factSheetMap.values());
        this.sort(factSheetDAO, bowlerStrikeRateComparator.thenComparing(bowlingAvgComparator));
        return new Gson().toJson(factSheetDAO);
    }

    public String getBestBowlingAverageWithMaxWicketSortedFactSheet() throws CricketLeagueAnalyserException {
        List<FactSheetDAO> factSheetDAO = new ArrayList<>(factSheetMap.values());
        this.sort(factSheetDAO, wicketComparator.thenComparing(bowlingAvgComparator));
        return new Gson().toJson(factSheetDAO);
    }

    public String getBestBattingAndBowlingAverageSortedFactSheet() throws CricketLeagueAnalyserException {
        List<FactSheetDAO> factSheetDAO = new ArrayList<>(factSheetMap.values());
        this.sort(factSheetDAO, bowlingAvgComparator.thenComparing(battingAvgComparator));
        return new Gson().toJson(factSheetDAO);
    }

    public String getBestRunsAndWicketsSortedFactSheet() throws CricketLeagueAnalyserException {
        List<FactSheetDAO> factSheetDAO = new ArrayList<>(factSheetMap.values());
        this.sort(factSheetDAO, wicketComparator.thenComparing(runComparator));
        return new Gson().toJson(factSheetDAO);
    }

    public String getBestBattingAverageWithMax100SortedFactSheet() throws CricketLeagueAnalyserException {
        List<FactSheetDAO> factSheetDAO = new ArrayList<>(factSheetMap.values());
        this.sort(factSheetDAO, hundredComparator.thenComparing(battingAvgComparator));
        return new Gson().toJson(factSheetDAO);
    }

    public String getBestBattingAverageWithMin100sAnd50SortedFactSheet() {
        List<FactSheetDAO> factSheetDAO = factSheetMap.values().stream()
                .filter(factSheet -> factSheetMap.get(factSheet.playerName).hundreds == 0)
                .filter(factSheet -> factSheetMap.get(factSheet.playerName).fifty == 0)
                .sorted(battingAvgComparator.reversed()).collect(Collectors.toList());
        return new Gson().toJson(factSheetDAO);
    }

    private void sort(List<FactSheetDAO> factSheetDAOS, Comparator<FactSheetDAO> comparator)
            throws CricketLeagueAnalyserException {
        if (factSheetDAOS == null || factSheetDAOS.size() == 0) {
            throw new CricketLeagueAnalyserException("No IPL Data",
                    CricketLeagueAnalyserException.ExceptionType.NO_IPL_DATA);
        }
        for (int i = 0; i < factSheetDAOS.size()-1; i++) {
            for (int j =0; j< factSheetDAOS.size() -i -1; j++) {
                FactSheetDAO leagueFact1 = factSheetDAOS.get(j);
                FactSheetDAO leagueFact2 = factSheetDAOS.get(j+1);
                if (comparator.compare(leagueFact1, leagueFact2) < 0){
                    factSheetDAOS.set(j, leagueFact2);
                    factSheetDAOS.set(j+1, leagueFact1);
                }
            }
        }
    }
}
