<%@ page language="java" contentType="text/html;charset=cp1251" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link href="//cdn.shopify.com/s/files/1/0691/5403/t/136/assets/style.scss.css?13696801755259293039" rel="stylesheet"
          type="text/css" media="all"/>
    <title>Student Web Service with RESTful</title>
</head>
<body id="bootstrap-themes" class="swag-line template-index">
<div class="container-overflow-wrap">
    <div class="container">
        <nav class="navbar navbar-default navbar-tall navbar-full" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#global-nav">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/student-ws-app/">Student Web App</a>
            </div>
            <div class="collapse navbar-collapse" id="global-nav">
                <div class="navbar-right">
                    <ul class="nav navbar-nav">
                        <li><a href="country/getall">Страна</a></li>
                        <li><a href="region/getall">Регион</a></li>
                        <li><a href="city/getall">Город</a></li>
                        <li><a href="student/getall">Студент</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="hidden-xs">
            <div class="row row-backbordered">
                <div class="col-sm-12">
                    <div class="panel panel-default panel-floating panel-floating-inline">
                        <div class="panel-body">

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- jquery.js -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js" type="text/javascript"></script>
<!-- bootstrap.js -->
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js" type="text/javascript"></script>

</body>
</html>