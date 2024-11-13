<#import "blocks/template.ftlh" as t>
<@t.template user>
    <h1 style="text-align: center">Авторизация</h1>
    <hr>
    <form action="/login" method="post">
        <div class="container">
        <div class="form-group">
            <label for="email">Электронная почта: </label>
            <input type="email" class="form-control <#if RequestParameters.error??>is-invalid</#if>"
                   id="email" name="username">
        </div>
        </div>
        <br>
        <div class="container">
        <div class="form-group">
            <label for="password">Пароль :</label>
            <input type="password" class="form-control <#if RequestParameters.error??>is-invalid</#if>"
                   id="password" name="password">
        </div>
        </div>
        <br>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <div class="container">
        <button type="submit" style="width: 100%" class="btn btn-dark">Войти</button>
        </div>
    </form>
    <hr>

    <br>
    <div class="container">
    <h2>Нет аккаунта? <a class="a_style" href="/registration">Зарегистрируйся!</a></h2>
    </div>
</@t.template>