package com.kingkong.superheroes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kingkong.superheroes.model.HeroDataResource
import com.kingkong.superheroes.ui.theme.SuperHeroesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperHeroesTheme {
                SuperHeroesApp()
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroesTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "Super Heroes",
                style = MaterialTheme.typography.displayLarge,
            )
        })
}

@Composable
fun SuperHeroesApp() {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            HeroesTopAppBar()
        }
    ){
        val heroes = HeroDataResource.heroes
        SuperHeroList(heroes = heroes, Modifier.padding(it))
    }
    }

@Preview(showBackground = true)
@Composable
fun SuperHeroesPreview() {
    SuperHeroesTheme {
    }
}