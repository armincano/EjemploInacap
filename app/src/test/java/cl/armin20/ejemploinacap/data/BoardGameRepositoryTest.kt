package cl.armin20.ejemploinacap.data

import cl.armin20.ejemploinacap.data.local.BoardDao
import cl.armin20.ejemploinacap.data.model.BoardGame
import cl.armin20.ejemploinacap.data.model.Classification
import cl.armin20.ejemploinacap.data.remote.BoardApi
import com.google.gson.Gson
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class BoardGameRepositoryTest {

    private lateinit var boardDao: BoardDao
    private lateinit var service: BoardApi
    private lateinit var boardGameRepository: BoardGameRepository
    private lateinit var mockWebServer: MockWebServer

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        service = Retrofit.Builder()
            .baseUrl(mockWebServer.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BoardApi::class.java)

        boardDao = mock()
        boardGameRepository = BoardGameRepository(boardDao)
    }


    @Test
    fun `verify server response is success`() = runBlocking  {
        val response = returnBoardGame()
        mockWebServer.enqueue(MockResponse().setBody(Gson().toJson(response)))

        val result = service.getBoardGamesData()

        assertNotNull(result.body())
        assertEquals(1, result.body()!!.size)
        assertTrue(result.isSuccessful)
    }


    @Test
    fun `verify server response is success whe search by id`() = runBlocking  {
        val response = returnBoardGame()[0]
        mockWebServer.enqueue(MockResponse().setBody(Gson().toJson(response)))

        val result = service.getBoardGame(1)

        assertTrue(result.isSuccessful)
        assertEquals(returnBoardGame()[0], result.body())
    }

    companion object {
        fun returnBoardGame(): List<BoardGame> {
            return listOf(BoardGame(1,"22","url","122", "asaq","123",1923,"12","123", "123","12","123", "123", Classification("", "")))
        }
    }
}