package leechiesnews.cleaner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import leechiesnews.model.News;

public abstract class Cleaner {
	public abstract void clean(News in);

	protected String selectOut(String text, String selector) {
		Document doc = Jsoup.parse(text);
		return doc.select(selector).outerHtml();
	}

	protected String selectIn(String text, String selector) {
		Document doc = Jsoup.parse(text);
		return doc.select(selector).html();
	}
	
	protected String remove(String text, String selector) {
		Document doc = Jsoup.parse(text);
		doc.select(selector).remove();
		return doc.outerHtml();
	}
}
