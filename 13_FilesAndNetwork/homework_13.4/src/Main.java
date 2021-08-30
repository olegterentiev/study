import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        String code = Download.parserFile("data/code.html");
        Document doc = Jsoup.parse(code);
        Elements elements = doc.select("img[src~=.jpg$]");
        for (Element el : elements) {
            String path = el.absUrl("src");
            Download.downloadFile(path);
        }
    }
}
