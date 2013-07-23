package org.hmaissi.lifeQuest

class Quest {

    String title
    String primarySkill
    String secondarySkill

    long ownerId

    String imageUrl
    String description

    static hasMany = [links: Link]


    static constraints = {
    }
}
