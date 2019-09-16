package com.my.consumeuserstest.presentation.userlist

import com.my.consumeuserstest.domain.usecases.UserFetchUseCase
import com.my.consumeuserstest.presentation.mvp.BasePresenter

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class UserListPresenter @Inject constructor(private val listUseCase: UserFetchUseCase) :
    BasePresenter<UserListView>(), UserListContract.Presenter {

    override fun fetchUsers() {
        disposables.add(listUseCase.fetchUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    view?.onLoaUsersSuccess(it)

                }, {
                    view?.onLoadUsersError(it)
                }
            )
        )
    }
}