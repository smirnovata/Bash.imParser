import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws Exception {
        URL bash = new URL("http://bash.im/");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(bash.openStream(), "windows-1251"));

        String inputLine;
        String value = "";

        while ((inputLine = in.readLine()) != null) {
            value = value + inputLine;
        }
        in.close();

        Document doc = Jsoup.parse(value);
        System.out.println(doc.title());
        Elements elements = doc.select("div.quote");

        for (Element element : elements) {
                System.out.println(element.select(("span.rating")).text() + " " + element.select("span.date").text() +
                        "\n"+ element.select("div.text").text()+"\n");
        }
    }
}


