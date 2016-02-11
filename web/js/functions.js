var boardID;
var boards;
var board;
var link;
var links;
var names;
var name;
var i;
var posts;
var post;
var j;
var tasks;
var task;
var patientName;
var patientNames;

$(document).ready(function () {

    //list all the users (get)
    $.get('api/users', function (xml) {
        var $xml = $(xml);
        names = $xml.find("name");
        for (i = 0; i < names.length; i++) {
            name += "<a id=\"userLink\" href=\"#\">"
                    + names[i].textContent + "</a><br>";
        }
        document.getElementById("userList").innerHTML = name;
    });
    name = "";

    //list all the boards (get)
    $.get('api/boards', function (xml) {
        var $xml = $(xml);
        boards = $xml.find("name");
        for (i = 0; i < boards.length; i++) {
            board += "<a id=\"boardLink\" href=\"#" +
                    "\" onclick=\"showBoard(); return false;\">"
                    + boards[i].textContent + "</a><br>";
        }
        document.getElementById("boardList").innerHTML = board;
    });
    board = "";

    //list all the board's users (get)
    $('#listUsers').click(function () {
        $.get('api/board//users', function (xml) {
            console.log(xml);
            var $xml = $(xml);
            names = $xml.find("name");
            for (i = 0; i < names.length; i++) {
                name += names[i].textContent + "<br>";
            }
            document.getElementById("userList").innerHTML = name;
        });
        name = "";
    });
    
    //add a new user to the board (post)
    $('user2board').click(function () {
        console.log("inside user2board function");
        var usr = $('#addUser').val();
        $.post('api/boards//users', usr,
                function () {
                    console.log("user addition ok");
                });
    });

    //list all the patients' names (get)
    $.get('api/patients', function (xml) {
        var $xml = $(xml);
        patientNames = $xml.find("value>name");
        for (i = 0; i < patientNames.length; i++) {
            patientName += "<a id=\"patientLink\" href=\"#\">"
                           + patientNames[i].textContent + "</a><br>";
        }
        document.getElementById("patientList").innerHTML = patientName;
    });
    patientName = "";

    //list patient info (get)
    function showPatient() {
        $.get('api/patients/{id}', function (xml) {
            console.log(xml);
            var $xml = $(xml);
            names = $xml.find("");//what info should it retrieve
            for (i = 0; i < names.length; i++) {
                name += "<a id=\"patientLink\" href=\"#\">"
                    + names[i].textContent + "</a><br>";
            }
            document.getElementById("patientList").innerHTML = name;
        });
        name = "";
    };

    //update patient info (put)

    //add new patient (post)

    //list all the tasks (get)
    $.get('api/tasks', function (xml) {
        console.log(xml);
        var $xml = $(xml);
        tasks = $xml.find("name");
        for (i = 0; i < tasks.length; i++) {
            task += names[i].textContent + "<br>";
        }
        document.getElementById("taskList").innerHTML = task;
    });
    task = "";
});