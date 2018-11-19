const m = require('mithril');

const user = require("../model/user");
const userView = {
  oninit: function (vnode) {
    user.load(vnode.attrs.userId);
  },
  view: function () {
    return [
      m('a',{
        href:'/',
        oncreate:m.route.link
      },m('button',"Home")),
      m('h1', "Id:" + user.id + ",  Name: " + user.name),
      m('button', "Edit")
    ];

  }
};

module.exports = userView;