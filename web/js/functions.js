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
var posterNames;
var posterName;
var post;
var posts;
var j;
var i;
var postXMLDoc;
var postXML;
var msg;

//display all the posts in the board (get)
var myfunc = function () {
    console.log("HAHAHAHAHAHAH");
};
function showPosts() {
    $.get('api/boards/1/posts', function (xml) {
        console.log("function showPosts");
        var $xml = $(xml);
        posterNames = $xml.find("name");
        posts = $xml.find("content");
        for (j = 0; j < posts.length; j++) {
            post += posts[j].textContent + "<br>";
        }
        for (i = 0; i < posterNames.length; i++) {
            posterName += posterNames[i].textContent + "<br>";
        }
        document.getElementById("postList").innerHTML = posterName + post + "<br>";
    });
    post = "";
    posterName = "";
}
;

//add a new post to the board (post)
function addPost() {
    console.log("function addPost");
    $('#post2board').click(function () {
        console.log("function post2board");
        postXMLDoc = $.parseXML('<post><content></content></post>');
        postXML = $(postXMLDoc);
        msg = $('#message').val();
        if (msg !== null) {
            postXML.find("content").append(msg);
        }
        else {
            console.log("empty message");
        }
//                    console.log(postXMLDoc);
        $.ajax({
            url: "api/boards/1/posts",
            data: postXMLDoc,
            processData: false,
            type: "POST",
            contentType: "application/xml",
            dataType: "xml",
            error: function (response) {
                alert("Error: " + response.statusText);
            },
            success: function (res) {
                showPosts();
            }
        });
    });
}
;

// DRQFT

//uArr = find (#user)
//
//uArr.each(func(element) {
//    
//})



// DRAQT

function pollPosts() {
    setTimeout(function () {
        showPosts();
        pollPosts();
    }, 500);
}

$(document).ready(function () {

    var xmlCred = $.parseXML('<user><username>ctu</username><password>111111</password></user>');
    $.ajax({
        url: "api/users/login",
        data: xmlCred,
        processData: false,
        type: "POST",
        contentType: "application/xml",
        dataType: "xml",
        success: function (xml) {
            console.log(xml);
        }
    });


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
        boards = $xml.find("board > name");
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
    }
    ;

    //update patient info (put)

    //add new patient (post)

    //list all the tasks (get)
    $.get('api/tasks', function (xml) {
//        console.log(xml);
        var $xml = $(xml);
        tasks = $xml.find("name");
        for (i = 0; i < tasks.length; i++) {
            task += tasks[i].textContent + "<br>";
        }
        document.getElementById("taskList").innerHTML = task;
    });
    task = "";
});