<#import "blocks/template.ftlh" as t>
<@t.template user>
<p align="center">Задание дня ${task.getNamber()}</p>
    <br>
<p align="center"> ${task.getText()} </p>
    <br>
    <div class="container">
        <iframe  width="560" height="315"
                 src="${task.getLink()}"
                 title="YouTube video player" frameborder="0"
                 allow="accelerometer; autoplay; clipboard-write; encrypted-media;
            gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
        <br><br>
    </div>

    <div class="container">
        <#if task.getId()==1>
            <iframe width="560" height="315" src="https://www.youtube.com/embed/EAolQ30ErBk?si=ToryATBQ4p7GH_Et"
                    title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write;
                encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
        </#if>


    </div>

    <div class="container">
<form action="@{/course/{idCourse}/task/{idTask}}" align="center" method="POST">
    <p align="center">Ответ на задание дня:</p>
    <#if task.haveAnswer(user)>
        <textarea align="center" cols="50" rows="10" name="text" id="text" class="form-control" placeholder="Ответ" required>
        #{task.getUserAnswer(user)}</textarea>
        <br>
        <br>
        <button style="width: 100%" type="submit" class="btn btn-light" id="addAnswerUser">Изменить ответ</button>
    <#else>
        <textarea align="center" cols="50" rows="10" name="text" id="text" class="form-control" placeholder="Ответ" required></textarea>
        <br>
        <br>
        <button style="width: 100%"  type="submit" class="btn btn-light" id="addAnswerUser">Отправить ответ</button>
    </#if>
    <div id="modal" class="modal">
        <div class="modal-content">
            <button class="close">close</button>
            <p>Ответ сохранён! Следующее задание будет доступно завтра!</p>
        </div>
    </div>
    <script>
        const modal = document.querySelector('#modal');
        const btn = document.querySelector('#addAnswerUser');
        const close = document.querySelector('.close');

        btn.onclick = function () {
            modal.style.display = 'block';
        };

        close.onclick = function () {
            modal.style.display = 'none';
        };

        window.onclick = function (event) {
            if (event.target == modal) {
                modal.style.display = 'none';
            }
        };

    </script>

</form>
    </div>
</@t.template>