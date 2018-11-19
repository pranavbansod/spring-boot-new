const m = require('mithril');

const users = require("./view/users");
const createUser = require("./view/createUser");
const viewUser = require("./view/viewUser");

m.route(document.body,"/users",{
  "/users":users,
  "/user/:userId":viewUser,
  "/createUser":createUser
});