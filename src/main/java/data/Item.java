package data;

import constants.Constants;
import data.jobs.Deadline;
import data.jobs.Event;
import data.jobs.Task;
import data.jobs.ToDo;
import exceptions.CommandException;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * The type Item.
 */
public class Item {

    /**
     * Item description.
     */
    protected String description;

    /**
     * The Is dated.
     */
    public boolean isDated = false;

    /**
     * The Is Weekly.
     */
    public boolean isWeekly = false;/**
     * The Is Weekly.
     */
    public static boolean WeeklyFlag = false;
    /**
     * Item Date time.
     */
    protected LocalDateTime dateTime;

    public boolean isSelected;

    /**
     * Instantiates a new Item.
     *
     * @param description the description
     */
    public Item(String description) {
        this.description = description;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return description;
    }


    private static ArrayList<String> getPatterns(boolean isDateOnly) {
        ArrayList<String> patterns = new ArrayList<>();
        if (isDateOnly) {
            for (String datePattern : Constants.DATE_PATTERNS) {
                patterns.add(datePattern);
                patterns.add(datePattern.replace(Constants.PARAM_ALIAS, Constants.PARAM));
                patterns.add(datePattern.replace(Constants.PARAM_ALIAS, Constants.CHAR_SPACE));
            }
        } else {
            for (String datePattern : Constants.DATE_PATTERNS) {
                for (String timePattern : Constants.TIME_PATTERNS) {
                    String concat = datePattern + Constants.SPACE + timePattern;
                    patterns.add(concat);
                    patterns.add(concat.replace(Constants.PARAM_ALIAS, Constants.PARAM));
                    patterns.add(concat.replace(Constants.PARAM_ALIAS, Constants.CHAR_SPACE));
                }
            }
        }
        return patterns;
    }

    /**
     * Parse date time local date time.
     *
     * @param input date time in string
     * @return the local date time
     */
    public static LocalDateTime parseDateTime(String input) {
        if (input.contains("Weekly")) {
            WeeklyFlag = true;
            input = input.replace("Weekly","");
        }
        LocalDateTime dateTime = null;
        ArrayList<String> patterns = getPatterns(false);
        for (String pattern : patterns) {
            if (dateTime == null) {
                try {
                    dateTime = LocalDateTime.parse(input.trim(), DateTimeFormatter.ofPattern(pattern));
                } catch (Exception e) {
                    e.addSuppressed(new CommandException()); // do nothing basically.
                }
            } else {
                break;
            }
        }
        if (dateTime == null) {
            patterns = getPatterns(true);
            for (String datePattern : patterns) {
                if (dateTime == null) {
                    try {
                        dateTime = LocalDate.parse(input.trim(),
                                DateTimeFormatter.ofPattern(datePattern)).atStartOfDay();
                    } catch (Exception e) {
                        e.addSuppressed(new CommandException()); // do nothing basically.
                    }
                } else {
                    break;
                }
            }
        }
        return dateTime;
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public LocalDate getDate() {
        if (dateTime == null) {
            return null;
        } else {
            return dateTime.toLocalDate();
        }
    }

    /**
     * Gets date time.
     *
     * @param date the date
     */
    protected void setDateTime(String date) {
        dateTime = parseDateTime(date);
        isDated = dateTime != null;
        isWeekly = WeeklyFlag;
    }

    /**
     * Sets date time using LocalDatetime.
     *
     * @param date the date
     */
    protected void setDateTime(LocalDateTime date) {
        dateTime = date;
        isDated = dateTime != null;
        isWeekly = true;
    }

    /**
     * Gets time.
     *
     * @return the time
     */
    public LocalTime getTime() {
        if (dateTime == null) {
            return null;
        } else {
            return dateTime.toLocalTime();
        }
    }


    /**
     * Gets date time.
     *
     * @return the date time
     */
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    /**
     * Gets date time string.
     *
     * @param input date time input
     * @return the date time string
     */
    protected String getDateTimeString(String input) {
        String result;
        DateTimeFormatter datePattern = DateTimeFormatter.ofPattern("MMM dd yyyy");
        if (dateTime == null) {
            result = input;
        } else {
            String date = getDate().format(datePattern);
            String time = getTime().toString();
            result = date + Constants.SPACE + time;
        }
        return result;
    }

    public String getDetails() {
        return toString().concat(isSelected ? " Selected" : "");
    }

    public DayOfWeek getDay() {
        LocalDateTime theDate = getDateTime();
        return theDate.getDayOfWeek();
    }

}