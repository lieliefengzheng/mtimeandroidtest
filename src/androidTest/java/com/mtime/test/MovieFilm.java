package com.mtime.test;

/**
 * Created by zhangmanying on 15/5/18.
 */
public class MovieFilm extends BaseTest {
    public MovieFilm() throws ClassNotFoundException {
        super(Class.forName("com.mtime.mtmovie.MainActivity"));
    }
    public void testMovieFilm() throws Throwable {
        int longWait = 8000;
        int medWait = 5000;
        int shortWait = 3000;
        solo.waitForActivity("MainActivity");
        assertTrue("HomeActivity is not found!", solo.waitForActivity("MainActivity"));
        solo.waitForActivity("HomeActivity");
        solo.clickOnView(solo.getView("home_but_pay"));
        Thread.sleep(shortWait);
        assertTrue("the wrong page!",solo.waitForActivity("MovieShowtimeActivity"));

    }
}
