<#import "blocks/template.ftlh" as t>
<@t.template user>
    <script>
        var i = 0;
        function buttonClick(n) {
            i = i + n;
            document.getElementById('inc').value = i;
        }
    </script>
    <div class="container">
    <p>Посчитайте сумму:</p>
    </div>
    <#list q as question>
        <div class="container">
            <p>${question.getText()}
        </div>
        <div class="container">
                <button onclick="buttonClick(1);">+1</button>
                <button onclick="buttonClick(2);">+2</button>
                <button onclick="buttonClick(3);">+3</button>
                <button onclick="buttonClick(4);">+4</button>
            </p>
        </div>
        <br>
    </#list>
        <br>
    <p>
    <div class="container">
    Ваш результат:
    <input type="text" id="inc" value="0"></input>
    </div>
    </p>
    <br>
    <br>
    <#list r as result>
        <div class="container">
            Диапазон: ${result.getMin()} - ${result.getMax()}
        </div>
        <div class="container">
            ${result.getText()}
        </div>
        <br>
    </#list>
</@t.template>