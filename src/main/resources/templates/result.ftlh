<#import "blocks/template.ftlh" as t>
<@t.template user>
    <p><h1 style="text-align: center">${test.getTitle()}</h1></p>
    <br>
    <br>

    <p style="text-align: center">Количество баллов: ${res}</p>
    <br>
    <br>
    <p style="text-align: center">Результат:</p>
    <p style="text-align: center">${resultTest}</p>
    <br>
    <br>

    <br>

</@t.template>