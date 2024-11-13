<#import "blocks/template.ftlh" as t>
<@t.template user>
    <h1 style="text-align: center">Панель администратора</h1><hr>
    <table class="table table-hover table-dark">
        <tr>
            <th scope="col">Email</th>
            <th scope="col">Роли</th>
        </tr>
        <#list users as us>
            <tr>
                <th>${us.getEmail()}</th>
                <th><#list us.roles as role>${role}</#list></th>
            </tr>

        <#else>
            <h3>Пользователей нет</h3>
        </#list>
    </table>
</@t.template>