package com.my.consumeuserstest.presentation.useredit

import com.my.consumeuserstest.domain.model.User
import com.my.consumeuserstest.domain.usecases.UserUpdateUseCase
import com.my.consumeuserstest.domain.utlis.FieldsValidator
import com.my.consumeuserstest.presentation.mvp.BasePresenter

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class UserEditPresenter @Inject constructor(private val userUpdateUseCase: UserUpdateUseCase) :
    BasePresenter<UserEditView>(), UserEditContract.Presenter {

    override fun updateUser(
        userId: Int,
        userFirstName: String,
        userLastName: String,
        userEmail: String
    ) {
        val user = User(userId, "", userEmail, userFirstName, userLastName)

        if (FieldsValidator().isValideFields(userEmail, userFirstName, userLastName)) {
            disposables.add(
                userUpdateUseCase.updateUser(user)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ view?.onUpdateUserSuccess() }, { onUpdateNoteError(it) })
            )
        } else {

            //view?.onUpdateUserFieldsAreIncorrect
        }
    }

    private fun onUpdateNoteError(throwable: Throwable) {
        view?.onUpdateUserError(throwable)
    }
}