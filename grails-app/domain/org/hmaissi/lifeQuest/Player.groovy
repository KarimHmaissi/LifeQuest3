package org.hmaissi.lifeQuest

class Player {

    transient springSecurityService

    String username
    String password
    boolean enabled
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    static hasMany =  [completedQuests : Quest,
            openQuests: Quest,
            achievements: Achievement,
            completedTasks: Task]

    Integer xpPoints
//    Integer pointsTillNextLevel
    Integer level


    static constraints = {
        username blank: false, unique: true
        password blank: false
    }

    static mapping = {
        password column: '`password`'
    }

    Set<Role> getAuthorities() {
        PlayerRole.findAllByPlayer(this).collect { it.role } as Set
    }

    def beforeInsert() {
        encodePassword()
    }

    def beforeUpdate() {
        if (isDirty('password')) {
            encodePassword()
        }
    }

    protected void encodePassword() {
        password = springSecurityService.encodePassword(password)
    }
}
