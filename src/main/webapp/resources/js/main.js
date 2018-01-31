/*$(document).ready(function(){
        $('.reg').hide();
        $('#btnReg').click(function(){
            $('.reg').css({'display':'block'});
        });
        $(this).keydown(function(eventObject){
            if (eventObject.which == 27)
                $('.reg').hide();
        });
    });
*/


/*
document.getElementById('pr').addEventListener('click', function () {
  window.location.href = 'http://site.ru';
});
*/

function goMail(){
    var UsName=document.getElementsById(('projectname').value);
    if (confirm("Уверены, что хотите отправить сообщение?")) {
    document.location="UserMail.html?id="+UsName; }
}