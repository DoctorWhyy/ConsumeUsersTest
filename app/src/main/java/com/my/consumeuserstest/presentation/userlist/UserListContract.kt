package com.my.consumeuserstest.presentation.userlist

import com.my.consumeuserstest.domain.model.UserList

interface UserListContract {

    interface View {
        fun onLoaUsersSuccess(users: List<UserList>)
        fun onLoadUsersError(throwable: Throwable)
        fun onFabClicked()
    }

    interface Presenter {
        fun fetchUsers()
    }
}