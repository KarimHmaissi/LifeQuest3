package org.hmaissi.lifeQuest

class Quest {

    String title
    String primarySkill
    String secondarySkill

    Player owner

    static hasMany = [links: Link]


    static constraints = {
    }
}
