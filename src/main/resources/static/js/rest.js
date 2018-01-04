  var client = new $.RestClient('');

  client.add('docs');
  client.add('support');
  client.add('about');
  client.add('blog');

  client.show();

