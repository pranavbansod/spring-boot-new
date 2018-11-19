const m = require("mithril");

let user = {
  id:"",
  name:"",
  load:function (id) {
    return m.request({
      method: 'get',
      url: `/user/${id}`
    }).then(function (res) {
      user.id = res.id;
      user.name = res.name;
    })
  }
};

module.exports = user;