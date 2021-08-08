package com.saher.couchbaseprebuiltdb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollScope
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.saher.couchbaseprebuiltdb.model.photo
import com.saher.couchbaseprebuiltdb.model.photoList
import com.saher.couchbaseprebuiltdb.ui.theme.CouchbasePreBuiltDbTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val profileViewModel by viewModels<MyViewModel>()

        setContent {
            CouchbasePreBuiltDbTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting(
                        selectedProfile = profileViewModel.selectedProfile,
                        onSelectProfile = profileViewModel::onSelectProfile
                    )

                }
            }
        }
    }
}

@Composable
fun Greeting(
    selectedProfile: photo,
    onSelectProfile: (photo: photo) -> Unit
) {

    Row(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxHeight()
                .width(150.dp)
                .background(color = Color.LightGray)
        ) {
            items(photoList) { item ->
                ProfileCard(photo = item) {
                    onSelectProfile(item)
                }
            }
        }
        photoContent(
            id = selectedProfile.id,
            owner = selectedProfile.owner,
            secret = selectedProfile.secret,
            server = selectedProfile.server,
            farm = selectedProfile.farm,
            title = selectedProfile.title,
            ispublic = selectedProfile.ispublic,
            isfamily = selectedProfile.isfamily,
            isfriend = selectedProfile.isfriend,
            url_s = selectedProfile.url_s,
            height_s = selectedProfile.height_s,
            width_s = selectedProfile.width_s
        )
    }
}

@Composable
fun ProfileCard(photo: photo, clickAction: () -> Unit) {
    Card( //We changed the default shape of Card to make a cut in the corner.
        modifier = Modifier
            .padding(top = 4.dp, bottom = 4.dp, start = 16.dp, end = 16.dp)
            .fillMaxWidth()
            .wrapContentHeight(
                align = Alignment.Top
            )
            .clickable { clickAction.invoke() }, //<-- moving the action to main composable.
        elevation = 8.dp,
        backgroundColor = Color.White // Uses Surface color by default, so we have to override it.
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            ProfileContent(photo, Alignment.Start)
        }
    }
}

@Composable
fun ProfileContent(name: photo, alignment: Alignment.Horizontal) {
    Column(
        modifier =
        Modifier
            .padding(4.dp),
        horizontalAlignment = alignment
    ) {
        Text(
            text = name.title,
            style = MaterialTheme.typography.body2,
        )
    }
}
@Composable
fun photoContent(
    id: String,
    owner: String,
    secret: String,
    server: String,
    farm: Int,
    title: String,
    ispublic: Int,
    isfriend: Int,
    isfamily: Int,
    url_s: String,
    height_s: Int,
    width_s: Int
) {
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(
            state = ScrollState(0)
        )
    ) {
        ImageDisplay(url_s,height_s,width_s)
        RowStringContent("ID: ", id)
        RowStringContent("Owner: ", owner)
        RowStringContent("Secret: ", secret)
        RowStringContent("Server: ", server)
        RowStringContent("Farm: ", farm.toString())
        RowStringContent("Title: ", title)
        RowStringContent("isPublic: ", ispublic.toString())
        RowStringContent("isFriend: ", isfriend.toString())
        RowStringContent("isFamily: ", isfamily.toString())
        RowStringContent("isFamily: ", isfamily.toString())

    }
}

@Composable
fun ImageDisplay(url_s: String, height_s: Int, width_s: Int) {
Image(
    painter = rememberImagePainter(
        data = url_s,
        builder = {transformations(CircleCropTransformation())}
    )
    , contentDescription ="",
    modifier = Modifier
        .height(height_s.dp)
        .width(width_s.dp),
    alignment = Alignment.Center
)
}

@Composable
fun RowStringContent(name: String, conent: String) {
    Row(
        modifier =
        Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp)
            .border(width = 1.dp, shape = RectangleShape, color = Color.LightGray)
    ) {
        Text(
            text = name,
            style = MaterialTheme.typography.h5
        )
        Text(
            text = conent,
            style = MaterialTheme.typography.h5
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

    CouchbasePreBuiltDbTheme {
//        Greeting(
//            selectedProfile = profileViewModel.selectedProfile,
//            onSelectProfile = profileViewModel::onSelectProfile
//        )
    }
}