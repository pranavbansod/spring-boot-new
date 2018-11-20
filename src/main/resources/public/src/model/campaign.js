const m = require("mithril");

let campaign = {
  id:"",
  name:"",
  load:function (id) {
    return m.request({
      method: 'get',
      url: `/campaign/${id}`
    }).then(function (res) {
      campaign.id = res.id;
      campaign.name = res.name;
    })
  }
};

module.exports = campaign;