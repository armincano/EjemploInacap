package cl.armin20.ejemploinacap.data

import cl.armin20.ejemploinacap.data.local.entities.BoardGameLocal
import cl.armin20.ejemploinacap.data.model.BoardGame


fun fromRemoteToLocalEntity(wrapper: List<BoardGame>) : List<BoardGameLocal> {
    return wrapper.map {
        BoardGameLocal(id = it.id,
            name = it.name,
            image = it.image,
            price = it.price,
            players = it.players,
            age = it.age,
            year = it.year,
            playingTime = it.playingTime,
            description = it.description,
            officialLink = it.officialLink,
            designer = it.designer,
            artist = it.artist,
            publisher = it.publisher,
            classification = it.classification
        )
    }
}