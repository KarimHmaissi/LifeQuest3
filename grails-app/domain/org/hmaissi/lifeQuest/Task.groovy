package org.hmaissi.lifeQuest

class Task {

    String title
    String description
    String url
    String imageUrl
    String type
    Integer xpGain

    static belongsTo = [quest: Quest]

    static constraints = {
    }
}
