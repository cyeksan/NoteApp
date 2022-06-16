package com.csappgenerator.noteapp.feature_note.presentation.util

sealed class Screen(val route: String) {
    object DisplayNotesScreen : Screen("display_note_screen")
    object AddEditNoteScreen : Screen("add_edit_note_screen")

}
