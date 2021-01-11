package com.company;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class RecurringAlarm extends StickyNote implements Scheduled {
    private LocalTime time;
    private LocalDate dismissDate;

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    @Override
    public boolean isDue() {
        return !LocalDate.now().equals(dismissDate) && LocalTime.now().isAfter(time);
    }

    @Override
    public void dismiss() {
        dismissDate = LocalDate.now();
    }

    @Override
    public boolean contains(String substr) {
        return super.contains(substr)
                || InputUtils.timeToString(time).toLowerCase().contains(substr);
    }

    @Override
    public void askData() {
        super.askData();
        time = InputUtils.askTime("Time");
    }

    @Override
    public String toString() {
        var str =  super.toString();
        return String.format("%s; time: %s", str, InputUtils.timeToString(time));
    }
}
