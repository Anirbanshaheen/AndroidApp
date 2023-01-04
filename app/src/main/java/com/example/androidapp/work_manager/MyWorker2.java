package com.example.androidapp.work_manager;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class MyWorker2 extends Worker {

    public MyWorker2(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {

        Data retrieveDataFromMyW1 = getInputData();
        int value = retrieveDataFromMyW1.getInt("output_data_chaining_work_1st", 10);

        value = value * 100;

        Data outputDataChainingWork2nd = new Data.Builder().putInt("output_data_chaining_work_2nd", value).build();

        return Result.success(outputDataChainingWork2nd);
    }
}
