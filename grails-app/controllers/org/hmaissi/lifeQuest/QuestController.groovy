package org.hmaissi.lifeQuest

import grails.converters.JSON

class QuestController {

    def springSecurityService
    def levellingService

    //Show individual quest page
    def index() {
        redirect(action:"questLibrary")
    }

    def viewQuest() {
        def questId = params.questId

        def player = Player.get(springSecurityService.principal.id)
        def quest = Quest.get(questId)

        //Check which tasks have already been completed by the player TODO wierd problem with refrencing player.completedTasks
        def completedTasks = new ArrayList<>()
        completedTasks.addAll(player.completedTasks)
//        def playerCompletedTasks = player.completedTasks

        def tasks = quest.tasks

        completedTasks.retainAll(tasks)

        def questOpen = false
        def questComplete = false

        //check if quest is open by player
        if (player.openQuests.contains(quest)) {
            questOpen = true
        }

        //check if quest is complete by player
        if (player.completedQuests.contains(quest)) {
            questComplete = true
            println "quest completed"
        }

        if (quest && player) {

            //Pull the username of the quest owner
            def questOwner = Player.get(quest.ownerId)
            def username = questOwner.username

//            println "quest complete? : " + questComplete
//            println "quest open? : " + questOpen

            render(view: "quest", model: [quest: quest,
                    username: username,
                    completedTasks: completedTasks,
                    questOpen: questOpen,
                    questComplete: questComplete])

        } else {
            //redirect to quest library
            redirect(action:"questLibrary")
        }
    }

    def questLibrary() {

        def quests = Quest.all
        def player  = Player.get(springSecurityService.principal.id)
        if (player) {
            def completedQuests = player.completedQuests
            def openQuests = player.openQuests
            render(view: "questLibrary", model: [quests: quests,
                    completedQuests: completedQuests,
                    openQuests: openQuests])
        } else {
            //Show all quests
            render(view: "questLibrary", model: [quests: quests])
        }

    }


    def openQuests() {
        def player = Player.get(springSecurityService.principal.id)
        if (player) {
            def quests = player.openQuests

            render(view: "openQuests", model: [quests:quests])
        } else {
            //redirect to login page
        }


    }

    def completedQuests() {
        def player = Player.get(springSecurityService.principal.id)
        if (player) {
            def quests = player.completedQuests

            render(view: "completedQuests", model: [quests:quests])
        } else {
            //redirect to login page
        }
    }

    def createQuest() {

    }

    def completeTask() {
        println "task Completed"
        def taskId = params.taskId
        def questId = params.questId
        def player = Player.get(springSecurityService.principal.id)

        if (taskId && player && questId) {

            def task = Task.get(taskId)
            def xpGain = task.xpGain

            def json = [
                    xpGain: xpGain,
                    newLevel: player.level,
                    levelUp:false,
                    questComplete:false
            ]

            player.addToCompletedTasks(task)
            player.xpPoints +=  xpGain

            //Check for level up
            def newLevel = levellingService.getLevelFromXp(player.xpPoints)

            if (newLevel != player.level) {
                //add level up and new level to json
                json.newLevel = newLevel
                json.levelUp = true

                //update level for player
                player.level = newLevel
            }

            //Check if quest is complete
            def quest = Quest.get(questId)
            def questCompleted = isQuestComplete(player, quest)

            if (questCompleted) {
                json.questComplete = true

                //Add quest to completeQuests and remove from openQuests
                player.addToCompletedQuests(quest)
                player.removeFromOpenQuests(quest)
            }

            player.save()

            render json as JSON

        }
    }

    /**
     * Checks if the quest has been completed by the player
     * @return
     */
    private boolean isQuestComplete(Player player, Quest quest) {
        if (player != null & quest != null) {

            def tasks = quest.tasks

            def completedTasks = new ArrayList<>()
            completedTasks.addAll(player.completedTasks)

            completedTasks.retainAll(tasks)

            if (completedTasks.size() == tasks.size()) {
                return true
            } else {
                return false
            }
        }


    }


}
