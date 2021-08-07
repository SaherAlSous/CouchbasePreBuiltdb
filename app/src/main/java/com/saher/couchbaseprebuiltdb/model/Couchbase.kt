package com.saher.couchbaseprebuiltdb.model

import android.content.Context
import com.couchbase.lite.*

val photoList = arrayListOf<photo>()

class Couchbase() {

    //Initialize the db
    fun initializeAndCreateDb(context: Context) {
        CouchbaseLite.init(context)
        val config = DatabaseConfiguration()
        config.directory = context.getFilesDir().getAbsolutePath()
        val database = Database("primary-directory", config)

        database.createIndex(
            "reindex",
            IndexBuilder.valueIndex(
                ValueIndexItem.property("id"),
                ValueIndexItem.property("owner"),
                ValueIndexItem.property("secret"),
                ValueIndexItem.property("server"),
                ValueIndexItem.property("farm"),
                ValueIndexItem.property("title"),
                ValueIndexItem.property("ispublic"),
                ValueIndexItem.property("isfriend"),
                ValueIndexItem.property("isfamily"),
                ValueIndexItem.property("url_s"),
                ValueIndexItem.property("height_s"),
                ValueIndexItem.property("width_s")
            )
        )

        val query = QueryBuilder
            .select(
                SelectResult.expression(Meta.id),
                SelectResult.property("owner"),
                SelectResult.property("secret"),
                SelectResult.property("server"),
                SelectResult.property("farm"),
                SelectResult.property("title"),
                SelectResult.property("ispublic"),
                SelectResult.property("isfriend"),
                SelectResult.property("isfamily"),
                SelectResult.property("url_s"),
                SelectResult.property("height_s"),
                SelectResult.property("width_s"),
            )
            .from(DataSource.database(database))

        val result = query.execute().allResults()

        for (rs in result) {
           // val doc = database.getDocument(photo.id)
            val id = rs.getString("id")
            val owner = rs.getString("owner")
            val secret = rs.getString("secret")
            val server = rs.getString("server")
            val farm = rs.getInt("farm")
            val title = rs.getString("title")
            val ispublic = rs.getInt("ispublic")
            val isfriend = rs.getInt("isfriend")
            val isfamily = rs.getInt("isfamily")
            val url_s = rs.getString("url_s")
            val height_s = rs.getInt("height_s")
            val width_s = rs.getInt("width_s")

            photoList.add(
                photo(
                    id!!,
                    owner!!,
                    secret!!,
                    server!!,
                    farm,
                    title!!,
                    ispublic,
                    isfriend,
                    isfamily,
                    url_s!!,
                    height_s,
                    width_s
                )
            )
//            for(photo in photoList){
//                println("Photo details: ${photo}")
//            }
        }
    }
}


/*

//        for (photo in photos) {
//            val mutablePhoto = MutableDocument(photo.id)
//            mutablePhoto.setString("id", photo.id)
//            mutablePhoto.setString("owner", photo.owner)
//            mutablePhoto.setString("secret", photo.secret)
//            mutablePhoto.setString("server", photo.server)
//            mutablePhoto.setInt("farm", photo.farm)
//            mutablePhoto.setString("title", photo.title)
//            mutablePhoto.setInt("ispublic", photo.ispublic)
//            mutablePhoto.setInt("isfriend", photo.isfriend)
//            mutablePhoto.setInt("isfamily", photo.isfamily)
//            mutablePhoto.setString("url_s", photo.url_s)
//            mutablePhoto.setInt("height_s", photo.height_s)
//            mutablePhoto.setInt("width_s", photo.width_s)
//            database.save(mutablePhoto)
//        }


//        val query = QueryBuilder
//            .select(SelectResult.all())
//            .from(DataSource.database(database))
//
//        val rs = query.execute()
//
//for (result in rs) {
//
//    val dictionary = result.getDictionary(0)
//
//                    println(dictionary.getString("Department")!!)
//                    println(dictionary.getString("name")!!)
//                    println(dictionary.getString("cost")!!)
//                    println(dictionary.getString("price")!!)
//                    println(dictionary.getString("Barcode")!!)
//
//    }
    //    val Grocery = Grocery(
//
//        result.getArray(0).getDictionary(0)!!.getString("Department")!!,
//        result.getArray(0).getDictionary(0)!!.getString("name")!!,
//        result.getArray(0).getDictionary(0)!!.getString("cost")!!,
//        result.getArray(0).getDictionary(0)!!.getString("price")!!,
//        result.getArray(0).getDictionary(0)!!.getString("Barcode")!!
//    )
//    println(
//        """Grocery items:
//            | Barcode: ${Grocery.Barcode},
//            | Department: ${Grocery.Department},
//            | Price: ${Grocery.Price},
//            | Cost: ${Grocery.Cost},
//            | Name: ${Grocery.Name}
//        """.trimMargin()
//    )

//        final Photo = new Photo(dict.get("id"), dict.get("height_s"), dict.get("width_s"))

 */

