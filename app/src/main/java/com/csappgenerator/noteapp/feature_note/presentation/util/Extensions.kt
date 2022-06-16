package com.csappgenerator.noteapp.feature_note.presentation.util


import androidx.navigation.NavController
import com.csappgenerator.noteapp.feature_note.domain.model.Note


fun NavController.redirectToAddEditNoteScreen(note: Note) {
    this.navigate(
        Screen.AddEditNoteScreen.route +
                "?noteId=${note.id}&noteColor=${note.color}"
    )
}

