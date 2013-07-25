package org.hmaissi.lifeQuest

class Quest {

    String title
    String primarySkill
    String secondarySkill

    long ownerId

    String imageUrl
    String description

    Date dateCreated

    Integer timesCompleted

    static hasMany = [tasks: Task]


    static constraints = {
    }
}
