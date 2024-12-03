package com.sylviepractices.motivationalquotes.model

class QuotesModelDummy {

    companion object {

        fun randomQuote(): QuoteModel = list[(0..10).random()]


        private val list = mutableListOf(
            QuoteModel(
                quote = "El éxito es la suma de pequeños esfuerzos repetidos día tras día.",
                author = "— Robert Collier"
            ),
            QuoteModel(
                quote = "El único lugar donde el éxito viene antes que el trabajo es en el diccionario.",
                author = "— Vidal Sassoon"
            ),
            QuoteModel(
                quote = "Nuestra mayor gloria no está en no caer nunca, sino en levantarnos cada vez que caemos.",
                author = "— Confucio"
            ),
            QuoteModel(
                quote = "El optimismo es la fe que conduce al logro. Nada puede hacerse sin esperanza y confianza.",
                author = "— Helen Keller"
            ),
            QuoteModel(
                quote = "La manera de empezar es dejar de hablar y comenzar a hacer.",
                author = "— Walt Disney"
            ),
            QuoteModel(
                quote = "No importa lo lento que vayas, siempre y cuando no te detengas.",
                author = "— Confucio"
            ),
            QuoteModel(
                quote = "El secreto del éxito es constancia en el propósito.",
                author = "— Benjamin Disraeli"
            ),
            QuoteModel(
                quote = "Cree que puedes y ya estás a mitad de camino.",
                author = "— Theodore Roosevelt"
            ),
            QuoteModel(
                quote = "Haz lo que puedas, con lo que tengas, donde estés.",
                author = "— Theodore Roosevelt"
            ),
            QuoteModel(
                quote = "El futuro pertenece a quienes creen en la belleza de sus sueños.",
                author = "— Eleanor Roosevelt"
            )
        )


    }

}