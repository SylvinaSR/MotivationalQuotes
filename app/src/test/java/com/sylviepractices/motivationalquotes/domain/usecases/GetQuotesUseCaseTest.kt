package com.sylviepractices.motivationalquotes.domain.usecases

import com.sylviepractices.motivationalquotes.domain.repository.QuotesRepository
import com.sylviepractices.motivationalquotes.model.QuoteModel
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetQuotesUseCaseTest {

    /* En este caso vamos a trucar el QuotesRepository que es necesario en
    GetQuotesUseCase, para eso funciona mock. Si no definimos una de las respuestas
    de la clase que estamos creando, nos la va a generar con @RelaxedMockk.
    Si ponemos solo @Mockk y la clase QuotesRepository accede a algo que no hemos preparado,
    el test fallara
    * */

    @RelaxedMockK
    private lateinit var quoteRepository: QuotesRepository

    lateinit var getQuotesUseCase: GetQuotesUseCase

    //Función que va a ejecutarse antes de que se haga el test
    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        getQuotesUseCase = GetQuotesUseCase(quoteRepository)
    }

    /*En este test, revisamos que cada que el metodo getQuotesFromService() retorne un emptyList,
    cuando llamamos getQuotesUseCase se use el metodo getQuotesFromDatabase()
    * */
    @Test
    fun `when the API does not return anything then get values from DB`() = runBlocking {
        //Given

        //coEvery, siempre que recibamos el mock
        coEvery { quoteRepository.getQuotesFromService() } returns emptyList()

        //When
        getQuotesUseCase()

        //Then
        coVerify(exactly = 1) { quoteRepository.getQuotesFromDatabase() }
    }


    /*En este test, verificamos que si la API retorna un valor diferente a emptylist,
    se llamen los metodos clearQuotes() e insertQuotes(), ademas hacemos un check de que NO
    se llame al metodo getQuotesFromDatabase. Finalmente, verificamos que lo recibido en
    quoteRepository.getQuotesFromService() sea igual a lo que hay en getQuotesUseCase()
    * */
    @Test
    fun `When the API returns something then get values from API`() = runBlocking {

        //Given
        val myList = listOf(QuoteModel(author = "Sylvie", quote = "Esto es un test"))
        coEvery { quoteRepository.getQuotesFromService() } returns myList

        //When
        val response = getQuotesUseCase()

        //Then
        coVerify(exactly = 1) { quoteRepository.clearQuotes() }
        coVerify(exactly = 1) { quoteRepository.insertQuotes(any()) }
        coVerify(exactly = 0) { quoteRepository.getQuotesFromDatabase() } //Verificamos que NO se llame este metodo
        assert(myList == response)
    }


}