<#import "blocks/template.ftlh" as t>
<@t.template user>
<h1 style="text-align: center">Добавление курса</h1><hr>
    <form action="/courseAdd" method="post">
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <input name="Title" type="text" id="Title" class="form-control" placeholder="Title" required/>
        <br><br>
        <input name="Price" type="number" id="Price" class="form-control" placeholder="Price" required/>
        <br><br>
        <input name="Description" type="text" id="Description" class="form-control" placeholder="Description" required/>
        <br><br>
        <button type="submit" class="btn btn-dark">Добавить курс</button>
        <br>
        <br>
        <#if errorMessage??>
            <h2 style="color: red">${errorMessage}</h2>
        </#if>
    </form>
</@t.template>