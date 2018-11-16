var m = require('mithril');

var users = require("./view/users");

m.route(document.body,"/users",{
  "/users":users
});