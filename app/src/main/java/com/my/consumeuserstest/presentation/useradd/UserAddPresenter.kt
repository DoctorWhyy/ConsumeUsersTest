package com.my.consumeuserstest.presentation.useradd

import com.my.consumeuserstest.domain.model.User
import com.my.consumeuserstest.domain.usecases.UserAddUseCase
import com.my.consumeuserstest.domain.utlis.FieldsValidator
import com.my.consumeuserstest.presentation.mvp.BasePresenter

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class UserAddPresenter @Inject constructor(private val addUserUseCase: UserAddUseCase) :
    BasePresenter<UserAddView>(), UserAddContract.Presenter {

    override fun sendUser(userFirstName: String, userLastName: String, userEmail: String) {

        val user = User(0, "", userEmail, userFirstName, userLastName)

        if (FieldsValidator().isValideFields(userEmail, userFirstName, userLastName)) {
            disposables.add(
                addUserUseCase.addUser(user)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ view?.onAddUserSuccess() }, { onAddNoteError(it) })
            )
        } else {
            //view?.onAddUserFieldsAreIncorrect()
        }
    }

    private fun onAddNoteError(throwable: Throwable) {
        view?.onAddUserError(throwable)
    }
}