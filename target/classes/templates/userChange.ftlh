<#import "blocks/template.ftlh" as t>
<@t.template user>
<h1 style="text-align: center">Редактирование пользователя ${user.name}</h1><hr>
    <br>
    <br>
<form action="/userChangeEmail" method="post">
    <input type="hidden" name="example" value=""/>
    <input type="hidden" value="${_csrf.token}" name="_csrf">

    <div class="container">
    Новая почта:
    <input name="email" type="text" id="email" class="form-control" placeholder="email" required/>
     </div>
    <br><br>
    <div class="container">
    <button type="submit" class="btn btn-dark" id="email">Изменить почту</button>
    </div>
    <br>
    <br>
    <#if errorMessage??>
        <h2 style="color: red">${errorMessage}</h2>
    </#if>
</form>
<form action="/userChangePassword" method="post">
    <input type="hidden" name="example" value=""/>
    <input type="hidden" value="${_csrf.token}" name="_csrf">

    <div class="container">
    Новый пароль:
    <input name="password1" type="password" id="password1" class="form-control" required/>
    </div>
    <br>
    <br>
    <div class="container">
    Подтвердите пароль:
    <input name="password2" type="password" id="password2" class="form-control" required/>
    </div>
    <br>
    <br>
    <div class="container">
    <button type="submit" class="btn btn-dark" id="pass">Изменить пароль</button>
    </div>
    <br>
    <br>
    <#if errorMessage??>
        <h2 style="color: red">${errorMessage}</h2>
    </#if>
</form>


</@t.template>