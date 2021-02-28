/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.model.Puppy

class DataProvider {

    val listPuppy = listOf<Puppy>(
        Puppy(
            "1",
            "cat",
            "unknown",
            "meme",
            "From meme",
            R.drawable.cat
        ),
        Puppy(
            "2",
            "doge",
            "unknown",
            "meme",
            "From meme",
            R.drawable.doge
        ),
        Puppy(
            "3",
            "Akita",
            "1 year",
            "Akita Inu",
            "From meme",
            R.drawable.akita
        ),
        Puppy(
            "4",
            "Alaskan",
            "1.5 year",
            "Alaskan Malamute",
            "From meme",
            R.drawable.alaskan_malamute
        ),
        Puppy(
            "5",
            "HaHa",
            "1 year",
            "Siberian Husky",
            "From meme",
            R.drawable.husky
        ),
        Puppy(
            "6",
            "Shiba",
            "2 year",
            "Shiba Inu",
            "From meme",
            R.drawable.shiba
        ),
        Puppy(
            "7",
            "Hey~Dog",
            "3 year",
            "Taiwan Dog",
            "From meme",
            R.drawable.taiwan
        ),
        Puppy(
            "8",
            "Good",
            "1 year",
            "Shetland Sheepdog",
            "From meme",
            R.drawable.sitting_pretty
        ),
        Puppy(
            "9",
            "GoGo",
            "2.5 year",
            "Pomeranian",
            "From meme",
            R.drawable.pomeranian
        ),
        Puppy(
            "10",
            "Dogo",
            "4 year",
            "Pembroke Welsh Corgi",
            "From meme",
            R.drawable.welchcorgipembroke
        ),
    )
}
