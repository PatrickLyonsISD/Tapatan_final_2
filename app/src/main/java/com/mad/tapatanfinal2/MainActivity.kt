package com.mad.tapatanfinal2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mad.tapatanfinal2.ui.theme.GameScreen
import com.mad.tapatanfinal2.ui.theme.GameViewModel
import com.mad.tapatanfinal2.ui.theme.TapatanFinal2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TapatanFinal2Theme {
                val gameViewModel = GameViewModel()
                GameScreen(gameViewModel = gameViewModel)
            }
        }
    }
}


