import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

public class ParsingHtml {

    Document doc = Jsoup.connect("https://www.moscowmap.ru/metro.html#lines").maxBodySize(0).get();

    public ParsingHtml() throws IOException {
    }

    public Map<String, String> getAllLines() {
        Elements elements = doc.select(".js-metro-line");
        Map<String, String> lines = new LinkedHashMap<>();
        for (int i = 0; i < elements.size(); i++) {
            lines.put(elements.get(i).attr("data-line"), elements.get(i).text());
        }
        return lines;
    }

    public LinkedHashMap<String, List> getAllStations() {
        Elements elements = doc.select(".js-metro-stations");
        LinkedHashMap<String, List> stations = new LinkedHashMap<>();
        for (int i = 0; i < elements.size(); i++) {
            String key = elements.get(i).attr("data-line");
            String value = elements.get(i).text().replaceAll("[0-9]+\\.", " ");
            ArrayList sss = new ArrayList();
            String[] fragments = value.split("   ");
            for (int z = 0; z < fragments.length; z++) {
                String st = fragments[z].trim();
                sss.add(st);
            }
            stations.put(key, sss);
        }
        return stations;
    }
}