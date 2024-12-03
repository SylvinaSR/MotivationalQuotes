package com.sylviepractices.motivationalquotes.ui.quote

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sylviepractices.motivationalquotes.model.QuoteModel
import com.sylviepractices.motivationalquotes.ui.theme.PurpleCustom
import com.sylviepractices.motivationalquotes.ui.theme.White

@Composable
fun QuoteScreen(viewModel: QuoteViewModel) {

    val currentQuote: QuoteModel by viewModel.quoteModel.observeAsState(
        initial = QuoteModel(
            "",
            ""
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PurpleCustom)
            .clickable {
                viewModel.randomQuote()
            },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            text = currentQuote.quote,
            fontSize = 32.sp,
            textAlign = TextAlign.Center,
            color = White,
            style = TextStyle(fontFamily = FontFamily.Cursive)
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp),
            text = currentQuote.author,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            color = White,
            style = TextStyle(fontFamily = FontFamily.SansSerif)
        )
    }
}