<#import "blocks/template.ftlh" as t>
<@t.template user>
<h1 style="text-align: center">Добавление ответа</h1><hr>
    <form action="/test/#{testid}/questionAnswerAdd" method="post">
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <input name="point" type="number" id="point" class="form-control" placeholder="Point" required/>
        <br><br>
        <input name="questionAnswerText" type="text" id="questionAnswerText" class="form-control" placeholder="Text" required/>
        <br><br>
        <button type="submit" class="btn btn-dark" id="email">Добавить ответ</button>
        <br>
        <br>
        <#if errorMessage??>
            <h2 style="color: red">${errorMessage}</h2>
        </#if>
    </form>
</@t.template>