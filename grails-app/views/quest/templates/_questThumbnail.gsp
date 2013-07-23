<div class="questThumbnail">
    <h3 class="questTitle">${it?.title}</h3>
    <g:img class="questThumbnailImage" dir="images" file="bootstrap.png"/>
    <p class="questDescription">${it?.description}</p>
    <g:link action="viewQuest" params="[questId:it.id]">View Quest</g:link>
    <g:link controller="player" action="addQuestToOpen" params="[questId:it.id]">Add to open quests</g:link>
</div>