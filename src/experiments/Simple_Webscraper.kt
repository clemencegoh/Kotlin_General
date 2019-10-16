package experiments

import java.net.HttpURLConnection
import java.net.URL


fun main(){
    scrapeMe()
}

fun scrapeMe(){
    val url = URL("http://www.google.com/")

    with(url.openConnection() as HttpURLConnection){
        requestMethod = "GET"
        println("Sent $requestMethod to $url with $responseCode as response")

        println("text received: $responseMessage")

        println("Web as html: ${inputStream.bufferedReader().readText()}")
    }
}