var ctrlC = function (obj) {

  var resultado = {};
  for (var prop in obj) {
    resultado[prop] = obj[prop];
  }
  return resultado;

}
