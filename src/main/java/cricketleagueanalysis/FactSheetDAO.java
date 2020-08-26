package cricketleagueanalysis;

public class FactSheetDAO {

    public double bowlingAvg;
    public int runs;
    public int fours;
    public int sixes;
    public double strikeRate;
    public String playerName;
    public double avgRun;

    public FactSheetDAO(IPLMostRunCSV iplMostRunCSV) {
        playerName = iplMostRunCSV.playerName;
        avgRun = iplMostRunCSV.avgRun;
        strikeRate = iplMostRunCSV.strikeRate;
        fours = iplMostRunCSV.fours;
        sixes = iplMostRunCSV.sixes;
        runs = iplMostRunCSV.runs;
    }

    public FactSheetDAO(IPLMostWktsCSV iplMostWktsCSV){
        playerName = iplMostWktsCSV.playerName;
        bowlingAvg = iplMostWktsCSV.bowlingAvg;
    }
}
