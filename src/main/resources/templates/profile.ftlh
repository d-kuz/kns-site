<#import "blocks/template.ftlh" as t>
<@t.template user>
    <h1 style="text-align: center">Личный кабинет</h1>
    <hr>
    <br>
    <div style="text-align: center">
        <img src="/static/avatar.png"
             style="border:2px solid black; border-radius: 20px" height="120">
        <br>
        <br>
        <h2>${user.name}</h2>
        <br>
        Электоронная почта: <b>${user.email}</b>
        <br>
        <a class="a_style" style="text-align: center; width: 100%"
           href="/userChange">
            Изменить почту или пароль
        </a><br>
        <br>
        <#if user.isAdmin()>
            <a class="a_style" href="/admin">
                Панель администратора
            </a><br>
        </#if>
        <br>
        <#if emptyCourses>
            Нет ни одного курса
        <#else>
            Мои курсы:
            <br>
            <br>
            <#list courses as course>
                <a class="a_style" href="/course/${course.getId()}">
                    ${course.getTitle()}
                </a>

            </#list>
        </#if>
        <br>
        <br>


        <form action="/logout" method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button type="submit" style="text-align: center; width: 100%" class="btn btn-danger mb-2">
                Выйти из аккаунта
            </button>
        </form>
    </div>
</@t.template>