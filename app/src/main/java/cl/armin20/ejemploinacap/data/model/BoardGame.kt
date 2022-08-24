package cl.armin20.ejemploinacap.data.model

data class BoardGame(
    val id: Int,
    val name: String,
    val image: String,
    val price: String,
    val players: String,
    val age: String,
    val year: Int,
    //TODO serialized
    val playingTime: String,
    val description: String,
    //TODO serialized
    val officialLink: String,
    //TODO serialized
    val designer: String,
    //TODO serialized
    val artist: String,
    //TODO serialized
    val publisher: String,
    val classification:Classification
)

data class Classification(
    val category: String,
    val mechanisms: String
)

/*
"id": 1,
"name": "Clank! Catacombs",
"image": "https://user-images.githubusercontent.com/22780253/176972254-e8a3b0d2-0e69-436a-9b4d-c34e773ba320.jpg",
"price": "350 USD",
"players": "2-4",
"age": "13+",
"year": 2022,
"playing_time": "45-90 min",
"description": "Deck-building adventure meets tile-laying in the newest incarnation of Clank!",
"official_link": "https://www.direwolfdigital.com/clank-catacombs/",
"Designer": "Paul Dennen",
"Artist": "Clay Brooks, Anika Burrell, Nate Storm, Dan Taylor (II)",
"Publisher": "Dire Wolf",
"classification": {
    "category": "adventure - fantasy",
    "mechanisms": "Deck, Bag, and Pool Building"*/
