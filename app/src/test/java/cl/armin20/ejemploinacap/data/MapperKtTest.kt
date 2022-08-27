package cl.armin20.ejemploinacap.data

import cl.armin20.ejemploinacap.data.local.entities.BoardGameLocal
import cl.armin20.ejemploinacap.data.model.BoardGame
import cl.armin20.ejemploinacap.data.model.Classification
import org.junit.Assert.*
import org.junit.Test

class MapperKtTest {

    @Test
    fun `verify boardRemote to boardRemoteLocal`() {
        //Given
        val wrapper = returnBoardGame()

        //When
        val result = fromRemoteToLocalEntity(wrapper)

        //Then
        assertNotNull(result)
        assertEquals(returnBoardGameLocal(), result)

    }

    companion object {
        fun returnBoardGame(): List<BoardGame> {
            return listOf(BoardGame(1,"22","url","122", "asaq","123",1923,"12","123", "123","12","123", "123", Classification("", "")))
        }

        fun returnBoardGameLocal(): List<BoardGameLocal> {
            return listOf(BoardGameLocal(1,"22","url","122", "asaq","123",1923,"12","123", "123","12","123", "123", Classification("", "")))
        }
    }

}