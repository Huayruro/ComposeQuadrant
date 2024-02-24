package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    ComposeQuadrant(
                        stringResource(R.string.title_one),
                        stringResource(R.string.text_one),
                        stringResource(R.string.title_two),
                        stringResource(R.string.text_two),
                        stringResource(R.string.title_three),
                        stringResource(R.string.text_three),
                        stringResource(R.string.title_four),
                        stringResource(R.string.text_four)
                    )
                }
            }
        }
    }
}

@Composable
fun ComposeQuadrant(titleOne: String, textOne:String,titleTwo: String, textTwo:String,titleThree: String, textThree:String,titleFour: String, textFour:String) {
    Column (Modifier.fillMaxWidth()) {
        Row (Modifier.weight(1f)){
            Quadrant(title = titleOne, text = textOne, Color(0xFFEADDFF),Modifier.weight(1f))
            Quadrant(title = titleTwo, text = textTwo, Color(0xFFD0BCFF),Modifier.weight(1f))
        }

        Row (Modifier.weight(1f)){
            Quadrant(title = titleThree, text = textThree, Color(0xFFB69DF8),Modifier.weight(1f))
            Quadrant(title = titleFour, text = textFour, Color(0xFFF6EDFF),Modifier.weight(1f))
        }
    }

}

@Composable
fun Quadrant(title: String, text:String, color: Color, modifier: Modifier=Modifier){
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(all = 16.dp)
            .background(color = color)
            .fillMaxSize()

    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(bottom = 16.dp)
        )
        Text(
            text = text,
            textAlign = TextAlign.Justify,
            modifier = Modifier

        )

    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeQuadrantTheme {
        ComposeQuadrant(
            stringResource(R.string.title_one),
            stringResource(R.string.text_one),
            stringResource(R.string.title_two),
            stringResource(R.string.text_two),
            stringResource(R.string.title_three),
            stringResource(R.string.text_three),
            stringResource(R.string.title_four),
            stringResource(R.string.text_four)
        )
    }
}