package ru.skillbranch.gameofthrones.presentations

import com.arellomobile.mvp.InjectViewState
import ru.skillbranch.gameofthrones.repositories.MainRepository

@InjectViewState
class MainPresenter (
    private val mainRepository: MainRepository
) : BasePresenter<IMainView>() {
}