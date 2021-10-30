import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {

        String file = "src/main/resources/mapMoscow.json";
        ParsingHtml html = new ParsingHtml();
        JSONObject object1 = new JSONObject();
        JSONArray lines = new JSONArray();

        for (int k = 0; k < html.getAllLines().size(); k++) {
            JSONObject line = new JSONObject();
            line.put("name", html.getAllLines().values().toArray()[k]);
            line.put("number", html.getAllLines().keySet().toArray()[k]);
            lines.add(line);
        }

        JSONArray test = new JSONArray();
        object1.put("stations", html.getAllStations());
        object1.put("lines", lines);
        test.add(html.getAllStations());
        Files.write(Paths.get(file), object1.toJSONString().getBytes());

        FileReader reader = new FileReader("src/main/resources/mapMoscow.json");
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
        JSONObject station = (JSONObject) jsonObject.get("stations");

        for (int i = 0; i < station.keySet().size(); i++) {
            String num = String.valueOf(station.keySet().toArray()[i]);
            JSONArray lineNumStation = (JSONArray) station.get(num);
            System.out.println("Линия : " + num + "\n кол-во станций : " + lineNumStation.size() + "\n");
        }
    }

}

