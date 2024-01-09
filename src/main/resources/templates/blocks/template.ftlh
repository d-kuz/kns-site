<#macro template user>
    <!doctype html >
    <html lang="ru">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">


        <title>Путь к себе</title>
    </head>
    <style>
        .mainTable{
            background-color: #08414a;
            color: #DAE7E6;
            width:100%;
            cellpadding:10px;
            align-self:center
        }
        .container{
            display: flex;
            justify-content: center;
        }
        .a_style {
            align-content: center;
            align-self: center;
            color: #000000;
        }
        p{
            color: #01272d;
        }

        body{
            color: #569393;
        }
        table{
            color: #01272d;
            text-align: center;
            align-self :center

        }
        .button1 {
            background-text: #DAE7E6
        }

        .p1{
            font-size: 16px;
            display: inline-block;
        }

        a{
            align-content: center;
            align-self: center;
            color: #FFFFFF;
        }
        a:visited {
            align-content: center;
            align-self: center;
            color: #569393;
        }
        .modal {
            display: none;
            position: fixed;
            z-index: 1;
            right: 0;
            top: -10%;
            width: 10%;
            height: 10%;
            overflow: auto;
            background-color: rgba(0, 0, 0, 0);
        }

        .modal-content {

        }

        .close {
        }


        * {box-sizing: border-box}
        body {font-family: Verdana, sans-serif; margin:0}
        .mySlides {display: none}
        img {vertical-align: middle;}

        /* Slideshow container */
        .slideshow-container {
            max-width: 300px;
            position: relative;
            margin: auto;
        }

        /* Next & previous buttons */
        .prev, .next {
            cursor: pointer;
            position: absolute;
            top: 50%;
            width: auto;
            padding: 16px;
            margin-top: -22px;
            color: white;
            font-weight: bold;
            font-size: 18px;
            transition: 0.6s ease;
            border-radius: 0 3px 3px 0;
        }

        /* Position the "next button" to the right */
        .next {
            right: -50px;
            border-radius: 0 3px 3px 0 ;
        }

        .prev {
            left: -50px;
            border-radius: 3px 0 0  3px;
        }

        /* On hover, add a black background color with a little bit see-through */
        .prev:hover, .next:hover {
            background-color: rgba(0,0,0,0.8);
        }

        /* Caption text */
        .text {
            color: #f2f2f2;
            font-size: 15px;
            padding: 8px 12px;
            position: absolute;
            bottom: 8px;
            width: 100%;
            text-align: center;
        }

        /* Number text (1/3 etc) */
        .numbertext {
            color: #f2f2f2;
            font-size: 12px;
            padding: 8px 12px;
            position: absolute;
            top: 0;
        }

        /* The dots/bullets/indicators */
        .dot {
            cursor: pointer;
            height: 15px;
            width: 15px;
            margin: 0 2px;
            background-color: #bbb;
            border-radius: 50%;
            display: inline-block;
            transition: background-color 0.6s ease;
        }

        .active, .dot:hover {
            background-color: #717171;
        }

        /* Fading animation */
        .fade {
            -webkit-animation-login: fade;
            -webkit-animation-duration: 1.5s;
            animation-login: fade;
            animation-duration: 1.5s;
        }

        @-webkit-keyframes fade {
            from {opacity: .4}
            to {opacity: 1}
        }

        @keyframes fade {
            from {opacity: .4}
            to {opacity: 1}
        }

        /* On smaller screens, decrease text size */
        @media only screen and (max-width: 300px) {
            .prev, .next,.text {font-size: 11px}
        }
        .cololEmail{
            color: white;
        }
    </style>
    <body>
    <table class="mainTable">
        <tr>
            <th width="15%"></th>
            <th width="15%"></th>
            <th><h2><a href = "/" style="text-decoration:none; color:#FFFFFF;" >Главная</a></h2></th>
            <th><h2><a href = "/course"  style="text-decoration:none; color:#FFFFFF;" >Курсы</a></h2></th>
            <th>
                <#if user.email??>
                    <h2><a href="/profile">
                            Профиль
                        </a></h2>
                <#else>
                    <h2><a href="/login">
                            Войти
                        </a></h2>
                </#if>
            </th>
            <th width="15%"></th>
            <th width="15%"></th>
        </tr>
    </table>
    <hr>
    <#nested/>
    <hr>
    <table class="mainTable">
        <tr>
            <td></td>
        </tr>
        <tr>
            <td align="center">
                <a href="https://vk.com/hydeem_s_golovoi"><img src="/static/vk.png" width="3%"></a>
                <span class="cololEmail">   hudeem-s-golovoi@mail.ru</span>
            </td>
            <td>

            </td>
        </tr>
        <tr>
            <td> </td>
        </tr>
    </table>
    </body>
    </html>
</#macro>
