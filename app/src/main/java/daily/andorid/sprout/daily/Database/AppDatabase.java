package daily.andorid.sprout.daily.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import daily.andorid.sprout.daily.Database.dao.CounterDao;
import daily.andorid.sprout.daily.Database.dao.CounterHistoryDao;
import daily.andorid.sprout.daily.Database.endity.Counter;
import daily.andorid.sprout.daily.Database.endity.CounterHistory;

@Database(entities = {Counter.class, CounterHistory.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract CounterDao counterDao();
    public abstract CounterHistoryDao counterHistoryDao();

    private static volatile AppDatabase INSTANCE;

    static AppDatabase getInstance(final Context context) {

        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, AppDatabase.class, "app_database").build();
                }
            }
        }

        return INSTANCE;
    }


}
