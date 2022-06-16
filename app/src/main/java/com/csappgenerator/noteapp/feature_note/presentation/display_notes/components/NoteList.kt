package com.csappgenerator.noteapp.feature_note.presentation.display_notes.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.csappgenerator.noteapp.feature_note.domain.model.Note
import com.csappgenerator.noteapp.feature_note.presentation.display_notes.NotesState

@Composable
fun NoteList(
    state: NotesState,
    onItemClick: (Note) -> Unit,
    onDeleteClick: (Note) -> Unit
) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(state.notes) { note ->
            NoteItem(
                note = note!!,
                modifier = Modifier
                    .fillMaxSize()
                    .clickable {
                        onItemClick(note)
                    },
                onDeleteClick = {
                    onDeleteClick(note)
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
        }

    }
}