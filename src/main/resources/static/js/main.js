var btn_home, btn_work, btn_relax;
btn_home = $('.btn-home');
btn_work = $('.btn-work');
btn_relax = $('.btn-relax');
  $(btn_home).on('click', function(){
  window.location = 'task-delivery/../assets/module/home/home.html';
      });

  $(btn_work).on('click', function(){
  window.location = 'task-delivery/../assets/module/work/work.html';
      });

  $(btn_relax).on('click', function cl(){
    window.location = 'task-delivery/../assets/module/relax/relax.html';
      });

var btn_search, field_search;
btn_search = $('.btn-search');

field_search = $('#field-search').val();
  $(btn_search).on('click', function(){
  if (field_search == field_search){
        alert("Технические работы");
  }



});
