package com.sylviepractices.motivationalquotes.domain.usecases

import com.sylviepractices.motivationalquotes.domain.repository.QuotesRepository
import com.sylviepractices.motivationalquotes.model.QuoteModel
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test


class GetCurrentQuoteUseCaseTest {

    @RelaxedMockK
    private lateinit var quoteRepository: QuotesRepository

    lateinit var getCurrentQuoteUseCase: GetCurrentQuoteUseCase

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        getCurrentQuoteUseCase = GetCurrentQuoteUseCase(quoteRepository)
    }


    /* En este test revisamos que cuando se llame al metodo getQuotesFromDatabase y la lista venga
    vacia, entonces el resultado de GetCurrentQuoteUseCase debe ser igual a nulo
    * */
    @Test
    fun `when DB is empty then return null`() = runBlocking {
        //Given
        coEvery { quoteRepository.getQuotesFromDatabase() } returns emptyList()

        //When
        val response = getCurrentQuoteUseCase()

        //Then
        assert(response == null)
    }

    /* En este test revisamos que cuando se llame al metodo getQuotesFromDatabase y la lista NO este
    vacia, entonces el resultado de getCurrentQuoteUseCase debe ser igual a una QuoteModel
    En este caso como la lista propuesta contiene un solo elemento, entonces el assert revisa
    que getCurrentQuoteUseCase sea igual a ese unico elemento.
    Recordar que en el caso de uso
    cuando la lista no esta vacia hacemos un return quotes[(quotes.indices).random()], como esta lista
    tiene un solo elemento, retornara siempre el mismo valor.
    * */
    @Test
    fun `when DB is not empty then return a list of quotes`() = runBlocking {

        //Given
        val myList = listOf(QuoteModel(author = "Sylvie", quote = "Esto es un test"))
        coEvery { quoteRepository.getQuotesFromDatabase() } returns myList

        //When
        val response = getCurrentQuoteUseCase()

        //Then
        assert(response == myList.first())

    }

}