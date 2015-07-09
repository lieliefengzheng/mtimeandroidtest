package com.mtime.test;

import android.widget.TextView;

import com.squareup.spoon.Spoon;

@SuppressWarnings("rawtypes")
public class HomePage extends BaseTest {
    public HomePage() throws ClassNotFoundException {
        super(Class.forName("com.mtime.mtmovie.MainActivity"));
    }

    public void testHomeMovie() throws Throwable {
        String movie_Home1;
        String movie_Detail;
        String movie_Home2;
        int longWait = 8000;
        int medWait = 5000;
        int shortWait = 3000;
        //case for firsttime installing
        Thread.sleep(longWait);
        if(solo.waitForActivity("LeadViewActivity")) {
            Thread.sleep(shortWait);
             op.screenrightscroll("iv_lead_view_bg",1);
//            ImageView view = (ImageView) solo.getView("iv_lead_view_bg");
//            int[] location = new int[2];
//            view.getLocationOnScreen(location);
//            solo.drag(location[0], location[0] - view.getWidth(), location[1], location[1], 5);
            Thread.sleep(shortWait);
            Spoon.screenshot(solo.getCurrentActivity(), "leadPage");
            Thread.sleep(shortWait);
            op.screenrightscroll("iv_lead_view_bg",1);
//            solo.drag(location[0], location[0] - view.getWidth(), location[1], location[1], 5);
            Thread.sleep(shortWait);
            op.screenrightscroll("iv_lead_view_bg",1);
//            solo.drag(location[0], location[0] - view.getWidth(), location[1], location[1], 5);
            Thread.sleep(shortWait);
//            solo.drag(location[0], location[0] - view.getWidth(), location[1], location[1], 5);
//            Thread.sleep(shortWait);
            solo.clickOnView(solo.getView("btn_lead_view"));
            Thread.sleep(shortWait);
            Spoon.screenshot(solo.getCurrentActivity(), "cityselectlist");
            Thread.sleep(shortWait);
            solo.clickOnText("北京");
        }

        //lack of the advertisement and  someleadingpicture

        solo.waitForActivity("MainFragmentTabActivity", longWait);
        assertTrue("HomeActivity is not found!", solo.waitForActivity("MainFragmentTabActivity"));
        solo.waitForActivity("MainFragmentTabActivity", longWait);
        Spoon.screenshot(solo.getCurrentActivity(),"homepage");
        //获取textview中的text
        movie_Home1 = ((TextView) solo.getView("home_movie_name")).getText().toString();
        //Click on 选座购票
        solo.clickOnView(solo.getView("home_but_pay"));
        Thread.sleep(longWait);
        assertTrue("MovieShowtimeActivity is not found!", solo.waitForActivity("MovieShowtimeActivity"));
        Spoon.screenshot(solo.getCurrentActivity(),"movieShowtimeActivity");
        Thread.sleep(longWait);
        //获取textview中的text
        movie_Detail = ((TextView) solo.getView("tip")).getText().toString();
        //断言影片名正确性
        assertEquals("the wrong page!", movie_Home1, movie_Detail);
        Thread.sleep(shortWait);
        //返回首页
        solo.goBack();
        Thread.sleep(shortWait);
        //点击首页影片海报头图
        solo.clickOnView(solo.getView("home_gallery"));
        Thread.sleep(longWait);
        //Wait for activity: 'com.mtime.mtmoviev2.FilmInfoActivity
        assertTrue("FilmInfoActivity not found!", solo.waitForActivity("FilmInfoActivity"));
        //断言影片名正确性
        assertEquals("the wrong page！", movie_Home1, ((TextView) solo.getView("movie_info_moviename_cn")).getText().toString());
        //返回首页
        solo.goBack();
        Thread.sleep(shortWait);
        //断言返回的activity
        solo.assertCurrentActivity("the wrong page!", "MainFragmentTabActivity");
        //滑动首页imageview
//        solo.scrollViewToSide(solo.getView("home_gallery"),solo.RIGHT);
        solo.scrollToSide(solo.RIGHT);
        Thread.sleep(medWait);
        Spoon.screenshot(solo.getCurrentActivity(),"rightslidegallry");
        Thread.sleep(shortWait);
        movie_Home2 = ((TextView) solo.getView("home_movie_name")).getText().toString();
        Thread.sleep(shortWait);
        solo.clickOnView(solo.getView("home_gallery"));
        assertTrue("FilmInfoActivity not found!", solo.waitForActivity("FilmInfoActivity"));
        Thread.sleep(longWait);
        Spoon.screenshot(solo.getCurrentActivity(),"FilmInfoActivity");
        Thread.sleep(shortWait);
        assertEquals("the wrong page!", movie_Home2, ((TextView) solo.getView("movie_info_moviename_cn")).getText().toString());
        Thread.sleep(shortWait);
        solo.goBack();
        Thread.sleep(longWait);
        op.screendownscroll("home_but_pay",2);
        Thread.sleep(shortWait);
        Spoon.screenshot(solo.getCurrentActivity(),"slidehomepagedown");
        Thread.sleep(shortWait);
        //点击今日热点
        solo.clickOnView(solo.getView("rl_todays_hot_arrow"));
        Thread.sleep(longWait);
        Spoon.screenshot(solo.getCurrentActivity(),"hotpointnews");
        Thread.sleep(shortWait);
        solo.goBack();
        Thread.sleep(shortWait);
        op.screendownscroll("rl_todays_hot_arrow",3);
        Thread.sleep(shortWait);
        //点击今日热点新闻条目
        solo.clickOnView(solo.getView("ll_todays_hot"));
        Thread.sleep(longWait);
        Spoon.screenshot(solo.getCurrentActivity(),"newsdetail");
        Thread.sleep(shortWait);
        solo.goBack();
        Thread.sleep(shortWait);
        Spoon.screenshot(solo.getCurrentActivity(),"homepage");
        Thread.sleep(shortWait);
        solo.clickOnView(solo.getView("city_select"));
        Thread.sleep(medWait);
        Spoon.screenshot(solo.getCurrentActivity(),"cityselectlist");
        Thread.sleep(medWait);
        solo.goBack();
        Thread.sleep(shortWait);
        assertTrue("HomeActivity is not found!", solo.waitForActivity("MainActivity"));
        Thread.sleep(shortWait);
        Spoon.screenshot(solo.getCurrentActivity(),"gobackhomepage");
        Thread.sleep(shortWait);
        solo.clickOnView(solo.getView("scan"));
        assertTrue("ScanPage is not found!", solo.waitForActivity("CaptureActivity"));
        Thread.sleep(shortWait);
        Spoon.screenshot(solo.getCurrentActivity(),"capturePage");
        Thread.sleep(shortWait);
        solo.goBackToActivity("MainTabActivity");
        Thread.sleep(shortWait);
        assertTrue("HomeActivity is not found!", solo.waitForActivity("MainActivity"));
        Thread.sleep(shortWait);
        Spoon.screenshot(solo.getCurrentActivity(),"backtohomepage");
        Thread.sleep(shortWait);
        solo.clickOnView(solo.getView("search"));
        Thread.sleep(shortWait);
        assertTrue("SearchPage is not found !",solo.waitForActivity("SearchActivity"));
        Spoon.screenshot(solo.getCurrentActivity(),"searchpage");
        Thread.sleep(shortWait);
        solo.goBack();
        Thread.sleep(shortWait);
        Spoon.screenshot(solo.getCurrentActivity(),"backtothehomepage");
        Thread.sleep(shortWait);
    }

//    public void testHomeBar() throws Exception {
//        //Wait for activity: 'com.mtime.mtmovie.MainActivity'
//        solo.waitForActivity("MainActivity");
//        //Wait for activity: 'com.mtime.mtmoviev2.HomeActivity'
//        assertTrue("HomeActivity is not found!", solo.waitForActivity("MainActivity"));
//        solo.waitForActivity("HomeActivity", 5000);
//        solo.clickOnView(solo.getView("city_select"));
//        op.getCurrentActivityName();
////        assertTrue("CityListPage not found!",solo.waitForActivity(""));
////        op.printAllViews();
//        solo.goBack();
//        //Wait for activity:'com.mtime.mtmovie.MainActivity'
//        solo.waitForActivity("MainActivity", 5000);
//        op.getCurrentActivityName();
//        assertTrue("HomeActivity is not found!", solo.waitForActivity("MainActivity"));
//        solo.clickOnView(solo.getView("scan"));
//        op.getCurrentActivityName();
//        assertTrue("ScanPage is not found!", solo.waitForActivity("CaptureActivity"));
//        solo.goBackToActivity("MainTabActivity");
////        solo.waitForActivity("MainActivity", 5000);
//        assertTrue("HomeActivity is not found!", solo.waitForActivity("MainActivity"));
//        solo.clickOnView(solo.getView("search"));
//        assertTrue("SearchPage is not found !",solo.waitForActivity("SearchActivity"));
//        solo.goBack();
//    }
//    public void testHomeContext() throws Exception{
//        //Wait for activity: 'com.mtime.mtmovie.MainActivity'
//        solo.waitForActivity("MainActivity", 8000);
//        //Wait for activity: 'com.mtime.mtmoviev2.HomeActivity'
//        assertTrue("HomeActivity is not found!", solo.waitForActivity("MainActivity"));
//        solo.waitForActivity("HomeActivity", 5000);
//        solo.clickOnView(solo.getView(""));
//        //点击正在热映
//        solo.clickOnView(solo.getView("home_movie_hot"));
//        op.getCurrentActivityName();
//        solo.goBack();
//        //点击即将上映
//        solo.clickOnView(solo.getView("home_movie_coming_text"));
//        op.getCurrentActivityName();
//        solo.goBack();
//        //点击找影院
//        solo.clickOnView(solo.getView("home_findmovie_text"));
//        op.getCurrentActivityName();
//        solo.goBack();
//        //
//    }
}
