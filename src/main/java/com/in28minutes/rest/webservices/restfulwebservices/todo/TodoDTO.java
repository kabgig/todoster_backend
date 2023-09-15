package com.in28minutes.rest.webservices.restfulwebservices.todo;

import java.time.LocalDate;

public class TodoDTO {
    private Integer id;
    private String description;
    private LocalDate targetDate;
    private boolean done;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "TodoDTO{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", targetDate=" + targetDate +
                ", done=" + done +
                '}';
    }
}
