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
    <title>Completed Quests</title>

</head>

<body>
<div class="content">
    <div class="wrapper-content">
        <div class="container-fluid">
            <h1>Completed Quests</h1>
            <div class="row-fluid">
                <g:each in="${quests}" var="quest" status="i">
                    <div class="block span3">
                        <div class="block-body">
                            <g:displayQuest quest="${quest}" allOpen="${false}" allCompleted="${true}"></g:displayQuest>
                        </div>
                    </div>
                </g:each>

            </div>
        </div>
    </div><!-- wrapper-content -->
</div><!-- content -->
</body>
</html>