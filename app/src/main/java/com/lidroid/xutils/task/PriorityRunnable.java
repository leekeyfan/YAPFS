package com.lidroid.xutils.task;

public class PriorityRunnable extends com.lidroid.xutils.task.PriorityObject<Runnable> implements Runnable {

    public PriorityRunnable(Priority priority, Runnable obj) {
        super(priority, obj);
    }

    @Override
    public void run() {
        this.obj.run();
    }
}
