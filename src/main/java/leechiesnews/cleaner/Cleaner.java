package leechiesnews.cleaner;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import leechiesnews.model.News;

public abstract class Cleaner {
	public abstract void clean(News in);

	protected String selectOut(String text, String selector) {
		if (StringUtils.isNotEmpty(text)) {
			Document doc = Jsoup.parse(text);
			return doc.select(selector).outerHtml();
		}
		return text;
	}

	protected String selectIn(String text, String selector) {
		if (StringUtils.isNotEmpty(text)) {
			Document doc = Jsoup.parse(text);
			return doc.select(selector).html();
		}
		return text;
	}

	protected String removeAll(String text, String... selector) {
		String rez = text;
		for (String sel : selector) {
			rez = remove (rez, sel);
		}
		return rez;
	}
	
	protected String remove(String text, String selector) {
		if (StringUtils.isNotEmpty(text)) {
			Document doc = Jsoup.parse(text);
			doc.select(selector).remove();
			return doc.outerHtml();
		}
		return text;
	}
}
