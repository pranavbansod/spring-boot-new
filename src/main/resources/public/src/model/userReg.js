const m = require('mithril');

let userReg = {
  users:[],
  fetch:function () {
    return m.request({
      method: 'get',
      url: '/user/all'
    }).then(function (result) {
      userReg.users = result;
    })
  }
};

module.exports = userReg;