/*Функция показа сообщения о процессе загрузки*/
function showProgress(data) {    
    if (data.status === "begin") {
        document.getElementById('loading_wrapper').style.display = "block";
    } else if (data.status === "success") {
        document.getElementById('loading_wrapper').style.display = "none";
    }
}

/*Функция информирования о добавлении новых продаж*/
function socketListener(message, channel, event) {
    console.log(message);
}