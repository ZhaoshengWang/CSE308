<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <meta charset="UTF-8">
        <title>GradeQuest</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/hpss1.css">
        <style>
            body {background-color: #f4f4f4; font-family: "Palatino Linotype", "Book Antiqua", Palatino, serif; margin: 0;}
            .block-centered {margin: 0 auto;}
            #top-nav {height: 6em; padding:0; background-color: #fff; text-align: center; border-bottom: #000 .1em solid; z-index: 999; position: absolute; width: 100%}
            #logo {display: inline-block; font-size: 2em; text-decoration: none; color: #000;}
            #nav {list-style: none; display: inline-block; margin: 0; padding: 1em 1em .8em 2em;}
            #nav li {display: inline-block; padding: 1.5em 3em; margin: 0; width: auto; color: #616263;
                     font-weight: bold;}
            #top-nav-menu {width: 60em; height: 0; background-color: #fff; transition: ease 0.3s; overflow: hidden;}
            #content-div {
                width:50em; background-color: #fff; height: 100em; position: relative; top: 10em;
            }
            .login-button {width: 1em;}
            #login-div {height: 8em; position: relative; top: 1em; transition: .3s ease; max-width: 500px; background-color: #fff; 
                         border-color: #999999; text-align: center;
                        padding: 2em 0 0 0; overflow: hidden;}
            input {display: block; width: 50%; border-radius: .5em; border-style: solid; margin: 0 auto 0 auto; padding-bottom: .5em; border-color: #cccccc}
            input:focus {border-color: #66afe9;
                         box-shadow: 0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px rgba(102, 175, 233, 0.6);
                         outline: 0 none;}
            #login-button { width: 6em;}
            #help {font-size: .7em;}

            @media (min-width: 400px){}
            /**
            background: linear-gradient(#f4f4f4, #fff) no-repeat
            */
        </style>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script type="text/javascript">
            $(function () {
              //  $("#login-button").click(function(){window.location.href="admin.html"});
                $("#nav").hover(openNavMenu, closeNavMenu);
                $("#top-nav-menu").hover(openNavMenu, closeNavMenu);
            });
            function openNavMenu() {
                $("#top-nav-menu").css("height", "15em");
                /** $("#id-input").attr("placeholder", "Login ID");
                 $("#pw-input").attr("placeholder", "Password");
                 $("#login-div").css("height", "10em");*/
            }
            function closeNavMenu() {
                $("#top-nav-menu").css("height", "");
                /**$("#id-input").attr("placeholder", "");
                 $("#pw-input").attr("placeholder", "");
                 $("#login-div").css("height", "");*/
            }
        </script>
    </head>
    <body>
        <div id="top-nav">
            <a href="home.html" id="logo">GradeQuest</a>
            <ul id="nav"><li>Business</li><li>Service</li><li>Student</li><li>About Us</li>
            </ul>
            <div id="top-nav-menu" class="block-centered">
                <div id="login-div" class="block-centered">
                    <form method="POST" action="login" id="login-form">
                        <input class="block-centered" placeholder="User ID" type="text" id="id-input" name="id">
                        <input class="block-centered" placeholder="Password" type="password" id="pw-input" name="pw">
                        <input class="block-centered" type="submit" value="Sign In" id="login-button">
                        <a id="help" href="" onclick="return false;">Need help?</a>
                    </form>
                </div>
            </div>
        </div>



        <div id="content-div" class="block-centered">

        </div>
    </body>
</html>
