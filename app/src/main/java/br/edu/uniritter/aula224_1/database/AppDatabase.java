package br.edu.uniritter.aula224_1.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Cliente.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
   public abstract ClienteDAO clienteDAO();

   private static volatile AppDatabase INSTANCE;
   private static final int NUMBER_OF_THREADS = 4;
   static final ExecutorService databaseWriteExecutor =
           Executors.newFixedThreadPool(NUMBER_OF_THREADS);

   public static AppDatabase getDatabase(final Context context) {
      if (INSTANCE == null) {
         synchronized (AppDatabase.class) {
            if (INSTANCE == null) {
               INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                               AppDatabase.class, "aula224")
                       .build();
            }
         }
      }
      return INSTANCE;
   }

}
