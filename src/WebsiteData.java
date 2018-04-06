import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;  
import org.jsoup.nodes.Document;  
import org.jsoup.nodes.Element;  
import org.jsoup.select.Elements;
	
public class WebsiteData {
	
	private Document site;
	private	Elements dateData;
	private	Elements titleData;
	private Element showTitle;
	private ArrayList<String> episodeTitles;
	private ArrayList<String> dates;
	
	public WebsiteData() {
		
		episodeTitles = new ArrayList<String>();
		dates = new ArrayList<String>();
		
	}
	
	public void setup(String url) {
		
		try {
			site = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		dateData = site.select("div.airdate");
		titleData = site.select("a[itemprop='name']");
		showTitle = site.select("a.subnav_heading").first();
		
		for(Element results : dateData) {
			dates.add(results.text());
		}
		
		for(Element results : titleData) {
			if(results.text().contains("Episode #")) {
				episodeTitles.add("Not aired yet!");
			} else {
				episodeTitles.add(results.text());
			}
		}
		
	}
	
	public ArrayList<String> getEpisodeTitle() {
		return episodeTitles;
	}
	
	public ArrayList<String> getDates() {
		return dates;
	}
	
	public String getShowTitle() {
		return showTitle.text();
	}
	
}
