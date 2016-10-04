import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.util.Iterator;

public class reader {
	public static void main(String[] args) throws IOException {
		Document DPwiki = Jsoup.connect("https://www.owasp.org/index.php/AppSensor_DetectionPoints").get();
		
		// Grab Titles
		Element table1 = DPwiki.select("table").first();
		Iterator<Element> iterator1 = table1.select("td").iterator();
		//while(iterator1.hasNext()){
		for (int i = 0; i < 6; i++) {
            System.out.print(iterator1.next().text()+",");
            iterator1.next().text();
        }
		System.out.println();
		
		// Grab Contents
		for (Element table2 : DPwiki.select("table")) {
			Iterator<Element> iterator2 = table2.select("td").iterator();
			//while(iterator2.hasNext()){
			for (int i = 0; i < 6; i++) {
				iterator2.next().text();
	            System.out.print("\""+iterator2.next().text()+"\",");
	        }
			System.out.println();
		}
	}
}
