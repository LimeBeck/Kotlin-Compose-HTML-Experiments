package domain.cat

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class CatServiceKtor(
    val client: HttpClient,
) : CatService {
    override suspend fun getRandomCatFact(): CatFact = client.get("https://catfact.ninja/fact").body()
}
