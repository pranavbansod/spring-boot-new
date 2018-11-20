const m = require('mithril');

let allCampaign = {
  campaigns:[],
  fetch:function () {
    return m.request({
      method: 'get',
      url: '/campaign/all'
    }).then(function (result) {
      allCampaign.campaigns = result;
    })
  }
};

module.exports = allCampaign;