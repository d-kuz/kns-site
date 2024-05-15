<#import "blocks/template.ftlh" as t>
<@t.template user>
    <h1 style="text-align: center">Тесты</h1><hr>

    <hr>

    <#list tests as test>
        <div class="container">
            <a class="a_style" href="/test/${test.getId()}">
                <h5>${test.title}</h5>
            </a>
        </div>
    </#list>

</@t.template>