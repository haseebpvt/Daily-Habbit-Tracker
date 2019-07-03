package daily.andorid.sprout.daily.Database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import daily.andorid.sprout.daily.Database.endity.Counter;

@Dao
public interface CounterHistoryDao {

    @Insert
    void insertCounter(Counter counter);

    @Query("SELECT * FROM counter_history_table")
    LiveData<List<Counter>> getAllCounters();

}
