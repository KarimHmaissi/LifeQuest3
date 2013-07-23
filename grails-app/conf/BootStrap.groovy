import org.hmaissi.lifeQuest.Link
import org.hmaissi.lifeQuest.Player
import org.hmaissi.lifeQuest.Quest

class BootStrap {

    def init = { servletContext ->
        createDummyData()
    }
    def destroy = {
    }

    private void createDummyData() {


        Player player = new Player()
        player.level = 0
        player.xpPoints = 0
        player.username = "john"
        player.password = "password"
        player.accountLocked = false
        player.accountExpired = false
        player.enabled = true
        player.save(failOnError: true)

        Player player2 = new Player()
        player2.level = 0
        player2.xpPoints = 0
        player2.username = "andy"
        player2.password = "password"
        player2.accountLocked = false
        player2.accountExpired = false
        player2.enabled = true
        player2.save(failOnError: true)

        Link link1 = new Link()
        link1.description = "Look for some resources that you can bookmark and reference later on your own. This article is filled with helpful sites, meetups, and design-focused organizations around the world. The first step to design literacy is to immerse yourself"
        link1.url = "http://google.com"
        link1.imageUrl = "http://google.com"
        link1.title = "Startups, This is How Design Works"
        link1.type = "Article"
        link1.xpGain = 20
        link1.save(failOnError: true)

        Link link2 = new Link()
        link2.url = "http://google.com"
        link2.description = "Look for some resources that you can bookmark and reference later on your own. This article is filled with helpful sites, meetups, and design-focused organizations around the world. The first step to design literacy is to immerse yourself"
        link2.imageUrl = "http://google.com"
        link2.title = "Startups, This is How Design Works"
        link2.type = "Article"
        link2.xpGain = 20
        link2.save(failOnError: true)

        Link link3 = new Link()
        link3.url = "http://google.com"
        link3.description = "Look for some resources that you can bookmark and reference later on your own. This article is filled with helpful sites, meetups, and design-focused organizations around the world. The first step to design literacy is to immerse yourself"
        link3.imageUrl = "http://google.com"
        link3.title = "Startups, This is How Design Works"
        link3.type = "Article"
        link3.xpGain = 20
        link3.save(failOnError: true)

        Link link4 = new Link()
        link4.url = "http://google.com"
        link4.description = "Look for some resources that you can bookmark and reference later on your own. This article is filled with helpful sites, meetups, and design-focused organizations around the world. The first step to design literacy is to immerse yourself"
        link4.imageUrl = "http://google.com"
        link4.title = "Startups, This is How Design Works"
        link4.type = "Article"
        link4.xpGain = 20
        link4.save(failOnError: true)

        for(int x = 0; x < 5; x++) {
            Quest quest = new Quest()
            quest.title = "Become a master of bootstrap"
            quest.ownerId = player2.id
            quest.primarySkill = "Programming"
            quest.secondarySkill = "Web Design"
            quest.imageUrl = "http://google.com"
            quest.description = "Bootstrap was made to not only look and behave great in the latest desktop browsers (as well as IE7!), but in tablet and smartphone browsers via responsive CSS as well. "
            quest.addToLinks(link1)
            quest.addToLinks(link2)
            quest.addToLinks(link3)
            quest.addToLinks(link4)
            quest.save(failOnError: true)
        }


    }
}
