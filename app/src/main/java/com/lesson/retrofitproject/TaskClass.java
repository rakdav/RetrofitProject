package com.lesson.retrofitproject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TaskClass
{
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("dateCreated")
    @Expose
    private String dateCreated;
    @SerializedName("done")
    @Expose
    private boolean done;
    @SerializedName("task")
    @Expose
    private String task;

    public String getId() {
        return id;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public boolean isDone() {
        return done;
    }

    public String getTask() {
        return task;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
