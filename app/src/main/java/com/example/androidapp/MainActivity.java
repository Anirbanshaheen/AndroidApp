package com.example.androidapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import android.content.Intent;
import android.os.Bundle;

import com.example.androidapp.databinding.ActivityMainBinding;
import com.example.androidapp.rv.TodoActivity;
import com.example.androidapp.work_manager.MyWorker1;
import com.example.androidapp.work_manager.MyWorker2;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        /**
         * One time work request
         */
        oneTimeWorkRequest();

        /**
         * Periodic work request
         */
        periodicWorkRequest();

        /**
         * Chaining work
         */
        chainingWork();
        nextRV();
    }

    private void nextRV() {
        binding.nextBtn.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), TodoActivity.class);
            startActivity(intent);
        });
    }

    private void oneTimeWorkRequest() {
        /**
         * Passing input Data via work request and For Data passing and retrieving, max data size limit is 10Kb
         */
        Data inputData = new Data.Builder().putString("input_data", "This is input data").build();

        /**
         * For passing constraints
         */
        Constraints constraints = new Constraints.Builder()
                .setRequiredNetworkType(NetworkType.UNMETERED)
                .setRequiresBatteryNotLow(true)
                .setRequiresCharging(false)
                .setRequiresStorageNotLow(true)
                .build();

        /*OneTimeWorkRequest oneTimeWorkRequest = new OneTimeWorkRequest.Builder(MyWorker1.class)
                .setConstraints(constraints)
                .setInputData(inputData) // input data
                .build();

        binding.doWorkBtn.setOnClickListener(view -> {
            WorkManager.getInstance(MainActivity.this).enqueue(oneTimeWorkRequest);
        });

        WorkManager.getInstance(this).getWorkInfoByIdLiveData(oneTimeWorkRequest.getId()).observe(this, new Observer<WorkInfo>() {
            @Override
            public void onChanged(WorkInfo workInfo) {
                String status = workInfo.getState().name();
                binding.resultTV.append(status + "\n");

                if (workInfo != null) {
                    if (workInfo.getState().isFinished()) {
                        Data retrievedDataFromWorker = workInfo.getOutputData();
                        String outputDataFromWorker = retrievedDataFromWorker.getString("output_data");

                        binding.resultTV.append(outputDataFromWorker + "\n");
                    }
                }
            }
        });*/
    }

    private void periodicWorkRequest() {
        /*PeriodicWorkRequest periodicWorkRequest = new PeriodicWorkRequest.Builder(MyWorker1.class, 15, TimeUnit.MINUTES).build();

        binding.doWorkBtn.setOnClickListener(view -> {
            WorkManager.getInstance(MainActivity.this).enqueue(periodicWorkRequest);
        });

        WorkManager.getInstance(this).getWorkInfoByIdLiveData(periodicWorkRequest.getId()).observe(this, new Observer<WorkInfo>() {
            @Override
            public void onChanged(WorkInfo workInfo) {
                String status = workInfo.getState().name();
                binding.resultTV.append(status + "\n");
            }
        });

        binding.cancelBtn.setOnClickListener(view -> {
            WorkManager.getInstance(MainActivity.this).cancelWorkById(periodicWorkRequest.getId());
        });*/
    }

    private void chainingWork() {
        /*Data inputDataW1 = new Data.Builder().putInt("input_data_1st_work", 10).build();

        OneTimeWorkRequest oneTimeWorkRequest1 = new OneTimeWorkRequest.Builder(MyWorker1.class)
                .setInputData(inputDataW1)
                .addTag("MyWork")
                .build();

        OneTimeWorkRequest oneTimeWorkRequest2 = new OneTimeWorkRequest.Builder(MyWorker2.class)
                .addTag("MyWork")
                .build();

        binding.doWorkBtn.setOnClickListener(view -> {
            WorkManager.getInstance(MainActivity.this)
                    .beginWith(oneTimeWorkRequest1)  // we can set oneTimeWorkRequest2, oneTimeWorkRequest3 these work request but then it will do parallel work.
                    .then(oneTimeWorkRequest2)
                    .enqueue();
        });

        WorkManager.getInstance(this).getWorkInfosByTagLiveData("MyWork").observe(this, new Observer<List<WorkInfo>>() {
            @Override
            public void onChanged(List<WorkInfo> workInfos) {
                if (workInfos.size() != 0){
                    for (int i=0; i<workInfos.size(); i++){
                        String status = workInfos.get(i).getState().name();
                        binding.resultTV.append(status + "\n");

                        if (workInfos.get(i).getState().isFinished()) {
                            Data retrieveData = workInfos.get(i).getOutputData();
                            int outputData = retrieveData.getInt("output_data_chaining_work_2nd", 0);
                            if (outputData > 0){
                                binding.resultTV.append(outputData + "\n");
                            }
                        }
                    }
                }
            }
        });*/
    }
}