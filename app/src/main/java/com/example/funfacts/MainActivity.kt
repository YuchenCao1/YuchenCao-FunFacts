package com.example.funfacts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.funfacts.ui.theme.FunFactsTheme
import kotlin.random.Random
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.background
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FunFactsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FunFactsApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun FunFactsApp(modifier: Modifier = Modifier) {
    val funFacts = listOf(
        "Some tornadoes are faster than Formula One race cars!",
        "There are 2,000 thunderstorms on Earth every minute.",
        "Wind is silent until it blows against something.",
        "The fastest recorded raindrop speed is 18 miles per hour!",
        "There are over 1,200 tornadoes in the United States each year.",
        "Lightning can indeed strike twice.",
        "Clouds appear white because they reflect sunlight from above.",
        "Rainwater contains vitamin B12.",
        "A lightning bolt is five times hotter than the sun.",
        "Garlic is rich in vitamin C, iron, potassium, magnesium, zinc, and contains 17 amino acids.",
        "On the island of Tristan da Cunha in the South Atlantic, potatoes were once used as currency.",
        "Strawberries are the only fruit with seeds on the outside.",
        "The seed of the double coconut palm weighs 45 pounds, making it the largest seed in the world.",
        "Ice cream was once called 'cream ice'.",
        "The 'pound cake' got its name because the original recipe called for one pound of butter, one pound of sugar, one pound of eggs, and one pound of flour.",
        "Peanuts are not nuts but legumes.",
        "Carrots weren't always orange; they were once purple.",
        "Cherries are part of the rose family, along with papayas, pears, plums, apples, peaches, and raspberries!",
        "Apples can float because they are one-quarter air!",
        "Sloths can't shiver to stay warm, so it's hard for them to regulate their body temperature on rainy days.",
        "Some reindeer travel more than 3,000 miles in a year in the wild.",
        "When dolphins sleep, only half of their brain goes into a sleep state while the other half stays awake.",
        "Besides humans, Emperor penguins are the only warm-blooded animals that spend the winter in Antarctica.",
        "The largest spider fossil was found in China. It measures one inch long and is 165 million years old.",
        "The largest animal currently is the blue whale, which can grow up to 100 feet long.",
        "Nearly 10% of a cat's bones are in its tail.",
        "A shrimp's heart is located in its head.",
        "Although pandas occasionally eat fish or small animals, 99% of their diet is bamboo.",
        "An ostrich's eyes are bigger than its brain.",
        "Foxes use their tails to communicate with other foxes.",
        "A dog's nose is wet because they secrete a thin layer of mucus, which actually helps with their sense of smell!"
    )

    var currentFactIndex by remember { mutableStateOf(Random.nextInt(funFacts.size)) }

    fun showNextFact() {
        currentFactIndex = Random.nextInt(funFacts.size)
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = funFacts[currentFactIndex],
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center,
            lineHeight = 30.sp,
            modifier = Modifier
                .padding(16.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color.LightGray, Color.White)
                    ),
                    shape = MaterialTheme.shapes.medium
                )
                .padding(16.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { showNextFact() },
            shape = MaterialTheme.shapes.medium,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFBB86FC),
                contentColor = Color.White
            ),
            elevation = ButtonDefaults.buttonElevation(8.dp),
            modifier = Modifier
                .padding(8.dp)
                .width(130.dp)
                .height(50.dp)
        ) {
            Text(
                text = "Next Fact",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun FunFactsAppPreview() {
    FunFactsTheme {
        FunFactsApp()
    }
}
