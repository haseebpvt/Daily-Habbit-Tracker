package daily.andorid.sprout.daily.Database.endity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * A table which saves all history of counters
 */
@Entity(tableName = "counter_history_table")
public class CounterHistory {

    /**
     * Unique id
     */
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "_id")
    private int id;

    /**
     * Name of the database
     */
    @NonNull
    @ColumnInfo(name = "counter_name")
    private String name;

    /**
     * Day the counter started
     */
    @ColumnInfo(name = "start_date")
    private String date;

    /**
     * Time the counter started
     */
    @ColumnInfo(name = "start_time")
    private String time;

    /**
     * Number of days completed
     */
    @ColumnInfo(name = "elapsed_days")
    private int daysElapshed;

    /**
     * A boolean flag that shows if the
     * counter is currently running
     */
    @ColumnInfo(name = "currently_running")
    private boolean isRunning;


    //Getters and Setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }
}
