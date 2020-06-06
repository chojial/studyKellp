package com.study.file.mywork;


/**
 * @author：xxx
 */
public class precedencesTest {



    public static void main(String[] args) {
        // make the boolean array of precedences
        // and the array of Runnable
        boolean [][] precedences = {{ false,   true,  false,  false,  false,  false },
                { false,  false,   true,  true, false ,  false  },
                { false,  false,  false,  true,  false,  true   },
                { false,  false,  false,  false,  false,  false },
                { false,  false,  false,  true,  false,  true   },
                { false,  false,  false,  false,  false,  false }
        };

        Runnable []  tasks = {new Executor.Task0(),new Executor.Task1(),new Executor.Task2(),
                new Executor.Task3(),new Executor.Task4(),new Executor.Task5()};



        // construct an Executor
        Executor  quicheMaker = new Executor( precedences, tasks);

        // run it
        quicheMaker.run();

    }
}
