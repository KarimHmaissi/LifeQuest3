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
                    <div class="span3">
                        <div class="questImage">

                        </div>
                    </div>

                    <div class="span9">
                        <h2>Quest Title: ${quest?.title}</h2>

                        <p class="questDescription">${quest.description}</p>

                        <g:each in="${quest.links}" var="link" status="i">
                            <g:render template="templates/singleLink" bean="${link}" model="[number: i+1]"></g:render>
                        </g:each>

                    </div>

                </div>
            </div>
        </div><!-- wrapper-content -->
    </div><!-- content -->
</body>
</html>