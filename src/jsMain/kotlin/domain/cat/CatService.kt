package domain.cat

import kotlinx.serialization.Serializable

interface CatService {
    suspend fun getRandomCatFact(): CatFact
}

@Serializable
data class CatFact(
    val fact: String,
)
