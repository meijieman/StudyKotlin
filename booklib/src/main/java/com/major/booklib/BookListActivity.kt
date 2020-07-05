package com.major.booklib

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.major.booklib.adapter.BookAdapter
import com.major.booklib.api.BookApiService
import com.major.booklib.bean.Book
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_book_list.*

class BookListActivity : AppCompatActivity() {

    private lateinit var bookAdapter: BookAdapter

    private var disposable: Disposable? = null

    private val bookApiService by lazy {
        BookApiService.create(BookApiService::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_list)

        initUi()

    }

    private fun initUi() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar).apply {
            title = getString(R.string.app_name)
            setNavigationIcon(R.mipmap.ic_launcher)
        }
        setSupportActionBar(toolbar)

        val manager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        bookAdapter = BookAdapter(
            listOf(
                Book(
                    1,
                    "kotlin",
                    "major"
                ), Book(2, "java", "m")
            )
        )

        recycler.run {
            layoutManager = manager
            adapter = bookAdapter
        }

        loadData()
    }

    private fun loadData() {
        progress.visibility = View.VISIBLE
        disposable = bookApiService.list()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                progress.visibility = View.GONE
                bookAdapter.items = it.data
                bookAdapter.notifyDataSetChanged()
            }, { error ->
                progress.visibility = View.GONE
                Toast.makeText(this, error.message, Toast.LENGTH_LONG).show()
            })
    }

    override fun onStop() {
        super.onStop()
        disposable?.dispose()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menus, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.refresh -> loadData()
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
