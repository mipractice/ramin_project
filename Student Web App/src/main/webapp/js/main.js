/**
 * Created by Ramin on 28.05.2017.
 */
/*------------- Вывод всех стран ----------*/
$(function () {
    $("#showCountry").click(function () {
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/student-ws-app/country/getall",
            dataType: "xml",
            success: function (xml) {
                $(xml).find('Country').each(function () {
                    var id = $(this).find("idCountry").text();
                    var name = $(this).find("nameCountry").text();
                    $("#countryBody").append(
                        '<tr>' +
                        '<td>' + id + '</td>' +
                        '<td>' + name + '</td>' +
                        '</tr>'
                    );
                });
            }
        });
    })
});


/*------------- Вывод всех регионов ----------*/
$(function () {
    $("#showRegion").click(function () {
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/student-ws-app/region/getall",
            dataType: "xml",
            success: function (xml) {
                $(xml).find('Region').each(function () {
                    var id = $(this).find("idRegion").text();
                    var name = $(this).find("nameRegion").text();
                    $("#regionBody").append(
                        '<tr>' +
                        '<td>' + id + '</td>' +
                        '<td>' + name + '</td>' +
                        '</tr>'
                    );
                });
            }
        });
    })
});


/*------------- Вывод всех городов ----------*/
$(function () {
    $("#showCity").click(function () {
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/student-ws-app/city/getall",
            dataType: "xml",
            success: function (xml) {
                $(xml).find('City').each(function () {
                    var id = $(this).find("idCity").text();
                    var name = $(this).find("nameCity").text();
                    $("#cityBody").append(
                        '<tr>' +
                        '<td>' + id + '</td>' +
                        '<td>' + name + '</td>' +
                        '</tr>'
                    );
                });
            }
        });
    })
});


/*------------- Вывод всех студентов ----------*/
$(function () {
    $("#showStudent").click(function () {
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/student-ws-app/student/getall",
            dataType: "xml",
            success: function (xml) {
                $(xml).find('Student').each(function () {
                    var id = $(this).find("idStudent").text();
                    var firstname = $(this).find("firstname").text();
                    var surname = $(this).find("surname").text();
                    var gender = $(this).find("gender").text();
                    var birthday = $(this).find("birthday").text();
                    var address = $(this).find("address").text();
                    var city = $(this).find("nameCity").text();
                    var phone = $(this).find("phone").text();
                    $("#studentBody").append(
                        '<tr>' +
                        '<td>' + id + '</td>' +
                        '<td>' + firstname + '</td>' +
                        '<td>' + surname + '</td>' +
                        '<td>' + gender + '</td>' +
                        // '<td>' + birthday + '</td>' +
                        '<td>' + address + '</td>' +
                        '<td>' + city + '</td>' +
                        '<td>' + phone + '</td>' +
                        '<td>' +
                            '<a id="deleteStudent" href="http://localhost:8080/student-ws-app/student/delete/'+ id + '" class="btn btn-primary"><i class="fa fa-trash-o" aria-hidden="true"></i></a>' +
                        '</td>' +
                        '</tr>'
                    );
                });
            }
        });
    })
});

