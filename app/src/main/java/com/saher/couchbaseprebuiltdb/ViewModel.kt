package com.saher.couchbaseprebuiltdb


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.saher.couchbaseprebuiltdb.model.photo

class MyViewModel: ViewModel() {

/*This variable shall store the photo,
Which I plan to use as an ID for the Profile Card.*/

    var selectedProfile by mutableStateOf(photo("","","","",0,"",0,0,0,"",0,0)) //Store state as mutableStateOf to ensure proper recompostions
        private set //Do not allow external modification, i.e., outside the ViewModel

    //We'll be modifying the variable through this method
    fun onSelectProfile(photo: photo) {
        selectedProfile = photo
    }
}


