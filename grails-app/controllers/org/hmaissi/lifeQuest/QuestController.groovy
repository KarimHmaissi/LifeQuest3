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

        //Check which tasks have already been completed by the player
        def completedTasks = player.completedTasks
        def tasks = quest.tasks

        completedTasks.retainAll(tasks)

        if (quest && player) {

            def questOwner = Player.get(quest.ownerId)
            def username = questOwner.username
            render(view: "quest", model: [quest:quest, username:username, completedTasks:completedTasks])

        } else {
            //redirect to quest library
            redirect(action:"questLibrary")
        }
    }

    def questLibrary() {

        def quests = Quest.all
        render(view: "questLibrary", model: [quests:quests])
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
        def taskId = params.taskId
        def player = Player.get(springSecurityService.principal.id)
        if (taskId && player) {

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
            def newLevel = levellingService.checkForLevelUp(player)

            if (newLevel != player.level) {
                //add level up and new level to json
                json.newLevel = newLevel
                json.levelUp = true
            }

            //Check if quest is complete
            def quest = task.quest
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

            def completedTasks = player.completedTasks
            def tasks = quest.tasks
            completedTasks.retainAll(tasks)

            if (completedTasks.size() == tasks.size()) {
                return true
            } else {
                return false
            }
        }


    }


}
