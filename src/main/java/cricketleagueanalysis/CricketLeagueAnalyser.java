package cricketleagueanalysis;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class CricketLeagueAnalyser {

    Map<String, FactSheetDAO>  factSheetMap;

    public enum Cricketer {
        BATSMEN, BOWLER
    }

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


    public void loadLeagueFactSheet(Cricketer cricketer, String csvFilePath) throws CricketLeagueAnalyserException {
        factSheetMap = new FactSheetLoader().leagueFactLoader(cricketer, csvFilePath);
    }

    public String getBattingAverageSortedFactSheet() {
        List<FactSheetDAO> factSheetDAO = new ArrayList<>(factSheetMap.values());
        this.sort(factSheetDAO, battingAvgComparator);
        return new Gson().toJson(factSheetDAO);
    }

    public String getStrikingRatesSortedFactSheet() {
        List<FactSheetDAO> factSheetDAO = new ArrayList<>(factSheetMap.values());
        this.sort(factSheetDAO, strikeRateComparator);
        return new Gson().toJson(factSheetDAO);
    }

    public String getMax4sAnd6sSortedFactSheet() {
        List<FactSheetDAO> factSheetDAO = new ArrayList<>(factSheetMap.values());
        this.sort(factSheetDAO, fourAndSixComparator);
        return new Gson().toJson(factSheetDAO);
    }

    public String getMax4sAnd6sWithStrikeRatesSortedFactSheet() {
        List<FactSheetDAO> factSheetDAO = new ArrayList<>(factSheetMap.values());
        this.sort(factSheetDAO, fourAndSixComparator.thenComparing(strikeRateComparator));
        return new Gson().toJson(factSheetDAO);
    }

    public String getBattingAverageWithStrikeRatesSortedFactSheet() {
        List<FactSheetDAO> factSheetDAO = new ArrayList<>(factSheetMap.values());
        this.sort(factSheetDAO, strikeRateComparator.thenComparing(battingAvgComparator));
        return new Gson().toJson(factSheetDAO);
    }

    public String getBestRunsWithBattingAverageSortedFactSheet() {
        List<FactSheetDAO> factSheetDAO = new ArrayList<>(factSheetMap.values());
        this.sort(factSheetDAO, battingAvgComparator.thenComparing(runComparator));
        return new Gson().toJson(factSheetDAO);
    }

    public String getBestBowlingAverageSortedFactSheet() {
        List<FactSheetDAO> factSheetDAO = new ArrayList<>(factSheetMap.values());
        this.sort(factSheetDAO, bowlingAvgComparator);
        return new Gson().toJson(factSheetDAO);
    }

    public String getBestBowlerStrikeRateSortedFactSheet() {
        List<FactSheetDAO> factSheetDAO = new ArrayList<>(factSheetMap.values());
        this.sort(factSheetDAO, bowlerStrikeRateComparator);
        return new Gson().toJson(factSheetDAO);
    }

    public String getBestEconomyRateSortedFactSheet() {
        List<FactSheetDAO> factSheetDAO = new ArrayList<>(factSheetMap.values());
        this.sort(factSheetDAO, ecoRateComparator);
        return new Gson().toJson(factSheetDAO);
    }

    public String getBestStrikeRateWith4wAnd5wSortedFactSheet() {
        List<FactSheetDAO> factSheetDAO = new ArrayList<>(factSheetMap.values());
        this.sort(factSheetDAO, w4AndW5Comparator.thenComparing(bowlerStrikeRateComparator));
        return new Gson().toJson(factSheetDAO);
    }

    public String getBestBowlingAverageWithStrikeRateSortedFactSheet() {
        List<FactSheetDAO> factSheetDAO = new ArrayList<>(factSheetMap.values());
        this.sort(factSheetDAO, bowlerStrikeRateComparator.thenComparing(bowlingAvgComparator));
        return new Gson().toJson(factSheetDAO);
    }

    public String getBestBowlingAverageWithMaxWicketSortedFactSheet() {
        List<FactSheetDAO> factSheetDAO = new ArrayList<>(factSheetMap.values());
        this.sort(factSheetDAO, wicketComparator.thenComparing(bowlingAvgComparator));
        return new Gson().toJson(factSheetDAO);
    }

    private void sort(List<FactSheetDAO> factSheetDAOS, Comparator<FactSheetDAO> comparator) {
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
