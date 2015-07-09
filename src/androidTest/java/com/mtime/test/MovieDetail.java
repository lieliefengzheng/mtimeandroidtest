package com.mtime.test;

import android.view.KeyEvent;
import android.widget.TextView;

import com.squareup.spoon.Spoon;

/**
 * Created by zhangmanying on 15/4/17.
 */
public class MovieDetail extends BaseTest {
    public MovieDetail() throws ClassNotFoundException {
        super(Class.forName("com.mtime.mtmovie.MainActivity"));
    }
public void testMovieInfo() throws Throwable {
    String movie_Home1;
    String movie_Detail;
    int longWait = 8000;
    int medWait = 5000;
    int shortWait = 3000;
    solo.waitForActivity("MainActivity");
    assertTrue("HomeActivity is not found!", solo.waitForActivity("MainActivity"));
    solo.waitForActivity("HomeActivity");
    Thread.sleep(longWait);
    Spoon.screenshot(solo.getCurrentActivity(), "HomeActivity");
    movie_Home1 = ((TextView) solo.getView("home_movie_name")).getText().toString();
    solo.clickOnView(solo.getView("home_gallery"));
    assertTrue("FilmInfoActivity not found!", solo.waitForActivity("FilmInfoActivity"));
    solo.waitForActivity("FilmInfoActivity");
    Thread.sleep(longWait);
    Spoon.screenshot(solo.getCurrentActivity(),"FilmInfoActivity");
    Thread.sleep(longWait);
    movie_Detail = ((TextView) solo.getView("movie_info_moviename_cn")).getText().toString();
    assertEquals("The wrong movie!",movie_Home1,movie_Detail);
    solo.waitForActivity("FilmInfoActivity");
    solo.clickOnView(solo.getView("movie_info_but_wantseen"));
    solo.waitForActivity("FilmInfoActivity");
    Thread.sleep(medWait);
    Spoon.screenshot(solo.getCurrentActivity(),"Movie_info_wantseen");
    assertTrue("FilmInfoActivity not found!",solo.waitForActivity("FilmInfoActivity"));
    Thread.sleep(shortWait);
    solo.clickOnView(solo.getView("movie_info_but_cr"));
    Thread.sleep(longWait);
    Spoon.screenshot(solo.getCurrentActivity(),"Movie_info_rate");
    Thread.sleep(medWait);
    solo.clickOnView(solo.getView("close"));
    solo.waitForActivity("FilminfoActivity");
    Thread.sleep(shortWait);
    Spoon.screenshot(solo.getCurrentActivity(),"FilmInfoActivity");
    Thread.sleep(shortWait);
    solo.clickOnView(solo.getView("movie_info_but_pay"));
    Thread.sleep(longWait);
    Spoon.screenshot(solo.getCurrentActivity(),"Film_Cinema");
    Thread.sleep(medWait);
    solo.goBackToActivity("FilmInfoActivity");
    Thread.sleep(shortWait);
    Spoon.screenshot(solo.getCurrentActivity(),"thefilminfo");
    solo.waitForActivity("FilmInfoActivity");
    if(solo.getView("movie_info_desc").isShown()){
    solo.clickOnView(solo.getView("movie_info_desc"));
     Thread.sleep(shortWait);
     Spoon.screenshot(solo.getCurrentActivity(),"theinfodetail");
     Thread.sleep(shortWait);
    solo.clickOnView(solo.getView("movie_info_desc_all"));
     op.screendownscroll("movie_info_desc",2);
    Thread.sleep(shortWait);
    }
    if(solo.getView("sku_num").isShown()){
        solo.clickOnView(solo.getView("sku_num"));
        Thread.sleep(shortWait);
//        Spoon.screenshot(solo.getCurrentActivity(),"the goods list");
        solo.goBackToActivity("FilmInfoActivity");
        Thread.sleep(shortWait);
//        Spoon.screenshot(solo.getCurrentActivity(),"the film info activity");
        solo.waitForActivity("FilmInfoActivity");
        solo.clickOnView(solo.getView("sku_icon"));
        Thread.sleep(shortWait);
        solo.goBackToActivity("FilmInfoActivity");
        Thread.sleep(shortWait);
        solo.waitForActivity("FilmInfoActivity");
        Thread.sleep(shortWait);
        op.screendownscroll("sku_num",2);
         Thread.sleep(shortWait);
    }
//    if(solo.getView("sku_icon").isShown()){
//        solo.clickOnView(solo.getView("sku_icon"));
//        Thread.sleep(1000);
//        solo.goBackToActivity("FilmInfoActivity");
//        Thread.sleep(1000);
//        solo.waitForActivity("FilmInfoActivity");
//        Thread.sleep(1000);
//       ImageView view =(ImageView)solo.getView("sku_icon");
//        int[] location = new int[2];
//        view.getLocationOnScreen(location);
//        solo.drag(location[0],location[0],location[1],location[1]-view.getHeight(),5);
//        Thread.sleep(1000);
//    }
        if(solo.getView("movie_info_wonderful").isShown()) {
            op.screendownscroll("movie_info_week",2);
            Thread.sleep(shortWait);
    }
    if(solo.getView("movie_info_person_num").isShown()){
        solo.clickOnView(solo.getView("movie_info_person_num"));
        Thread.sleep(longWait);
        Spoon.screenshot(solo.getCurrentActivity(),"theactorlist");
        solo.sleep(shortWait);
        solo.goBackToActivity("FilmInfoActivity");
        solo.sleep(shortWait);
        Spoon.screenshot(solo.getCurrentActivity(),"thefilminfoactvity");
        solo.sleep(shortWait);
        solo.clickOnView(solo.getView("movie_info_director_img"));
        solo.sleep(longWait);
        Spoon.screenshot(solo.getCurrentActivity(),"themovieimage");
        solo.sleep(shortWait);
        solo.goBackToActivity("FilmInfoActivity");
        Spoon.screenshot(solo.getCurrentActivity(),"thefilminfoactvity");
        solo.sleep(medWait);
        op.screendownscroll("movie_info_person_num",3);
        Thread.sleep(shortWait);
    }
//    if(solo.getView("movie_info_director_img").isShown()) {
//        solo.clickOnView(solo.getView("movie_info_director_img"));
//        solo.sleep(5000);
//        solo.goBackToActivity("FilmInfoActivity");
//        solo.sleep(3000);
//        ImageView view =(ImageView)solo.getView("movie_info_director_img");
//        int[] location = new int[2];
//        view.getLocationOnScreen(location);
//        solo.drag(location[0],location[0],location[1],location[1]-view.getHeight(),5);
//        Thread.sleep(1000);
//    }
    if(solo.getView("movie_info_poster_num").isShown()){
        solo.clickOnView(solo.getView("movie_info_poster_num"));
        solo.sleep(longWait);
        Spoon.screenshot(solo.getCurrentActivity(),"theimagepic");
        Thread.sleep(shortWait);
        solo.goBackToActivity("FilmInfoActivity");
        Thread.sleep(shortWait);
        Spoon.screenshot(solo.getCurrentActivity(),"thefilminfo");
        solo.sleep(shortWait);
        solo.clickOnView(solo.getView("movie_info_poster_1"));
        Thread.sleep(longWait);
        solo.goBackToActivity("FilmInfoActivity");
        Thread.sleep(shortWait);
        op.screendownscroll("movie_info_poster_1",1);
        Thread.sleep(shortWait);
    }
    if(solo.getView("movie_info_comment_long_num").isShown()){
        solo.clickOnView(solo.getView("movie_info_comment_long_num"));
        Thread.sleep(longWait);
        Spoon.screenshot(solo.getCurrentActivity(),"themovielongcomment");
        solo.sleep(shortWait);
        solo.goBackToActivity("FilmInfoActivity");
        Thread.sleep(shortWait);
        Spoon.screenshot(solo.getCurrentActivity(),"thefilminfoactivty");
        solo.sleep(shortWait);
        solo.clickOnView(solo.getView("comment_hotLong_txt"));
        Thread.sleep(longWait);
        Spoon.screenshot(solo.getCurrentActivity(),"thelongcommenttxt");
        Thread.sleep(shortWait);
        solo.goBackToActivity("FilmInfoActivity");
        Thread.sleep(shortWait);
        Spoon.screenshot(solo.getCurrentActivity(),"filminfoactivity");
        Thread.sleep(shortWait);
        op.screendownscroll("movie_info_comment_long_num",4);
        Thread.sleep(shortWait);
    }
    if(solo.getView("movie_info_top_but_pay").isShown()){
        solo.clickOnView(solo.getView("movie_info_top_but_pay"));
        Thread.sleep(longWait);
        Spoon.screenshot(solo.getCurrentActivity(),"movieinfopay");
        solo.sleep(shortWait);
        solo.goBackToActivity("FilmInfoActivity");
        Thread.sleep(shortWait);
        Spoon.screenshot(solo.getCurrentActivity(),"thefilminfo");
        solo.sleep(shortWait);
    }
    if(solo.getView("ad2_seperate").isShown()){
        solo.clickOnView(solo.getView("ad2_seperate"));
        solo.sleep(5000);
        solo.goBackToActivity("FilmInfoActivity");
        solo.sleep(3000);
    }
    if (solo.getView("ad2").isShown()){
        solo.clickOnView(solo.getView("ad2"));
        solo.sleep(5000);
        solo.goBackToActivity("FilmInfoActivity");
        solo.sleep(3000);
    }
//    if(!solo.getView("movie_info_comment_short_null").isShown()){
//       solo.clickInList(20,1);
//        solo.clickOnView(solo.getView(""));
//        Thread.sleep(1000);
//        solo.goBackToActivity("FilmInfoActivity");
//        Thread.sleep(1000);
//    }
    solo.clickOnView(solo.getView("hint_view"));
    System.out.println("ok");
    solo.sendKey(KeyEvent.KEYCODE_N);
    Thread.sleep(1000);
    solo.clickOnView(solo.getView("send"));
    Thread.sleep(1000);
//    op.printAllViews();
//    assertEquals("The wrong movie!",movie_Detail,solo.getView(""));
    }
}