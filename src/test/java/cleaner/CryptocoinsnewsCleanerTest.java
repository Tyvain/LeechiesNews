package cleaner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import leechiesnews.cleaner.CryptocoinsnewsCleaner;
import leechiesnews.model.News;

public class CryptocoinsnewsCleanerTest {

	private static String NOT_CLEAN = "<div id=\"primary\" class=\"content-area\"> \r\n <main id=\"main\" class=\"site-main\" role=\"main\"> \r\n  <article id=\"post-114036\" class=\"post full-post post-114036 type-post status-publish format-standard has-post-thumbnail hentry category-bitcoin-investment category-bitcoin-mining category-news tag-mgt-capital\"> \r\n   <div class=\"entry-content\"> \r\n    <aside class=\"mashsb-container mashsb-main \">\r\n     <div class=\"mashsb-box\">\r\n      <div class=\"mashsb-buttons\">\r\n       <a class=\"mashicon-twitter mash-large mash-nomargin mashsb-noshadow\" href=\"https://twitter.com/intent/tweet?text=John%20McAfee-Led%20MGT%20Capital%20Raises%20%242.4%20Million%20to%20Boost%20Bitcoin%20Mining%20Operation&amp;url=https://www.cryptocoinsnews.com/?p=114036&amp;via=CryptoCoinsNews\" target=\"_blank\" rel=\"nofollow\"><span class=\"icon\"></span><span class=\"text\">Twitter</span></a>\r\n       <a class=\"mashicon-linkedin  mash-large mash-nomargin mashsb-noshadow\" href=\"https://www.linkedin.com/shareArticle?trk=John+McAfee-Led+MGT+Capital+Raises+%242.4+Million+to+Boost+Bitcoin+Mining+Operation&amp;url=https%3A%2F%2Fwww.cryptocoinsnews.com%2Fjohn-mcafee-led-mgt-capital-raises-2-4-million-boost-bitcoin-mining%2F\" target=\"_blank\" rel=\"nofollow\"><span class=\"icon\"></span><span class=\"text\">Linkedin </span></a>\r\n       <a class=\"mashicon-facebook mash-large mash-nomargin mashsb-noshadow\" href=\"https://www.facebook.com/sharer.php?u=https%3A%2F%2Fwww.cryptocoinsnews.com%2Fjohn-mcafee-led-mgt-capital-raises-2-4-million-boost-bitcoin-mining%2F\" target=\"_blank\" rel=\"nofollow\"><span class=\"icon\"></span><span class=\"text\">Facebook</span></a>\r\n       <a class=\"mashicon-reddit  mash-large mash-nomargin mashsb-noshadow\" href=\"http://www.reddit.com/submit?url=https%3A%2F%2Fwww.cryptocoinsnews.com%2Fjohn-mcafee-led-mgt-capital-raises-2-4-million-boost-bitcoin-mining%2F&amp;title=John+McAfee-Led+MGT+Capital+Raises+%242.4+Million+to+Boost+Bitcoin+Mining+Operation\" target=\"_blank\" rel=\"nofollow\"><span class=\"icon\"></span><span class=\"text\">Reddit </span></a>\r\n       <a class=\"mashicon-weibo mash-large mash-nomargin mashsb-noshadow\" href=\"http://service.weibo.com/share/share.php?url=https%3A%2F%2Fwww.cryptocoinsnews.com%2Fjohn-mcafee-led-mgt-capital-raises-2-4-million-boost-bitcoin-mining%2F&amp;title=John+McAfee-Led+MGT+Capital+Raises+%242.4+Million+to+Boost+Bitcoin+Mining+Operation\" target=\"_blank\" rel=\"nofollow\"><span class=\"icon\"></span><span class=\"text\">Weibo</span></a>\r\n       <div class=\"onoffswitch2 mash-large mashsb-noshadow\" style=\"display:none;\"></div>\r\n      </div> \r\n     </div> \r\n     <div style=\"clear:both;\"></div>\r\n    </aside> \r\n    <em><a href=\"https://hacked.com\">Get Trading Recommendations and Read Analysis on Hacked.com for just $39 per month.</a></em>\r\n    <br>\r\n    <br>\r\n    <p>MGT Capital, a tech company that engages in hydro-powered bitcoin mining has raised $2.4 million in a new round of financing.</p> \r\n    <p>In an announcement, the firm said the round of financing will help to \u201Cmaterially ramp up its bitcoin mining operations\u201D. The financing comes following a 10% convertible note issued to UAHC Ventures, an investing firm. The note is self-amortizing with a ceiling repayment of $160,000 per month.</p> \r\n    <p>The new financing comes at a time when the company is constructing its third mining location in Washington state, with plans to deploy new mining rigs in the facility by early October 2017. A resource-hungry process reliant on large amounts of electric power, bitcoin mining results in new transactions added to the bitcoin blockchain. Currently, bitcoin miners are rewarded 12 bitcoins ($50,000) for creating the next transaction block in the chain.</p> \r\n    <p>As <a href=\"https://www.cryptocoinsnews.com/john-mcafee-mgt-bitcoin-mining/\">reported earlier</a>, MGT capital secured a location in central Washington with low-cost hydro power resources in the vicinity to launch its mining operation in July 2016. Come September, the company announced it had <a href=\"https://www.cryptocoinsnews.com/john-mcafee-led-mgt-capital-mining-90-bitcoins-month/\">completed its first phase</a> of operations at a time when it was mining 90 bitcoins a month. With \u2018phase two\u2019 of its operation, the company ramped up its processing power from 2 PetaHash at launch to <a href=\"https://www.cryptocoinsnews.com/john-mcafee-led-bitcoin-mining-operation-aims-to-scale-5-petahash-in-2016/\">upwards of 5 PetaHash</a> by the end of the year.</p> \r\n    <p>Last week, MGT announced the deployment of 650 new bitcoin mining rigs. The Bitmain 29 units will be installed at \u201Ca new multi MegaWatt facility\u201D in central Washington, with production expected to reach maximum capacity by the end of the month.</p>\r\n    <div class=\"MYMD5JTj\" style=\"clear:both;float:left;width:100%;margin:0 0 20px 0;\">\r\n     <div class=\"mobile\">\r\n      <br>\r\n      <center>\r\n       <font size=\"1\">Advertisement:</font>\r\n       <br> \r\n       <div id=\"div-gpt-ad-1502707715006-0\" style=\"height:60px; width:468px;\"> \r\n        <script>\r\ngoogletag.cmd.push(function() { googletag.display('div-gpt-ad-1502707715006-0'); });\r\n</script> \r\n       </div>\r\n      </center>\r\n      <br>\r\n     </div>\r\n    </div> \r\n    <p>\u201CWith the recent highs of $4,500 per bitcoin, the business of mining is as profitable as ever,\u201D stated newly appointed president of MGT Crypto-Capital Stephen Schaeffer.</p> \r\n    <p>Earlier in June, John McAfee, CEO of MGT Capital, announced the company\u2019s decision to <a href=\"https://www.cryptocoinsnews.com/john-mcafees-investment-company-to-start-mining-ethereum/\">mine Ethereum</a> alongside bitcoin.</p> \r\n    <p>\u201CWe will definitely be profitable before the end of the year,\u201D revealed McAfee in an interview to Bloomberg. \u201CFrom bitcoin mining, we will get the experience and expertise to apply the blockchain to our security products.\u201D One of those security products being developed includes <a href=\"http://www.newsweek.com/john-mcafee-privacy-phone-smartphone-590373\">a smartphone titled the \u2018Privacy Phone\u2019</a>.</p> \r\n    <p>McAfee also dismissed recent chatter of bitcoin prices being in the midst of a bubble period<a href=\"https://www.cryptocoinsnews.com/john-mcafee-bitcoin-price-bubble-talk-absurd/\">, calling such talk \u2018absurd\u2019</a>. &nbsp;In keeping with his bullish tone, McAfee sees bitcoin prices reaching $500,000 by 2020.</p> \r\n    <p><em>Featured image from Shutterstock.</em></p> \r\n    <div class=\"mobile\">\r\n     Advertisement:\r\n     <br>\r\n     <a href=\"http://bit.ly/2tRw13o\" rel=\"nofollow\" target=\"blank\"><img src=\"https://www.cryptocoinsnews.com/wp-content/uploads/2017/07/728X90.gif\"></a> \r\n    </div> \r\n    <div class=\"showmobile\">\r\n      Advertisement:\r\n     <br> \r\n     <div id=\"div-gpt-ad-1501693332436-0\" style=\"height:100px; width:300px;\"> \r\n      <script>\r\ngoogletag.cmd.push(function() { googletag.display('div-gpt-ad-1501693332436-0'); });\r\n</script> \r\n     </div>\r\n    </div>\r\n    <aside class=\"mashsb-container mashsb-main \">\r\n     <div class=\"mashsb-box\">\r\n      <div class=\"mashsb-buttons\">\r\n       <a class=\"mashicon-twitter mash-large mash-nomargin mashsb-noshadow\" href=\"https://twitter.com/intent/tweet?text=John%20McAfee-Led%20MGT%20Capital%20Raises%20%242.4%20Million%20to%20Boost%20Bitcoin%20Mining%20Operation&amp;url=https://www.cryptocoinsnews.com/?p=114036&amp;via=CryptoCoinsNews\" target=\"_blank\" rel=\"nofollow\"><span class=\"icon\"></span><span class=\"text\">Twitter</span></a>\r\n       <a class=\"mashicon-linkedin  mash-large mash-nomargin mashsb-noshadow\" href=\"https://www.linkedin.com/shareArticle?trk=John+McAfee-Led+MGT+Capital+Raises+%242.4+Million+to+Boost+Bitcoin+Mining+Operation&amp;url=https%3A%2F%2Fwww.cryptocoinsnews.com%2Fjohn-mcafee-led-mgt-capital-raises-2-4-million-boost-bitcoin-mining%2F\" target=\"_blank\" rel=\"nofollow\"><span class=\"icon\"></span><span class=\"text\">Linkedin </span></a>\r\n       <a class=\"mashicon-facebook mash-large mash-nomargin mashsb-noshadow\" href=\"https://www.facebook.com/sharer.php?u=https%3A%2F%2Fwww.cryptocoinsnews.com%2Fjohn-mcafee-led-mgt-capital-raises-2-4-million-boost-bitcoin-mining%2F\" target=\"_blank\" rel=\"nofollow\"><span class=\"icon\"></span><span class=\"text\">Facebook</span></a>\r\n       <a class=\"mashicon-reddit  mash-large mash-nomargin mashsb-noshadow\" href=\"http://www.reddit.com/submit?url=https%3A%2F%2Fwww.cryptocoinsnews.com%2Fjohn-mcafee-led-mgt-capital-raises-2-4-million-boost-bitcoin-mining%2F&amp;title=John+McAfee-Led+MGT+Capital+Raises+%242.4+Million+to+Boost+Bitcoin+Mining+Operation\" target=\"_blank\" rel=\"nofollow\"><span class=\"icon\"></span><span class=\"text\">Reddit </span></a>\r\n       <a class=\"mashicon-weibo mash-large mash-nomargin mashsb-noshadow\" href=\"http://service.weibo.com/share/share.php?url=https%3A%2F%2Fwww.cryptocoinsnews.com%2Fjohn-mcafee-led-mgt-capital-raises-2-4-million-boost-bitcoin-mining%2F&amp;title=John+McAfee-Led+MGT+Capital+Raises+%242.4+Million+to+Boost+Bitcoin+Mining+Operation\" target=\"_blank\" rel=\"nofollow\"><span class=\"icon\"></span><span class=\"text\">Weibo</span></a>\r\n       <div class=\"onoffswitch2 mash-large mashsb-noshadow\" style=\"display:none;\"></div>\r\n      </div> \r\n     </div> \r\n     <div style=\"clear:both;\"></div>\r\n    </aside> \r\n   </div> \r\n   <div class=\"entry-meta\"> \r\n    <ul class=\"meta-list\"> \r\n     <li class=\"meta-cat\"> <span>Posted in:</span> <a href=\"https://www.cryptocoinsnews.com/bitcoin-investment/\" rel=\"category tag\">Bitcoin &amp; Blockchain Investments</a>, <a href=\"https://www.cryptocoinsnews.com/bitcoin-mining/\" rel=\"category tag\">Bitcoin Mining</a>, <a href=\"https://www.cryptocoinsnews.com/news/\" rel=\"category tag\">News</a> </li> \r\n     <li class=\"meta-tag\"> <span>Tagged in:</span> <a href=\"https://www.cryptocoinsnews.com/tag/mgt-capital/\" rel=\"tag\">MGT Capital</a> </li> \r\n    </ul> \r\n   </div> \r\n  </article> \r\n  <div class=\"author-profile\"> \r\n   <a class=\"author-profile-avatar\" href=\"https://www.cryptocoinsnews.com/author/samburaj-das/\" title=\"Posts by Samburaj Das\"></a> \r\n   <div class=\"author-profile-info\"> \r\n    <h3 class=\"author-profile-title\"> Posted by Samburaj Das</h3> \r\n    <div class=\"author-profile-links\"> \r\n     <a href=\"https://www.cryptocoinsnews.com/author/samburaj-das/\"><i class=\"fa fa-pencil-square\"></i> All Posts</a> \r\n    </div> \r\n   </div> \r\n  </div> \r\n  <div class=\"share-comment click\"> \r\n   <a class=\"comments-toggle button\" href=\"#\"> <span><i class=\"fa fa-comments\"></i> Leave a comment </span> <span><i class=\"fa fa-times\"></i> Hide comments</span> </a> \r\n  </div> \r\n  <div class=\"dcl-disqus-thread\" id=\"comments\"> \r\n   <div id=\"disqus_thread\"> \r\n   </div> \r\n  </div> \r\n  <script type=\"text/javascript\">\r\n\t/* <![CDATA[ */\r\n\t\tvar disqus_url = 'https://www.cryptocoinsnews.com/john-mcafee-led-mgt-capital-raises-2-4-million-boost-bitcoin-mining/';\r\n\t\tvar disqus_identifier = '114036 https://www.cryptocoinsnews.com/?p=114036';\r\n\t\tvar disqus_container_id = 'disqus_thread';\r\n\t\tvar disqus_domain = 'disqus.com';\r\n\t\tvar disqus_shortname = 'cryptocoinsnews';\r\n\t\tvar disqus_title = \"John McAfee-Led MGT Capital Raises $2.4 Million to Boost Bitcoin Mining Operation\";\r\n\t\tvar disqus_config = function () {\r\n\t\t\tvar config = this; // Access to the config object\r\n\t\t\tconfig.language = '';\r\n\r\n\t\t\t/* Add the ability to add javascript callbacks */\r\n\t\t\t\r\n\t\t\t/*\r\n\t\t\t   All currently supported events:\r\n\t\t\t\t* preData \u2014 fires just before we request for initial data\r\n\t\t\t\t* preInit - fires after we get initial data but before we load any dependencies\r\n\t\t\t\t* onInit  - fires when all dependencies are resolved but before dtpl template is rendered\r\n\t\t\t\t* afterRender - fires when template is rendered but before we show it\r\n\t\t\t\t* onReady - everything is done\r\n\t\t\t */\r\n\r\n\t\t\tconfig.callbacks.preData.push(function() {\r\n\t\t\t\t// clear out the container (its filled for SEO/legacy purposes)\r\n\t\t\t\tdocument.getElementById(disqus_container_id).innerHTML = '';\r\n\t\t\t});\r\n\t\t\t\t\t\t\t\t};\r\n\t/* ]]> */\r\n\t</script> \r\n  <script type=\"text/javascript\">\r\n\t/* <![CDATA[ */\r\n\t\tvar DsqLocal = {\r\n\t\t\t'trackbacks': [\r\n\t\t\t\t],\r\n\t\t\t'trackback_url': \"https:\\/\\/www.cryptocoinsnews.com\\/john-mcafee-led-mgt-capital-raises-2-4-million-boost-bitcoin-mining\\/trackback\\/\"\t\t};\r\n\t/* ]]> */\r\n\t</script> \r\n </main> \r\n</div>\r\n";
	private static List<String> NOT_CLEAN_TAGS = new ArrayList<>(Arrays.asList("Altcoin News", " News ", " Ripple News"));	
	
	
	@Test
	public void testClean () {
		News news = new News();
		news.text = NOT_CLEAN;	
		news.tags = NOT_CLEAN_TAGS;
		new CryptocoinsnewsCleaner().clean(news);
		System.out.println(news.cleanText);
		System.out.println(news.cleanTags);	
	}
}
