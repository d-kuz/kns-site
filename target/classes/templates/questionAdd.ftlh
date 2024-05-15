<#import "blocks/template.ftlh" as t>
<@t.template user>
<h1 style="text-align: center">Добавление вопроса</h1><hr>
    <form action="/test/#{testid}/questionAdd" method="post">
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <input name="Namber" type="number" id="Namber" class="form-control" placeholder="Namber" required/>
        <br><br>
        <input name="Text" type="text" id="Text" class="form-control" placeholder="Text" required/>
        <br><br>
        <button type="submit" class="btn btn-dark" id="email">Добавить вопрос</button>
        <br>
        <br>
        <#if errorMessage??>
            <h2 style="color: red">${errorMessage}</h2>
        </#if>
    </form>
</@t.template>