package daily.andorid.sprout.daily.Database.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import daily.andorid.sprout.daily.Database.endity.Counter;

@Dao
public interface CounterDao {

    @Insert
    void insertCounter(Counter counter);

    @Query("SELECT * FROM counter_table WHERE counter_name LIKE :name")
    LiveData<Counter> getCounter(String name);

}
