package com.my.consumeuserstest.presentation.userlist

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.my.consumeuserstest.R
import com.my.consumeuserstest.TestApplication
import com.my.consumeuserstest.domain.model.UserList
import com.my.consumeuserstest.domain.utlis.Constants.KEY_USER_EMAIL
import com.my.consumeuserstest.domain.utlis.Constants.KEY_USER_FIRST_NAME
import com.my.consumeuserstest.domain.utlis.Constants.KEY_USER_ID
import com.my.consumeuserstest.domain.utlis.Constants.KEY_USER_LAST_NAME
import com.my.consumeuserstest.presentation.mvp.BaseView
import com.my.consumeuserstest.presentation.useredit.UserEditView

import kotlinx.android.synthetic.main.user_view.*
import javax.inject.Inject

class UserListView : BaseView(), UserListContract.View {

    @Inject
    lateinit var presenter: UserListPresenter

    private val clickListener: (UserList) -> Unit = this::onUserClicked

    private val recyclerViewAdapter = UserListAdapter(clickListener)

    override fun onLoaUsersSuccess(users: List<UserList>) {
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = recyclerViewAdapter
        recyclerViewAdapter.updateUsers(users)
    }

    override fun onLoadUsersError(throwable: Throwable) {
        Log.d("Fetch error", throwable.message)
    }

    override fun onFabClicked() {
        fab.setOnClickListener {
            val intent = Intent(this, UserAddView::class.java)
            startActivity(intent)
        }
    }

    override fun init(savedInstanceState: Bundle?) {
        with(presenter) {
            start(this@UserListView)
            presenter.fetchUsers()
        }

        onFabClicked()
    }

    override fun getLayoutId(): Int {
        return R.layout.user_view
    }

    override fun injectDependencies() {
        DaggerUserListComponent.builder()
            .appComponent(TestApplication.component)
            .userListModule(UserListModule())
            .build()
            .inject(this)
    }

    private fun onUserClicked(userList: UserList) {
        val intent = Intent(this, UserEditView::class.java)
        intent.putExtra(KEY_USER_FIRST_NAME, userList.firstName)
        intent.putExtra(KEY_USER_LAST_NAME, userList.lastName)
        intent.putExtra(KEY_USER_EMAIL, userList.email)
        intent.putExtra(KEY_USER_ID, userList.id)
        startActivity(intent)
    }

    override fun stopScreen() {
        presenter.destroy()
    }
}