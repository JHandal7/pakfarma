/*
 * Copyright (C) 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat.getSystemService
import com.android.example.aboutme.databinding.ActivityMainBinding
import androidx.databinding.DataBindingUtil
//import androidx.
/**
 * Main Activity of the AboutMe app. This app demonstrates:
 *     * Getting user input with an EditText.
 *     * Click handler for a Button to retrieve text from an EditText and set it in a TextView.
 *     * Setting a click handler on a TextView.
 *     * Setting the visibility status of a view.
 */
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_main)
 binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        //findViewById<Button>(R.id.done_button).setOnClickListener {
         binding.doneButton.setOnClickListener { addNickname(it) }

//Alhamdulilah
    }

    /**
     * Click handler for the DONE button.
     * Hides the EditText and the DONE button.
     * Sets the EditText content to the TextView and displays it.
     */
    private fun addNickname(view: View) {

     binding.apply {
         nicknameText.text = binding.nicknameEdit.text
         invalidateAll()
         nicknameEdit.visibility = View.GONE
         doneButton.visibility = View.GONE
         nicknameEdit.visibility = View.VISIBLE
     }
        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }

    /**
     * Click handler for the nickname TextView.
     * Displays the EditText and the DONE button.
     * Hides the nickname TextView.
     */

}

