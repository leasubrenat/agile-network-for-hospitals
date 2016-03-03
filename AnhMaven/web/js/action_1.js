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

var me = {
    id: null,
    name: null
};
var board = {
    activeId: null,
    polling: false
};

//add a new post to the board (post)
function addPost() {
    if (!board.activeId)
        return;
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
        $.ajax({
            url: "api/boards/" + board.activeId + "/posts",
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
                showPosts(board.activeId);
            }
        });
    });
}

function pollPosts() {
    setTimeout(function () {
        if (board.activeId) {
            showPosts(board.activeId);
        } else {
            board.polling = false;
        }
        if (board.polling)
            pollPosts();
    }, 500);
}

/**
 * MAIN FUNCTION
 */
$(document).ready(function () {

    session(function () {
        $('.dashboard > .welcome').html('Welcome back, ' + me.name);
    });
    $('#login-form button').click(function () {
        var username = document.getElementById('login-username').value;
        var password = document.getElementById('login-password').value;
        session(function () {
            $('.dashboard > .welcome').html('Welcome back, ' + me.name);
        }, {username: username, password: password});
    });

    pollPosts();

    $('#collapse-notification').click(function () {
        board.activeId = null;
        board.polling = false;
        showNotifications();
    });

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

    //list all the tasks (get)
    $.get('api/tasks', function (xml) {
        var $xml = $(xml);
        tasks = $xml.find("name");
        for (i = 0; i < tasks.length; i++) {
            task += tasks[i].textContent + "<br>";
        }
        document.getElementById("taskList").innerHTML = task;
    });
    task = "";
});

function session(cb, cred) {
    if (cred && cred.username && cred.password) {
        var xmlCred = $.parseXML('<user><username>' + cred.username + '</username><password>' + cred.password + '</password></user>');
        $.ajax({
            url: "api/users/login",
            data: xmlCred,
            processData: false,
            type: "POST",
            contentType: "application/xml",
            dataType: "xml",
            success: function (xml) {
                var $xml = $(xml);
                me.id = $xml.find('user > id').text();
                me.name = $xml.find('user > name').text();
                cb();
            }
        });
    } else {
        $.ajax({
            url: 'api/users/me',
            type: 'GET',
            success: function (xml) {
                var $xml = $(xml);
                me.id = $xml.find('user > id').text();
                me.name = $xml.find('user > name').text();
                cb();
            }
        });
    }
}

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

            var $boardDOM = $('<a href="#tab-board" data-toggle="tab" class="list-group-item">' + name + '</a>');
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

            var patientDOM = $('<a href="#tab-patient" data-toggle="tab">' + name + '</a>');
            patientDOM.attr('onclick', 'getPatient(' + id + ')');
            patientDOM.appendTo(document.getElementById('patientList'));
            document.getElementById('patientList').innerHTML += '<br>';
        }
    });
}

function showNotifications() {
    // GET a list of all notifications
    if (!me.id)
        return;
    $.get('api/users/' + me.id + '/notifications', function (xml) {
        var $panelDOM = $(document.getElementById("notification-list"));
        $panelDOM.empty();
        var $xml = $(xml);
        var notifications = $xml.find('notification');

        for (var i = 0; i < notifications.length; i++) {
            var $notification = $(notifications[i]);
            var senderName = $notification.find('notification > sender > name').text();
            var postId = $notification.find('notification > post > id').text();
            var postPreview = $notification.find('notification > post > content').text().substring(0, 30);
            var unread = $notification.find('notification > unread').text();

            var $postDOM;
            $postDOM = $('<div class="notification"></div>');
            if (unread === 'true') {
                $postDOM.addClass('unread');
            }
            $postDOM.append('From: ' + senderName + '<br>');
            $postDOM.append(postPreview + '...');
            $panelDOM.append($postDOM);
        }
    });
}

function showPosts(boardId) {
    board.activeId = boardId;
    if (!board.polling)
        pollPosts();
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
            var authorUsername = $post.find('post > author > username').text();
            var content = $post.find('post > content').text();

            var $postDOM;
            if (cache.postHTML.data) {
                $postDOM = $(cache.postHTML.data);
                $postDOM.find('.author').html(authorName).attr('href', 'api/users/' + authorId);
                $postDOM.find('.content').html(content);
                $postDOM.find('.header .profile-img').attr('src', 'http://api.adorable.io/avatars/40/' + authorUsername + '.png');
                $panelDOM.append($postDOM);
            } else {
                console.log("No cache found, loading the component...");
                builder.loadComponent('components/post.html', function (html, cbData) {
                    console.log(cbData.authorName);
                    var $postDOM = $(html);
                    $postDOM.find('.author').html(cbData.authorName).attr('href', 'api/users/' + cbData.authorId);
                    $postDOM.find('.content').html(cbData.content);
                    $postDOM.find('.header .profile-img').attr('src', 'http://api.adorable.io/avatars/40/' + cbData.authorUsername + '.png');
                    $panelDOM.append($postDOM);
                }, {authorId: authorId, authorName: authorName, authorUsername: authorUsername, content: content}, cache.postHTML);
            }
        }
    });
}

function getPatient(patientId) {
    board.activeId = null;
    board.polling = false;
    // GET a patient info
    $.get('api/patients/' + patientId, function (xml) {
        var $panelDOM = $(document.getElementById("patient-info"));
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
    loadComponent: function (uri, cb, cbData, cacheTarget) {
        $.get(uri, function (html) {
            if (typeof cacheTarget !== 'undefined') {
                cacheTarget.data = html;
            }
            cb(html, cbData);
        });
    }
};

var cache = {
    postHTML: {data: null}
};