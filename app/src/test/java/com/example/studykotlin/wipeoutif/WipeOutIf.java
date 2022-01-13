package com.example.studykotlin.wipeoutif;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author meijie05
 * @since 2020/8/16 上午9:48
 */

public class WipeOutIf {

    public static void main(String[] args) {

        WipeOutIf woi = new WipeOutIf();
        woi.bad("ddd");

        woi.addCase("aaa", () -> {

        });


        woi.good("eee");
    }

    public void addCase(String key, IWork work) {
        mCases.put(key, work);
    }

    public void bad(String input) {
        if ("aaa".equals(input)) {

        } else if ("bbb".equals(input)) {

        } else if ("ccc".equals(input)) {

        } else {
            System.err.println("do not deal");
        }
    }

    private Map<String, IWork> mCases = new HashMap<String, IWork>(){
        {
            put("ccc", () -> {

            });
            put("ddd", () -> {

            });
        }
    };

    public void good(String input) {

        IWork iWork = mCases.get(input);
        if (iWork != null) {
            iWork.doWork();
        } else {
            System.err.println("do not deal");
        }

    }

    interface IWork {
        void doWork();
    }
}
