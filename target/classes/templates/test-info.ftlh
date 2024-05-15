<#import "blocks/template.ftlh" as t>
<@t.template user>

<p><h1 style="text-align: center">${test.getTitle()}</h1></p>
    <br>
    <br>

    <p style="text-align: center">${test.getDescription()}</p>
    <br>
    <br>
     <a class="a_style" href="/test/${test.getId()}/${questions}">
             <h5>Начать</h5>
         </a>
     <br>
     <br>

    <br>

</@t.template>