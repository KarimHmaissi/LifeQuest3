<div data-offset-top="360" data-spy="affix" class="sidebar-nav affix-top">
    <form class="search form-inline">
        <input type="text" placeholder="Search...">
        <button class="search-submit btn-search" value="" type="submit"><i class="icon-search"></i></button>
    </form>

    <div class="sidebar-avatar">
        <img src="assets/images/team-1.jpg" alt="avatar" class="thumbnail-avatar">
        <a href="#"><div class="sidebar-avatar-message"><div class="notify notify-message"><i class="icon-envelope"></i></div></div></a>
        <a href="#"><div class="sidebar-avatar-notify"><div class="notify ">7</div></div></a>
    </div>


    <a data-toggle="collapse" data-target=".nav-collapse" class="btn-sidebar">
        <span class="notify navigation span12"><i class="icon-reorder"></i> Navigation <span class="pull-right label sidebar-label label-danger"><i class="icon-angle-down"></i> </span></span>
    </a>


    <div class="nav-collapse subnav-collapse collapse ">

        <li><g:link class="nav-header" controller="Player" action="index"><i class="icon-calendar"></i>Profile</g:link></li>
        <li><g:link class="nav-header" controller="achievement" action="index"><i class="icon-calendar"></i>Achievements</g:link></li>
        <a href="#ui-elements" class="nav-header" data-toggle="collapse"><i class="icon-magic"></i>Quests<span class="label sidebar-label label-info"><i class="icon-angle-down"></i> </span></a>
        <ul id="ui-elements" class="nav nav-list collapse">
            <li><g:link controller="quest" action="index"><i class="icon-tasks"></i> Quest Library</g:link></li>
            <li><g:link controller="quest" action="openQuests"><i class="icon-circle"></i> Open Quests</g:link> </li>
            <li><g:link controller="quest" action="completedQuests"><i class="icon-list-alt"></i> Completed Quests</g:link></li>
            <li><g:link controller="quest" action="createQuest"><i class="icon-list-alt"></i> Create a Quest</g:link></li>
        </ul>







    </div>

</div><!-- sidebar -->