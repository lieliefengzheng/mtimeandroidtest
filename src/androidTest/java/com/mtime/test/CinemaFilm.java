package com.mtime.test;

/**
 * Created by zhangmanying on 15/5/18.
 */
public class CinemaFilm extends BaseTest {
    public CinemaFilm() throws ClassNotFoundException {
        super(Class.forName("com.mtime.mtmovie.MainActivity"));
    }
    public void testCinemaFilm() throws Throwable {
        int longWait = 8000;
        int medWait = 5000;
        int shortWait = 3000;
        Thread.sleep(longWait);
        solo.clickOnView(solo.getView("home_findmovie_text"));
        Thread.sleep(shortWait);
        op.getCurrentActivityName();
        Thread.sleep(medWait);
        op.printAllViews();
        Thread.sleep(longWait);
        solo.clickOnView(solo.getView("nearby"));
        solo.clickOnView(solo.getView("price_icon"));
        solo.clickOnView(solo.getView("price_icon"));
        solo.clickOnView(solo.getView("list"));
        solo.goBack();
        solo.clickOnView(solo.getView("line_1"));
        if(solo.getView("ad1").isShown()){
            solo.clickOnView(solo.getView("ad1"));
            solo.goBack();
        }
        solo.clickOnView(solo.getView("favorite_label"));
        solo.goBack();
    }
}