package leechiesnews.cleaner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import leechiesnews.model.News;

public class CryptocoinsnewsCleaner extends Cleaner {

	@Override
	public void clean(News in) {

		// clean title
		in.cleanTitle = in.title;

		// clean text
		in.cleanText = selectOut(in.text, "html");
		in.cleanText = removeAll(in.cleanText, "em", "aside", "script", ".author-profile-links", ".author-profile", ".mobile", ".showmobile", ".wp-caption-text", ".entry-meta", ".share-comment.click", ".dcl-disqus-thread");
		in.cleanText = selectIn(in.cleanText, "body");

		// clean tags
		// first tag = cryptocurrency
		in.cleanTags.add("cryptocurrency");
		if (in.tags != null) {
			for (String tag : in.tags) {
				tag = tag.replaceAll(" .+$", "");
				tag = tag.replace("News", "");
				tag = tag.replace("news", "");
				if (StringUtils.isNotEmpty(tag)) {
					in.cleanTags.add(tag);
				}
				if (in.cleanTags.size() > 4) {
					return;// no more than 5 tags
				}
			}
		}

		// clean img
		if (StringUtils.isNotEmpty(in.imgUrl)) {
			String urlRegex = "(http.*jpg)";
			Pattern pattern = Pattern.compile(urlRegex, Pattern.CASE_INSENSITIVE);
			Matcher urlMatcher = pattern.matcher(in.imgUrl);
			boolean b = urlMatcher.find();
			in.cleanImgUrl = urlMatcher.group(0);
		}

		// Ajout image
		in.cleanText = in.cleanImgUrl + "\n" + in.cleanText;
		
		// Ajout source		
		in.cleanText += "\n Source : " + in.url;
	}
}
