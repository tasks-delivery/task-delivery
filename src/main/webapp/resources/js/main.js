$(document).ready(function(){
        $('.reg').hide();
        $('#btnReg').click(function(){
            $('.reg').css({'display':'block'});
        });
        $(this).keydown(function(eventObject){
            if (eventObject.which == 27)
                $('.reg').hide();
        });
    });