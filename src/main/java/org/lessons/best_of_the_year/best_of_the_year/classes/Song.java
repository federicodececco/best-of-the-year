package org.lessons.best_of_the_year.best_of_the_year.classes;

import java.io.Serializable;

public class Song implements Serializable {
    private int id;
    private String title;

    public Song(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public  int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {

        return id + " " + title;
    }
}
