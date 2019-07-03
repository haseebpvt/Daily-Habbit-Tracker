package daily.andorid.sprout.daily.Database;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;

import java.util.List;

import daily.andorid.sprout.daily.Database.AppDatabase;
import daily.andorid.sprout.daily.Database.dao.CounterDao;
import daily.andorid.sprout.daily.Database.dao.CounterHistoryDao;
import daily.andorid.sprout.daily.Database.endity.Counter;

public class CounterRepository {

    private CounterDao counterDao;
    private CounterHistoryDao counterHistoryDao;

    LiveData<Counter> counter;
    LiveData<List<Counter>> allCountersHistory;

    public CounterRepository(Application application) {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        counterDao = appDatabase.counterDao();
        counterHistoryDao = appDatabase.counterHistoryDao();

        allCountersHistory = counterHistoryDao.getAllCounters();
    }

    public void setCounterDao(CounterDao counterDao) {
        this.counterDao = counterDao;
    }

    public void setCounterHistoryDao(CounterHistoryDao counterHistoryDao) {
        this.counterHistoryDao = counterHistoryDao;
    }

    public LiveData<Counter> getCurrentCounter(String name) {
        return counterDao.getCounter(name);
    }

    public LiveData<List<Counter>> getAllCountersHistory() {
        return allCountersHistory;
    }

    public void insertCounter(Counter counter) {
        new insertCounterAsync(counterDao).execute(counter);
    }

    public void insertCounterHistory(Counter counter) {
        Log.d("custom_tag", "Inserting counter history");
        new insertCounterHistoryAsync(counterHistoryDao).execute(counter);
    }

    private static class insertCounterAsync extends AsyncTask<Counter, Void, Void> {

        private CounterDao asyncCounterDao;

        public insertCounterAsync(CounterDao asyncCounterDao) {
            this.asyncCounterDao = asyncCounterDao;
        }

        @Override
        protected Void doInBackground(Counter... counters) {
            asyncCounterDao.insertCounter(counters[0]);
            return null;
        }
    }

    private static class insertCounterHistoryAsync extends AsyncTask<Counter, Void, Void> {

        private CounterHistoryDao asyncCounterHistoryDao;

        public insertCounterHistoryAsync(CounterHistoryDao asyncCounterHistoryDao) {
            this.asyncCounterHistoryDao = asyncCounterHistoryDao;
        }

        @Override
        protected Void doInBackground(Counter... counters) {
            asyncCounterHistoryDao.insertCounter(counters[0]);
            return null;
        }
    }

}
