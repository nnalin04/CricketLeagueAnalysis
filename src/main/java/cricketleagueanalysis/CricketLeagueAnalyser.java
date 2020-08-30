package cricketleagueanalysis;

import com.google.gson.Gson;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CricketLeagueAnalyser {

    Map<String, FactSheetDAO>  factSheetMap;

    public void loadLeagueFactSheet(IPLComparatorAndEnum.Cricketer cricketer, String... csvFilePath)
            throws CricketLeagueAnalyserException {
        factSheetMap = new FactSheetLoader().leagueFactLoader(cricketer, csvFilePath);
    }

    public String getSortedFacts(IPLComparatorAndEnum.Compare... compare) {
        List<FactSheetDAO> factSheetDAO;
        if (compare.length == 1) {
             factSheetDAO = factSheetMap.values().stream()
                    .sorted(IPLComparatorAndEnum.getComparator(compare[0]).reversed()).collect(Collectors.toList());
        } else {
            factSheetDAO = factSheetMap.values()
                                       .stream()
                                       .sorted(IPLComparatorAndEnum
                                       .getComparator(compare[0])
                                       .thenComparing(IPLComparatorAndEnum
                                       .getComparator(compare[1]))
                                       .reversed())
                                       .collect(Collectors
                                               .toList());
        }
        return new Gson().toJson(factSheetDAO);
    }
}
