package org.lessons.best_of_the_year.best_of_the_year.classes;

public class Movie {
    private int id;
    private String title;

    public Movie(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
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
