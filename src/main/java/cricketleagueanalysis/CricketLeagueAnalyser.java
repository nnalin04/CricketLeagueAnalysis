package cricketleagueanalysis;

import com.google.gson.Gson;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CricketLeagueAnalyser {

    Map<String, FactSheetDAO>  factSheetMap;

    public enum Cricketer {
        BATSMEN, BOWLER
    }

    public Map<String, FactSheetDAO> loadLeagueFactSheet(Cricketer cricketer, String csvFilePath) throws CricketLeagueAnalyserException {
        factSheetMap = new FactSheetLoader().leagueFactLoader(cricketer, csvFilePath);
        return factSheetMap;
    }

    public String getBattingAverageSortedFactSheet() {
        Comparator<FactSheetDAO> avgRunComparator = Comparator.comparing(leagueFact -> leagueFact.avgRun);
        List<FactSheetDAO> factSheetDAO = factSheetMap.values().stream()
                .collect(Collectors.toList());
        this.sort(factSheetDAO, avgRunComparator);
        String sortedFactSheetJson = new Gson().toJson(factSheetDAO);
        return sortedFactSheetJson;
    }

    public String getStrikingRatesSortedFactSheet() {
        Comparator<FactSheetDAO> strikeRateComparator = Comparator.comparing(leagueFact -> leagueFact.strikeRate);
        List<FactSheetDAO> factSheetDAO = factSheetMap.values().stream()
                .collect(Collectors.toList());
        this.sort(factSheetDAO, strikeRateComparator);
        String sortedFactSheetJson = new Gson().toJson(factSheetDAO);
        return sortedFactSheetJson;
    }

    public String getMax4sAnd6sSortedFactSheet() {
        Comparator<FactSheetDAO> fourAndSixComparator = Comparator.comparing(leagueFact -> leagueFact.fours * 4 + leagueFact.sixes * 6);
        List<FactSheetDAO> factSheetDAO = factSheetMap.values().stream()
                .collect(Collectors.toList());
        this.sort(factSheetDAO, fourAndSixComparator);
        String sortedFactSheetJson = new Gson().toJson(factSheetDAO);
        return sortedFactSheetJson;
    }

    public String getMax4sAnd6sWithStrikeRatesSortedFactSheet() {
        Comparator<FactSheetDAO> strikeRateComparator = Comparator.comparing(leagueFact -> leagueFact.strikeRate);
        Comparator<FactSheetDAO> fourAndSixComparator = Comparator.comparing
                (leagueFact -> leagueFact.fours * 4 + leagueFact.sixes * 6);
        List<FactSheetDAO> factSheetDAO = factSheetMap.values().stream()
                .collect(Collectors.toList());
        this.sort(factSheetDAO, fourAndSixComparator.thenComparing(strikeRateComparator));
        String sortedFactSheetJson = new Gson().toJson(factSheetDAO);
        return sortedFactSheetJson;
    }

    public String getBattingAverageWithStrikeRatesSortedFactSheet() {
        Comparator<FactSheetDAO> avgRunComparator = Comparator.comparing(leagueFact -> leagueFact.avgRun);
        Comparator<FactSheetDAO> strikeRateComparator = Comparator.comparing(leagueFact -> leagueFact.strikeRate);
        List<FactSheetDAO> factSheetDAO = factSheetMap.values().stream()
                .collect(Collectors.toList());
        this.sort(factSheetDAO, strikeRateComparator.thenComparing(avgRunComparator));
        String sortedFactSheetJson = new Gson().toJson(factSheetDAO);
        return sortedFactSheetJson;
    }

    public String getBestRunsWithBattingAverageSortedFactSheet() {
        Comparator<FactSheetDAO> avgRunComparator = Comparator.comparing(leagueFact -> leagueFact.avgRun);
        Comparator<FactSheetDAO> runComparator = Comparator.comparing(leagueFact -> leagueFact.runs);
        List<FactSheetDAO> factSheetDAO = factSheetMap.values().stream()
                .collect(Collectors.toList());
        this.sort(factSheetDAO, runComparator.thenComparing(avgRunComparator));
        String sortedFactSheetJson = new Gson().toJson(factSheetDAO);
        return sortedFactSheetJson;
    }

    public String getBestBowlingAverageSortedFactSheet() {
        Comparator<FactSheetDAO> bowlingAvgComparator = Comparator.comparing(leagueFact -> leagueFact.avgRun);
        List<FactSheetDAO> factSheetDAO = factSheetMap.values().stream()
                .collect(Collectors.toList());
        this.sort(factSheetDAO, bowlingAvgComparator);
        String sortedFactSheetJson = new Gson().toJson(factSheetDAO);
        return sortedFactSheetJson;
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
