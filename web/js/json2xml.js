/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function json2xml(o, tab) {
  var toXml = function(v, name, ind) {
    var xml = "";
    if (typeof(v) == "object") {
      var hasChild = false;
      for (var m in v) {
        if (m.charAt(0) == "@") {
          xml += " " + m.substr(1) + "=\"" + v[m].toString() + "\"";
        } else {
          hasChild = true;
        }
      }
      if (hasChild) {
        for (var m in v) {
          if (m=="name") {
            xml += "<" + v[m] + ">" + v['value'] + "";
          }
        }
      }
    }
    return xml;
  }, xml="";
  for (var m in o) {
    xml += toXml(o[m], m, "");
  }

  return ""+xml+"";

}