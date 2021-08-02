package com.saher.couchbaseprebuiltdb

import android.app.Application
import android.content.Context
import android.os.Bundle
import android.provider.ContactsContract
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.couchbase.lite.*
import com.saher.couchbaseprebuiltdb.model.photo
import com.saher.couchbaseprebuiltdb.ui.theme.CouchbasePreBuiltDbTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CouchbasePreBuiltDbTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val context = applicationContext
                    Greeting(context,"Couchbase")
                }
            }
        }
    }
}

@Composable
fun Greeting(context: Context,name: String) {
    val config = DatabaseConfiguration()
    config.directory = context.getFilesDir().getAbsolutePath()
    val database = Database("primary-directory", config)
//    var mutableDoc = MutableDocument("api.flickr")
//    mutableDoc = database.getDocument(mutableDoc.id).toMutable()
//    val document = database.getDocument(mutableDoc.id)

//    database.createIndex(
//        "allKeys",
//        IndexBuilder.valueIndex(
//            ValueIndexItem.property("owner"),
//            ValueIndexItem.property("id"),
//            ValueIndexItem.property("secret"),
//            ValueIndexItem.property("server"),
//            ValueIndexItem.property("farm"),
//            ValueIndexItem.property("title"),
//            ValueIndexItem.property("ispublic"),
//            ValueIndexItem.property("isfriend"),
//            ValueIndexItem.property("isfamily"),
//            ValueIndexItem.property("url_s"),
//            ValueIndexItem.property("height_s"),
//            ValueIndexItem.property("width_s")
//        )
//    )


    Row (
        modifier = Modifier.fillMaxSize()
            ){
        LazyColumn(
            modifier = Modifier
                .fillMaxHeight()
                .width(150.dp)
                .background(color = Color.LightGray)
        ){
//            items(){ item ->
//                ProfileCard(photo = item) {
                }
            }
        }



@Composable
fun ProfileCard(photo: photo, clickAction: () -> Unit) {
    Card( //We changed the default shape of Card to make a cut in the corner.
        modifier = Modifier
            .padding(top = 8.dp, bottom = 4.dp, start = 16.dp, end = 16.dp)
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
            ProfileContent(photo.title, Alignment.Start)
        }
    }
}
@Composable
fun ProfileContent(name: String, alignment: Alignment.Horizontal) {
    Column(
        modifier =
        Modifier
            .padding(8.dp),
        horizontalAlignment = alignment
    ) {
        Text(
            text = name,
            style = MaterialTheme.typography.h5,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CouchbasePreBuiltDbTheme {
        Greeting(context = Application().applicationContext ,"Couchbase")
    }
}