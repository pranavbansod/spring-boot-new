const m = require('mithril');

const campaign = require("../model/campaign");

const campaignView = {
  oninit: function (vnode) {
    campaign.load(vnode.attrs.campaignId);
  },
  view: function () {
    return [
      m('a',{
        href:'/',
        oncreate:m.route.link
      },m('button',"Home")),
      m('h1', "Id:" + campaign.id + ",  Name: " + campaign.name)
    ];
  }
};

module.exports = campaignView;