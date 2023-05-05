package com.example.coffeehouse.data.data_source;


import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.example.coffeehouse.data.models.User;

public class UserSettingsSyncWorker extends Worker {
    private static final String TAG = UserSettingsSyncWorker.class.getSimpleName();
    UserLocalDataSourceImpl localDataSource;
    UserRemoteDataSource remoteDataSource;

    public UserSettingsSyncWorker(@NonNull Context context,
                                  @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        localDataSource = new UserLocalDataSourceImpl(context);
        remoteDataSource = new UserRemoteDataSourceImpl();
    }

    @NonNull
    @Override
    public Result doWork() {
        try {
            User localUsers = localDataSource.getUser();
            remoteDataSource.pushUser(localUsers);

            return Result.success();
        } catch (Throwable throwable) {
            Log.e(TAG, "Error while sync");
            return Result.failure();
        }
    }
}
