<#import "blocks/template.ftlh" as t>
<@t.template user>

<p><h1 style="text-align: center">${test.getTitle()}</h1></p>
    <br>
    <br>

    <p style="text-align: center">${test.getDescription()}</p>
    <br>
    <br>
    <div class="container">
     <a class="a_style" href="/test/${test.getId()}/questions">
             <h5>Начать</h5>
         </a>

    </div>
     <br>
     <br>

    <#if user.isAdmin()>
        <div class="container">
        <a class="a_style" href="/test/{idTest}/addQ">
            Добавить вопрос
        </a>
        </div><br>
        <div class="container">
        <a class="a_style" href="/test/{idTest}/addR">
            Добавить результат
        </a>
        </div><br>
    </#if>
    <br>

</@t.template>