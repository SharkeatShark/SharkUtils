package com.shark;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.*;

public class AlibabaJson {

	public static void main(String[] args) {
		String tags = "{\r\n" + 
				"		        \"list\": [\r\n" + 
				"		            {\r\n" + 
				"		                \"id\": 6,\r\n" + 
				"		                \"productId\": \"542655350126\",\r\n" + 
				"		                \"productCode\": null,\r\n" + 
				"		                \"productName\": \"童装/女童 短裤(3件装) 189005 优衣库UNIQLO\",\r\n" + 
				"		                \"productMainCover\": null,\r\n" + 
				"		                \"productFeature\": null,\r\n" + 
				"		                \"price\": null,\r\n" + 
				"		                \"color\": null,\r\n" + 
				"		                \"texture\": null,\r\n" + 
				"		                \"size\": null,\r\n" + 
				"		                \"state\": 1,\r\n" + 
				"		                \"style1\": null,\r\n" + 
				"		                \"createTime\": null,\r\n" + 
				"		                \"sizeList\": null,\r\n" + 
				"		                \"productTag\": null,\r\n" + 
				"		                \"intro\": \"<p>不易影响下装外观的低腰短裤。纯色与印花图案设计的3件装组合。 ·采用肌肤触感柔软的棉质面料制成，具有舒适的穿着感受。 ·纯色、格纹等图案设计的3件装。 ·清爽的配色是其魅力所在。 ·浅裆低腰的设计，适合与低腰下装搭配穿着。</p>\",\r\n" + 
				"		                \"sort\": null,\r\n" + 
				"		                \"effective\": null,\r\n" + 
				"		                \"timestamp\": null,\r\n" + 
				"		                \"fresh\": null,\r\n" + 
				"		                \"sku\": null,\r\n" + 
				"		                \"allTags\": [\r\n" + 
				"		                    {\r\n" + 
				"		                        \"id\": 2236,\r\n" + 
				"		                        \"name\": \"下装\",\r\n" + 
				"		                        \"level\": null,\r\n" + 
				"		                        \"synonym\": null,\r\n" + 
				"		                        \"nameOr\": null,\r\n" + 
				"		                        \"nameAnd\": null,\r\n" + 
				"		                        \"nameNot\": null,\r\n" + 
				"		                        \"sort\": null,\r\n" + 
				"		                        \"count\": null,\r\n" + 
				"		                        \"pinyin\": null,\r\n" + 
				"		                        \"level1\": null\r\n" + 
				"		                    },\r\n" + 
				"		                    {\r\n" + 
				"		                        \"id\": 88,\r\n" + 
				"		                        \"name\": \"低腰\",\r\n" + 
				"		                        \"level\": null,\r\n" + 
				"		                        \"synonym\": null,\r\n" + 
				"		                        \"nameOr\": null,\r\n" + 
				"		                        \"nameAnd\": null,\r\n" + 
				"		                        \"nameNot\": null,\r\n" + 
				"		                        \"sort\": null,\r\n" + 
				"		                        \"count\": null,\r\n" + 
				"		                        \"pinyin\": null,\r\n" + 
				"		                        \"level1\": null\r\n" + 
				"		                    },\r\n" + 
				"		                    {\r\n" + 
				"		                        \"id\": 16,\r\n" + 
				"		                        \"name\": \"短裤\",\r\n" + 
				"		                        \"level\": null,\r\n" + 
				"		                        \"synonym\": null,\r\n" + 
				"		                        \"nameOr\": null,\r\n" + 
				"		                        \"nameAnd\": null,\r\n" + 
				"		                        \"nameNot\": null,\r\n" + 
				"		                        \"sort\": null,\r\n" + 
				"		                        \"count\": null,\r\n" + 
				"		                        \"pinyin\": null,\r\n" + 
				"		                        \"level1\": null\r\n" + 
				"		                    }\r\n" + 
				"		                ],\r\n" + 
				"		                \"allJudgeTags\": [\r\n" + 
				"		                    {\r\n" + 
				"		                        \"judgeId\": 1649,\r\n" + 
				"		                        \"content\": \"--不易影响下装外观的低腰短裤。\",\r\n" + 
				"		                        \"proId\": \"542655350126\",\r\n" + 
				"		                        \"tagId\": 2236,\r\n" + 
				"		                        \"state\": 1\r\n" + 
				"		                    },\r\n" + 
				"		                    {\r\n" + 
				"		                        \"judgeId\": 1650,\r\n" + 
				"		                        \"content\": \"--不易影响下装外观的低腰短裤。\",\r\n" + 
				"		                        \"proId\": \"542655350126\",\r\n" + 
				"		                        \"tagId\": 88,\r\n" + 
				"		                        \"state\": 1\r\n" + 
				"		                    },\r\n" + 
				"		                    {\r\n" + 
				"		                        \"judgeId\": 1651,\r\n" + 
				"		                        \"content\": \"--不易影响下装外观的低腰短裤。\",\r\n" + 
				"		                        \"proId\": \"542655350126\",\r\n" + 
				"		                        \"tagId\": 16,\r\n" + 
				"		                        \"state\": 1\r\n" + 
				"		                    }\r\n" + 
				"		                ]\r\n" + 
				"		            },\r\n" + 
				"		            {\r\n" + 
				"		                \"id\": 19,\r\n" + 
				"		                \"productId\": \"553971322953\",\r\n" + 
				"		                \"productCode\": null,\r\n" + 
				"		                \"productName\": \"童装/男童 袜子(2双装) 400904 优衣库UNIQLO\",\r\n" + 
				"		                \"productMainCover\": null,\r\n" + 
				"		                \"productFeature\": null,\r\n" + 
				"		                \"price\": null,\r\n" + 
				"		                \"color\": null,\r\n" + 
				"		                \"texture\": null,\r\n" + 
				"		                \"size\": null,\r\n" + 
				"		                \"state\": 1,\r\n" + 
				"		                \"style1\": null,\r\n" + 
				"		                \"createTime\": null,\r\n" + 
				"		                \"sizeList\": null,\r\n" + 
				"		                \"productTag\": null,\r\n" + 
				"		                \"intro\": \"<p>长度稍短的中筒袜。线条图案与条纹图案2双装。 ·不易滑落，舒适贴合后跟与脚心。 ·在易感到负担的指尖和脚心追加了缓冲起绒设计。 ·适合活泼好动的孩童在玩耍时穿着。 ·适合与中裤搭配穿着的中筒长度。 ·宽窄不一的线条与条纹图案2双装。</p>\",\r\n" + 
				"		                \"sort\": null,\r\n" + 
				"		                \"effective\": null,\r\n" + 
				"		                \"timestamp\": null,\r\n" + 
				"		                \"fresh\": null,\r\n" + 
				"		                \"sku\": null,\r\n" + 
				"		                \"allTags\": [\r\n" + 
				"		                    {\r\n" + 
				"		                        \"id\": 619,\r\n" + 
				"		                        \"name\": \"舒适\",\r\n" + 
				"		                        \"level\": null,\r\n" + 
				"		                        \"synonym\": null,\r\n" + 
				"		                        \"nameOr\": null,\r\n" + 
				"		                        \"nameAnd\": null,\r\n" + 
				"		                        \"nameNot\": null,\r\n" + 
				"		                        \"sort\": null,\r\n" + 
				"		                        \"count\": null,\r\n" + 
				"		                        \"pinyin\": null,\r\n" + 
				"		                        \"level1\": null\r\n" + 
				"		                    },\r\n" + 
				"		                    {\r\n" + 
				"		                        \"id\": 53,\r\n" + 
				"		                        \"name\": \"AIRism\",\r\n" + 
				"		                        \"level\": null,\r\n" + 
				"		                        \"synonym\": null,\r\n" + 
				"		                        \"nameOr\": null,\r\n" + 
				"		                        \"nameAnd\": null,\r\n" + 
				"		                        \"nameNot\": null,\r\n" + 
				"		                        \"sort\": null,\r\n" + 
				"		                        \"count\": null,\r\n" + 
				"		                        \"pinyin\": null,\r\n" + 
				"		                        \"level1\": null\r\n" + 
				"		                    }\r\n" + 
				"		                ],\r\n" + 
				"		                \"allJudgeTags\": [\r\n" + 
				"		                    {\r\n" + 
				"		                        \"judgeId\": 1654,\r\n" + 
				"		                        \"content\": \"--不易滑落，舒适贴合后跟与脚心。\",\r\n" + 
				"		                        \"proId\": \"553971322953\",\r\n" + 
				"		                        \"tagId\": 619,\r\n" + 
				"		                        \"state\": 1\r\n" + 
				"		                    },\r\n" + 
				"		                    {\r\n" + 
				"		                        \"judgeId\": 1655,\r\n" + 
				"		                        \"content\": \"--不易滑落，舒适贴合后跟与脚心。\",\r\n" + 
				"		                        \"proId\": \"553971322953\",\r\n" + 
				"		                        \"tagId\": 53,\r\n" + 
				"		                        \"state\": 1\r\n" + 
				"		                    }\r\n" + 
				"		                ]\r\n" + 
				"		            },\r\n" + 
				"		            {\r\n" + 
				"		                \"id\": 20,\r\n" + 
				"		                \"productId\": \"553973506998\",\r\n" + 
				"		                \"productCode\": null,\r\n" + 
				"		                \"productName\": \"童装/男童 袜子(2双装) 400902 优衣库UNIQLO\",\r\n" + 
				"		                \"productMainCover\": null,\r\n" + 
				"		                \"productFeature\": null,\r\n" + 
				"		                \"price\": null,\r\n" + 
				"		                \"color\": null,\r\n" + 
				"		                \"texture\": null,\r\n" + 
				"		                \"size\": null,\r\n" + 
				"		                \"state\": 1,\r\n" + 
				"		                \"style1\": null,\r\n" + 
				"		                \"createTime\": null,\r\n" + 
				"		                \"sizeList\": null,\r\n" + 
				"		                \"productTag\": null,\r\n" + 
				"		                \"intro\": \"<p>质地结实的袜子。条纹图案与附带线条设计的彩色拼块2双装。 ·不易滑落，舒适贴合后跟与脚心。 ·在易感到负担的指尖和脚心追加了缓冲起绒设计。 ·适合活泼好动的孩童在玩耍时穿着。 ·经典的条纹图案与附带线条设计的彩色拼块2双装。</p>\",\r\n" + 
				"		                \"sort\": null,\r\n" + 
				"		                \"effective\": null,\r\n" + 
				"		                \"timestamp\": null,\r\n" + 
				"		                \"fresh\": null,\r\n" + 
				"		                \"sku\": null,\r\n" + 
				"		                \"allTags\": [\r\n" + 
				"		                    {\r\n" + 
				"		                        \"id\": 619,\r\n" + 
				"		                        \"name\": \"舒适\",\r\n" + 
				"		                        \"level\": null,\r\n" + 
				"		                        \"synonym\": null,\r\n" + 
				"		                        \"nameOr\": null,\r\n" + 
				"		                        \"nameAnd\": null,\r\n" + 
				"		                        \"nameNot\": null,\r\n" + 
				"		                        \"sort\": null,\r\n" + 
				"		                        \"count\": null,\r\n" + 
				"		                        \"pinyin\": null,\r\n" + 
				"		                        \"level1\": null\r\n" + 
				"		                    },\r\n" + 
				"		                    {\r\n" + 
				"		                        \"id\": 53,\r\n" + 
				"		                        \"name\": \"AIRism\",\r\n" + 
				"		                        \"level\": null,\r\n" + 
				"		                        \"synonym\": null,\r\n" + 
				"		                        \"nameOr\": null,\r\n" + 
				"		                        \"nameAnd\": null,\r\n" + 
				"		                        \"nameNot\": null,\r\n" + 
				"		                        \"sort\": null,\r\n" + 
				"		                        \"count\": null,\r\n" + 
				"		                        \"pinyin\": null,\r\n" + 
				"		                        \"level1\": null\r\n" + 
				"		                    }\r\n" + 
				"		                ],\r\n" + 
				"		                \"allJudgeTags\": [\r\n" + 
				"		                    {\r\n" + 
				"		                        \"judgeId\": 1656,\r\n" + 
				"		                        \"content\": \"--不易滑落，舒适贴合后跟与脚心。\",\r\n" + 
				"		                        \"proId\": \"553973506998\",\r\n" + 
				"		                        \"tagId\": 619,\r\n" + 
				"		                        \"state\": 1\r\n" + 
				"		                    },\r\n" + 
				"		                    {\r\n" + 
				"		                        \"judgeId\": 1657,\r\n" + 
				"		                        \"content\": \"--不易滑落，舒适贴合后跟与脚心。\",\r\n" + 
				"		                        \"proId\": \"553973506998\",\r\n" + 
				"		                        \"tagId\": 53,\r\n" + 
				"		                        \"state\": 1\r\n" + 
				"		                    }\r\n" + 
				"		                ]\r\n" + 
				"		            },\r\n" + 
				"		            {\r\n" + 
				"		                \"id\": 25,\r\n" + 
				"		                \"productId\": \"544446322122\",\r\n" + 
				"		                \"productCode\": null,\r\n" + 
				"		                \"productName\": \"【特别尺码】男装 AIRism V领T恤(短袖) 182486 优衣库UNIQLO\",\r\n" + 
				"		                \"productMainCover\": null,\r\n" + 
				"		                \"productFeature\": null,\r\n" + 
				"		                \"price\": null,\r\n" + 
				"		                \"color\": null,\r\n" + 
				"		                \"texture\": null,\r\n" + 
				"		                \"size\": null,\r\n" + 
				"		                \"state\": 1,\r\n" + 
				"		                \"style1\": null,\r\n" + 
				"		                \"createTime\": null,\r\n" + 
				"		                \"sizeList\": null,\r\n" + 
				"		                \"productTag\": null,\r\n" + 
				"		                \"intro\": \"<p>质地轻盈，颇具透气性与速干性！不易从衬衫领口中露出的V领与短袖设计。 ·质地轻盈且颇具透气性与速干性，呈现更为舒适的穿着感受。 ·纤细纤维可带来细腻、柔美的肌肤触感。 ·附带吸汗速干的快干功能。 ·深V领的款式，敞开衬衫领口穿着也不易露出。 ·轻爽的短袖样式。</p>\",\r\n" + 
				"		                \"sort\": null,\r\n" + 
				"		                \"effective\": null,\r\n" + 
				"		                \"timestamp\": null,\r\n" + 
				"		                \"fresh\": null,\r\n" + 
				"		                \"sku\": null,\r\n" + 
				"		                \"allTags\": [\r\n" + 
				"		                    {\r\n" + 
				"		                        \"id\": 46,\r\n" + 
				"		                        \"name\": \"短袖\",\r\n" + 
				"		                        \"level\": null,\r\n" + 
				"		                        \"synonym\": null,\r\n" + 
				"		                        \"nameOr\": null,\r\n" + 
				"		                        \"nameAnd\": null,\r\n" + 
				"		                        \"nameNot\": null,\r\n" + 
				"		                        \"sort\": null,\r\n" + 
				"		                        \"count\": null,\r\n" + 
				"		                        \"pinyin\": null,\r\n" + 
				"		                        \"level1\": null\r\n" + 
				"		                    }\r\n" + 
				"		                ],\r\n" + 
				"		                \"allJudgeTags\": [\r\n" + 
				"		                    {\r\n" + 
				"		                        \"judgeId\": 1658,\r\n" + 
				"		                        \"content\": \"--不易从衬衫领口中露出的V领与短袖设计。\\r\\n--不易露出。\",\r\n" + 
				"		                        \"proId\": \"544446322122\",\r\n" + 
				"		                        \"tagId\": 46,\r\n" + 
				"		                        \"state\": 1\r\n" + 
				"		                    }\r\n" + 
				"		                ]\r\n" + 
				"		            },\r\n" + 
				"		            {\r\n" + 
				"		                \"id\": 30,\r\n" + 
				"		                \"productId\": \"554936666366\",\r\n" + 
				"		                \"productCode\": null,\r\n" + 
				"		                \"productName\": \"男装 精纺条纹衬衫(长袖) 401824 优衣库UNIQLO\",\r\n" + 
				"		                \"productMainCover\": null,\r\n" + 
				"		                \"productFeature\": null,\r\n" + 
				"		                \"price\": null,\r\n" + 
				"		                \"color\": null,\r\n" + 
				"		                \"texture\": null,\r\n" + 
				"		                \"size\": null,\r\n" + 
				"		                \"state\": 1,\r\n" + 
				"		                \"style1\": null,\r\n" + 
				"		                \"createTime\": null,\r\n" + 
				"		                \"sizeList\": null,\r\n" + 
				"		                \"productTag\": null,\r\n" + 
				"		                \"intro\": \"<p>面料、缝纫、做工、设计都较为考究！便于打理的优质棉质衬衫。 ·采用质地柔软、优美的棉质面料制成。 ·采用纤维纤细的面料制成，呈现出柔美、上乘的质地。 ·施有易护理加工，洗后不易起皱，简单熨烫后即可穿着。 ·稍大的口袋，可放入ID卡和护照。 ·经典、百搭的标准领设计。 ·配色优雅的双条纹图案，商务休闲两相宜。</p>\",\r\n" + 
				"		                \"sort\": null,\r\n" + 
				"		                \"effective\": null,\r\n" + 
				"		                \"timestamp\": null,\r\n" + 
				"		                \"fresh\": null,\r\n" + 
				"		                \"sku\": null,\r\n" + 
				"		                \"allTags\": [\r\n" + 
				"		                    {\r\n" + 
				"		                        \"id\": 647,\r\n" + 
				"		                        \"name\": \"简约\",\r\n" + 
				"		                        \"level\": null,\r\n" + 
				"		                        \"synonym\": null,\r\n" + 
				"		                        \"nameOr\": null,\r\n" + 
				"		                        \"nameAnd\": null,\r\n" + 
				"		                        \"nameNot\": null,\r\n" + 
				"		                        \"sort\": null,\r\n" + 
				"		                        \"count\": null,\r\n" + 
				"		                        \"pinyin\": null,\r\n" + 
				"		                        \"level1\": null\r\n" + 
				"		                    },\r\n" + 
				"		                    {\r\n" + 
				"		                        \"id\": 980,\r\n" + 
				"		                        \"name\": \"简洁\",\r\n" + 
				"		                        \"level\": null,\r\n" + 
				"		                        \"synonym\": null,\r\n" + 
				"		                        \"nameOr\": null,\r\n" + 
				"		                        \"nameAnd\": null,\r\n" + 
				"		                        \"nameNot\": null,\r\n" + 
				"		                        \"sort\": null,\r\n" + 
				"		                        \"count\": null,\r\n" + 
				"		                        \"pinyin\": null,\r\n" + 
				"		                        \"level1\": null\r\n" + 
				"		                    }\r\n" + 
				"		                ],\r\n" + 
				"		                \"allJudgeTags\": [\r\n" + 
				"		                    {\r\n" + 
				"		                        \"judgeId\": 1659,\r\n" + 
				"		                        \"content\": \"--不易起皱，简单熨烫后即可穿着。\",\r\n" + 
				"		                        \"proId\": \"554936666366\",\r\n" + 
				"		                        \"tagId\": 647,\r\n" + 
				"		                        \"state\": 1\r\n" + 
				"		                    },\r\n" + 
				"		                    {\r\n" + 
				"		                        \"judgeId\": 1660,\r\n" + 
				"		                        \"content\": \"--不易起皱，简单熨烫后即可穿着。\",\r\n" + 
				"		                        \"proId\": \"554936666366\",\r\n" + 
				"		                        \"tagId\": 980,\r\n" + 
				"		                        \"state\": 1\r\n" + 
				"		                    }\r\n" + 
				"		                ]\r\n" + 
				"		            },\r\n" + 
				"		            {\r\n" + 
				"		                \"id\": 39,\r\n" + 
				"		                \"productId\": \"544541897466\",\r\n" + 
				"		                \"productCode\": null,\r\n" + 
				"		                \"productName\": \"女装 短裤(无缝) 197323 优衣库UNIQLO\",\r\n" + 
				"		                \"productMainCover\": null,\r\n" + 
				"		                \"productFeature\": null,\r\n" + 
				"		                \"price\": null,\r\n" + 
				"		                \"color\": null,\r\n" + 
				"		                \"texture\": null,\r\n" + 
				"		                \"size\": null,\r\n" + 
				"		                \"state\": 1,\r\n" + 
				"		                \"style1\": null,\r\n" + 
				"		                \"createTime\": null,\r\n" + 
				"		                \"sizeList\": null,\r\n" + 
				"		                \"productTag\": null,\r\n" + 
				"		                \"intro\": \"<p>无缝的设计与出众的贴合感是其魅力所在。款型利落的短裤。 ·质地轻薄，具有舒适的贴身穿着感。 ·无缝的款式，轻柔舒适贴合肌肤。 ·裆部采用穿着柔和的面料制成。 ·线缝较为平坦，不易影响下装外观。 ·比基尼款型的设计，即使搭配轻薄下装穿着也不易露出痕迹。杂色风格的配色，凸显自然风情。 ·适合与轻型文胸搭配成套穿着。</p>\",\r\n" + 
				"		                \"sort\": null,\r\n" + 
				"		                \"effective\": null,\r\n" + 
				"		                \"timestamp\": null,\r\n" + 
				"		                \"fresh\": null,\r\n" + 
				"		                \"sku\": null,\r\n" + 
				"		                \"allTags\": [\r\n" + 
				"		                    {\r\n" + 
				"		                        \"id\": 2236,\r\n" + 
				"		                        \"name\": \"下装\",\r\n" + 
				"		                        \"level\": null,\r\n" + 
				"		                        \"synonym\": null,\r\n" + 
				"		                        \"nameOr\": null,\r\n" + 
				"		                        \"nameAnd\": null,\r\n" + 
				"		                        \"nameNot\": null,\r\n" + 
				"		                        \"sort\": null,\r\n" + 
				"		                        \"count\": null,\r\n" + 
				"		                        \"pinyin\": null,\r\n" + 
				"		                        \"level1\": null\r\n" + 
				"		                    }\r\n" + 
				"		                ],\r\n" + 
				"		                \"allJudgeTags\": [\r\n" + 
				"		                    {\r\n" + 
				"		                        \"judgeId\": 1661,\r\n" + 
				"		                        \"content\": \"--不易影响下装外观。\\r\\n--不易露出痕迹。\",\r\n" + 
				"		                        \"proId\": \"544541897466\",\r\n" + 
				"		                        \"tagId\": 2236,\r\n" + 
				"		                        \"state\": 1\r\n" + 
				"		                    }\r\n" + 
				"		                ]\r\n" + 
				"		            },\r\n" + 
				"		            {\r\n" + 
				"		                \"id\": 40,\r\n" + 
				"		                \"productId\": \"555327409232\",\r\n" + 
				"		                \"productCode\": null,\r\n" + 
				"		                \"productName\": \"男装 精纺府绸衬衫(长袖) 401362 优衣库UNIQLO\",\r\n" + 
				"		                \"productMainCover\": null,\r\n" + 
				"		                \"productFeature\": null,\r\n" + 
				"		                \"price\": null,\r\n" + 
				"		                \"color\": null,\r\n" + 
				"		                \"texture\": null,\r\n" + 
				"		                \"size\": null,\r\n" + 
				"		                \"state\": 1,\r\n" + 
				"		                \"style1\": null,\r\n" + 
				"		                \"createTime\": null,\r\n" + 
				"		                \"sizeList\": null,\r\n" + 
				"		                \"productTag\": null,\r\n" + 
				"		                \"intro\": \"<p>采用优质棉质面料制成的简约衬衫。商务休闲两相宜。 ·采用质地柔软、优美的棉质面料制成。 ·采用纤维纤细的面料制成，呈现出柔美、上乘的质地。 ·施有易护理加工，洗后不易起皱，简单熨烫后即可穿着。 ·经典的款型，适合多个年龄层穿着。 ·纯色与标准领的样式，凸显简约。 ·是一款适合在多种场合穿搭的百搭单品。</p>\",\r\n" + 
				"		                \"sort\": null,\r\n" + 
				"		                \"effective\": null,\r\n" + 
				"		                \"timestamp\": null,\r\n" + 
				"		                \"fresh\": null,\r\n" + 
				"		                \"sku\": null,\r\n" + 
				"		                \"allTags\": [\r\n" + 
				"		                    {\r\n" + 
				"		                        \"id\": 647,\r\n" + 
				"		                        \"name\": \"简约\",\r\n" + 
				"		                        \"level\": null,\r\n" + 
				"		                        \"synonym\": null,\r\n" + 
				"		                        \"nameOr\": null,\r\n" + 
				"		                        \"nameAnd\": null,\r\n" + 
				"		                        \"nameNot\": null,\r\n" + 
				"		                        \"sort\": null,\r\n" + 
				"		                        \"count\": null,\r\n" + 
				"		                        \"pinyin\": null,\r\n" + 
				"		                        \"level1\": null\r\n" + 
				"		                    },\r\n" + 
				"		                    {\r\n" + 
				"		                        \"id\": 980,\r\n" + 
				"		                        \"name\": \"简洁\",\r\n" + 
				"		                        \"level\": null,\r\n" + 
				"		                        \"synonym\": null,\r\n" + 
				"		                        \"nameOr\": null,\r\n" + 
				"		                        \"nameAnd\": null,\r\n" + 
				"		                        \"nameNot\": null,\r\n" + 
				"		                        \"sort\": null,\r\n" + 
				"		                        \"count\": null,\r\n" + 
				"		                        \"pinyin\": null,\r\n" + 
				"		                        \"level1\": null\r\n" + 
				"		                    }\r\n" + 
				"		                ],\r\n" + 
				"		                \"allJudgeTags\": [\r\n" + 
				"		                    {\r\n" + 
				"		                        \"judgeId\": 1662,\r\n" + 
				"		                        \"content\": \"--不易起皱，简单熨烫后即可穿着。\",\r\n" + 
				"		                        \"proId\": \"555327409232\",\r\n" + 
				"		                        \"tagId\": 647,\r\n" + 
				"		                        \"state\": 1\r\n" + 
				"		                    },\r\n" + 
				"		                    {\r\n" + 
				"		                        \"judgeId\": 1663,\r\n" + 
				"		                        \"content\": \"--不易起皱，简单熨烫后即可穿着。\",\r\n" + 
				"		                        \"proId\": \"555327409232\",\r\n" + 
				"		                        \"tagId\": 980,\r\n" + 
				"		                        \"state\": 1\r\n" + 
				"		                    }\r\n" + 
				"		                ]\r\n" + 
				"		            },\r\n" + 
				"		            {\r\n" + 
				"		                \"id\": 41,\r\n" + 
				"		                \"productId\": \"543908191700\",\r\n" + 
				"		                \"productCode\": null,\r\n" + 
				"		                \"productName\": \"【特别尺码】男装 AIRism网眼圆领T恤(短袖) 182498 优衣库UNIQLO\",\r\n" + 
				"		                \"productMainCover\": null,\r\n" + 
				"		                \"productFeature\": null,\r\n" + 
				"		                \"price\": null,\r\n" + 
				"		                \"color\": null,\r\n" + 
				"		                \"texture\": null,\r\n" + 
				"		                \"size\": null,\r\n" + 
				"		                \"state\": 1,\r\n" + 
				"		                \"style1\": null,\r\n" + 
				"		                \"createTime\": null,\r\n" + 
				"		                \"sizeList\": null,\r\n" + 
				"		                \"productTag\": null,\r\n" + 
				"		                \"intro\": \"<p>质地轻盈，配色富有韵味，颇具透气性与速干性！网眼设计的圆领T恤。 ·质地轻盈且颇具透气性与速干性，呈现更为舒适的穿着感受。 ·网眼面料颇具透气性，不易产生闷热感，舒爽的质地是其魅力所在。 ·附带吸汗速干的快干功能。 ·圆领款式，适合在多种场合穿搭。</p>\",\r\n" + 
				"		                \"sort\": null,\r\n" + 
				"		                \"effective\": null,\r\n" + 
				"		                \"timestamp\": null,\r\n" + 
				"		                \"fresh\": null,\r\n" + 
				"		                \"sku\": null,\r\n" + 
				"		                \"allTags\": [\r\n" + 
				"		                    {\r\n" + 
				"		                        \"id\": 53,\r\n" + 
				"		                        \"name\": \"AIRism\",\r\n" + 
				"		                        \"level\": null,\r\n" + 
				"		                        \"synonym\": null,\r\n" + 
				"		                        \"nameOr\": null,\r\n" + 
				"		                        \"nameAnd\": null,\r\n" + 
				"		                        \"nameNot\": null,\r\n" + 
				"		                        \"sort\": null,\r\n" + 
				"		                        \"count\": null,\r\n" + 
				"		                        \"pinyin\": null,\r\n" + 
				"		                        \"level1\": null\r\n" + 
				"		                    }\r\n" + 
				"		                ],\r\n" + 
				"		                \"allJudgeTags\": [\r\n" + 
				"		                    {\r\n" + 
				"		                        \"judgeId\": 1664,\r\n" + 
				"		                        \"content\": \"--不易产生闷热感，舒爽的质地是其魅力所在。\",\r\n" + 
				"		                        \"proId\": \"543908191700\",\r\n" + 
				"		                        \"tagId\": 53,\r\n" + 
				"		                        \"state\": 1\r\n" + 
				"		                    }\r\n" + 
				"		                ]\r\n" + 
				"		            },\r\n" + 
				"		            {\r\n" + 
				"		                \"id\": 44,\r\n" + 
				"		                \"productId\": \"553936357558\",\r\n" + 
				"		                \"productCode\": null,\r\n" + 
				"		                \"productName\": \"童装/男童 袜子(2双装) 400906 优衣库UNIQLO\",\r\n" + 
				"		                \"productMainCover\": null,\r\n" + 
				"		                \"productFeature\": null,\r\n" + 
				"		                \"price\": null,\r\n" + 
				"		                \"color\": null,\r\n" + 
				"		                \"texture\": null,\r\n" + 
				"		                \"size\": null,\r\n" + 
				"		                \"state\": 1,\r\n" + 
				"		                \"style1\": null,\r\n" + 
				"		                \"createTime\": null,\r\n" + 
				"		                \"sizeList\": null,\r\n" + 
				"		                \"productTag\": null,\r\n" + 
				"		                \"intro\": \"<p>适合与运动鞋搭配穿着的短袜。不同的彩色拼块2双装。 ·不易滑落，舒适贴合后跟与脚心。 ·在易感到负担的指尖和脚心追加了缓冲起绒设计。 ·适合活泼好动的孩童在玩耍时穿着。 ·短款的设计，利落有型。 ·颜色、位置不同的拼块设计2双装。</p>\",\r\n" + 
				"		                \"sort\": null,\r\n" + 
				"		                \"effective\": null,\r\n" + 
				"		                \"timestamp\": null,\r\n" + 
				"		                \"fresh\": null,\r\n" + 
				"		                \"sku\": null,\r\n" + 
				"		                \"allTags\": [\r\n" + 
				"		                    {\r\n" + 
				"		                        \"id\": 619,\r\n" + 
				"		                        \"name\": \"舒适\",\r\n" + 
				"		                        \"level\": null,\r\n" + 
				"		                        \"synonym\": null,\r\n" + 
				"		                        \"nameOr\": null,\r\n" + 
				"		                        \"nameAnd\": null,\r\n" + 
				"		                        \"nameNot\": null,\r\n" + 
				"		                        \"sort\": null,\r\n" + 
				"		                        \"count\": null,\r\n" + 
				"		                        \"pinyin\": null,\r\n" + 
				"		                        \"level1\": null\r\n" + 
				"		                    },\r\n" + 
				"		                    {\r\n" + 
				"		                        \"id\": 53,\r\n" + 
				"		                        \"name\": \"AIRism\",\r\n" + 
				"		                        \"level\": null,\r\n" + 
				"		                        \"synonym\": null,\r\n" + 
				"		                        \"nameOr\": null,\r\n" + 
				"		                        \"nameAnd\": null,\r\n" + 
				"		                        \"nameNot\": null,\r\n" + 
				"		                        \"sort\": null,\r\n" + 
				"		                        \"count\": null,\r\n" + 
				"		                        \"pinyin\": null,\r\n" + 
				"		                        \"level1\": null\r\n" + 
				"		                    }\r\n" + 
				"		                ],\r\n" + 
				"		                \"allJudgeTags\": [\r\n" + 
				"		                    {\r\n" + 
				"		                        \"judgeId\": 1665,\r\n" + 
				"		                        \"content\": \"--不易滑落，舒适贴合后跟与脚心。\",\r\n" + 
				"		                        \"proId\": \"553936357558\",\r\n" + 
				"		                        \"tagId\": 619,\r\n" + 
				"		                        \"state\": 1\r\n" + 
				"		                    },\r\n" + 
				"		                    {\r\n" + 
				"		                        \"judgeId\": 1666,\r\n" + 
				"		                        \"content\": \"--不易滑落，舒适贴合后跟与脚心。\",\r\n" + 
				"		                        \"proId\": \"553936357558\",\r\n" + 
				"		                        \"tagId\": 53,\r\n" + 
				"		                        \"state\": 1\r\n" + 
				"		                    }\r\n" + 
				"		                ]\r\n" + 
				"		            },\r\n" + 
				"		            {\r\n" + 
				"		                \"id\": 60,\r\n" + 
				"		                \"productId\": \"551847790042\",\r\n" + 
				"		                \"productCode\": null,\r\n" + 
				"		                \"productName\": \"婴儿/幼儿 圆领T恤(长袖) 402170 优衣库UNIQLO\",\r\n" + 
				"		                \"productMainCover\": null,\r\n" + 
				"		                \"productFeature\": null,\r\n" + 
				"		                \"price\": null,\r\n" + 
				"		                \"color\": null,\r\n" + 
				"		                \"texture\": null,\r\n" + 
				"		                \"size\": null,\r\n" + 
				"		                \"state\": 1,\r\n" + 
				"		                \"style1\": null,\r\n" + 
				"		                \"createTime\": null,\r\n" + 
				"		                \"sizeList\": null,\r\n" + 
				"		                \"productTag\": null,\r\n" + 
				"		                \"intro\": \"<p>适合日常穿搭！采用棉质面料制成的T恤，迷彩图案的口袋是设计亮点。 ·采用质地柔滑的棉质面料制成，具有松软的肌肤触感。 ·施有成衣水洗加工不易变形，略显随性。 ·下摆稍长，即使随意活动也不易担心下摆露出。 ·左肩附带按扣，便于为宝宝更衣。 ·左胸口袋与后背内侧的迷彩图案是其亮点所在。</p>\",\r\n" + 
				"		                \"sort\": null,\r\n" + 
				"		                \"effective\": null,\r\n" + 
				"		                \"timestamp\": null,\r\n" + 
				"		                \"fresh\": null,\r\n" + 
				"		                \"sku\": null,\r\n" + 
				"		                \"allTags\": [\r\n" + 
				"		                    {\r\n" + 
				"		                        \"id\": 220,\r\n" + 
				"		                        \"name\": \"下摆\",\r\n" + 
				"		                        \"level\": null,\r\n" + 
				"		                        \"synonym\": null,\r\n" + 
				"		                        \"nameOr\": null,\r\n" + 
				"		                        \"nameAnd\": null,\r\n" + 
				"		                        \"nameNot\": null,\r\n" + 
				"		                        \"sort\": null,\r\n" + 
				"		                        \"count\": null,\r\n" + 
				"		                        \"pinyin\": null,\r\n" + 
				"		                        \"level1\": null\r\n" + 
				"		                    },\r\n" + 
				"		                    {\r\n" + 
				"		                        \"id\": 849,\r\n" + 
				"		                        \"name\": \"随性\",\r\n" + 
				"		                        \"level\": null,\r\n" + 
				"		                        \"synonym\": null,\r\n" + 
				"		                        \"nameOr\": null,\r\n" + 
				"		                        \"nameAnd\": null,\r\n" + 
				"		                        \"nameNot\": null,\r\n" + 
				"		                        \"sort\": null,\r\n" + 
				"		                        \"count\": null,\r\n" + 
				"		                        \"pinyin\": null,\r\n" + 
				"		                        \"level1\": null\r\n" + 
				"		                    }\r\n" + 
				"		                ],\r\n" + 
				"		                \"allJudgeTags\": [\r\n" + 
				"		                    {\r\n" + 
				"		                        \"judgeId\": 1667,\r\n" + 
				"		                        \"content\": \"--不易变形，略显随性。\\r\\n--不易担心下摆露出。\",\r\n" + 
				"		                        \"proId\": \"551847790042\",\r\n" + 
				"		                        \"tagId\": 220,\r\n" + 
				"		                        \"state\": 1\r\n" + 
				"		                    },\r\n" + 
				"		                    {\r\n" + 
				"		                        \"judgeId\": 1668,\r\n" + 
				"		                        \"content\": \"--不易变形，略显随性。\\r\\n--不易担心下摆露出。\",\r\n" + 
				"		                        \"proId\": \"551847790042\",\r\n" + 
				"		                        \"tagId\": 849,\r\n" + 
				"		                        \"state\": 1\r\n" + 
				"		                    }\r\n" + 
				"		                ]\r\n" + 
				"		            },\r\n" + 
				"		            {\r\n" + 
				"		                \"id\": 64,\r\n" + 
				"		                \"productId\": \"560174920239\",\r\n" + 
				"		                \"productCode\": null,\r\n" + 
				"		                \"productName\": \"女装 花式上衣(长袖) 404545 优衣库UNIQLO\",\r\n" + 
				"		                \"productMainCover\": null,\r\n" + 
				"		                \"productFeature\": null,\r\n" + 
				"		                \"price\": null,\r\n" + 
				"		                \"color\": null,\r\n" + 
				"		                \"texture\": null,\r\n" + 
				"		                \"size\": null,\r\n" + 
				"		                \"state\": 1,\r\n" + 
				"		                \"style1\": null,\r\n" + 
				"		                \"createTime\": null,\r\n" + 
				"		                \"sizeList\": null,\r\n" + 
				"		                \"productTag\": null,\r\n" + 
				"		                \"intro\": \"<p>后身加入纽扣！打造优雅又富有女人味的造型。 ·纵线、横线均采用粘纤与优质聚酯纤维混纺而成的纱线制成。 ·接触肌肤的面采用粘纤面料制成，质地柔滑的粘纤面料不易起皱。 ·质地柔软、肌肤触感舒适、穿着感舒爽是其魅力所在。 ·洗后不易起皱、便于打理，适合工作忙碌的女性穿着。 ·本季对款型进行适度改良！后背加入开口的样式，有助于提升设计感。 ·款型宽松。 ·既可打造职场清爽造型，亦可与牛仔裤搭配打造休闲造型。 ·稍稍下调后领口，适度露出后颈线条，增添女性魅力。 ·单穿即可打造清新造型，推荐您解开后身纽扣展现时尚小心机。 ·是一款搭配性出众的单品。</p>\",\r\n" + 
				"		                \"sort\": null,\r\n" + 
				"		                \"effective\": null,\r\n" + 
				"		                \"timestamp\": null,\r\n" + 
				"		                \"fresh\": null,\r\n" + 
				"		                \"sku\": null,\r\n" + 
				"		                \"allTags\": [\r\n" + 
				"		                    {\r\n" + 
				"		                        \"id\": 680,\r\n" + 
				"		                        \"name\": \"商务\",\r\n" + 
				"		                        \"level\": null,\r\n" + 
				"		                        \"synonym\": null,\r\n" + 
				"		                        \"nameOr\": null,\r\n" + 
				"		                        \"nameAnd\": null,\r\n" + 
				"		                        \"nameNot\": null,\r\n" + 
				"		                        \"sort\": null,\r\n" + 
				"		                        \"count\": null,\r\n" + 
				"		                        \"pinyin\": null,\r\n" + 
				"		                        \"level1\": null\r\n" + 
				"		                    },\r\n" + 
				"		                    {\r\n" + 
				"		                        \"id\": 1,\r\n" + 
				"		                        \"name\": \"女装\",\r\n" + 
				"		                        \"level\": null,\r\n" + 
				"		                        \"synonym\": null,\r\n" + 
				"		                        \"nameOr\": null,\r\n" + 
				"		                        \"nameAnd\": null,\r\n" + 
				"		                        \"nameNot\": null,\r\n" + 
				"		                        \"sort\": null,\r\n" + 
				"		                        \"count\": null,\r\n" + 
				"		                        \"pinyin\": null,\r\n" + 
				"		                        \"level1\": null\r\n" + 
				"		                    }\r\n" + 
				"		                ],\r\n" + 
				"		                \"allJudgeTags\": [\r\n" + 
				"		                    {\r\n" + 
				"		                        \"judgeId\": 1669,\r\n" + 
				"		                        \"content\": \"--不易起皱。\\r\\n--不易起皱、便于打理，适合工作忙碌的女性穿着。\",\r\n" + 
				"		                        \"proId\": \"560174920239\",\r\n" + 
				"		                        \"tagId\": 680,\r\n" + 
				"		                        \"state\": 1\r\n" + 
				"		                    },\r\n" + 
				"		                    {\r\n" + 
				"		                        \"judgeId\": 1670,\r\n" + 
				"		                        \"content\": \"--不易起皱。\\r\\n--不易起皱、便于打理，适合工作忙碌的女性穿着。\",\r\n" + 
				"		                        \"proId\": \"560174920239\",\r\n" + 
				"		                        \"tagId\": 1,\r\n" + 
				"		                        \"state\": 1\r\n" + 
				"		                    }\r\n" + 
				"		                ]\r\n" + 
				"		            },\r\n" + 
				"		            {\r\n" + 
				"		                \"id\": 78,\r\n" + 
				"		                \"productId\": \"554936266751\",\r\n" + 
				"		                \"productCode\": null,\r\n" + 
				"		                \"productName\": \"男装 精纺格子衬衫(长袖) 401823 优衣库UNIQLO\",\r\n" + 
				"		                \"productMainCover\": null,\r\n" + 
				"		                \"productFeature\": null,\r\n" + 
				"		                \"price\": null,\r\n" + 
				"		                \"color\": null,\r\n" + 
				"		                \"texture\": null,\r\n" + 
				"		                \"size\": null,\r\n" + 
				"		                \"state\": 1,\r\n" + 
				"		                \"style1\": null,\r\n" + 
				"		                \"createTime\": null,\r\n" + 
				"		                \"sizeList\": null,\r\n" + 
				"		                \"productTag\": null,\r\n" + 
				"		                \"intro\": \"<p>面料、缝纫、做工、设计都较为考究！便于打理的优质棉质衬衫。 ·采用质地柔软、优美的棉质面料制成。 ·优质纱线纺织而成的棉质面料具有柔软的肌肤触感与考究的质地。 ·施有易护理加工，洗后不易起皱，简单熨烫后即可穿着。 ·稍大的口袋，可放入ID卡和护照。 ·对领子的设计进行改良，使其即使不系领带亦有助于展现优美领型。 ·小格子图案，适合打造时尚造型。</p>\",\r\n" + 
				"		                \"sort\": null,\r\n" + 
				"		                \"effective\": null,\r\n" + 
				"		                \"timestamp\": null,\r\n" + 
				"		                \"fresh\": null,\r\n" + 
				"		                \"sku\": null,\r\n" + 
				"		                \"allTags\": [\r\n" + 
				"		                    {\r\n" + 
				"		                        \"id\": 647,\r\n" + 
				"		                        \"name\": \"简约\",\r\n" + 
				"		                        \"level\": null,\r\n" + 
				"		                        \"synonym\": null,\r\n" + 
				"		                        \"nameOr\": null,\r\n" + 
				"		                        \"nameAnd\": null,\r\n" + 
				"		                        \"nameNot\": null,\r\n" + 
				"		                        \"sort\": null,\r\n" + 
				"		                        \"count\": null,\r\n" + 
				"		                        \"pinyin\": null,\r\n" + 
				"		                        \"level1\": null\r\n" + 
				"		                    },\r\n" + 
				"		                    {\r\n" + 
				"		                        \"id\": 980,\r\n" + 
				"		                        \"name\": \"简洁\",\r\n" + 
				"		                        \"level\": null,\r\n" + 
				"		                        \"synonym\": null,\r\n" + 
				"		                        \"nameOr\": null,\r\n" + 
				"		                        \"nameAnd\": null,\r\n" + 
				"		                        \"nameNot\": null,\r\n" + 
				"		                        \"sort\": null,\r\n" + 
				"		                        \"count\": null,\r\n" + 
				"		                        \"pinyin\": null,\r\n" + 
				"		                        \"level1\": null\r\n" + 
				"		                    }\r\n" + 
				"		                ],\r\n" + 
				"		                \"allJudgeTags\": [\r\n" + 
				"		                    {\r\n" + 
				"		                        \"judgeId\": 1671,\r\n" + 
				"		                        \"content\": \"--不易起皱，简单熨烫后即可穿着。\",\r\n" + 
				"		                        \"proId\": \"554936266751\",\r\n" + 
				"		                        \"tagId\": 647,\r\n" + 
				"		                        \"state\": 1\r\n" + 
				"		                    },\r\n" + 
				"		                    {\r\n" + 
				"		                        \"judgeId\": 1672,\r\n" + 
				"		                        \"content\": \"--不易起皱，简单熨烫后即可穿着。\",\r\n" + 
				"		                        \"proId\": \"554936266751\",\r\n" + 
				"		                        \"tagId\": 980,\r\n" + 
				"		                        \"state\": 1\r\n" + 
				"		                    }\r\n" + 
				"		                ]\r\n" + 
				"		            },\r\n" + 
				"		            {\r\n" + 
				"		                \"id\": 81,\r\n" + 
				"		                \"productId\": \"553866476240\",\r\n" + 
				"		                \"productCode\": null,\r\n" + 
				"		                \"productName\": \"童装/男童 袜子(2双装) 400903 优衣库UNIQLO\",\r\n" + 
				"		                \"productMainCover\": null,\r\n" + 
				"		                \"productFeature\": null,\r\n" + 
				"		                \"price\": null,\r\n" + 
				"		                \"color\": null,\r\n" + 
				"		                \"texture\": null,\r\n" + 
				"		                \"size\": null,\r\n" + 
				"		                \"state\": 1,\r\n" + 
				"		                \"style1\": null,\r\n" + 
				"		                \"createTime\": null,\r\n" + 
				"		                \"sizeList\": null,\r\n" + 
				"		                \"productTag\": null,\r\n" + 
				"		                \"intro\": \"<p>长度稍短的中筒袜。条纹图案与彩色拼块2双装。 ·不易滑落，舒适贴合后跟与脚心。 ·在易感到负担的指尖和脚心追加了缓冲起绒设计。 ·适合活泼好动的孩童在玩耍时穿着。 ·适合与中裤搭配穿着的中筒长度。 ·经典的条纹与加入棉结纱线混纺的彩色拼块2双装。</p>\",\r\n" + 
				"		                \"sort\": null,\r\n" + 
				"		                \"effective\": null,\r\n" + 
				"		                \"timestamp\": null,\r\n" + 
				"		                \"fresh\": null,\r\n" + 
				"		                \"sku\": null,\r\n" + 
				"		                \"allTags\": [\r\n" + 
				"		                    {\r\n" + 
				"		                        \"id\": 619,\r\n" + 
				"		                        \"name\": \"舒适\",\r\n" + 
				"		                        \"level\": null,\r\n" + 
				"		                        \"synonym\": null,\r\n" + 
				"		                        \"nameOr\": null,\r\n" + 
				"		                        \"nameAnd\": null,\r\n" + 
				"		                        \"nameNot\": null,\r\n" + 
				"		                        \"sort\": null,\r\n" + 
				"		                        \"count\": null,\r\n" + 
				"		                        \"pinyin\": null,\r\n" + 
				"		                        \"level1\": null\r\n" + 
				"		                    },\r\n" + 
				"		                    {\r\n" + 
				"		                        \"id\": 53,\r\n" + 
				"		                        \"name\": \"AIRism\",\r\n" + 
				"		                        \"level\": null,\r\n" + 
				"		                        \"synonym\": null,\r\n" + 
				"		                        \"nameOr\": null,\r\n" + 
				"		                        \"nameAnd\": null,\r\n" + 
				"		                        \"nameNot\": null,\r\n" + 
				"		                        \"sort\": null,\r\n" + 
				"		                        \"count\": null,\r\n" + 
				"		                        \"pinyin\": null,\r\n" + 
				"		                        \"level1\": null\r\n" + 
				"		                    }\r\n" + 
				"		                ],\r\n" + 
				"		                \"allJudgeTags\": [\r\n" + 
				"		                    {\r\n" + 
				"		                        \"judgeId\": 1673,\r\n" + 
				"		                        \"content\": \"--不易滑落，舒适贴合后跟与脚心。\",\r\n" + 
				"		                        \"proId\": \"553866476240\",\r\n" + 
				"		                        \"tagId\": 619,\r\n" + 
				"		                        \"state\": 1\r\n" + 
				"		                    },\r\n" + 
				"		                    {\r\n" + 
				"		                        \"judgeId\": 1674,\r\n" + 
				"		                        \"content\": \"--不易滑落，舒适贴合后跟与脚心。\",\r\n" + 
				"		                        \"proId\": \"553866476240\",\r\n" + 
				"		                        \"tagId\": 53,\r\n" + 
				"		                        \"state\": 1\r\n" + 
				"		                    }\r\n" + 
				"		                ]\r\n" + 
				"		            },\r\n" + 
				"		            {\r\n" + 
				"		                \"id\": 85,\r\n" + 
				"		                \"productId\": \"553971118397\",\r\n" + 
				"		                \"productCode\": null,\r\n" + 
				"		                \"productName\": \"童装/男童 袜子(2双装) 400120 优衣库UNIQLO\",\r\n" + 
				"		                \"productMainCover\": null,\r\n" + 
				"		                \"productFeature\": null,\r\n" + 
				"		                \"price\": null,\r\n" + 
				"		                \"color\": null,\r\n" + 
				"		                \"texture\": null,\r\n" + 
				"		                \"size\": null,\r\n" + 
				"		                \"state\": 1,\r\n" + 
				"		                \"style1\": null,\r\n" + 
				"		                \"createTime\": null,\r\n" + 
				"		                \"sizeList\": null,\r\n" + 
				"		                \"productTag\": null,\r\n" + 
				"		                \"intro\": \"<p>质地结实的袜子。迷彩图案与条纹图案2双装。 ·不易滑落，舒适贴合后跟与脚心。 ·在易感到负担的指尖和脚心追加了缓冲起绒设计。 ·适合活泼好动的孩童在玩耍时穿着。 ·经典的迷彩与条纹设计。 ·迷彩图案采用锦纶纱线纺织而成，图案内侧不易出丝，提升舒适度。</p>\",\r\n" + 
				"		                \"sort\": null,\r\n" + 
				"		                \"effective\": null,\r\n" + 
				"		                \"timestamp\": null,\r\n" + 
				"		                \"fresh\": null,\r\n" + 
				"		                \"sku\": null,\r\n" + 
				"		                \"allTags\": [\r\n" + 
				"		                    {\r\n" + 
				"		                        \"id\": 619,\r\n" + 
				"		                        \"name\": \"舒适\",\r\n" + 
				"		                        \"level\": null,\r\n" + 
				"		                        \"synonym\": null,\r\n" + 
				"		                        \"nameOr\": null,\r\n" + 
				"		                        \"nameAnd\": null,\r\n" + 
				"		                        \"nameNot\": null,\r\n" + 
				"		                        \"sort\": null,\r\n" + 
				"		                        \"count\": null,\r\n" + 
				"		                        \"pinyin\": null,\r\n" + 
				"		                        \"level1\": null\r\n" + 
				"		                    },\r\n" + 
				"		                    {\r\n" + 
				"		                        \"id\": 53,\r\n" + 
				"		                        \"name\": \"AIRism\",\r\n" + 
				"		                        \"level\": null,\r\n" + 
				"		                        \"synonym\": null,\r\n" + 
				"		                        \"nameOr\": null,\r\n" + 
				"		                        \"nameAnd\": null,\r\n" + 
				"		                        \"nameNot\": null,\r\n" + 
				"		                        \"sort\": null,\r\n" + 
				"		                        \"count\": null,\r\n" + 
				"		                        \"pinyin\": null,\r\n" + 
				"		                        \"level1\": null\r\n" + 
				"		                    }\r\n" + 
				"		                ],\r\n" + 
				"		                \"allJudgeTags\": [\r\n" + 
				"		                    {\r\n" + 
				"		                        \"judgeId\": 1675,\r\n" + 
				"		                        \"content\": \"--不易滑落，舒适贴合后跟与脚心。\\r\\n--不易出丝，提升舒适度。\",\r\n" + 
				"		                        \"proId\": \"553971118397\",\r\n" + 
				"		                        \"tagId\": 619,\r\n" + 
				"		                        \"state\": 1\r\n" + 
				"		                    },\r\n" + 
				"		                    {\r\n" + 
				"		                        \"judgeId\": 1676,\r\n" + 
				"		                        \"content\": \"--不易滑落，舒适贴合后跟与脚心。\\r\\n--不易出丝，提升舒适度。\",\r\n" + 
				"		                        \"proId\": \"553971118397\",\r\n" + 
				"		                        \"tagId\": 53,\r\n" + 
				"		                        \"state\": 1\r\n" + 
				"		                    }\r\n" + 
				"		                ]\r\n" + 
				"		            },\r\n" + 
				"		            {\r\n" + 
				"		                \"id\": 107,\r\n" + 
				"		                \"productId\": \"544570362030\",\r\n" + 
				"		                \"productCode\": null,\r\n" + 
				"		                \"productName\": \"男装 DRY-EX圆领T恤(短袖) 190240 优衣库UNIQLO\",\r\n" + 
				"		                \"productMainCover\": null,\r\n" + 
				"		                \"productFeature\": null,\r\n" + 
				"		                \"price\": null,\r\n" + 
				"		                \"color\": null,\r\n" + 
				"		                \"texture\": null,\r\n" + 
				"		                \"size\": null,\r\n" + 
				"		                \"state\": 1,\r\n" + 
				"		                \"style1\": null,\r\n" + 
				"		                \"createTime\": null,\r\n" + 
				"		                \"sizeList\": null,\r\n" + 
				"		                \"productTag\": null,\r\n" + 
				"		                \"intro\": \"<p>颇具速干性的DRY EX面料！迷彩图案，设计性出众。采用DRY EX面料制成，不易产生黏腻感，有助于保持舒爽的肌肤触感。 ·洗后亦可快速晾干。 ·木纹色调的迷彩图案，颇具设计性。 ·经典的圆领款式，适合在多种场合穿搭。 ·是一款适合在夏日的健身房中穿着的单品。</p>\",\r\n" + 
				"		                \"sort\": null,\r\n" + 
				"		                \"effective\": null,\r\n" + 
				"		                \"timestamp\": null,\r\n" + 
				"		                \"fresh\": null,\r\n" + 
				"		                \"sku\": null,\r\n" + 
				"		                \"allTags\": [\r\n" + 
				"		                    {\r\n" + 
				"		                        \"id\": 53,\r\n" + 
				"		                        \"name\": \"AIRism\",\r\n" + 
				"		                        \"level\": null,\r\n" + 
				"		                        \"synonym\": null,\r\n" + 
				"		                        \"nameOr\": null,\r\n" + 
				"		                        \"nameAnd\": null,\r\n" + 
				"		                        \"nameNot\": null,\r\n" + 
				"		                        \"sort\": null,\r\n" + 
				"		                        \"count\": null,\r\n" + 
				"		                        \"pinyin\": null,\r\n" + 
				"		                        \"level1\": null\r\n" + 
				"		                    }\r\n" + 
				"		                ],\r\n" + 
				"		                \"allJudgeTags\": [\r\n" + 
				"		                    {\r\n" + 
				"		                        \"judgeId\": 1677,\r\n" + 
				"		                        \"content\": \"--不易产生黏腻感，有助于保持舒爽的肌肤触感。\",\r\n" + 
				"		                        \"proId\": \"544570362030\",\r\n" + 
				"		                        \"tagId\": 53,\r\n" + 
				"		                        \"state\": 1\r\n" + 
				"		                    }\r\n" + 
				"		                ]\r\n" + 
				"		            }\r\n" + 
				"		        ]\r\n" + 
				"			}";
//		Type type = new TypeReference<List<IqProductWithJudgeTags>>() {}.getType();
		JSONObject tagstr = JSON.parseObject(tags);
		System.out.println(tagstr.getString("list"));
		List<IqProductWithJudgeTags> parseArray = JSON.parseArray(tagstr.getString("list"), IqProductWithJudgeTags.class);
		// 字符串转换成json数据
        String str = "{'name':'zhang','age':20}";
        String str_json1 = JSON.toJSONString(str, true);
        String str_json2 = JSON.toJSONString(str, false);
        System.out.println("格式化数据" + str_json1);
        System.out.println("未格式化数据" + str_json2);
        // json转化简单的实体类
        String stu = "{'name':'lisi','age':22}";
        Student ss = JSON.parseObject(stu, Student.class);
        System.out.println(ss);
        // 输出jsonObject中的数据
        JSONObject object = JSON.parseObject(stu);
        System.out.println("获取json数据中的数据       " + object.get("name") + " " + object.get("age"));
        // 删除json中的数据
        String propertyName = "name";
        Set set = object.keySet();
        set.remove(propertyName);
        // object.remove(propertyName);
        System.out.println("删除数据之后的json格式  " + object.toString());
        // json转化list集合
        // String list = "[{'name':'zhang','age':20},{'name':'li','age':30}]";
        // 添加属性value值
        String addPropertyName = "sex";
        String addPropertyVlaue = "man";
        object.put(addPropertyName, addPropertyVlaue);
        System.out.println("输出新增后的json数据   " + object.toString());
        // 修改属性的值等同于覆盖值
        String updatePropertyName = "sex";
        String updatePropertyVlaue = "woman";
        Set set2 = object.keySet();
        if (set2.contains(updatePropertyName)) {
            // object.put(updatePropertyName, JSON.toJSONString(updatePropertyVlaue));
            object.put(updatePropertyName, updatePropertyVlaue);
        }
        System.out.println("输出修改属性值的json数据   " + object.toString());
        // 判断json是否存在属性
        System.out.println("是否存在属性值id  " + object.keySet().contains("id"));
        // 转换日期，这个还是比较重要
        Object date = new Date();
        String date_json = JSON.toJSONStringWithDateFormat(date, "yyyy-MM-dd HH:mm:ss.SSS");
        System.out.println("日期处理  " + date_json);
        // 解析Map集合对象
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "李四");
        map.put("age", "20");
        String map_json = JSON.toJSONString(map);
        System.out.println("map转换成json数据     " + map_json);

        Map<String, String> map1 = new HashMap<String, String>();
        map1.put("code", "11");
        map1.put("message", "ok");
        String json = JSON.toJSONString(map1);
        JSONObject jsonObject = JSON.parseObject(json);
        System.out.println("获取map集合中的数据   " + jsonObject.get("code") + "  " + jsonObject.get("message"));

        // 解析多个对象成list集合 使用JSONArray数组
        String array = "[{'name':'zhang','age':20},{'name':'wang','age':21}]";
        List<Student> stu_list = new ArrayList<Student>(JSONArray.parseArray(array, Student.class));
        System.out.println("输出集合大小  " + stu_list.size());
        for(Student s : stu_list) {
        	System.out.println("遍历每一个对象    " + s);
        }
        
	}
}

class Student {
	String name;
	String sex;
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", sex=" + sex + ", age=" + age + "]";
	}
	
	

}
