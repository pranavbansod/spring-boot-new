const m = require('mithril');

let userReg = require("../model/userReg");


let users = {
  oninit:function(){
    userReg.fetch();
  },
  view: function () {
    return [
      m('h1', 'All Users'),
      m('button',{href: '/createUser', oncreate: m.route.link}, "Create User"),
      m('div', userReg.users.map(function (user) {
        return m('li',m('a', {
        },user.id + "--" +  user.name))
      }))
    ]
  }
};


module.exports = users;