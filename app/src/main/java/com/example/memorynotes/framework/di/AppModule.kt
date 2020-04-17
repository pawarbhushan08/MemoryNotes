package com.example.memorynotes.framework.di

import android.app.Application
import com.example.core.repository.NoteRepository
import com.example.core.usecase.*
import com.example.memorynotes.framework.RoomNoteDataSource
import com.example.memorynotes.framework.UseCases
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {

    @Singleton
    @Provides
    fun provideRepository(app: Application) = NoteRepository(RoomNoteDataSource(app))

    @Singleton
    @Provides
    fun getUseCases(repository: NoteRepository) = UseCases(
        AddNote(repository),
        GetAllNotes(repository),
        GetNote(repository),
        RemoveNote(repository)
    )
}