package com.falcofemoralis.hdrezkaapp.models

import com.falcofemoralis.hdrezkaapp.objects.Actor
import org.jsoup.Jsoup
import org.jsoup.nodes.Document

object ActorModel {
    fun getActorMainInfo(actorLink: String): Actor {
        val document: Document = Jsoup.connect(actorLink).get()
        val name: String = document.select("div.b-post__title h1 span").text()
        val photoLink: String = document.select("div.b-sidecover img").attr("src")

        val actor = Actor(actorLink, name)
        actor.photoLink = photoLink
        return actor
    }
}