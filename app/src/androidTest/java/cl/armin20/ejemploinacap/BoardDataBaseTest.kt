package cl.armin20.ejemploinacap

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import cl.armin20.ejemploinacap.data.local.BoardDao
import cl.armin20.ejemploinacap.data.local.BoardGamesDataBase
import cl.armin20.ejemploinacap.data.local.entities.BoardGameLocal
import cl.armin20.ejemploinacap.data.model.Classification
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class BoardDataBaseTest {


    private lateinit var boardDao: BoardDao
    private lateinit var db: BoardGamesDataBase

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, BoardGamesDataBase::class.java)
            .allowMainThreadQueries()
            .build()
        boardDao = db.getBoardGameDao()
    }

    @After
    fun tearDown() {
        db.close()
    }

    @Test
    fun verifyInsertEmptyBoarData() = runBlocking {
        //Given
        val stopData = listOf<BoardGameLocal>()
        //when
        boardDao.insertAllBoardGames(stopData)
        //then
        boardDao.getAllBoardGames().observeForever {
            assertNotNull(it)
            assertEquals(emptyList<BoardGameLocal>(), it)
        }
    }

    @Test
    fun verifyInsertListOfBoarData() = runBlocking {
        //Given
        val stopData = returnBoardGameLocal()
        //when
        boardDao.insertAllBoardGames(stopData)
        //then
        val expectedSize = 1
        boardDao.getAllBoardGames().observeForever {
            assertNotNull(it)
            assertEquals(expectedSize , it.size)
        }
    }

    companion object {
        fun returnBoardGameLocal(): List<BoardGameLocal> {
            return listOf(BoardGameLocal(1,"22","url","122", "asaq","123",1923,"12","123", "123","12","123", "123", Classification("", "")))
        }
    }
}