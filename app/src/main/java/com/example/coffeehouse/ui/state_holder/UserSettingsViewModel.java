package com.example.coffeehouse.ui.state_holder;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import com.example.coffeehouse.data.data_source.UserSettingsSyncWorker;

public class UserSettingsViewModel extends AndroidViewModel {
    private final WorkManager workManager;

    public UserSettingsViewModel(@NonNull Application application) {
        super(application);
        workManager = WorkManager.getInstance(application);
    }

    public void syncSettings(){
        workManager.enqueue(OneTimeWorkRequest.from(UserSettingsSyncWorker.class));
    }
}
