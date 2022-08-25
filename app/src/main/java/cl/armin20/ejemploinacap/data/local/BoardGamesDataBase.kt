package cl.armin20.ejemploinacap.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import cl.armin20.ejemploinacap.data.local.entities.BoardGameLocal

@Database(
    entities = [BoardGameLocal::class],
    version = 1,
    exportSchema = false
)
abstract class BoardGamesDataBase: RoomDatabase() {

    abstract fun getBoardGameDao(): BoardDao

    companion object {
        @Volatile
        private var INSTANCE: BoardGamesDataBase? = null

        fun getDataBase(context: Context): BoardGamesDataBase {
            return INSTANCE ?: synchronized(this) {
                val tempInstance = Room.databaseBuilder(
                    context.applicationContext,
                    BoardGamesDataBase::class.java,
                    "BoardGameDB"
                ).build()
                INSTANCE  = tempInstance
                return tempInstance
            }
        }
    }
}