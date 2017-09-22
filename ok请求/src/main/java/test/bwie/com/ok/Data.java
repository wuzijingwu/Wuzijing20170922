package test.bwie.com.ok;

import java.util.List;

/**
 * Created by dell on 2017/9/22.
 */


public class Data {

    /**
     * date : 20170921
     * stories : [{"images":["https://pic1.zhimg.com/v2-0e25275b2775f3b9c2030577b0662ccc.jpg"],"type":0,"id":9625395,"ga_prefix":"092119","title":"有了这份简单易学的炸鸡宝典，今晚吃鸡大吉大利"},{"images":["https://pic4.zhimg.com/v2-4b92bf39cfeab406f53ead31530ed07f.jpg"],"type":0,"id":9621418,"ga_prefix":"092118","title":"天凉了，秋天穿衣搭配，该备的基础款心里有数了吗？"},{"images":["https://pic1.zhimg.com/v2-903d1d3c4bd04d2ad19645e01cf09efc.jpg"],"type":0,"id":9625710,"ga_prefix":"092117","title":"辉煌中国 · 目前中国的空间科学研究在国际上处于什么地位？"},{"images":["https://pic2.zhimg.com/v2-8c6f4c78b363ea69d47bc1dfc1364ca9.jpg"],"type":0,"id":9622748,"ga_prefix":"092116","title":"什么是「消费升级」？为什么近两年人人都在说消费升级？"},{"images":["https://pic2.zhimg.com/v2-9f39830e248f7b90eba33ec51d381855.jpg"],"type":0,"id":9625761,"ga_prefix":"092115","title":"投资者们又盯上了办公室零售，目的是要喂胖所有人"},{"images":["https://pic1.zhimg.com/v2-8964b5d2932b4f42b6390503d0771ab4.jpg"],"type":0,"id":9621936,"ga_prefix":"092114","title":"经常电话不接消息不回，跟这样的恋人相处，特别心累吧？"},{"images":["https://pic2.zhimg.com/v2-4ac9d60f5a533da7cf77f7aa58fbe869.jpg"],"type":0,"id":9623839,"ga_prefix":"092113","title":"为什么有人愿意给「恶人」、「贪官」做辩护律师？"},{"images":["https://pic4.zhimg.com/v2-5c81a823aead581b75099ed5f17ba747.jpg"],"type":0,"id":9623966,"ga_prefix":"092112","title":"大误 · 汽车下海实录"},{"images":["https://pic2.zhimg.com/v2-3de15d16a93ff91ccf25f23ea2e50b51.jpg"],"type":0,"id":9624349,"ga_prefix":"092111","title":"一家公司的财务有问题，是否还有被投资的价值？"},{"images":["https://pic1.zhimg.com/v2-25e53f2a34cc7e0e6181821d523644dc.jpg"],"type":0,"id":7065071,"ga_prefix":"092110","title":"只有阳光会晒黑人吗？电灯光、电脑屏幕光呢？"},{"images":["https://pic1.zhimg.com/v2-0029e8232b966679544509593215fecc.jpg"],"type":0,"id":9624305,"ga_prefix":"092109","title":"为什么你很少听说阅读障碍？因为在中国，他们统一被打成了「笨」"},{"images":["https://pic3.zhimg.com/v2-7f513c31c4414aac09f09b089c7d249e.jpg"],"type":0,"id":9621205,"ga_prefix":"092108","title":"还没上映就连破纪录，恐怖片的新标杆，说的就是「它」了"},{"images":["https://pic4.zhimg.com/v2-f0c491fca32a604f55668a7a498124d7.jpg"],"type":0,"id":9624095,"ga_prefix":"092107","title":"朋友圈被「最美古风翻译」刷屏，我怎么觉得是篇 0 分神作\u2026\u2026"},{"images":["https://pic4.zhimg.com/v2-f489eed57a85a62e0cadecf58fab1117.jpg"],"type":0,"id":9623447,"ga_prefix":"092107","title":"取代中国红牛成为新的业界老大，他们已经按捺不住了"},{"images":["https://pic3.zhimg.com/v2-ea1b75576f57495979eb45a1c398ad7a.jpg"],"type":0,"id":9483544,"ga_prefix":"092107","title":"希望你和家人，不是只在 9 月 21 号这天才关心这个病"},{"images":["https://pic4.zhimg.com/v2-4c1413b569a69dbb3411ab6ab783e8f3.jpg"],"type":0,"id":9624081,"ga_prefix":"092106","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"https://pic2.zhimg.com/v2-a4ebecc5f3ac7845805b2d17688db35d.jpg","type":0,"id":9622748,"ga_prefix":"092116","title":"什么是「消费升级」？为什么近两年人人都在说消费升级？"},{"image":"https://pic1.zhimg.com/v2-31c7577a439db633b92b2be42caf1e64.jpg","type":0,"id":9624305,"ga_prefix":"092109","title":"为什么你很少听说阅读障碍？因为在中国，他们统一被打成了「笨」"},{"image":"https://pic1.zhimg.com/v2-ccd5abcab2fe67c945245e1e8781d550.jpg","type":0,"id":9483544,"ga_prefix":"092107","title":"希望你和家人，不是只在 9 月 21 号这天才关心这个病"},{"image":"https://pic2.zhimg.com/v2-c612e4396b7226aeebbec2ef2a352bdd.jpg","type":0,"id":9624311,"ga_prefix":"092017","title":"辉煌中国 · 为什么说中国是「基建狂魔」？"},{"image":"https://pic2.zhimg.com/v2-14cfdf6d6d80649d6dd91248caab6159.jpg","type":0,"id":9622931,"ga_prefix":"092016","title":"「暴力游戏就是毒害青少年」，怕不能这么草率粗暴下定论"}]
     */

    private String date;
    private List<StoriesBean> stories;
    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        /**
         * images : ["https://pic1.zhimg.com/v2-0e25275b2775f3b9c2030577b0662ccc.jpg"]
         * type : 0
         * id : 9625395
         * ga_prefix : 092119
         * title : 有了这份简单易学的炸鸡宝典，今晚吃鸡大吉大利
         */

        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private List<String> images;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        /**
         * image : https://pic2.zhimg.com/v2-a4ebecc5f3ac7845805b2d17688db35d.jpg
         * type : 0
         * id : 9622748
         * ga_prefix : 092116
         * title : 什么是「消费升级」？为什么近两年人人都在说消费升级？
         */

        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
