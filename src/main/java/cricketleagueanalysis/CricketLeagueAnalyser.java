package cricketleagueanalysis;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CricketLeagueAnalyser {

    Map<String, FactSheetDAO>  factSheetMap;

    public void loadLeagueFactSheet(EnumCollection.Cricketer cricketer, String... csvFilePath) throws CricketLeagueAnalyserException {
        factSheetMap = new FactSheetLoader().leagueFactLoader(cricketer, csvFilePath);
    }

    public String getSingleFactSorted(Comparator<FactSheetDAO>... comparator) {
        List<FactSheetDAO> factSheetDAO ;
        if (comparator.length == 1) {
             factSheetDAO = factSheetMap.values().stream()
                    .sorted(comparator[0].reversed()).collect(Collectors.toList());
        } else {
            factSheetDAO = factSheetMap.values().stream()
                    .sorted(comparator[0].thenComparing(comparator[1]).reversed()).collect(Collectors.toList());
        }
        return new Gson().toJson(factSheetDAO);
    }
}
