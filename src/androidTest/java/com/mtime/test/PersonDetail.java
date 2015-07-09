package com.mtime.test;

import com.squareup.spoon.Spoon;

/**
 * Created by zhangmanying on 15/5/18.
 */
public class PersonDetail extends BaseTest {
    public PersonDetail() throws ClassNotFoundException {
        super(Class.forName("com.mtime.mtmovie.MainActivity"));
    }
    public void testPersonDetail() throws Throwable {
        int longWait = 8000;
        int medWait = 5000;
        int shortWait = 3000;
        solo.waitForActivity("MainActivity");
        assertTrue("HomeActivity is not found!", solo.waitForActivity("MainActivity"));
        solo.waitForActivity("HomeActivity");
        Thread.sleep(longWait);
        Spoon.screenshot(solo.getCurrentActivity(),"thehomepage");
        Thread.sleep(medWait);
        solo.clickOnView(solo.getView("home_gallery"));
        Thread.sleep(longWait);
        assertTrue("FilmInfoActivity not found!", solo.waitForActivity("FilmInfoActivity"));
        solo.waitForActivity("FilmInfoActivity");
        Spoon.screenshot(solo.getCurrentActivity(),"themoviedetail");
        Thread.sleep(medWait);
        if(solo.getView("movie_info_desc").isShown()){
            op.screendownscroll("movie_info_desc",2);
            Thread.sleep(shortWait);
        }
        if(solo.getView("sku_num").isShown()){
            op.screendownscroll("sku_num",2);
            Thread.sleep(shortWait);
        }
        if(solo.getView("movie_info_wonderful_unit").isShown()) {
            op.screendownscroll("movie_info_wonderful_unit",2);
            Thread.sleep(shortWait);
        }
        if(solo.getView("movie_info_person_num").isShown()){
            Spoon.screenshot(solo.getCurrentActivity(),"originpage");
            solo.clickOnView(solo.getView("movie_info_director_img"));
            Thread.sleep(longWait);
            assertTrue("the wrong page!",solo.waitForActivity("ActorViewActivity"));
            Spoon.screenshot(solo.getCurrentActivity(),"persondetail");
            Thread.sleep(medWait);
        }
        solo.clickOnView(solo.getView("like_mark_icon"));
        Thread.sleep(longWait);
        Spoon.screenshot(solo.getCurrentActivity(),"like");
        Thread.sleep(medWait);
        solo.clickOnView(solo.getView("unlike_mark_icon"));
        Thread.sleep(longWait);
        Spoon.screenshot(solo.getCurrentActivity(),"dislike");
//        solo.clickOnView(solo.getView("item_actor_introduction_iv_arrow_down"));
//        Thread.sleep(1000);
//        solo.clickOnView(solo.getView("item_actor_introduction_tv_content"));
        if(solo.getView("hot_playing_title").isShown()){
            solo.clickOnView(solo.getView("hot_playing_header"));
            Thread.sleep(longWait);
            assertTrue("the wrong page", solo.waitForActivity("FilmInfoActivity"));
            Spoon.screenshot(solo.getCurrentActivity(),"FilmInfoActivity");
            Thread.sleep(medWait);
            solo.goBackToActivity("ActorViewActivity");
            assertTrue("the wrong page!", solo.waitForActivity("ActorViewActivity"));
            Spoon.screenshot(solo.getCurrentActivity(),"ActorViewActivity");
            Thread.sleep(medWait);
            solo.clickOnView(solo.getView("hot_playing_buy_ticket"));
            Thread.sleep(longWait);
            assertTrue("the wrong page!",solo.waitForActivity("MovieShowtimeActivity"));
            Spoon.screenshot(solo.getCurrentActivity(),"movieshowtimeactivity");
            Thread.sleep(shortWait);
            solo.goBackToActivity("ActorViewActivity");
            Thread.sleep(shortWait);
            op.screendownscroll("hot_playing_header",1);
            Thread.sleep(medWait);
        }
        if(solo.getView("movies_title").isShown()){
            solo.clickOnView(solo.getView("movies_title"));
            Thread.sleep(longWait);
            Spoon.screenshot(solo.getCurrentActivity(),"moviestitle");
            Thread.sleep(shortWait);
            solo.goBackToActivity("ActorViewActivity");
            Thread.sleep(shortWait);
            solo.clickOnView(solo.getView("name"));
            Thread.sleep(longWait);
            solo.goBackToActivity("ActorViewActivity");
            op.screenrightscroll("name",1);
//            TextView view =(TextView)solo.getView("name");
//            int[] location = new int[2];
//            view.getLocationOnScreen(location);
//            solo.drag(location[0],location[0]-view.getHeight(),location[1],location[1],5);
            Thread.sleep(shortWait);
        }
        if(solo.getView("header").isShown()){
            op.screendownscroll("header",1);
            Thread.sleep(shortWait);
        }
        if(solo.getView("honors_title").isShown()){
            solo.clickOnView(solo.getView("honors_title"));
            Thread.sleep(longWait);
            Spoon.screenshot(solo.getCurrentActivity(),"honors");
            solo.goBackToActivity("ActorViewActivity");
            Thread.sleep(shortWait);
            solo.clickOnView(solo.getView("awards_value"));
            Thread.sleep(longWait);
            solo.goBackToActivity("ActorViewActivity");
            Thread.sleep(shortWait);
            op.screendownscroll("honors_title",2);
            Thread.sleep(shortWait);
        }
        if(solo.getView("album_title").isShown()){
            solo.clickOnView(solo.getView("album_title"));
            Thread.sleep(longWait);
            Spoon.screenshot(solo.getCurrentActivity(),"actorpic");
            Thread.sleep(shortWait);
            solo.goBackToActivity("ActorViewActivity");
            Thread.sleep(shortWait);
            solo.clickOnView(solo.getView("actor_detail_picture_1"));
            Thread.sleep(longWait);
            Spoon.screenshot(solo.getCurrentActivity(),"actorviewactivty");
            Thread.sleep(shortWait);
            solo.goBackToActivity("ActorViewActivity");
            Thread.sleep(shortWait);
            op.screendownscroll("actor_detail_picture_1",1);
            Thread.sleep(shortWait);
        }
        if(solo.getView("ad2").isShown()){
            solo.clickOnView(solo.getView("ad2_seperate"));
            Thread.sleep(longWait);
            solo.goBackToActivity("ActorViewActivity");
            Thread.sleep(shortWait);
            op.screendownscroll("ad2_seperate",1);
            Thread.sleep(shortWait);
        }

    }
}