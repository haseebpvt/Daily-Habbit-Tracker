package daily.andorid.sprout.daily;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import daily.andorid.sprout.daily.Database.endity.Counter;
import daily.andorid.sprout.daily.ViewModel.CounterViewModel;

public class MainActivity extends AppCompatActivity {

    private CounterViewModel counterViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counterViewModel = ViewModelProviders.of(this).get(CounterViewModel.class);

//        for (int i = 0; i < 5; i++) {
//            Counter counter = new Counter();
//            counter.setName("Hello" + i);
//            counter.setDate(Integer.toString(i));
//            counter.setRunning(false);
//            counter.setTime(Integer.toString(i));
//
//            counterViewModel.insertCounterHistory(counter);
//        }
//
//        counterViewModel.getAllCounterHistory().observe(this, new Observer<List<Counter>>() {
//            @Override
//            public void onChanged(List<Counter> counters) {
//                for (Counter c : counters) {
//                    Log.d("custom_tag", c.getName());
//                }
//            }
//        });

    }
}
