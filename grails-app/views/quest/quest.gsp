<%--
  Created by IntelliJ IDEA.
  User: Karim
  Date: 22/07/13
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="custom"/>
    <title>${quest?.title}</title>

</head>

<body>
    <div class="content">

        %{--<div class="header">--}%
            %{--<h1 class="page-title">Quest</h1>--}%
        %{--</div><!-- header -->--}%

        %{--<ul class="breadcrumb">--}%
            %{--<li><a href="#">Home</a> <span class="divider"><i class="icon-chevron-right"></i></span></li>--}%
            %{--<li class="active">Dashboard</li>--}%

        %{--</ul><!-- breadcrumb -->--}%

        <div class="wrapper-content">
            <div class="container-fluid">
                <div class="row-fluid">

                    <g:if test="${questComplete == true}">
                        <div class="block span9 quest questComplete" id="${quest.id}">
                    </g:if>
                    <g:elseif test="${questOpen == true}">
                        <div class="block span9 quest questOpen" id="${quest.id}">
                    </g:elseif>
                    <g:else>
                        <div class="block span9 quest" id="${quest?.id}">
                    </g:else>

                        <div class="block-body">
                            <h2>Quest Title: ${quest?.title}</h2>

                            <p class="questDescription">${quest?.description}</p>


                            %{--Loop over each task in the quest. Test if task is complete --}%
                            %{--<g:each in="${quest.tasks}" var="task" status="i">--}%
                                %{--<g:each in="${completedTasks}" var="completedTasks" status="x">--}%

                                %{--</g:each>--}%
                                %{--<g:render template="templates/singleTask" bean="${task}" model="[number: i+1]"></g:render>--}%
                            %{--</g:each>--}%
                            <g:each in="${quest.tasks}" var="task" status="i">
                                <g:displayTask number="${i+1}" completedTasks="${completedTasks}" task="${task}" ></g:displayTask>
                            </g:each>
                        </div>

                    </div>

                    <div class="block span3">
                        <p class="block-heading">
                            <span class="block-icon pull-right">
                                <a href="#" class="demo-cancel-click" rel="tooltip" title="" data-original-title="settings"><i class="icon-cog"></i></a>
                            </span>

                            <span>Quest Creator</span>
                        </p>
                        <div class="block-body">
                            <div class="questImage">
                                <g:img dir="images" file="bootstrap.png" class="questThumbnailImage"></g:img>
                            </div>
                            <div class="questOwner">
                                <a href="profile/${username}"><h2><strong>${username}</strong></h2></a>
                            </div>
                        </div>
                    </div>

                    <div class="span3">
                            <g:if test="${questComplete == true}">
                                <h2>Quest Complete</h2>
                            </g:if>
                            <g:elseif test="${questOpen == true}">
                                <h2>Quest Open</h2>
                            </g:elseif>
                            <g:else>
                                <g:link class="btn btn-large btn-primary" controller="player" action="addQuestToOpen" params="[questId:quest.id]">Add to open quests</g:link>
                            </g:else>

                        </p>
                        %{--<div class="block-body">--}%

                        %{--</div>--}%
                    </div>


                </div>

                <g:render template="templates/questComments"></g:render>
            </div>
        </div><!-- wrapper-content -->
    </div><!-- content -->

    <r:script>
        init("quest");
    </r:script>
</body>
</html>