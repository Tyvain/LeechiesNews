package leechiesnews.cleaner;

import org.apache.commons.lang3.StringUtils;

import leechiesnews.model.News;

public class CryptocoinsnewsCleaner extends Cleaner {

	@Override
	public void clean(News in) {
		in.cleanText = selectOut(in.text, "p");
		in.cleanText = remove(in.cleanText, "em");
		in.cleanText = selectIn(in.cleanText, "body");

		for (String tag : in.tags) {
			tag = tag.replace(" ", "");
			tag = tag.replace("News", "");
			tag = tag.replace("news", "");
			if (StringUtils.isNotEmpty(tag)) {
				in.cleanTags.add(tag);
			}
		}
	}
}
