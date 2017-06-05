<%@ page language="java" contentType="text/html;charset=cp1251" %>
<!doctype html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
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
            <div class="row">
                <div class="col-sm-12">
                    <div class="panel panel-default panel-floating panel-floating-inline">
                        <div class="panel-body">
                            <div class="panel-actions">
                                <form id="studentForm">
                                    <div class="form-group">
                                        <label for="idStudent">№</label>
                                        <input class="form-control" type="text" id="idStudent" placeholder="№">
                                    </div>
                                    <div class="form-group">
                                        <label for="nameStudent">Имя</label>
                                        <input class="form-control" type="text" id="nameStudent" placeholder="Имя">
                                    </div>
                                    <div class="form-group">
                                        <label for="surnameStudent">Фамилия</label>
                                        <input class="form-control" type="text" id="surnameStudent"
                                               placeholder="Фамилия">
                                    </div>
                                    <div class="form-group">
                                        <label for="genderStudent">Пол</label>
                                        <select class="form-control" id="genderStudent">
                                            <option value="Мужской">Мужской</option>
                                            <option value="Женский">Женский</option>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label for="birthdayStudent">Дата рождения</label>
                                        <input class="form-control" type="date" value="1994-01-01" id="birthdayStudent">
                                    </div>
                                    <div class="form-group">
                                        <label for="addressStudent">Адрес</label>
                                        <input class="form-control" type="text" id="addressStudent" placeholder="Адрес">
                                    </div>
                                    <div class="form-group">
                                        <label for="phoneStudent">Номер телефона</label>
                                        <input class="form-control" type="text" id="phoneStudent"
                                               placeholder="Номер телефона">
                                    </div>
                                    <div class="form-group">
                                        <label for="cityStudent">Город</label>
                                        <select class="form-control" id="cityStudent">
                                            <option value="Улан-Удэ">Улан-Удэ</option>
                                            <option value="Москва">Москва</option>
                                        </select>
                                    </div>
                                    <button type="submit" class="btn btn-primary">Добавить</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="hidden-xs">
            <div class="row row-backbordered">
                <div class="col-sm-12">
                    <div class="panel panel-default panel-floating panel-floating-inline">
                        <div class="panel-body">
                            <div class="panel-actions">
                                <button id="showCountry" class="btn btn-primary">Страна</button>
                                <button id="showRegion" class="btn btn-primary">Регион</button>
                                <button id="showCity" class="btn btn-primary">Город</button>
                                <button id="showStudent" class="btn btn-primary">Студент</button>
                                <hr>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="panel panel-default panel-floating panel-floating-inline">
                    <div class="panel-body">
                        <div class="panel-actions">
                            <ul class="nav nav-tabs" role="tablist">
                                <li class="nav-item">
                                    <a class="nav-link active" data-toggle="tab" href="#countryTab"
                                       role="tab">Страна</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" data-toggle="tab" href="#regionTab" role="tab">Регион</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" data-toggle="tab" href="#cityTab" role="tab">Город</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" data-toggle="tab" href="#studentTab" role="tab">Студент</a>
                                </li>
                            </ul>
                            <div class="tab-content">
                                <div class="tab-pane" id="countryTab" role="tabpanel">
                                    <table id="countryTable" class="table table-bordered">
                                        <thead>
                                        <tr>
                                            <th>№</th>
                                            <th>Название</th>
                                        </tr>
                                        </thead>
                                        <tbody id="countryBody">

                                        </tbody>
                                    </table>
                                </div>
                                <div class="tab-pane" id="regionTab" role="tabpanel">
                                    <table id="regionTable" class="table table-bordered">
                                        <thead>
                                        <tr>
                                            <th>№</th>
                                            <th>Название</th>
                                        </tr>
                                        </thead>
                                        <tbody id="regionBody">

                                        </tbody>
                                    </table>
                                </div>
                                <div class="tab-pane" id="cityTab" role="tabpanel">
                                    <table id="cityTable" class="table table-bordered">
                                        <thead>
                                        <tr>
                                            <th>№</th>
                                            <th>Название</th>
                                        </tr>
                                        </thead>
                                        <tbody id="cityBody">

                                        </tbody>
                                    </table>
                                </div>
                                <div class="tab-pane active" id="studentTab" role="tabpanel">
                                    <table id="studentTable" class="table table-bordered">
                                        <thead>
                                        <tr>
                                            <th>№</th>
                                            <th>Имя</th>
                                            <th>Фамилия</th>
                                            <th>Пол</th>
                                            <%--<th>Дата рождения</th>--%>
                                            <th>Адрес</th>
                                            <th>Город</th>
                                            <th>Телефон</th>
                                            <th>Функции</th>
                                        </tr>
                                        </thead>
                                        <tbody id="studentBody">

                                        </tbody>
                                    </table>
                                </div>
                            </div>
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
<!-- main.js -->
<script src="js/main.js"></script>
</body>

</html>
