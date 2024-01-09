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
                <th>${user.getEmail()}</th>
                <th><#list user.getRoles() as role>${role}</#list></th>
                <th>${user.getPassword()}</th>
            </tr>
        </#list>
    </table>
</@t.template>