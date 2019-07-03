package daily.andorid.sprout.daily.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import daily.andorid.sprout.daily.Database.CounterRepository;
import daily.andorid.sprout.daily.Database.endity.Counter;

public class CounterViewModel extends AndroidViewModel {

    private CounterRepository counterRepository;

    private LiveData<Counter> counter;
    private LiveData<List<Counter>> allCounterHistory;


    public CounterViewModel(@NonNull Application application) {
        super(application);
        counterRepository = new CounterRepository(application);

        allCounterHistory = counterRepository.getAllCountersHistory();

    }

    public LiveData<Counter> getCounter(String name) {
        return counterRepository.getCurrentCounter(name);
    }

    public LiveData<List<Counter>> getAllCounterHistory() {
        return counterRepository.getAllCountersHistory();
    }

    public void insertCurrentCounter(Counter counter) {
        counterRepository.insertCounter(counter);
    }

    public void insertCounterHistory(Counter counter) {
        counterRepository.insertCounterHistory(counter);
    }


}
