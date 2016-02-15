var boardID;
var link;
var links;
var names;
var name;
var tasks;
var task;
var patientName;
var patientNames;
var posterNames;
var posterName;
var post;
var posts;
var j;
var postXMLDoc;
var postXML;
var msg;

//add a new post to the board (post)
function addPost() {
//    console.log("function addPost");
    $('#post2board').click(function () {
        console.log("function post2board");
        postXMLDoc = $.parseXML('<post><content></content></post>');
        postXML = $(postXMLDoc);
        msg = $('#message').val();
        if (msg !== null) {
            postXML.find("content").append(msg);
        } else {
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
                console.log(response);
            },
            success: function (res) {
                showPosts();
            }
        });
    });
}

function pollPosts() {
    setTimeout(function () {
        showPosts();
        pollPosts();
    }, 500);
}

$(document).ready(function () {

    // Synchronous loading test
//    var postHTML = builder.postHTML();
    var postHTMLcache = null;

    // Login the user first. This is for development purpose.
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
//    $.get('api/users', function (xml) {
//        var $xml = $(xml);
//        names = $xml.find("name");
//        for (i = 0; i < names.length; i++) {
//            name += "<a id=\"userLink\" href=\"#\">"
//                    + names[i].textContent + "</a><br>";
//        }
//        document.getElementById("userList").innerHTML = name;
//    });
//    name = "";

    listBoards();

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
    listPatients();
//    $.get('api/patients', function (xml) {
//        var $xml = $(xml);
//        patientNames = $xml.find("value>name");
//        for (i = 0; i < patientNames.length; i++) {
//            patientName += "<a id=\"patientLink\" href=\"#\">"
//                    + patientNames[i].textContent + "</a><br>";
//        }
//        document.getElementById("patientList").innerHTML = patientName;
//    });
//    patientName = "";

//    listPatients();

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

function listBoards() {
    // GET a list of all boards
    $.get('api/boards', function (xml) {
        var $xml = $(xml);
        var boards = $xml.find('board');

        document.getElementById('boardList').innerHTML = '';
        for (var i = 0; i < boards.length; i++) {
            var $board = $(boards[i]);
            var id = $board.find('board > id').text();
            var name = $board.find('board > name').text();

            var $boardDOM = $('<a href="#" class="list-group-item">' + name + '</a>');
            $boardDOM.attr('onclick', 'showBoard(' + id + ')');
//            boardDOM.appendTo(document.getElementById('boardList'))
            document.getElementById('boardList').appendChild($boardDOM.get(0));
//            document.getElementById('boardList').innerHTML += '<br>';

//            var boardLink = document.createElement('A');
//            boardLink.innerHTML = name;
//            boardLink.setAttribute('onclick', 'showBoard(' + id + ')');
//            document.getElementById("boardList").appendChild(boardLink);
//            document.getElementById("boardList").innerHTML += '<br>';
        }
    });
}

function listPatients() {
    // GET a list of all patients
    $.get('api/patients', function (xml) {
        var $xml = $(xml);

        var patients = $xml.find('byId > entry > value'); // TODO Should be changed from the backend
//        var patients = $xml.find('patient');

        document.getElementById('patientList').innerHTML = '';
        for (var i = 0; i < patients.length; i++) {
            var $patient = $(patients[i]);

            var id = $patient.find('value > id').text(); // TODO Should be changed from the backend
            var name = $patient.find('value > name').text(); // TODO Should be changed from the backend

            var patientDOM = $('<a href="#">' + name + '</a>');
            patientDOM.attr('onclick', 'getPatient(' + id + ')');
            patientDOM.appendTo(document.getElementById('patientList'));
            document.getElementById('patientList').innerHTML += '<br>';
        }
    });
}

function showPosts(boardId) {
    // GET a list of all posts in a board
    $.get('api/boards/' + boardId + '/posts', function (xml) {
        var $panelDOM = $(document.getElementById("postList"));
        $panelDOM.empty();
        var $xml = $(xml);
        var posts = $xml.find('post');

        for (var i = 0; i < posts.length; i++) {
            var $post = $(posts[i]);
            var authorId = $post.find('post > author > id').text();
            var authorName = $post.find('post > author > name').text();
            var content = $post.find('post > content').text();

//            var postDOM = $('<div></div>');
//            postDOM.append('<em>' + authorName + '</em><br>');
//            postDOM.append(content);
//            $panelDOM.append(postDOM);

//            var postDOM = builder.postHTML();
//            postDOM.find('.author').html(authorName);
//            postDOM.find('.content').html(content);
//            $panelDOM.append(postDOM);

            var $postDOM;
            if (cache.postHTML.data) {
                $postDOM = $(cache.postHTML.data);
                $postDOM.find('.author').html(authorName).attr('href', 'api/users/' + authorId);
                $postDOM.find('.content').html(content);
                $postDOM.find('.header .profile-img').attr('src', 'http://api.adorable.io/avatars/64' + authorName + '.png');
                $panelDOM.append($postDOM);
            } else {
                console.log("No cache found, loading the component...");
                builder.loadComponent('components/post.html', function (html, cbData) {
                    console.log(cbData.authorName);
                    var $postDOM = $(html);
                    $postDOM.find('.author').html(cbData.authorName).attr('href', 'api/users/' + cbData.authorId);
                    $postDOM.find('.content').html(cbData.content);
                    $postDOM.find('.header .profile-img').attr('src', 'http://api.adorable.io/avatars/64' + cbData.authorName + '.png');
                    $panelDOM.append($postDOM);
                }, {authorId: authorId, authorName: authorName, content: content}, cache.postHTML);
            }
        }

//        $.each(posts, function (index, post) {
//            var $post = $(post);
//            var authorName = $post.find('post > author > name').text();
//            var content = $post.find('post > content').text();
//            var postDOM = $('<div></div>');
//            postDOM.append('<em>' + authorName + '</em><br>');
//            postDOM.append(content);
//            $postList.append(postDOM);
//        });

//        posterNames = $xml.find("name");
//        posts = $xml.find("content");
//        for (j = 0; j < posts.length; j++) {
//            post += posts[j].textContent + "<br>";
//        }
//        for (i = 0; i < posterNames.length; i++) {
//            posterName += posterNames[i].textContent + "<br>";
//        }
//        document.getElementById("postList").innerHTML = posterName + post + "<br>";
    });
}

function getPatient(patientId) {
    // GET a patient info
    $.get('api/patients/' + patientId, function (xml) {
        var $panelDOM = $(document.getElementById("postList"));
        $panelDOM.empty();
        var $xml = $(xml);
        var patients = $xml.find('patient');

        for (var i = 0; i < patients.length; i++) {
            var $patient = $(patients[i]);
            var name = $patient.find('patient > name').text();
            var age = $patient.find('patient > age').text();
            var doctorName = $patient.find('patient > mainDoctor > name').text();
            var roomNumber = $patient.find('patient > room > number').text();

            var postDOM = $('<div></div>');
            postDOM.append('<b>' + name + '</b><br>');
            postDOM.append('Age: ' + age + '<br>');
            postDOM.append('Doctor: ' + doctorName + '<br>');
            postDOM.append('Room: ' + roomNumber + '<br>');
            $panelDOM.append(postDOM);
        }
    });
}

// TODO update patient info (put)

// TODO add new patient (post)

var builder = {
    postHTML: function () {
        return $('<div class="post">' +
                '<div class="header">' +
                '<div class="author"></div>' +
                '</div>' +
                '<div class="content"></div>' +
                '</div>');
    },
    loadComponent: function (uri, cb, cbData, cacheTarget) {
        $.get(uri, function (html) {
            if (typeof cacheTarget.data !== 'undefined') {
                cacheTarget.data = html;
            }
            cb(html, cbData);
        });
//        $.ajax({
//            method: 'get',
//            url: uri,
//            async: false,
//            success: function (html) {
//                if (typeof cache !== 'undefined') {
//                    cache = html;
//                }
//                cb(html);
//            }
//        });
    }
};

var cache = {
    postHTML: { data: null }
};