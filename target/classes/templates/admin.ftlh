<#import "blocks/template.ftlh" as t>
<@t.template user>
    <h1 style="text-align: center">Панель администратора</h1><hr>
    <table class="table table-hover table-dark">
        <tr>
            <th scope="col">Email</th>
            <th scope="col">Роли</th>
            <th scope="col">Пароль</th>
        </tr>
        <#list users as user>
            <tr>
                <th>${user.email}</th>
                <th><#list user.roles as role>${role}</#list></th>
                <th>${user.password}</th>
            </tr>
        </#list>
    </table>
</@t.template>