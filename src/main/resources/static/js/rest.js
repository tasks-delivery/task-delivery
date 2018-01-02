  var client = new $.RestClient('');

  client.add('api');
  client.api.read("work");
  client.api.read("relax");
  client.api.read("home");
  client.show();

