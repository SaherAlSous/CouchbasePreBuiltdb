package com.saher.couchbaseprebuiltdb

import android.app.Application
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
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
        setContent {
            CouchbasePreBuiltDbTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting()

                }
            }
        }
    }
}

@Composable
fun Greeting() {
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
//                        photoContent(
//                            id = item.id,
//                            owner = item.owner,
//                            secret = item.secret,
//                            server = item.server,
//                            farm = item.farm,
//                            title = item.title,
//                            ispublic = item.ispublic,
//                            isfriend = item.isfriend,
//                            isfamily = item.isfamily,
//                            url_s = item.url_s,
//                            height_s = item.height_s,
//                            width_s = item.width_s
//                        )
                }
            }
        }
        photoContent(
            id = "",
            owner = "",
            secret = "",
            server = "",
            farm = 0,
            title = "",
            ispublic = 0,
            isfamily = 0,
            isfriend = 0,
            url_s = "",
            height_s = 0,
            width_s = 0
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
    Column(modifier = Modifier.fillMaxSize()) {
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
            .border(width = 1.dp,shape = RectangleShape, color = Color.LightGray)
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
        Greeting()
    }
}