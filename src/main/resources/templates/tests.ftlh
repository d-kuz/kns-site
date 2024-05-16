<#import "blocks/template.ftlh" as t>
<@t.template user>
    <h1 style="text-align: center">Тесты</h1><hr>

    <hr>
    <#if !empty>
    <#list tests as test>
        <div class="container">
            <a class="a_style" href="/test/${test.getId()}">
                <h5>${test.title}</h5>
            </a>
        </div>
    </#list>
    <#else >
        Нет тестов!
    </#if>
    <#if user.isAdmin()>
        <a class="a_style" href="/test/add">
            Добавить тест
        </a><br>
    </#if>
</@t.template>