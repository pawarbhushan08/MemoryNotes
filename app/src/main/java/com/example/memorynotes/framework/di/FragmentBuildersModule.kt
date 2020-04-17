package com.example.memorynotes.framework.di

import com.example.memorynotes.presentation.ListFragment
import com.example.memorynotes.presentation.NoteFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeListFragment(): ListFragment

    @ContributesAndroidInjector
    abstract fun contributeNoteFragment(): NoteFragment
}