//    var mutableDoc = MutableDocument("api.flickr")
//    mutableDoc = database.getDocument(mutableDoc.id).toMutable()
//    val document = database.getDocument(mutableDoc.id)

//    val query = QueryBuilder
//        .select(SelectResult.all())
//        .from(DataSource.database(database))
//    val result = query.execute().allResults()
//    println("Array Result: ${result[0].getArray(0).toList()}")
//    val photosList: MutableList<photo>
//        photosList =result[0].getArray(0).toList() as MutableList<photo>

//database.createIndex(
//            "allKeys",
//            IndexBuilder.valueIndex(
//                ValueIndexItem.property("name"),
//                ValueIndexItem.property("price"),
//                ValueIndexItem.property("Barcode"),
//                ValueIndexItem.property("Department"),
//                ValueIndexItem.property("cost"),
//            )
//        )


/*
        val first_document = MutableDocument("123")
        val first_document = MutableDocument("4963406")
        database.inBatch {
            first_document
                .setLong("BarCode", 4963406)
                .setString("name", "COCA-COLA - CAN - SINGLE")
                .setFloat("price", 0.93f)
                .setString("Department", "misc")
                .setFloat("Cost", 0f)
        }

        val second_document = MutableDocument("813497004174")
        database.inBatch {
            second_document
                .setLong("BarCode", 813497004174)
                .setString("name", "LUC BELAIRE RARE ROSE - 750ML")
                .setFloat("price", 29.99f)
                .setString("Department", "misc")
                .setFloat("Cost", 17f)
        }

        database.save(first_document)
        database.save(second_document)

        val query = QueryBuilder
            .select(SelectResult.expression(Meta.id))
            .from(DataSource.database(database))
            .where(Expression.property("BarCode").equalTo(Expression.longValue(813497004174)))

        for (result in query.execute().allResults())
            println(
                """
            Result BarCode = ${result.getLong("BarCode")},
            Result Price= ${result.getFloat("price")},
            Result Cost = ${result.getFloat("Cost")}
            Result Name = ${result.getString("name")}
        """.trimIndent()
            )

        println("""
            CouchBase Result BarCode = ${first_document.getLong("BarCode")},
            CouchBase Result Price= ${first_document.getFloat("price")},
            CouchBase Result Cost = ${first_document.getFloat("Cost")}
            CouchBase Result Name = ${first_document.getString("name")}
        """.trimIndent())

        val last_document = MutableDocument("4963406")
        println("""
            CouchBase last_document Result BarCode = ${last_document.getLong("BarCode")},
            CouchBase last_document Result Price= ${last_document.getFloat("price")},
            CouchBase last_document Result Cost = ${last_document.getFloat("Cost")}
            CouchBase last_document Result Name = ${last_document.getString("name")}
        """.trimIndent())


        ------------------------
        database.inBatch {
            first_document
                .setString("BarCode", "4963406")
                .setString("name", "COCA-COLA - CAN - SINGLE")
                .setString("price", "0.93")
                .setString("Department", "misc")
                .setString("Cost", "0")
        }

        database.save(first_document)


        val last_document = database.getDocument("123").toMutable()
        println(
            """
            CouchBase last_document Result BarCode = ${last_document.getString("BarCode")},
            CouchBase last_document Result Price= ${last_document.getString("price")},
            CouchBase last_document Result Cost = ${last_document.getString("Cost")},
            CouchBase last_document Result Name = ${last_document.getString("name")},
            CouchBase last_document Result Department= ${last_document.getString("Department")}
        """.trimIndent()
        )

        val query = QueryBuilder
            .select(SelectResult.expression(Meta.id))
            .from(DataSource.database(database))
            .where(Expression.string("4963406").`in`(Expression.property("BarCode")))


        for (result in query.execute())
        {
            println(
                """
            CouchBase Query Result BarCode = ${result.getString("BarCode")},
            CouchBase Query Result Price= ${result.getString("price")},
            CouchBase Query Result Cost = ${result.getString("Cost")},
            CouchBase Query Result Name = ${result.getString("name")},
            CouchBase Query Result Department= ${result.getString("Department")}
        """.trimIndent()
            )
 */