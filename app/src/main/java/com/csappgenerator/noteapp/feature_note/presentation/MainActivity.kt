package com.csappgenerator.noteapp.feature_note.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.csappgenerator.noteapp.feature_note.presentation.add_edit_notes.AddEditNoteScreen
import com.csappgenerator.noteapp.feature_note.presentation.display_notes.DisplayNotesScreen
import com.csappgenerator.noteapp.feature_note.presentation.util.Screen
import com.csappgenerator.noteapp.ui.theme.NoteAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.DisplayNotesScreen.route
                    ) {

                        composable(route = Screen.DisplayNotesScreen.route) {
                            DisplayNotesScreen(navController = navController)
                        }
                        composable(
                            route = Screen.AddEditNoteScreen.route
                                    + "?noteId={noteId}&noteColor={noteColor}",
                            arguments = listOf(
                                navArgument(
                                    name = "noteId"
                                ) {
                                    type = NavType.IntType
                                    defaultValue = -1
                                },
                                navArgument(
                                    name = "noteColor"
                                ) {
                                    type = NavType.IntType
                                    defaultValue = -1
                                }
                            )) {
                            val color = it.arguments?.getInt("noteColor") ?: -1
                            AddEditNoteScreen(navController = navController, noteColor = color)

                        }
                    }
                }
            }
        }
    }
}