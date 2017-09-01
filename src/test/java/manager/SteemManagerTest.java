package manager;

import static org.hamcrest.CoreMatchers.equalTo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import leechiesnews.manager.SteemManager;
import leechiesnews.model.News;

public class SteemManagerTest {
	private static List<String> TAGS = new ArrayList<>(Arrays.asList("FirstOne", "News", "Ripple", "BitCoin", "LastOne"));	
	private static String URL = "https://www.cryptocoinsnews.com/wp-content/uploads/2017/08/UBS-mast.jpg";
	
	@Test
	public void testBuildMetaData () {
		News news = new News();
		news.cleanTags = TAGS;
		news.cleanImgUrl = URL;
		Assert.assertThat(SteemManager.buildMetaData(news), equalTo("{\"tags\":[\"FirstOne\",\"News\",\"Ripple\",\"BitCoin\",\"LastOne\"],\"image\":[\"https://www.cryptocoinsnews.com/wp-content/uploads/2017/08/UBS-mast.jpg\"],\"app\":\"steemit/0.1\",\"format\":\"markdown\"}"));		
	}	
}
