const m = require('mithril');

let userReg = require("../model/userReg");


let users = {
  oninit:function(){
    userReg.fetch();
  },
  view: function () {
    return [
      m('h1', 'All Users'),
      m('button', "Create User")
    ]
  }
};


module.exports = users;