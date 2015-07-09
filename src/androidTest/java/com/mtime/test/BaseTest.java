package com.mtime.test;

import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;

import com.robotium.solo.Solo;

/**
 * Created by zhangmanying on 15/4/13.
 */
public abstract class BaseTest extends ActivityInstrumentationTestCase2 {
    public Solo solo;
    final String TAG = "Test->INIT";
    Operation op = null;
@SuppressWarnings({ "rawtypes", "unchecked" })
public BaseTest(Class<?> aClass) throws ClassNotFoundException{
        super(aClass);
    }

    @Override
    public void setUp() throws Exception {
        try {
            super.setUp();
            Log.d(TAG,"启动了一个测试");
           solo = new Solo(getInstrumentation(),getActivity());
        } catch (Throwable tr) {
            throw new SetUpException(tr);
        }
    }
    @Override
    public void tearDown() throws Exception {
        try {
            solo.finishOpenedActivities();
        } catch (Throwable th) {
            throw new TearDownException(th);
        }
        getActivity().finish();
        super.tearDown();
    }
    public void runTest() throws Throwable{
            int retryTimes = 1;
            op = new Operation(solo);
            op.getdp();
            while(retryTimes > 0)
            {
                try{
                    Log.d("Robotium", "super");
                    super.runTest();
                    break;
                } catch (Throwable th)
                {
                    if(retryTimes > 1) {
                        Log.d("Robotium", "fail，重跑--"+retryTimes);
                        retryTimes--;
                        tearDown();
                        setUp();
                        continue;
                    }
                    else
                        throw new RunTestException(th);  //记得抛出异常，否则case永远不会失败
                }
            }
        }
    class SetUpException extends Exception{
        private static final long serialVersionUID = 1L;
        SetUpException(Throwable e){
            super("Error in setup()!",e);
        }
    }
    class RunTestException extends Exception{
        private static final long serialVersionUID = 2L;
        RunTestException(Throwable e){
            super("Error in runtest()!",e);
        }
    }
    class TearDownException extends Exception{
        private static final long serialVersionUID = 3L;
        TearDownException(Throwable e){
            super("Error in teardown()!",e);
        }
    }
}
