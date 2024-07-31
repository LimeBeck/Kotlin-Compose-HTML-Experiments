package domain.cat

class CatServiceMock : CatService {
    override suspend fun getRandomCatFact(): CatFact = CatFact("Cat has 9 lives")
}
