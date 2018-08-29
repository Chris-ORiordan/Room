package com.example.standard.room;

import android.os.AsyncTask;

public class DatabaseInitialiser {

    public String TAG = DatabaseInitialiser.class.getSimpleName();

    private static User addUser(final AppDatabase db, User user){
        db.userDAO().insertAll(user);
        return user;
    }

    private static void populateWithTestData(AppDatabase db){
        User user = new User();
        user.setFirstName("Chris");
        user.setLastName("O Riordan");
        user.setAge(23);
        addUser(db, user);
    }

    private static class populateDBAsync extends AsyncTask<Void, Void, Void> {

        private final AppDatabase mDb;

        populateDBAsync(AppDatabase db) {mDb = db;}

        @Override
        protected Void doInBackground(Void... voids) {
            populateWithTestData(mDb);
            return null;
        }
    }
}
