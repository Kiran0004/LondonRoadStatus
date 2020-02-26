package com.example.roadstatus.status

import android.app.Activity
import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.example.roadstatus.R
import com.example.roadstatus.status.model.RoadStatusPresentation
import com.example.roadstatus.status.viewmodel.StatusState
import com.example.roadstatus.status.viewmodel.StatusViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class StatusActivity : AppCompatActivity() {

    private val ERROR_MSG = "The following road id is not recognised: "
    private val NOT_FOUND_MSG = "Not found"
    private val statusViewModel: StatusViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        status_btn.setOnClickListener(View.OnClickListener {
            closeSoftKeyboard(this)
            result_layout.visibility = View.GONE
            statusViewModel.linesStatusLiveData.observe(this, Observer {
                when(it) {
                    is StatusState.Error -> showError()
                    is StatusState.Loading -> showLoading()
                    is StatusState.Data -> showLinesStatus(it.linesStatuses)
                }
            })
            statusViewModel.fetchLinesStatus(roadId_editText.text.toString())
        })
    }
    private fun showLoading() {
        repository_progress.visibility = View.VISIBLE
    }

    private fun showLinesStatus(linesStatuses: List<RoadStatusPresentation>) {
        repository_progress.visibility = View.GONE
        result_layout.visibility = View.VISIBLE
        roadstatus_name.text = linesStatuses.get(0).name
        status_name.text = linesStatuses.get(0).severityLevel
        severity_desc.text = linesStatuses.get(0).severityLevelDescription
    }

    private fun showError() {
        repository_progress.visibility = View.GONE
        result_layout.visibility = View.VISIBLE
        roadstatus_name.text = roadId_editText.text.toString()
        status_name.text = NOT_FOUND_MSG
        severity_desc.text = ERROR_MSG + roadId_editText.text.toString()
    }

    fun closeSoftKeyboard(activity: Activity) {
        try {
            val inputManager = activity.getSystemService("input_method") as InputMethodManager
            inputManager.hideSoftInputFromWindow(activity.currentFocus!!.windowToken, 2)
        } catch (var3: Exception) {
        }
    }
}
