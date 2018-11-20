const m = require('mithril');

let allCampaign = require("../model/allCampaign");


let campaigns = {
  oninit:function(){
    allCampaign.fetch();
  },
  view: function () {
    return [
      m('h1', 'All Campaigns'),
      m('button',{href: '/createCampaign', oncreate: m.route.link}, "Create Campaign"),
      m('div', allCampaign.campaigns.map(function (campaign) {
        return m('li',m('a', {
          href: '/campaign/' + campaign.id,
          oncreate: m.route.link,
        },campaign.id + "--" +  campaign.name))
      }))
    ]
  }
};


module.exports = campaigns;