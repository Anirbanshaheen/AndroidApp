package com.example.androidapp.work_manager;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.example.androidapp.R;

public class MyWorker1 extends Worker {

    public MyWorker1(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {

        /**
         *  Chaining work
         */
        Data retrieveDataW1 = getInputData();
        int value = retrieveDataW1.getInt("input_data_1st_work", 5);

        int sum = 0;
        for (int i = 0; i<value; i++){

            // for showing data, we use thread to delay
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            sum = sum + i;
        }
        Data outputDataChainingWork1st = new Data.Builder().putInt("output_data_chaining_work_1st", sum).build();



        Data retrievedData = getInputData(); // From Main Activity class
        String desc = retrievedData.getString("input_data");

        displayNotification("Title", desc);

        /**
         * For Data passing and retrieving, max data size limit is 10Kb
         */
        Data outputData = new Data.Builder().putString("output_data", "This is an output data").build();
        isStopped(); // related to onStopped() method

        return Result.success(outputDataChainingWork1st);
    }

    /**
     * For running work, this is how to cancel
     */
    @Override
    public void onStopped() {
        super.onStopped();
    }

    private void displayNotification(String task, String desc) {

        NotificationManager manager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("shaheen1", "shaheen", NotificationManager.IMPORTANCE_DEFAULT);
            manager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), "shaheen1")
                .setContentText(task)
                .setContentText(desc)
                .setSmallIcon(R.mipmap.ic_launcher);

        manager.notify(1, builder.build());
    }
}
