<div class="block span4">
    <p class="block-heading">
        <span class="block-icon pull-right">
            <a href="#" class="demo-cancel-click" rel="tooltip" title="" data-original-title="settings"><i class="icon-cog"></i></a>
        </span>

        <span>Open Quests</span>
    </p>
    <div class="block-body project">

        <ul class="unstyled">

                <g:displayQuestStatus player="${it}" questList="${it?.openQuests}"></g:displayQuestStatus>

        </ul>


    </div>
</div>