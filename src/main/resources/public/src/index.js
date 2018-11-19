var m = require('mithril');

var users = require("./view/users");
var createUser = require("./view/createUser");

m.route(document.body,"/users",{
  "/users":users,
  "/createUser":createUser
});