package com.lidroid.xutils.task;

public class PriorityObject<E> {

    public final com.lidroid.xutils.task.Priority priority;
    public final E obj;

    public PriorityObject(com.lidroid.xutils.task.Priority priority, E obj) {
        this.priority = priority == null ? com.lidroid.xutils.task.Priority.DEFAULT : priority;
        this.obj = obj;
    }
}
